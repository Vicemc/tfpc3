package br.com.tfpc3.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;


@Data
@Entity
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer veiculo_id;
    private String placa;
    private String cor;
    private Integer anoModelo;
    private Integer anoFabricacao;

    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "marca_id")
    private Marca marca;
}
