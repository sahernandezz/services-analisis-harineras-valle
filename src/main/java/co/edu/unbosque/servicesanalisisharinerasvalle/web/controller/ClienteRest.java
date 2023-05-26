package co.edu.unbosque.servicesanalisisharinerasvalle.web.controller;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormClienteRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.Cliente;
import co.edu.unbosque.servicesanalisisharinerasvalle.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteRest {

    private final ClienteService clienteService;

    @Operation(summary = "Lista de clientes",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Todos los clientes",
                            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Cliente.class)))
                    )
            })
    @GetMapping
    ResponseEntity<List<Cliente>> listarCliente() {
        return ResponseEntity.ok(clienteService.listarCliente());
    }

    @Operation(summary = "Buscar cliente por correo",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Cliente encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
                    ),
                    @ApiResponse(
                            responseCode = "404", description = "Cliente no encontrado"
                    )
            })
    @GetMapping("/{correo}")
    ResponseEntity<Cliente> buscarCliente(@PathVariable String correo) {
        final Optional<Cliente> opCliente = clienteService.buscarCliente(correo);
        return opCliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear cliente",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Cliente creado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
                    ),
                    @ApiResponse(
                            responseCode = "401", description = "Parametros invalidos",
                            content = @Content(mediaType = "application/json")
                    )
            })
    @PostMapping
    ResponseEntity<Cliente> crearCliente(@RequestBody @Valid FormClienteRequest formClienteRequest) {
        return ResponseEntity.ok(clienteService.crearCliente(formClienteRequest));
    }

    @Operation(summary = "Actualizar cliente",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Cliente actualizado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
                    ),
                    @ApiResponse(
                            responseCode = "401", description = "Parametros invalidos",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404", description = "Cliente no encontrado"
                    )
            })
    @PutMapping("/{id}")
    ResponseEntity<Cliente> actualizarCliente(@RequestBody @Valid FormClienteRequest formClienteRequest, @PathVariable Long id) {
        final Optional<Cliente> opCliente = clienteService.actualizarCliente(formClienteRequest, id);
        return opCliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
