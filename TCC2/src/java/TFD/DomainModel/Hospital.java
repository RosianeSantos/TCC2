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
public class Hospital implements Entidade,  Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long IdHospital;
    private String Nome;
    private String Endereço;
    private String Telefone1;
    private String Telefone2;
    private String Telefone3;

    public Long getIdHospital() {
        return IdHospital;
    }

    public void setIdHospital(Long IdHospital) {
        this.IdHospital = IdHospital;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
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

    @Override
    public Long getId() {
        return null;
    }
    

    

  
}
