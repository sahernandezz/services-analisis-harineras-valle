package co.edu.unbosque.servicesanalisisharinerasvalle.web.controller;

import co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request.FormMPRequest;
import co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity.MateriaPrima;
import co.edu.unbosque.servicesanalisisharinerasvalle.service.MateriaPrimaService;
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
@RequestMapping("/api/v1/mp")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MateriaPrimaRest {

    private final MateriaPrimaService materiaPrimaService;

    @Operation(summary = "Crear materia prima",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Materia prima creada",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MateriaPrima.class))
                    ),
                    @ApiResponse(
                            responseCode = "401", description = "Parametros invalidos",
                            content = @Content(mediaType = "application/json")
                    )
            })
    @PostMapping
    ResponseEntity<MateriaPrima> crearMateriaPrima(@RequestBody @Valid FormMPRequest formMPRequest) {
        return ResponseEntity.ok(materiaPrimaService.agregarMateriaPrima(formMPRequest));
    }

    @Operation(summary = "Lista de materias primas",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Lista de materias primas",
                            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MateriaPrima.class)))
                    )
            })
    @GetMapping
    ResponseEntity<List<MateriaPrima>> listarMateriaPrima() {
        return ResponseEntity.ok(materiaPrimaService.listarMateriaPrima());
    }

    @Operation(summary = "Buscar materia prima por codigo",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Materia prima encontrada",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MateriaPrima.class))
                    ),
                    @ApiResponse(
                            responseCode = "404", description = "Materia prima no encontrada"
                    )
            })
    @GetMapping("/{codigo}")
    ResponseEntity<MateriaPrima> buscarMateriaPrima(@PathVariable String codigo) {
        final Optional<MateriaPrima> opMp = materiaPrimaService.buscarMateriaPrima(codigo);
        return opMp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar materia prima",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Materia prima actualizada",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MateriaPrima.class))
                    ),
                    @ApiResponse(
                            responseCode = "401", description = "Parametros invalidos",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404", description = "Materia prima no encontrada"
                    )
            })
    @PutMapping("/{id}")
    ResponseEntity<MateriaPrima> actualizarMateriaPrima(@RequestBody @Valid FormMPRequest formMPRequest, @PathVariable Long id) {
        final Optional<MateriaPrima> opMP = materiaPrimaService.actualizarMateriaPrima(formMPRequest, id);
        return opMP.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
