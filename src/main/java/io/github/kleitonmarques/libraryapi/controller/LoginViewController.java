package io.github.kleitonmarques.libraryapi.controller;

import io.github.kleitonmarques.libraryapi.security.CustomAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginViewController {

    @GetMapping("/login")
    public String paginaLogin() {
        return "login";
    }

    @GetMapping("/")
    @ResponseBody
    public String paginaHome(Authentication authentication) {
        if(authentication instanceof CustomAuthentication customAlth) {
            System.out.println(customAlth.getUsuario());
        }
        return "Olá " + authentication.getName();
    }
}
