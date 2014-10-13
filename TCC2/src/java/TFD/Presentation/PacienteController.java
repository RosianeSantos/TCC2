/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


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
@Named(value = "pacienteController")
@SessionScoped
public class PacienteController implements Serializable{
    
    Paciente entidade;
    Paciente filtro;
    List<Paciente> lista;

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
     
     
     
      public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    } 

    /**
     *
     Criando o Metodo de salvar */
    public void salvar() {
        dao.Salvar(entidade);
        lista = null;
        exibirMensagem("Salvo!");
    }

   
    public String editar() {
        return "PacienteEditar.xhtml";
    }
    
   
    public String novo(){
        return "PacienteEditar.xhtml";
    }

   
    public String criar() {
        entidade = new Paciente();
        return "PacienteEditar.xhtml";
    }

   
    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Apagado com sucesso!");
        return "PacienteListagem.xhtml";
    }

  
    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "PacienteListagem.xhtml";
    }

    
    public String voltar() {
        lista = null;
        return "PacienteListagem.xhtml";
    }
    
  
    public Paciente getEntidade() {
        return entidade;
    }

    public void setEntidade(Paciente entidade) {
        this.entidade = entidade;
    }

    public List<Paciente> getListagem() {
        if (lista == null) {
            Paciente filtro = new Paciente();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

  
    public void setListagem(List<Paciente> listagem) {
        this.lista = listagem;
    }

    
    public Paciente getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Paciente filtro) {
        this.filtro = filtro;
    }
    
}
