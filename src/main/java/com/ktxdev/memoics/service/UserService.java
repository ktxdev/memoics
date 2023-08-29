package com.ktxdev.memoics.service;

import com.ktxdev.memoics.dtos.UserDto;
import com.ktxdev.memoics.model.User;

public interface UserService {
    User register(UserDto userDto);
}
