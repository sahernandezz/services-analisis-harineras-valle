package co.edu.unbosque.servicesanalisisharinerasvalle.service;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormClienteRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listarCliente();
    Optional<Cliente> buscarCliente(String correo);
    Cliente crearCliente(FormClienteRequest formClienteRequest);
    Optional<Cliente> actualizarCliente(FormClienteRequest formClienteRequest, Long id);
}
