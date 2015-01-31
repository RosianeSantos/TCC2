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
public class Recurso implements Entidade, Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecurso;
    
    private Double valorUnitario;
    private String Nome;
    private int codigoSai;

    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

   
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCodigoSai() {
        return codigoSai;
    }

    public void setCodigoSai(int codigoSai) {
        this.codigoSai = codigoSai;
    }

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
}
