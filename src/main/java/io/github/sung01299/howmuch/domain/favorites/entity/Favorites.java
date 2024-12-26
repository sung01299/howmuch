package io.github.sung01299.howmuch.domain.favorites.entity;

import io.github.sung01299.howmuch.domain.user.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
