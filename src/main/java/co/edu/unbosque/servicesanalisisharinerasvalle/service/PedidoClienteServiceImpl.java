package co.edu.unbosque.servicesanalisisharinerasvalle.service;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormPCRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.Cliente;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EstadoPedido;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.PedidoCliente;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.repository.PedidoClienteRepository;
import co.edu.unbosque.servicesanalisisharinerasvalle.service.mapper.FormPCTOPedioCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoClienteServiceImpl implements PedidoClienteService {

    private final PedidoClienteRepository pedidoClienteRepository;

    private final FormPCTOPedioCliente formPCTOPedioCliente;

    @Override
    public List<PedidoCliente> listarPedidoCliente() {
        return pedidoClienteRepository.findAll();
    }

    @Override
    public Optional<PedidoCliente> buscarPedidoCliente(String codigo) {
        return pedidoClienteRepository.findByCodigo(codigo);
    }

    @Override
    public PedidoCliente crearPedidoCliente(FormPCRequest formPCRequest) {
        final PedidoCliente pedidoCliente = formPCTOPedioCliente.map(formPCRequest);
        pedidoCliente.setCliente(Cliente.builder().id(formPCRequest.getIdCliente()).build());
        pedidoCliente.setPrecioTotal(pedidoCliente.getCantidad() * pedidoCliente.getPrecioUnitario());
        pedidoCliente.setFechaPedido(new Date());
        pedidoCliente.setEstado(EstadoPedido.PENDIENTE);
        pedidoCliente.setCodigo(generarCodigo(formPCRequest.getIdCliente(), pedidoCliente.getFechaPedido()));
        return pedidoClienteRepository.save(pedidoCliente);
    }

    @Override
    public Optional<PedidoCliente> actualizarPedidoCliente(FormPCRequest formPCRequest, Long id) {
        Optional<PedidoCliente> pedidoCliente = pedidoClienteRepository.findById(id);
        if (pedidoCliente.isPresent()) {
            PedidoCliente pedidoClienteMapp = formPCTOPedioCliente.map(formPCRequest);
            pedidoClienteMapp.setId(id);
            pedidoClienteMapp.setCodigo(pedidoCliente.get().getCodigo());
            pedidoClienteMapp.setFechaPedido(pedidoCliente.get().getFechaPedido());
            pedidoClienteMapp.setPrecioTotal(pedidoClienteMapp.getCantidad() * pedidoClienteMapp.getPrecioUnitario());
            pedidoClienteMapp.setCliente(Cliente.builder().id(formPCRequest.getIdCliente()).build());
            pedidoCliente = Optional.of(pedidoClienteRepository.save(pedidoClienteMapp));
        }
        return pedidoCliente;
    }

    private String generarCodigo(final Long idCliente, final Date fechaPedido) {
        return fechaPedido.getYear() + "" + fechaPedido.getMonth() + "" + fechaPedido.getDay() + "" + idCliente;
    }


}
