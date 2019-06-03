package com.wind.user.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {
    private Long id;

    private String loginName;

    private String loginPassword;

    private String nickname;

    private Long role;

    private Long phone;

    private String sex;

    private Date birthDate;

    private String valid;

    private String grade;

    private String email;

    private String marriage;

    private String nativePlace;

    private Date createDate;

    private Date updateDate;

}