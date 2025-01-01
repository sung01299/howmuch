package io.github.sung01299.howmuch.domain.user.entity;

import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Favorites> favorites = new ArrayList<>();
}
