package com.example.demouserproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@AllArgsConstructor
@Table (name = "ad")
@Validated
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    AdStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    AdCategory category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonManagedReference
    AppUser owner;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    String text;

    LocalDateTime publishedAt;
}
