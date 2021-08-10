package com.springboot.caffeine.cache.dto;

import com.springboot.caffeine.cache.model.Commerce;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

//lombok annotation
@Data
@AllArgsConstructor
@Getter
//swagger annotation
@Schema
public class CommerceDto {

    UUID id;
    String productName;
    String material;
    double price;
    String promotionCode;
    String department;

    public static CommerceDto from(final Commerce entity) {
        return new CommerceDto(entity.getReferenceId(),
                entity.getProductName(),
                entity.getMaterial(),
                entity.getPrice(),
                entity.getPromotionCode(),
                entity.getDepartment());
    }
}
