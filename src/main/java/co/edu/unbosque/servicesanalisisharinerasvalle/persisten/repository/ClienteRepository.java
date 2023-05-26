package co.edu.unbosque.servicesanalisisharinerasvalle.persisten.repository;

import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCorreo(String correo);
}
