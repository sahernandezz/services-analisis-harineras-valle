package co.edu.unbosque.servicesanalisisharinerasvalle.service;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormMPRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.MateriaPrima;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.repository.MateriaPrimaRepository;
import co.edu.unbosque.servicesanalisisharinerasvalle.service.mapper.FormMtTOMt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MateriaPrimaServiceImpl implements MateriaPrimaService {

    private final MateriaPrimaRepository materiaPrimaRepository;

    private final FormMtTOMt formMtTOMt;

    @Override
    public List<MateriaPrima> listarMateriaPrima() {
        return materiaPrimaRepository.findAll();
    }

    @Override
    public Optional<MateriaPrima> buscarMateriaPrima(String codigo) {
        return materiaPrimaRepository.findByCodigo(codigo);
    }

    @Override
    public MateriaPrima agregarMateriaPrima(FormMPRequest formMPRequest) {
        final MateriaPrima mpMapp = formMtTOMt.map(formMPRequest);
        mpMapp.setFecha(new Date());
        mpMapp.setCodigo(generarCodigo(mpMapp.getFecha(), mpMapp.getNombre()));
        return materiaPrimaRepository.save(mpMapp);
    }

    @Override
    public Optional<MateriaPrima> actualizarMateriaPrima(FormMPRequest formMPRequest, Long id) {
        Optional<MateriaPrima> materiaPrima = materiaPrimaRepository.findById(id);
        if (materiaPrima.isPresent()) {
            MateriaPrima mpMapp = formMtTOMt.map(formMPRequest);
            mpMapp.setId(id);
            mpMapp.setCodigo(materiaPrima.get().getCodigo());
            mpMapp.setFecha(materiaPrima.get().getFecha());
            materiaPrima = Optional.of(materiaPrimaRepository.save(mpMapp));
        }
        return materiaPrima;
    }

    private String generarCodigo(final Date fecha, final String nombre) {
        return fecha.getYear() + "" + fecha.getMonth() + "" + fecha.getDay() + "" + nombre.substring(0, 3).toLowerCase(Locale.ROOT);
    }
}
