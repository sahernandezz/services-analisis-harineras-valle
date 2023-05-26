package co.edu.unbosque.servicesanalisisharinerasvalle.service.mapper;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormMPRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EstadoMP;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.MateriaPrima;
import org.springframework.stereotype.Component;

@Component
public class FormMtTOMt implements IMapper<FormMPRequest, MateriaPrima> {
    @Override
    public MateriaPrima map(FormMPRequest in) {
        return MateriaPrima.builder()
                .nombre(in.getNombre())
                .descripcion(in.getDescripcion())
                .cantidad(in.getCantidad())
                .precio(in.getPrecio())
                .peso(in.getPeso())
                .estado(EstadoMP.valueOf(in.getEstado()))
                .build();
    }
}
