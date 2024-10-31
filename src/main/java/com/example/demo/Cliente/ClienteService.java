package com.example.demo.Cliente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getCliente() {
        return clienteRepository.findAll();
    }

    public void addNewCliente(Cliente cliente) {
        Optional<Cliente> clienteConCorreo = clienteRepository.findByCorreo(cliente.getCorreo());

        if (clienteConCorreo.isPresent()) {
            throw new IllegalStateException("El correo del cliente ya existe");
        }

        clienteRepository.save(cliente);

        System.out.println(cliente);
    }

    public void deleteCliente(Long clienteid) {
        boolean b = clienteRepository.existsById(clienteid);
        if(!b) {
            throw new IllegalStateException("Cliente no encontrado con id: "+clienteid);
        }
        clienteRepository.deleteById(clienteid);
    }

    @Transactional
    public void updateCliente(Long clienteId,String name,String email) {
        Cliente cli = clienteRepository.findById(clienteId).orElseThrow(() -> new IllegalStateException("Cliente no existe con id: "+clienteId));

        if(name != null && name.length()>0 && !Objects.equals(cli.getNombre(),name)) {
            cli.setNombre(name);
        }

        if(email != null && email.length()>0 && !Objects.equals(cli.getCorreo(),email)) {
            Optional<Cliente> optional = clienteRepository.findByCorreo(email);
            if(optional.isPresent()) {
                throw new IllegalStateException("El correo ya ha sido tomado o ya existe, este es el correo: "+email);
            }
            cli.setCorreo(email);
        }
    }


}
