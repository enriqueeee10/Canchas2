package com.lp3.sistema.IndividualCanchas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp3.sistema.IndividualCanchas.Request.clienteRequest;
import com.lp3.sistema.IndividualCanchas.Services.ClientesServices;
import com.lp3.sistema.IndividualCanchas.model.Clientes;

@RestController
@RequestMapping("/cliente")
public class clientesController {
    
    @Autowired
    ClientesServices clientesServices;

    @PostMapping("/nuevocliente")
    public void nuevoCliente(@RequestBody clienteRequest cliente) {
        clientesServices.registrarCliente(cliente);
    }
    
    @GetMapping("/verclientes")
    public List<Clientes> getclientes() {
        return clientesServices.getClientes();
    }
    
    @GetMapping("/vercliente/{idcliente}")
    public Clientes getClienteid(@PathVariable int idcliente) {
        return clientesServices.getClienteById(idcliente);
    }

    @PutMapping("/actualizarcliente/{idcliente}")
    public void actualizarCliente(@PathVariable int idcliente, @RequestBody clienteRequest cliente) {
        clientesServices.actualizarCliente(idcliente, cliente);
    }

    @DeleteMapping("/eliminarcliente/{idcliente}")
    public void eliminarCliente(@PathVariable Integer idcliente) {
        clientesServices.eliminarCliente(idcliente);
    }
}
