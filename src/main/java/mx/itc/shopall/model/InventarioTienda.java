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
@Table(name = "inventario_tienda")
public class InventarioTienda implements Serializable{
    @Id
    @Column(name = "id_inventario")
    private int id_inventario;
    @Column(name = "cantidad")
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    private Tienda tienda;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;
}
