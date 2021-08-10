package com.scalepoint.jwt_assertion_client;

import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Simple in-memory token cache implementation
 */
public class InMemoryTokenCache implements TokenCache {
    private final Log log = LogFactory.getLog(InMemoryTokenCache.class);
    private final ExpiringMap<String, String> cacheMap;
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * Create new in-memory cache instance
     */
    @SuppressWarnings("WeakerAccess")
    public InMemoryTokenCache() {
        this.cacheMap = ExpiringMap.builder()
                .variableExpiration()
                .build();
    }

    /**
     * @param cacheKey         Cache key
     * @param underlyingSource Underlying token source to invoke on cache miss
     * @return Token from either cache or underlying source
     * @throws IOException Exception from underlying source
     */
    @Override
    public String get(String cacheKey, TokenSource underlyingSource) throws IOException {
        String value = cacheMap.get(cacheKey);
        if (value == null) {
            lock.lock();
            try {
                value = cacheMap.get(cacheKey);
                if (value == null) {
                    ExpiringToken token = underlyingSource.get();
                    value = token.getToken();
                    if (token.getExpiresInSeconds() > 0) {
                        cacheMap.put(cacheKey, value, ExpirationPolicy.CREATED, token.getExpiresInSeconds(), TimeUnit.SECONDS);
                    } else {
                        log.warn("Authorization server does not provide token expiration information. Consider using NoCache or custom cache implementation to avoid performance penalty caused by locking.");
                    }
                }
            } finally {
                lock.unlock();
            }
        }
        return value;
    }
}
