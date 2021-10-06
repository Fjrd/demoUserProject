package com.example.demouserproject.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@Table (name = "ad")
@Validated
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    AdStatus status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    AppUser owner;

    LocalDateTime publishedAt;
}
