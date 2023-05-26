package co.edu.unbosque.servicesanalisisharinerasvalle.web.controller;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormPCRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.PedidoCliente;
import co.edu.unbosque.servicesanalisisharinerasvalle.service.PedidoClienteService;
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
@RequestMapping("/api/v1/pc")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoClienteRest {

    private final PedidoClienteService pedidoClienteService;

    @Operation(summary = "Lista de pedidos de clientes",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Lista de pedidos de clientes",
                            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PedidoCliente.class)))
                    )
            })
    @GetMapping
    ResponseEntity<List<PedidoCliente>> listarPedidoCliente() {
        return ResponseEntity.ok(pedidoClienteService.listarPedidoCliente());
    }

    @Operation(summary = "Buscar pedido de cliente por codigo",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Pedido de cliente encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoCliente.class))
                    ),
                    @ApiResponse(
                            responseCode = "404", description = "Pedido de cliente no encontrado"
                    )
            })
    @GetMapping("/{codigo}")
    ResponseEntity<PedidoCliente> buscarPedidoCliente(@PathVariable String codigo) {
        final Optional<PedidoCliente> pedidoCliente = pedidoClienteService.buscarPedidoCliente(codigo);
        return pedidoCliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear pedido de cliente",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Pedido de cliente creado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoCliente.class))
                    ),
                    @ApiResponse(
                            responseCode = "401", description = "Parametros invalidos",
                            content = @Content(mediaType = "application/json")
                    )
            })
    @PostMapping
    ResponseEntity<PedidoCliente> crearPedidoCliente(@RequestBody @Valid FormPCRequest formPCRequest) {
        return ResponseEntity.ok(pedidoClienteService.crearPedidoCliente(formPCRequest));
    }

    @Operation(summary = "Actualizar pedido de cliente",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Pedido de cliente actualizado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoCliente.class))
                    ),
                    @ApiResponse(
                            responseCode = "401", description = "Parametros invalidos",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404", description = "Pedido de cliente no encontrado"
                    )
            })
    @PutMapping("/{id}")
    ResponseEntity<PedidoCliente> actualizarPedidoCliente(@RequestBody @Valid FormPCRequest formPCRequest, @PathVariable Long id) {
        final Optional<PedidoCliente> pedidoCliente = pedidoClienteService.actualizarPedidoCliente(formPCRequest, id);
        return pedidoCliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
