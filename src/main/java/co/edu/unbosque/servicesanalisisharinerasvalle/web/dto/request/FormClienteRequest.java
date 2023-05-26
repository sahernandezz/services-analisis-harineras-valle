package co.edu.unbosque.servicesanalisisharinerasvalle.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class FormClienteRequest {

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @NotBlank(message = "El celular no puede estar vacio")
    private String celular;

    @Email(message = "El correo no es valido")
    private String correo;

    @NotBlank(message = "El tipo de documento no puede estar vacio")
    private String tipoDocumento;

    @NotBlank(message = "El numero de documento no puede estar vacio")
    private String numeroDocumento;
}
