package co.edu.unbosque.servicesanalisisharinerasvalle.persisten.repository;


import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EstadoEnvio;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.PedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoClienteRepository extends JpaRepository<PedidoCliente, Long> {
    Optional<PedidoCliente> findByCodigo(String codigo);
}
