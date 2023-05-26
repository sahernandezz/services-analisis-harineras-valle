package co.edu.unbosque.servicesanalisisharinerasvalle.service;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormPCRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.PedidoCliente;

import java.util.List;
import java.util.Optional;

public interface PedidoClienteService {
    List<PedidoCliente> listarPedidoCliente();
    Optional<PedidoCliente> buscarPedidoCliente(String codigo);
    PedidoCliente crearPedidoCliente(FormPCRequest formPCRequest);
    Optional<PedidoCliente> actualizarPedidoCliente(FormPCRequest formPCRequest, Long id);
}
