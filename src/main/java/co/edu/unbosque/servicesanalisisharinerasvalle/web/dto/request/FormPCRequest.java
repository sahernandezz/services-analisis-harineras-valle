package co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class FormPCRequest {

    @NotNull(message = "Cliente no seleccionado")
    private Long idCliente;

    @NotNull(message = "Ingrese la cantidad")
    private Float cantidad;

    @NotNull(message = "Ingrese el precio unitario")
    private Float precioUnitario;

    private String descripcion;

    @NotBlank(message = "Seleccione el medio de pago")
    private String medioPago;

    @NotBlank(message = "Seleccione el estado")
    private String estado;
}
