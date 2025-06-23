package com.saludvital.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @Column(name = "client_id", unique = true, nullable = false)
    private String clientId;
    @Column(name = "client_secret", nullable = false)
    private String clientSecret;
    @Column(name = "description")
    private String description;
    @Column(name = "enabled")
    private boolean enabled;
}