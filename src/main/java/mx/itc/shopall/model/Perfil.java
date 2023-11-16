package mx.itc.shopall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "perfil")
public class Perfil implements Serializable{
    @Id
    @Column(name = "id_perfil")
    private int id_perfil;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "consulta")
    private int consulta;
    @Column(name = "escritura")
    private int escritura;
    @Column(name = "total")
    private int total;
}