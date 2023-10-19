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
@Data
@ToString
@Entity
@Table(name = "carrito")
public class Carrito implements Serializable{
    @Id
    @Column(name = "id_carrito")
    private int id_carrito;
    @Column(name = "estado")
    private byte estado; 
    @ManyToOne
    @JoinColumn(name = "id_comprador", referencedColumnName = "id_comprador")
    private Comprador comprador;
}
