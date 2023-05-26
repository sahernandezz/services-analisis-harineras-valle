package co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
public class FormEPRequest {

    @NotNull(message = "El campo no puede estar vacio")
    private Long idPedidoCliente;

    @NotBlank(message = "El campo no puede estar vacio")
    private String direccion;

    @NotNull(message = "El campo no puede estar vacio")
    private Date fechaEnvio;

    @NotNull(message = "El campo no puede estar vacio")
    private Date fechaEstimadaEntrega;

    @NotNull(message = "El campo no puede estar vacio")
    private Float costoEnvio;

    @NotBlank(message = "El campo no puede estar vacio")
    private String estado;
}
