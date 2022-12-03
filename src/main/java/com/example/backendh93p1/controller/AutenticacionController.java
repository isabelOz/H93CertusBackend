package com.example.backendh93p1.controller;


import com.example.backendh93p1.config.JwtUtilies;
import com.example.backendh93p1.entity.UsuariosEntity;
import com.example.backendh93p1.entity.jwtRequest;
import com.example.backendh93p1.entity.jwtResponse;
import com.example.backendh93p1.services.implement.UserDetailsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/autenticacion")
@CrossOrigin("*")
public class AutenticacionController {

    @Autowired
    private UserDetailsServicesImpl userDetail;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilies jwtUtiles;

    @GetMapping("/userloggin")
    public UsuariosEntity obtenerUsuario (Principal principal){
        return (UsuariosEntity) userDetail.loadUserByUsername(principal.getName());
    }

    @PostMapping("/generartoken")
    public ResponseEntity<?> generarToken (@RequestBody jwtRequest jwtR) throws Exception{
        try {
            this.autenticar(jwtR.getUsername(),jwtR.getPassword());
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception ("Usuario mal registrado");
        }

        UserDetails userDetails = userDetail.loadUserByUsername(jwtR.getUsername());
        String token = jwtUtiles.generateToken(userDetails);

        return ResponseEntity.ok(new jwtResponse(token));
    }

    public void autenticar (String username,String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("Usuario Desabilitado" + e.getMessage());
        }catch (BadCredentialsException be){
            throw new Exception("Credencial Erronea" + be.getMessage());
        }
    }


}
