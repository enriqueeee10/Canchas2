package com.lp3.sistema.IndividualCanchas.Controller;

import java.util.List;
import java.util.Optional;

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
import com.lp3.sistema.IndividualCanchas.model.Clientes;
import com.lp3.sistema.IndividualCanchas.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class clientesController {
    
    @Autowired
    ClienteRepository clienteRepo;

    @PostMapping("/nuevocliente")
    public void nuevoCliente(@RequestBody clienteRequest cliente) {
        Clientes nuevocliente = new Clientes();
        nuevocliente.setIdcliente(cliente.getIdcliente());
        nuevocliente.setDni(cliente.getDni());
        nuevocliente.setNombre(cliente.getNombre());
        nuevocliente.setApellido(cliente.getApellido());
        nuevocliente.setCorreo(cliente.getCorreo());
        nuevocliente.setDireccion(cliente.getDireccion());
        nuevocliente.setTelefono(cliente.getTelefono());
        clienteRepo.save(nuevocliente);
    }
    
    @GetMapping("/verclientes")
    public List<Clientes> getclientes() {
        return clienteRepo.findAll();
    }
    
    @GetMapping("/vercliente/{idcliente}")
    public Clientes getClienteid(@PathVariable int idcliente) {
        return clienteRepo.findById(idcliente).orElseThrow(() -> new RuntimeException("Error"));
    }

    @PutMapping("/actualizarcliente/{idcliente}")
    public void actualizarCliente(@PathVariable int idcliente, @RequestBody clienteRequest cliente) {
        Optional<Clientes> optionalCliente = clienteRepo.findById(idcliente);
        if (optionalCliente.isPresent()) {
            Clientes clienteExistente = optionalCliente.get();
            clienteExistente.setDni(cliente.getDni());
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setCorreo(cliente.getCorreo());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteRepo.save(clienteExistente);
        } else {
            // Manejar el caso en que el cliente no exista
        }
    }

    @DeleteMapping("/eliminarcliente/{idcliente}")
    public void eliminarCliente(@PathVariable Integer idcliente) {
        Optional<Clientes> clienteOptional = clienteRepo.findById(idcliente);
        if (clienteOptional.isPresent()) {
            clienteRepo.deleteById(idcliente);
        } else {
            // Manejar el caso en que el cliente no exista
        }
    }
}
