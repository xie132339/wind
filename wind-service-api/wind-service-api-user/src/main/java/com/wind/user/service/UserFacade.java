package com.wind.user.service;

import com.wind.user.dto.UserDTO;

public interface UserFacade {
    //@RequestMapping("/getUser")
    //@RequestParam("id")
    UserDTO getUser(Long id) throws Exception;
}
