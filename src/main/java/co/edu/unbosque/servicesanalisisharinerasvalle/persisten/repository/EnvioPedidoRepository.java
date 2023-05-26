package co.edu.unbosque.servicesanalisisharinerasvalle.persisten.repository;

import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EnvioPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnvioPedidoRepository extends JpaRepository<EnvioPedido, Long> {
    Optional<EnvioPedido> findByPedidoClienteCodigo(String codigo);
}
