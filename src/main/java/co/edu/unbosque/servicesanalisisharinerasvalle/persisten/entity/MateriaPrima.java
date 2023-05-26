package co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "materia_prima")
public class MateriaPrima {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "codigo", nullable = false, length = 15, unique = true)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "cantidad", nullable = false)
    private Float cantidad;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @Column(name = "peso", nullable = false)
    private Float peso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "estado", nullable = false)
    private EstadoMP estado;
}
