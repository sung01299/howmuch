package io.github.sung01299.howmuch.domain.favorites.entity;

import io.github.sung01299.howmuch.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Getter @Setter
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue
    @Column(name = "favorites_id")
    private Long id;

    private String ticker;
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
