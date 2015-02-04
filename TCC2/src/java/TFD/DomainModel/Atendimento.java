/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DomainModel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Rosy
 */
@Entity
public class Atendimento implements Entidade, Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAtendimento")
    private Integer idAtendimento;
    
    
    private String nome;
    
    @JoinColumn(name = "idHospital", referencedColumnName = "idHospital")
    @OneToOne
    private Hospital Hospital;
    
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @OneToOne
    private Paciente Paciente;
     
    @JoinColumn(name = "idClinicatr", referencedColumnName = "idClinicatr")
    @OneToOne
    private Clinicatr Clinicatr;
    
   
    @JoinColumn(name = "idEspecialidade", referencedColumnName = "idEspecialidade")
    @OneToOne
    private Especialidade Especialidade;

    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public Integer getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(Integer idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Hospital getHospital() {
        return Hospital;
    }

    public void setHospital(Hospital Hospital) {
        this.Hospital = Hospital;
    }

    public Paciente getPaciente() {
        return Paciente;
    }

    public void setPaciente(Paciente Paciente) {
        this.Paciente = Paciente;
    }

    public Clinicatr getClinicatr() {
        return Clinicatr;
    }

    public void setClinicatr(Clinicatr Clinicatr) {
        this.Clinicatr = Clinicatr;
    }

    public Especialidade getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(Especialidade Especialidade) {
        this.Especialidade = Especialidade;
    }

   
       
    
    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
