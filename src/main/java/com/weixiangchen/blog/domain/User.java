package com.weixiangchen.blog.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    private String username;

    private String password;
}
