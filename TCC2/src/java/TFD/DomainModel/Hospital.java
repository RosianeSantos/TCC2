/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DomainModel;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
public class Hospital implements Entidade,  Serializable{
    
   
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHospital;
    
    private String nomeHospital;
    private String Telefone1;
    private String Telefone2;
    private String Telefone3;
    private String enderecoHospital;
    private String Complemento;
    private int numero;
    
//    @ManyToOne(cascade= CascadeType.ALL)
//    private Cidade cidade;
    
    
    
    
    
    public String getNomeHospital() {
        return nomeHospital;
    }

    public void setNomeHospital(String nomeHospital) {
        this.nomeHospital = nomeHospital;
    }

    public String getEnderecoHospital() {
        return enderecoHospital;
    }

    public void setEnderecoHospital(String enderecoHospital) {
        this.enderecoHospital = enderecoHospital;
    }
       
    public String getTelefone1() {
        return Telefone1;
    }

    public void setTelefone1(String Telefone1) {
        this.Telefone1 = Telefone1;
    }

    public String getTelefone2() {
        return Telefone2;
    }

    public void setTelefone2(String Telefone2) {
        this.Telefone2 = Telefone2;
    }

    public String getTelefone3() {
        return Telefone3;
    }

    public void setTelefone3(String Telefone3) {
        this.Telefone3 = Telefone3;
    }

    
    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Long getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Long idHospital) {
        this.idHospital = idHospital;
    }

//    public Cidade getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(Cidade cidade) {
//        this.cidade = cidade;
//    }

    

  @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idHospital != null ? this.idHospital.hashCode() : 0);
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
        final Hospital other = (Hospital) obj;
        if (this.idHospital != other.idHospital && (this.idHospital == null || !this.idHospital.equals(other.idHospital))) {
            return false;
        }
        return true;
    }

    
@Override
    public String toString() {
        return nomeHospital;
    }    
    
    @Override
    public Long getId() {
        return null;
    }
    

    

  
}
