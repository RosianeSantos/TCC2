/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DomainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    
  
    @OneToMany()
    private Hospital Hospital;
    
    @OneToMany()
    private Paciente Paciente;
     
    @OneToMany()
    private Clinicatr Clinicatr;
    
   
    @OneToMany()
    private Especialidade Especialidade;

//     @ManyToMany(cascade= CascadeType.ALL) 
//    private List<Endereco> endereco;  
//     
//     public Atendimento() {
//        this.endereco = new ArrayList<>();
//        
//    }
//     
     
//       public void addEndereco(Endereco e){         
//          if(endereco == null)
//            endereco = new ArrayList<>();
//        if(!endereco.contains(e)){
//            endereco.add(e);
//        }
//        
//    }
//    
//    public void removeEndereco(Endereco e){
//        if(endereco.contains(e)){
//            endereco.remove(e);
//        }
//    }
    
    // Getter e Setter
    
    
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


//     public List<Endereco> getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(List<Endereco> endereco) {
//        this.endereco = endereco;
//    }
//    
    
    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
