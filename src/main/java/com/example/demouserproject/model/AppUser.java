package com.example.demouserproject.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    UUID id;
    String firstName;
    String middleName;
    String lastName;
    String email;
    String password;

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
