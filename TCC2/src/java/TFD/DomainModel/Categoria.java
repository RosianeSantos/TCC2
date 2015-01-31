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
public class Categoria implements Entidade, Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategoria;
    
    private String nome;
    private String quantidade;

    
    
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.idCategoria != other.idCategoria && (this.idCategoria == null || !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idCategoria + " - " + nome;
    }

    @Override
    public Long getId() {
        return null;
    }
  
    
    
    
}
