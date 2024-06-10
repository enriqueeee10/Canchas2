package com.lp3.sistema.IndividualCanchas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp3.sistema.IndividualCanchas.Services.RolesServices;
import com.lp3.sistema.IndividualCanchas.model.Roles;

@RestController
@RequestMapping("/rol")
public class rolesController {
    
    @Autowired
    RolesServices rolesServices;

    @PostMapping("/nuevorol")
    public void nuevoRol(@RequestBody Roles rol) {
        rolesServices.registrarRol(rol);
    }
}
