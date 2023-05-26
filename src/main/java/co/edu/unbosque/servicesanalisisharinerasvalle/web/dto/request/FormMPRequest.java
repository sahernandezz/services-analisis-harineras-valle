package co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class FormMPRequest {

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    private String descripcion;

    @NotNull(message = "El peso no puede estar vacio")
    private Float peso;

    @NotNull(message = "La cantidad no puede estar vacio")
    private Float cantidad;

    @NotNull(message = "El precio no puede estar vacio")
    private Float precio;

    @NotBlank(message = "El estado no puede estar vacio")
    private String estado;
}
