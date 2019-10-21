package com.wind.log.service.fallback;

import org.springframework.stereotype.Component;

import com.wind.log.service.UserService;
import com.wind.user.dto.UserDTO;

@Component
public class UserServiceFallback implements UserService {

    @Override
    public UserDTO getUser(Long id) throws Exception {
        return null;
    }

}
