/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DomainModel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rosy
 */
@Entity
public class Carro implements Entidade, Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarro;
    
    private String modelo;
//    private String quantidade;
    private String placa;
    
//    @ManyToOne(cascade= CascadeType.ALL)
//    private Categoria categoria;

    public Long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

//    public String getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(String quantidade) {
//        this.quantidade = quantidade;
//    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

//     public Categoria getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(Categoria categoria) {
//        this.categoria = categoria;
//    }



     @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarro != null ? idCarro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.idCarro == null && other.idCarro != null) || (this.idCarro != null && !this.idCarro.equals(other.idCarro))) {
            return false;
        }
        return true;
    }

   

    @Override
    public Long getId() {
       return null;
    }

     @Override
    public String toString() {
        return modelo;
    }
}




