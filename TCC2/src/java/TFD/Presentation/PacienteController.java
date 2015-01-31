/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Paciente;
import TFD.DomainModel.PacienteRepositorio;
import java.io.Serializable;
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
@Named(value = "pacienteController")
@SessionScoped
public class PacienteController extends ControllerGenerico<Paciente> implements Serializable{
    
//    Paciente entidade;
//    Paciente filtro;
//    List<Paciente> lista;

    @EJB
    PacienteRepositorio dao;
    

    /**
     * Creates a new instance of PacienteController
     */
    public PacienteController() {
        entidade = new Paciente();
        filtro = new Paciente();
    }
    
    
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
     
     
//      public void validaCPF (FacesContext context, UIComponent component, Object value) throws ValidatorException {
//
//     
//        if (!ValidacaoCPF.validaCPF(value.toString())) {
//            FacesMessage msg
//                    = new FacesMessage("CPF Inválido!");
//            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//            throw new ValidatorException(msg);
//        }
//    }
//     
//     
//      public void exibirMensagem(String msg) {
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage(msg));
//    } 

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
        return "Paciente.xhtml";
    }
    
   
    public String novo(){
        entidade = new Paciente();
        return "Paciente.xhtml";
    }

    @Override
    public String abrir() {
        return "Paciente.xhtml";
    }
   
    public String criar() {
        entidade = new Paciente();
        return "ListagemPaciente.xhtml";
    }

     @Override
    public String cancelar() {
        return "ListagemPaciente.xhtml";
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

    
    public PacienteRepositorio getDao() {
        return dao;
    }

    public void setDao(PacienteRepositorio dao) {
        this.dao = dao;
    }
    
}
