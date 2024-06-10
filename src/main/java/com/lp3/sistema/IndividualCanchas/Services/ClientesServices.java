package com.lp3.sistema.IndividualCanchas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.sistema.IndividualCanchas.Request.clienteRequest;
import com.lp3.sistema.IndividualCanchas.model.Clientes;
import com.lp3.sistema.IndividualCanchas.repository.ClienteRepository;

@Service
public class ClientesServices {
    
    @Autowired
    ClienteRepository clienteRepo;

    public void registrarCliente(clienteRequest cliente) {
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

    public List<Clientes> getClientes() {
        return clienteRepo.findAll();
    }

    public Clientes getClienteById(int idcliente) {
        return clienteRepo.findById(idcliente).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public void actualizarCliente(int idcliente, clienteRequest cliente) {
        Clientes clienteExistente = getClienteById(idcliente);
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setCorreo(cliente.getCorreo());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteRepo.save(clienteExistente);
    }

    public void eliminarCliente(int idcliente) {
        Clientes clienteExistente = getClienteById(idcliente);
        clienteRepo.delete(clienteExistente);
    }
}
