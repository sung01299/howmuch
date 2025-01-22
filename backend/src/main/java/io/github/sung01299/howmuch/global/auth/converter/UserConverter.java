package io.github.sung01299.howmuch.global.auth.converter;

import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.global.auth.dto.UserResponseDTO;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getUserId())
                .build();
    }
}
