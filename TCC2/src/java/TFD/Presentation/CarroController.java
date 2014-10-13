/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Carro;
import TFD.DomainModel.CarroRepositorio;
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
@Named(value = "carroController")
@SessionScoped
public class CarroController implements Serializable {
    
    Carro entidade;
    Carro filtro;
    List<Carro> lista;
    List<Categoria> listagemcategoria;

    @EJB
    CarroRepositorio dao;
    
    @EJB
    CategoriaRepositorio daoCategoria;
    
    
    public CarroController() {
        entidade = new Carro();
        filtro = new Carro();
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
        return "CarroEditar.xhtml";
    }
    
   
    public String novo(){
        return "Carro.xhtml";
    }

   
    public String criar() {
        entidade = new Carro();
        return "Carro.xhtml";
    }

   
    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Apagado com sucesso!");
        return "CarroListagem.xhtml";
    }

  
    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "CarroListagem.xhtml";
    }

    
    public String voltar() {
        lista = null;
        return "CarroListagem.xhtml";
    }
    
  
    public Carro getEntidade() {
        return entidade;
    }

    public List<Carro> getLista() {
        if (lista == null) {
            Carro filtro = new Carro();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setLista(List<Carro> lista) {
        this.lista = lista;
    }

    public List<Categoria> getListagemcategoria() {
        if (listagemcategoria == null) {
            listagemcategoria = daoCategoria.Buscar(null);
        }
        return listagemcategoria;
    }

    public void setListagemcategoria(List<Categoria> listagemcategoria) {
       
        this.listagemcategoria = listagemcategoria;
    }

    
    
    public Carro getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Carro filtro) {
        this.filtro = filtro;
    }
    
}
