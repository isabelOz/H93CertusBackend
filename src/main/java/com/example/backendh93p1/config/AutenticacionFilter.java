package com.example.backendh93p1.config;


import com.example.backendh93p1.services.implement.UserDetailsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AutenticacionFilter {

    @Autowired
    private UserDetailsServicesImpl userDetailsImpl;

    @Autowired
    private JwtUtilies jwtUtilies;

    public void filtrarDatos (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception{
        String headerToken = request.getHeader("Authorization");
        String username = null;
        String tokenjwt = null;

        if (headerToken != null && headerToken.startsWith("Bearer ")){
            tokenjwt = headerToken.substring(7);
            try {
                username  = this.jwtUtilies.extractUsername(tokenjwt);
            }catch (Exception e){
                e.printStackTrace();
                throw new Exception("Token Invalido");
            }

        }else {
            System.out.println("Token Invalido, no comienza con Bearer");
        }

        if (username != null){
            UserDetails userD = userDetailsImpl.loadUserByUsername(username);
            Boolean validacion = this.jwtUtilies.validateToken(tokenjwt,userD);
            if(validacion){
                UsernamePasswordAuthenticationToken upatoken = new UsernamePasswordAuthenticationToken(userD,null,userD.getAuthorities());
                upatoken.setDetails(userD);
                SecurityContextHolder.getContext().setAuthentication(upatoken);
            }
        }else{
            System.out.println("El usuario esta vacio, no asociado al token");
        }

        filterChain.doFilter(request,response);
    }
}
