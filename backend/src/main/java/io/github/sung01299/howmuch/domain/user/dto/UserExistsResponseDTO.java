package io.github.sung01299.howmuch.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserExistsResponseDTO {
    private Long userId;
    private Boolean exist;
}
