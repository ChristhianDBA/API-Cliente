package com.example.demo.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT e FROM Cliente e WHERE e.correo=:correo")
    Optional<Cliente> findByCorreo(String correo);
}
