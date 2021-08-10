package com.springboot.caffeine.cache.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.UUID;

//lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//spring jpa annotations
@Entity
@Table(name = "commerce")
//spring annotation
@Component
public class Commerce {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String productName;
    String material;
    double price;
    String promotionCode;
    String department;
    UUID referenceId;
}
