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
import javax.persistence.ManyToOne;

/**
 *
 * @author Rosy
 */
@Entity
public class Clinicatr implements Entidade, Serializable {
  
   
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClinicatr;
    
    private String nomeClinicatr;

    
    
    
    
    
    
    
    public Long getIdClinicatr() {
        return idClinicatr;
    }

    public void setIdClinicatr(Long idClinicatr) {
        this.idClinicatr = idClinicatr;
    }

    public String getNomeClinicatr() {
        return nomeClinicatr;
    }

    public void setNomeClinicatr(String nomeClinicatr) {
        this.nomeClinicatr = nomeClinicatr;
    }
    
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idClinicatr != null ? this.idClinicatr.hashCode() : 0);
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
        final Clinicatr other = (Clinicatr) obj;
        if (this.idClinicatr != other.idClinicatr && (this.idClinicatr == null || !this.idClinicatr.equals(other.idClinicatr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeClinicatr;
    }
    
    
    
    @Override
    public Long getId() {
        return null;
    }

 
    
}
