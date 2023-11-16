package mx.itc.shopall.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    
    @JoinColumn(name = "id_persona")
    @OneToOne(fetch = FetchType.EAGER)
    private Persona persona;

    @JoinColumn(name = "id_perfil")
    @OneToOne(fetch = FetchType.EAGER)
    private Perfil perfil;

    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    @OneToMany(fetch = FetchType.EAGER)
    private List<PerfilMetodo> metodos;
}
