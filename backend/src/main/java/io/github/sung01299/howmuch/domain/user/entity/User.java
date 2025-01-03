package io.github.sung01299.howmuch.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String userName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Favorites> favorites = new ArrayList<>();
}
