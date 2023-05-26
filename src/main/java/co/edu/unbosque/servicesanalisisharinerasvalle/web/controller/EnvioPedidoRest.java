package co.edu.unbosque.servicesanalisisharinerasvalle.web.controller;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormEPRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.EnvioPedido;
import co.edu.unbosque.servicesanalisisharinerasvalle.service.EnvioPedidoService;
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
@RequestMapping("/api/v1/ep")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnvioPedidoRest {

    private final EnvioPedidoService envioPedidoService;

    @Operation(summary = "Listar envio de pedidos",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Lista de envio de pedidos",
                            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EnvioPedido.class)))
                    )
            })
    @GetMapping
    ResponseEntity<List<EnvioPedido>> listarEnvioPedido() {
        return ResponseEntity.ok(envioPedidoService.listarEnvioPedido());
    }

    @Operation(summary = "Buscar envio de pedido por codigo",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Envio de pedido encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnvioPedido.class))
                    ),
                    @ApiResponse(
                            responseCode = "404", description = "Envio de pedido no encontrado"
                    )
            })
    @GetMapping("/{codigo}")
    ResponseEntity<EnvioPedido> buscarEnvioPedido(@PathVariable String codigo) {
        final Optional<EnvioPedido> opEP = envioPedidoService.buscarEnvioPedido(codigo);
        return opEP.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear envio de pedido",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Envio de pedido creado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnvioPedido.class))
                    ),
                    @ApiResponse(
                            responseCode = "401", description = "Envio de pedido no creado",
                            content = @Content(mediaType = "application/json")
                    )
            })
    @PostMapping
    ResponseEntity<EnvioPedido> crearEnvioPedido(@RequestBody @Valid FormEPRequest formEPRequest) {
        return ResponseEntity.ok(envioPedidoService.crearEnvioPedido(formEPRequest));
    }

    @Operation(summary = "Actualizar envio de pedido",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Envio de pedido actualizado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnvioPedido.class))
                    ),
                    @ApiResponse(
                            responseCode = "401", description = "Envio de pedido no actualizado",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404", description = "Envio de pedido no encontrado"
                    )
            })
    @PutMapping("/{id}")
    ResponseEntity<EnvioPedido> actualizarEnvioPedido(@RequestBody @Valid FormEPRequest formEPRequest, @PathVariable Long id) {
        final Optional<EnvioPedido> opEP = envioPedidoService.actualizarEnvioPedido(formEPRequest, id);
        return opEP.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
