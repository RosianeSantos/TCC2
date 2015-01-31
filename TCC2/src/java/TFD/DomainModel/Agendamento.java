/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rosy
 */
@Entity
public class Agendamento implements Entidade, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAgendamento")
    private Integer idAgendamento;
    
    
    @Basic(optional = false)
    @Column(name = "Viagem")
    @Temporal(TemporalType.DATE)
    private Date Viagem;
    
    @Basic(optional = false)
    @Column(name = "Finalidade")
    private String finalidade;
    
    @Basic(optional = false)

    @Column(name = "Acompanhante")
    private String acompanhante;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Situacao")
    private String situacao;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroTFD")
    private int numeroTFD;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Clinicatr")
    private String clinicatr;
    
     @Basic(optional = false)
    @NotNull
    @Column(name = "GRS")
    private String GRS;
     
      @Basic(optional = false)
    @NotNull
    @Column(name = "municipioDestino")
    private String municipioDestino;
      
       @Basic(optional = false)
    @NotNull
    @Column(name = "Quantidade")
    private int quantidade;
       
       @Basic(optional = false)
    @NotNull
    @Column(name = "valorTotal")
    private Double valorTotal;
     
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private Paciente idPaciente;
    @JoinColumn(name = "idCidade", referencedColumnName = "idCidade")
    @ManyToOne(optional = false)
    private Cidade idCidade;
    @JoinColumn(name = "idCarro", referencedColumnName = "idcarro")
    @ManyToOne(optional = false)
    private Carro idCarro;
    @JoinColumn(name = "idHospital", referencedColumnName = "idHospital")
    @ManyToOne(optional = false)
    private Hospital idHospital;
    @JoinColumn(name = "idEspecialidade", referencedColumnName = "idEspecialidade")
    @ManyToOne(optional = false)
    private Especialidade idEspecialidade;

    public Integer getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Integer idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getViagem() {
        return Viagem;
    }

    public void setViagem(Date Viagem) {
        this.Viagem = Viagem;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getNumeroTFD() {
        return numeroTFD;
    }

    public void setNumeroTFD(int numeroTFD) {
        this.numeroTFD = numeroTFD;
    }

    public String getClinicatr() {
        return clinicatr;
    }

    public void setClinicatr(String clinicatr) {
        this.clinicatr = clinicatr;
    }

    public String getGRS() {
        return GRS;
    }

    public void setGRS(String GRS) {
        this.GRS = GRS;
    }

    public String getMunicipioDestino() {
        return municipioDestino;
    }

    public void setMunicipioDestino(String municipioDestino) {
        this.municipioDestino = municipioDestino;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Cidade getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
    }

    public Carro getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Carro idCarro) {
        this.idCarro = idCarro;
    }

    public Hospital getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Hospital idHospital) {
        this.idHospital = idHospital;
    }

    public Especialidade getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Especialidade idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
    
    
    
    
    

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
