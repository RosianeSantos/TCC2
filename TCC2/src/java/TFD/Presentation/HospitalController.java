/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Funcionario;
import TFD.DomainModel.Hospital;
import TFD.DomainModel.HospitalRepositorio;
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
@Named(value = "hospitalController")
@SessionScoped
public class HospitalController implements Serializable {

    Hospital entidade;
    Hospital filtro;
    List<Hospital> lista;

    @EJB
    HospitalRepositorio dao;
    
    
     public HospitalController() {
        entidade = new Hospital();
        filtro = new Hospital();
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
        return "HospitalEditar.xhtml";
    }
    
   
    public String novo(){
        return "HospitalEditar.xhtml";
    }

   
    public String criar() {
        entidade = new Hospital();
        return "HospitalEditar.xhtml";
    }

   
    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Apagado com sucesso!");
        return "HospitalListagem.xhtml";
    }

  
    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "HospitalListagem.xhtml";
    }

    
    public String voltar() {
        lista = null;
        return "HospitalListagem.xhtml";
    }
    
  
    public Hospital getEntidade() {
        return entidade;
    }

    public void setEntidade(Hospital entidade) {
        this.entidade = entidade;
    }

    public List<Hospital> getListagem() {
        if (lista == null) {
            Hospital filtro = new Hospital();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

  
    public void setListagem(List<Hospital> listagem) {
        this.lista = listagem;
    }

    
    public Hospital getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Hospital filtro) {
        this.filtro = filtro;
    }
}
