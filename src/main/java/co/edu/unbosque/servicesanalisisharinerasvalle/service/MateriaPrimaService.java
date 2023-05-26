package co.edu.unbosque.servicesanalisisharinerasvalle.service;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormMPRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.MateriaPrima;

import java.util.List;
import java.util.Optional;

public interface MateriaPrimaService {
    List<MateriaPrima> listarMateriaPrima();

    Optional<MateriaPrima> buscarMateriaPrima(String codigo);

    MateriaPrima agregarMateriaPrima(FormMPRequest formMPRequest);

    Optional<MateriaPrima> actualizarMateriaPrima(FormMPRequest formMPRequest, Long id);
}
