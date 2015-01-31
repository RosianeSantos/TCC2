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
public class Especialidade implements Entidade, Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEspecialidade;
    
    private String nomeEspecialidade;

    
    
    
    public Long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

   

    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idEspecialidade != null ? this.idEspecialidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especialidade other = (Especialidade) obj;
        if (this.idEspecialidade != other.idEspecialidade && (this.idEspecialidade == null || !this.idEspecialidade.equals(other.idEspecialidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeEspecialidade;
    }
    
    @Override
    public Long getId() {
        return null;
    }
   
    
  
}
