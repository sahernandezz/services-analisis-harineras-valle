package co.edu.unbosque.servicesanalisisharinerasvalle.service.mapper;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormClienteRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.TipoDocumento;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class FormClienteTOCliente implements IMapper<FormClienteRequest, Cliente> {
    @Override
    public Cliente map(FormClienteRequest in) {
        return Cliente.builder()
                .nombre(in.getNombre())
                .apellido(in.getApellido())
                .celular(in.getCelular())
                .correo(in.getCorreo())
                .tipoDocumento(TipoDocumento.valueOf(in.getTipoDocumento()))
                .numeroDocumento(in.getNumeroDocumento())
                .build();
    }
}
