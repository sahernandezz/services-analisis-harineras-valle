package co.edu.unbosque.servicesanalisisharinerasvalle.service;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormEPRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EnvioPedido;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.PedidoCliente;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.repository.EnvioPedidoRepository;
import co.edu.unbosque.servicesanalisisharinerasvalle.service.mapper.FormEPTOEnvioPedido;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnvioPedidoServiceImpl implements EnvioPedidoService {

    private final EnvioPedidoRepository envioPedidoRepository;

    private final FormEPTOEnvioPedido formEPTOEnvioPedido;

    @Override
    public List<EnvioPedido> listarEnvioPedido() {
        return envioPedidoRepository.findAll();
    }

    @Override
    public Optional<EnvioPedido> buscarEnvioPedido(String codigo) {
        return envioPedidoRepository.findByPedidoClienteCodigo(codigo);
    }

    @Override
    public EnvioPedido crearEnvioPedido(FormEPRequest formEPRequest) {
        EnvioPedido envioPedido = formEPTOEnvioPedido.map(formEPRequest);
        envioPedido.setPedidoCliente(PedidoCliente.builder().id(formEPRequest.getIdPedidoCliente()).build());
        return envioPedidoRepository.save(envioPedido);
    }

    @Override
    public Optional<EnvioPedido> actualizarEnvioPedido(FormEPRequest formEPRequest, Long id) {
        Optional<EnvioPedido> envioPedido = envioPedidoRepository.findById(id);
        if (envioPedido.isPresent()) {
            EnvioPedido envioPedido1 = formEPTOEnvioPedido.map(formEPRequest);
            envioPedido1.setPedidoCliente(PedidoCliente.builder().id(formEPRequest.getIdPedidoCliente()).build());
            envioPedido1.setId(envioPedido.get().getId());
            envioPedido = Optional.of(envioPedidoRepository.save(envioPedido1));
        }
        return envioPedido;
    }
}
