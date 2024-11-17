package com.example.demo.Cliente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


public interface ClienteService {

    public List<Cliente> getCliente();

    public void addNewCliente(Cliente cliente);

    public void deleteCliente(Long clienteid);

    public void updateCliente(Long clienteId, String name, String email);

}
