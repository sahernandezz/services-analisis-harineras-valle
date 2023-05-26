package co.edu.unbosque.servicesanalisisharinerasvalle.service;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormEPRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EnvioPedido;

import java.util.List;
import java.util.Optional;

public interface EnvioPedidoService {
    List<EnvioPedido> listarEnvioPedido();
    Optional<EnvioPedido> buscarEnvioPedido(String codigo);
    EnvioPedido crearEnvioPedido(FormEPRequest formEPRequest);
    Optional<EnvioPedido> actualizarEnvioPedido(FormEPRequest formEPRequest, Long id);
}
