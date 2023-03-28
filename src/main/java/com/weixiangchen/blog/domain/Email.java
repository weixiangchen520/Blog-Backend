package com.weixiangchen.blog.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    private String recipient;

    private String subject;

    private String text;
}
