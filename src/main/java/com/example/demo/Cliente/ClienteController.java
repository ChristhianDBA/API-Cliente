package com.example.demo.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getCliente();
    }
    @PostMapping
    public void AddNewCliente(@RequestBody Cliente cliente) {
        clienteService.addNewCliente(cliente);
    }
    @DeleteMapping(path = "{clienteId}")
    public void deleteCliente(@PathVariable("clienteId") Long clienteid) {
        clienteService.deleteCliente(clienteid);
    }

    @PutMapping(path = "{clienteId}")
    public void updateCliente(
            @PathVariable("clienteId") Long clienteId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        clienteService.updateCliente(clienteId, name, email);
    }

}
