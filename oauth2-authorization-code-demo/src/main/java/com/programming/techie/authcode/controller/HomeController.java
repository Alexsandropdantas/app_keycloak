package com.programming.techie.authcode.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping(path = "/")
	public String index() {
	    return "external";
	}
	
	
	@GetMapping(path = "/alex")
	public String alex() {
	    return "nav-tabs-boostrap";
	}

    @GetMapping("/home")
    public String home() {
    	
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	System.out.println("dados:"+principal.toString());
    	
    	DefaultOidcUser oauthUser = (DefaultOidcUser) principal;
    	String given_name = oauthUser.getAttribute("given_name");
    	String cpf = oauthUser.getAttribute("cpf");
    	String iss = oauthUser.getAttribute("iss").toString();
    	//String roles = oauthUser.getAttribute("Granted Authorities").toString();
    	
    	System.out.println("given_name: "+given_name);
    	System.out.println("iss:"+iss);
    	System.out.println("cpf:"+cpf);
    	//System.out.println("roles:"+roles);
    	
    	
//        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
//        String accessToken = keycloakSecurityContext.getTokenString();
        // Faça o processamento necessário com o accessToken

//    	System.out.println(accessToken);
    	
    	
    	//AccessToken.Access access = accessToken.getRealmAccess();
    	//Set<String> roles = access.getRoles();
    	
    	
    	
        return "home";
    }
}






