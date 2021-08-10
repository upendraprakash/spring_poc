package com.springboot.caffeine.cache.controller;

import com.springboot.caffeine.cache.dto.CommerceDto;
import com.springboot.caffeine.cache.model.Commerce;
import com.springboot.caffeine.cache.service.CommerceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//spring annotations
@RestController
@RequestMapping("/api")
//swagger annotation
@Tag(name = "Commerce resource REST endpoints", description = "Shows the product info")
public class CommerceController {

    @Autowired
    private CommerceService service;

    //http://localhost:10095/api/commerces
    //swagger annotations
    @Operation(summary = "Return product list")
    @ApiResponse(responseCode = "200", description = "The request has succeeded")
    //spring annotations
    @GetMapping("/commerces")
    @ResponseStatus(HttpStatus.OK)
    public List<CommerceDto> getCommerceDtoList() {
        return service.getCommerceList().stream().map(CommerceDto::from).collect(Collectors.toList());
    }

    //NOTE - we are only considering the happy path.
    //you are free to add the failure case where if product not found
    //throw an NotFoundException and return HTTP 404 error response
    //code

    //http://localhost:10095/api/commerce?id=e45f2c96-be5b-4779-803c-a611ff5f150f
    //swagger annotations
    @Operation(summary = "Return product by id")
    @ApiResponse(responseCode = "200", description = "The request has succeeded")
    //spring annotations
    @GetMapping("/commerce")
    @ResponseStatus(HttpStatus.OK)
    public CommerceDto getCommerceById(@RequestParam("id") UUID id) {
        final Commerce c = service.getCommerceByRefId(id);
        return CommerceDto.from(c);
    }
}
