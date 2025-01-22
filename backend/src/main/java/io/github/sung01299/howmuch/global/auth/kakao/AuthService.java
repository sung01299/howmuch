package io.github.sung01299.howmuch.global.auth.kakao;

import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.repository.UserRepository;
import io.github.sung01299.howmuch.global.auth.dto.KakaoDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final KakaoUtil kakaoUtil;
    private final UserRepository userRepository;

    public User oAuthLogin(String accessCode, HttpServletResponse httpServletResponse){
        KakaoDTO.OAuthToken oAuthToken = kakaoUtil.requestToken(accessCode);
        KakaoDTO.KakaoProfile kakaoProfile = kakaoUtil.requestProfile(oAuthToken);

        Optional<User> queryUser = userRepository.findByEmail(kakaoProfile.getKakao_account().getEmail());

        return queryUser.orElse(new User());
    }
}
