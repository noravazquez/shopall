package mx.itc.shopall.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "rol")
public class Rol implements Serializable{
    @Id
    @Column(name = "id_rol")
    private int id_rol;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "consulta")
    private int consulta;
    @Column(name = "escritura")
    private int escritura;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rol_metodo",
            joinColumns = {@JoinColumn(name = "id_rol")},
            inverseJoinColumns = {@JoinColumn(name = "id_metodo")})
    private List<Metodo> metodos = new ArrayList<Metodo>();
}
