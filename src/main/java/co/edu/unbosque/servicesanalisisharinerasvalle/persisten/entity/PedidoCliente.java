package co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido_cliente")
public class PedidoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "codigo", nullable = false, length = 15, unique = true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "cantidad", nullable = false)
    private Float cantidad;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "precio", nullable = false)
    private Date fechaPedido;

    @Column(name = "precio_unitario", nullable = false)
    private Float precioUnitario;

    @Column(name = "precio_total", nullable = false)
    private Float precioTotal;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "medio_pago", nullable = false)
    private MedioPago medioPago;

    @Column(name = "estado", nullable = false)
    private EstadoPedido estado;
}
