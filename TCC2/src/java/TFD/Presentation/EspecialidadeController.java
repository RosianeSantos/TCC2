/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Especialidade;
import TFD.DomainModel.EspecialidadeRepositorio;
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
@Named(value = "especialidadeController")
@SessionScoped
public class EspecialidadeController implements Serializable{
    
    Especialidade entidade;
    Especialidade filtro;
    List<Especialidade> lista;

    @EJB
    EspecialidadeRepositorio dao;
    
    
    public EspecialidadeController() {
        entidade = new Especialidade();
        filtro = new Especialidade();
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
        return "EspecialidadeEditar.xhtml";
    }
    
   
    public String novo(){
        return "EspecialidadeEditar.xhtml";
    }

   
    public String criar() {
        entidade = new Especialidade();
        return "EspecialidadeEditar.xhtml";
    }

   
    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Apagado com sucesso!");
        return "EspecialidadeListagem.xhtml";
    }

  
    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "EspecialidadeListagem.xhtml";
    }

    
    public String voltar() {
        lista = null;
        return "EspecialidadeListagem.xhtml";
    }
    
  
    public Especialidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Especialidade entidade) {
        this.entidade = entidade;
    }

    public List<Especialidade> getListagem() {
        if (lista == null) {
            Especialidade filtro = new Especialidade();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

  
    public void setListagem(List<Especialidade> listagem) {
        this.lista = listagem;
    }

    
    public Especialidade getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Especialidade filtro) {
        this.filtro = filtro;
    }
    
}
