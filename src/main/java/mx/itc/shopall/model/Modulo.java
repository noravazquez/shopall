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
@Data
@ToString
@Entity
@Table(name = "modulo")
public class Modulo implements Serializable{
    @Id
    @Column(name = "id_modulo")
    private int id_modulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column (name = "url")
    private String url;
}
