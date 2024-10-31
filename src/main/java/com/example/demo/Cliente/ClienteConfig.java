package com.example.demo.Cliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ClienteConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClienteRepository repo) {
        return args -> {
            Cliente roy = new Cliente(
                    "Roy",
                    "Meza",
                    "74922216",
                    "r.meza@gmail.com",
                    "Av. Cesar Vallejo 487 - El Agustino",
                    LocalDate.of(2004, Month.APRIL, 18)
            );

            Cliente luz = new Cliente(
                    "Luz",
                    "Meza",
                    "87495412",
                    "l.meza@gmail.com",
                    "A.H. 5 de Enero Mz. B Lote 9 - Ate",
                    LocalDate.of(2018, Month.JUNE, 21)
            );
            repo.saveAll(List.of(roy, luz));
        };

    }
}
