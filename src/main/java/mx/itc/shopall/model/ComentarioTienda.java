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
@Table(name = "comentario_tienda")
public class ComentarioTienda implements Serializable{
    @Id
    @Column(name = "id_comentario")
    private int id_comentario;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "fecha")
    private java.sql.Date fecha;
    @Column(name = "hora")
    private java.sql.Time hora;
    @ManyToOne
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    private Tienda tienda;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
}
