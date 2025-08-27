package org.esfe.controladores;

import jakarta.servlet.http.HttpServletRequest;
import org.esfe.servicios.implementaciones.CustomUserDetails;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

//    @ModelAttribute("usuarioActual")
//    public CustomUserDetails usuarioActual() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getName())) {
//
//            return (CustomUserDetails) auth.getPrincipal();
//        }
//
//        return null;
//    }

    @GetMapping
    public String Index (){
        return "home/Index";
    }

    @GetMapping("/login")
    public  String login(){
        return "home/login";
    }

    @GetMapping("/logout")
    public  String logout(HttpServletRequest request){
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);

        return "redirect:/";
    }
}
