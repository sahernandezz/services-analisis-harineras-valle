package co.edu.unbosque.servicesanalisisharinerasvalle.persisten.repository;

import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.MateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Long> {
    Optional<MateriaPrima> findByCodigo(String codigo);
}
