package com.wind.user.po;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private Long id;

    private String loginName;

    private String loginPassword;

    private String nickname;

    private Long role;

    private Long phone;

    private String set;

    private Date birthDate;

    private String valid;

    private String grade;

    private String email;

    private String marriage;

    private String nativePlace;

    private Date createDate;
    
    private Date updateDate;
}
