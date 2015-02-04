/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Atendimento;
import TFD.DomainModel.AtendimentoRepositorio;
import TFD.DomainModel.Clinicatr;
import TFD.DomainModel.ClinicatrRepositorio;
import TFD.DomainModel.Especialidade;
import TFD.DomainModel.EspecialidadeRepositorio;
import TFD.DomainModel.Hospital;
import TFD.DomainModel.HospitalRepositorio;
import TFD.DomainModel.Paciente;
import TFD.DomainModel.PacienteRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "atendimentoController")
@SessionScoped
public class AtendimentoController extends ControllerGenerico<Atendimento>  implements Serializable {
    
//      List<Hospital>listagemHospitals;
//      List<Clinicatr> listagemClinicatrs;
//      List<Especialidade> listagemEspecialidades;
//      List<Paciente> listagemPacientes;

    @EJB
     AtendimentoRepositorio dao;
    
//    @EJB
//     HospitalRepositorio daoHospital;
//    
//    @EJB
//      ClinicatrRepositorio daoClinicatr;
//    
//    @EJB
//      EspecialidadeRepositorio daoEspecialidade;
//    
//    @EJB
//      PacienteRepositorio daoPaciente;
    
    

    /**
     * Creates a new instance of FuncionarioController
     */
    public AtendimentoController() {
        entidade = new Atendimento();
        filtro = new Atendimento();
//        hospital = new Hospital();
//        clinicatr = new Clinicatr();
//        especialidade = new Especialidade();
//        paciente = new Paciente();
    }

    /**
     *
     */
    
     public void validarEspacoEmBranco(FacesContext contexto, UIComponent componente, Object valor) {
        String valorString = (String) valor;
        if (valorString.trim().equals("")) {
            ((UIInput) componente).setValid(false);
            String mensagem = componente.getAttributes().get("label")
                    + ":Não é permitido espaço em branco. ";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
            contexto.addMessage(componente.getClientId(contexto), facesMessage);
        }

    }
    
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    } 

    /**
     *
     Criando o Metodo de salvar */
   public void salvar() {
        if(dao.Salvar(entidade)){
            listagem = null; 
        } else {
            //mensagem de erro
        }
    }

   
    public String editar() {
        return "Atendimento.xhtml";
    }
    
   
    public String novo(){
        entidade = new Atendimento();
        return "Atendimento.xhtml";
    }
    
    @Override
    public String abrir() {
        return "Atendimento.xhtml";
    }

   
    public String criar() {
        entidade = new Atendimento();
        return "ListagemAtendimento.xhtml";
    }

    @Override
    public String cancelar() {
        return "ListagemAtendimento.xhtml";
    }
   
    @Override
    public String excluir() {
        if(dao.Apagar(entidade)){
            listagem = null; 
            return "";
        } else {
            return "";
        }
    }

  
    @Override
    public void filtrar() {
        listagem = dao.Buscar(filtro);
    }

    public AtendimentoRepositorio getDao() {
        return dao;
    }

    public void setDao(AtendimentoRepositorio dao) {
        this.dao = dao;
    }

    
    
    
//    public List<Hospital> getListagemHospitals() {
//        
//        if (listagemHospitals == null) {
//            Atendimento filtro = new Atendimento();
//            listagemHospitals = daoHospital.Buscar(null);
//        }       
//        return listagemHospitals;
//    }
//
//    public void setListagemHospitals(List<Hospital> listagemHospitals) {
//        this.listagemHospitals = listagemHospitals;
//    }
//
//    
//    public List<Clinicatr> getListagemClinicatrs() {
//        if (listagemClinicatrs == null) {
//            Atendimento filtro = new Atendimento();
//            listagemClinicatrs = daoClinicatr.Buscar(null);
//        }   
//        return listagemClinicatrs;
//    }
//
//    public void setListagemClinicatrs(List<Clinicatr> listagemClinicatrs) {
//        this.listagemClinicatrs = listagemClinicatrs;
//    }
//
//    public List<Especialidade> getListagemEspecialidades() {
//        if (listagemEspecialidades == null) {
//            Atendimento filtro = new Atendimento();
//            listagemEspecialidades = daoEspecialidade.Buscar(null);
//        }   
//        return listagemEspecialidades;
//    }
//
//    public void setListagemEspecialidades(List<Especialidade> listagemEspecialidades) {
//        this.listagemEspecialidades = listagemEspecialidades;
//    }
//
//    public List<Paciente> getListagemPacientes() {
//        if (listagemPacientes == null) {
//            Atendimento filtro = new Atendimento();
//            listagemPacientes = daoPaciente.Buscar(null);
//        }   
//        return listagemPacientes;
//    }
//
//    public void setListagemPacientes(List<Paciente> listagemPacientes) {
//        this.listagemPacientes = listagemPacientes;
//    }
//
//   
    
    
      
    
}
