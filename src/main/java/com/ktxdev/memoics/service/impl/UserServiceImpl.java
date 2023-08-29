package com.ktxdev.memoics.service.impl;

import com.ktxdev.memoics.dtos.UserDto;
import com.ktxdev.memoics.exceptions.InvalidRequestException;
import com.ktxdev.memoics.model.User;
import com.ktxdev.memoics.repository.UserRepository;
import com.ktxdev.memoics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new InvalidRequestException("User with same name already exists");
        }

        if (!userDto.getPassword().equals(userDto.getPasswordConfirm())) {
            throw new InvalidRequestException("Passwords do not match");
        }

        User user = User.fromDto(userDto, passwordEncoder);
        return userRepository.save(user);
    }
}
