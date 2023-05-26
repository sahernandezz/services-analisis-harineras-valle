package co.edu.unbosque.servicesanalisisharinerasvalle.service;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormClienteRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.service.mapper.FormClienteTOCliente;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.Cliente;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final FormClienteTOCliente formClienteTOCliente;

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarCliente(String correo) {
        return clienteRepository.findByCorreo(correo);
    }

    @Override
    public Cliente crearCliente(FormClienteRequest formClienteRequest) {
        final Cliente cliente = formClienteTOCliente.map(formClienteRequest);
        cliente.setFechaRegistro(new Date());
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> actualizarCliente(FormClienteRequest formClienteRequest, Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            Cliente clienteMapp = formClienteTOCliente.map(formClienteRequest);
            clienteMapp.setId(id);
            clienteMapp.setFechaRegistro(cliente.get().getFechaRegistro());
            cliente = Optional.of(clienteRepository.save(clienteMapp));
        }
        return cliente;
    }
}
