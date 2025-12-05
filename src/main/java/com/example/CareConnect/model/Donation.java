package com.example.CareConnect.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String donorName;
    private String donorEmail;
    private String type; // gpay_qr | in-kind | money
    private String gpayQrImageUrl;
    private Double amount;
    private LocalDateTime createdAt;
}
