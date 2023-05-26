package co.edu.unbosque.servicesanalisisharinerasvalle.service.mapper;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormPCRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EstadoPedido;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.MedioPago;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.PedidoCliente;
import org.springframework.stereotype.Component;

@Component
public class FormPCTOPedioCliente implements IMapper<FormPCRequest, PedidoCliente> {
    @Override
    public PedidoCliente map(FormPCRequest in) {
        return PedidoCliente.builder()
                .descripcion(in.getDescripcion())
                .precioUnitario(in.getPrecioUnitario())
                .cantidad(in.getCantidad())
                .estado(EstadoPedido.valueOf(in.getEstado()))
                .medioPago(MedioPago.valueOf(in.getMedioPago()))
                .build();
    }
}
