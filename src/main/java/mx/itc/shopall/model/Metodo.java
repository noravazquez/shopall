package mx.itc.shopall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@ToString
@Data
@Entity
@Table(name = "metodo")
public class Metodo implements Serializable{
    @Id
    @Column(name = "id_metodo")
    private int id_metodo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "url")
    private String url;
    @Column(name = "metodo")
    private String metodo;
    @JoinColumn(name = "id_modulo")
    @OneToOne(fetch = FetchType.EAGER)
    private Modulo modulo;
}
