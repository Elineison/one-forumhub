package com.alura.forumhub.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCrua = "123456";
        String senhaCriptografada = encoder.encode(senhaCrua);
        System.out.println("Senha original: " + senhaCrua);
        System.out.println("Senha criptografada: " + senhaCriptografada);
    }
}