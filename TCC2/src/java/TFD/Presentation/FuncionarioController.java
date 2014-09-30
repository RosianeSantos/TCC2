/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Funcionario;
import TFD.DomainModel.FuncionarioRepositorio;
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
@Named(value = "funcionarioController")
@SessionScoped
public class FuncionarioController implements Serializable {

    Funcionario entidade;
    Funcionario filtro;
    List<Funcionario> lista;

    @EJB
    FuncionarioRepositorio dao;
    

    /**
     * Creates a new instance of FuncionarioController
     */
    public FuncionarioController() {
        entidade = new Funcionario();
        filtro = new Funcionario();
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
        dao.Salvar(entidade);
        lista = null;
        exibirMensagem("Salvo!");
    }

   
    public String editar() {
        return "FuncionarioEditar.xhtml";
    }
    
   
    public String novo(){
        return "FuncionarioEditar.xhtml";
    }

   
    public String criar() {
        entidade = new Funcionario();
        return "FuncionarioEditar.xhtml";
    }

   
    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Apagado com sucesso!");
        return "FuncionarioListagem.xhtml";
    }

  
    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "FuncionarioListagem.xhtml";
    }

    
    public String voltar() {
        lista = null;
        return "FuncionarioListagem.xhtml";
    }
    
  
    public Funcionario getEntidade() {
        return entidade;
    }

    public void setEntidade(Funcionario entidade) {
        this.entidade = entidade;
    }

    public List<Funcionario> getListagem() {
        if (lista == null) {
            Funcionario filtro = new Funcionario();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

  
    public void setListagem(List<Funcionario> listagem) {
        this.lista = listagem;
    }

    
    public Funcionario getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Funcionario filtro) {
        this.filtro = filtro;
    }
}
