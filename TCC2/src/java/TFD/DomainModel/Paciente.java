/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DomainModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.br.CPF;
/**
 *
 * @author Rosy
 */
@Entity

public class Paciente implements Entidade,  Serializable {
    
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPaciente;
    
 
    private String nomePaciente;
    private String enderecoPaciente;
    private String complemento;
    private String numero;
    private String cep;
   
    private String telefoneR;
   
    private String telefoneC;
   
    private String telefoneCelular;
    private String sexo;
    private String rg;
    @Column(nullable = false, length = 11)
    @CPF
    private String cpf;

    
    
    
    
    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getEnderecoPaciente() {
        return enderecoPaciente;
    }

    public void setEnderecoPaciente(String enderecoPaciente) {
        this.enderecoPaciente = enderecoPaciente;
    }
    
    
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefoneR() {
        return telefoneR;
    }

    public void setTelefoneR(String telefoneR) {
        this.telefoneR = telefoneR;
    }

    public String getTelefoneC() {
        return telefoneC;
    }

    public void setTelefoneC(String telefoneC) {
        this.telefoneC = telefoneC;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
      @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idPaciente != null ? this.idPaciente.hashCode() : 0);
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
        final Paciente other = (Paciente) obj;
        if (this.idPaciente != other.idPaciente && (this.idPaciente == null || !this.idPaciente.equals(other.idPaciente))) {
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
        return nomePaciente;
    }
    
    
    
    
}
