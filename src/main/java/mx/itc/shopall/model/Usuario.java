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
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @Column(name = "id_usuario")
    private int id_usuario;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "metodo_usuario",
            joinColumns = {@JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "id_metodo")})
    private List<Metodo> metodos = new ArrayList<Metodo>();
}
