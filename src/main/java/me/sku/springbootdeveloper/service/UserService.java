package me.sku.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sku.springbootdeveloper.domain.User;
import me.sku.springbootdeveloper.dto.AddUserRequest;
import me.sku.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {// AddUserRequest 객체를 인수로 받는 회원정보 추가 메서드
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))//패스워드 시큐리티 설정하며 패스워드 인코딩용으로 등록한 빈을 사용해서 암호화한다.
                .build()).getId();
    }
}