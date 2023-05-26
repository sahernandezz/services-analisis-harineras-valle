package co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente", uniqueConstraints = {
        @UniqueConstraint(name = "cliente_celular_unique", columnNames = "celular"),
        @UniqueConstraint(name = "cliente_correo_unique", columnNames = "correo"),
        @UniqueConstraint(name = "cliente_documento_unique", columnNames = {"tipo_documento", "numero_documento"})
})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "celular", nullable = false, length = 10, unique = true)
    private String celular;

    @Column(name = "correo", nullable = false, length = 50, unique = true)
    private String correo;

    @Column(name = "tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "numero_documento", nullable = false, length = 15)
    private String numeroDocumento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;
}
