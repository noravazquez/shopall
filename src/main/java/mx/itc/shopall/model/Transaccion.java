package mx.itc.shopall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "transaccion")
public class Transaccion implements Serializable{
    @Id
    @Column(name = "id_transaccion")
    private int id_transaccion;
    @Column(name = "monto_total")
    private double monto_total;
    @Column(name = "direccion_envio")
    private String direccion_envio;
    @Column(name = "informacion_pago")
    private String informacion_pago;
    @Column(name = "fecha")
    private java.sql.Date fecha;
    @Column(name = "hora")
    private java.sql.Time hora;
    @ManyToOne
    @JoinColumn(name = "id_carrito", referencedColumnName = "id_carrito")
    private Carrito carrito;
}
