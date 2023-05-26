package co.edu.unbosque.servicesanalisisharinerasvalle.persisten.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "envio_pedido")
public class EnvioPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_pedido_cliente", nullable = false, unique = true)
    private PedidoCliente pedidoCliente;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_envio", nullable = false)
    private Date fechaEnvio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_estimada_entrega", nullable = false)
    private Date fechaEstimadaEntrega;

    @Column(name = "costo_envio", nullable = false)
    private Float costoEnvio;

    @Column(name = "estado", nullable = false)
    private EstadoEnvio estado;
}
