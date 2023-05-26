package co.edu.unbosque.servicesanalisisharinerasvalle.service.mapper;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormEPRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EnvioPedido;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EstadoEnvio;
import org.springframework.stereotype.Component;

@Component
public class FormEPTOEnvioPedido implements IMapper<FormEPRequest, EnvioPedido> {
    @Override
    public EnvioPedido map(FormEPRequest in) {
        return EnvioPedido.builder()
                .direccion(in.getDireccion())
                .fechaEnvio(in.getFechaEnvio())
                .fechaEstimadaEntrega(in.getFechaEstimadaEntrega())
                .costoEnvio(in.getCostoEnvio())
                .estado(EstadoEnvio.valueOf(in.getEstado()))
                .build();
    }
}
