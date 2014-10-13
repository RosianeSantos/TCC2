/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Categoria;
import TFD.DomainModel.CategoriaRepositorio;
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
@Named(value = "categoriaController")
@SessionScoped
public class CategoriaController implements Serializable{
    
    Categoria entidade;
    Categoria filtro;
    List<Categoria> lista;

    @EJB
    CategoriaRepositorio dao;
    
    
    public CategoriaController() {
        entidade = new Categoria();
        filtro = new Categoria();
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
        return "CategoriaEditar.xhtml";
    }
    
   
    public String novo(){
        return "CategoriaEditar.xhtml";
    }

   
    public String criar() {
        entidade = new Categoria();
        return "CategoriaEditar.xhtml";
    }

   
    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Apagado com sucesso!");
        return "CategoriaListagem.xhtml";
    }

  
    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "CategoriaListagem.xhtml";
    }

    
    public String voltar() {
        lista = null;
        return "CategoriaListagem.xhtml";
    }
    
  
    public Categoria getEntidade() {
        return entidade;
    }

    public void setEntidade(Categoria entidade) {
        this.entidade = entidade;
    }

    public List<Categoria> getLista() {
        if (lista == null) {
            Categoria filtro = new Categoria();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

  
    public void setLista(List<Categoria> lista) {
        this.lista = lista;
    }

    
    public Categoria getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Categoria filtro) {
        this.filtro = filtro;
    }
    
}
