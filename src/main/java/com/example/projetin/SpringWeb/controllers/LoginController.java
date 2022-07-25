package com.example.projetin.SpringWeb.controllers;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projetin.SpringWeb.Servico.CookieService;
import com.example.projetin.SpringWeb.models.Administrador;
import com.example.projetin.SpringWeb.repositorio.AdministradoresRepo;

@Controller
public class LoginController {
    @Autowired
    private AdministradoresRepo repo;
    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException{
        Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
        if(adm != null){

            int tempoLogado = (60*60);
            //uma hora de cookie
            if(lembrar != null) tempoLogado = (60*60*24*365); // 1 ano de cookie
            CookieService.setCookie(response, "usuariosId", String.valueOf(adm.getId()), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos.");
        return "login/index";
    }
    @GetMapping("/sair")
    public String sair(HttpServletResponse response) throws IOException{
            CookieService.setCookie(response, "usuariosId", "", 0);
            return "redirect:/login";
    }
}
