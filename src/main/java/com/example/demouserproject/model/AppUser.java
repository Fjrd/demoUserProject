package com.example.demouserproject.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Table (name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    UUID id;

    @Column(nullable = false)
    String firstName;

    String middleName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "owner")
    @JsonBackReference
    List<Ad> ads;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
