package com.lp3.sistema.IndividualCanchas.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp3.sistema.IndividualCanchas.Request.loginRequest;
import com.lp3.sistema.IndividualCanchas.Services.LoginServices;

@RestController
@RequestMapping("/login")
public class loginController {
    
    @Autowired
    LoginServices loginServices;

    @PostMapping("/ingreso")
    public ResponseEntity<Map<String, Boolean>> login(@RequestBody loginRequest loginRequest) {
        boolean valid = loginServices.validarCredenciales(loginRequest);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("valid", valid);
        
        if (valid) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
