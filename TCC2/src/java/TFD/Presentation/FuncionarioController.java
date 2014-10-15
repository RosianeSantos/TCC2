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
        return "CadastroFuncionario.xhtml";
    }
    
   
    public String novo(){
        entidade = new Funcionario();
        return "CadastroFuncionario.xhtml";
    }

   
    public String criar() {
        entidade = new Funcionario();
        return "CadastroFuncionario.xhtml";
    }

   
    public String apagar() {
        if(dao.Apagar(entidade)){
        lista = null;
        exibirMensagem("Apagado com sucesso!");
        return "FuncionarioListar.xhtml";
        }else{
            return "";
        }
    }

  
    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "FuncionarioListar.xhtml";
    }

    
    public String voltar() {
        lista = null;
        return "CadastroFuncionario.xhtml";
    }
    
  
    public Funcionario getEntidade() {
        return entidade;
    }

    public void setEntidade(Funcionario entidade) {
        this.entidade = entidade;
    }

    public List<Funcionario> getLista() {
        if (lista == null) {
            Funcionario filtro = new Funcionario();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

  
    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }

    
    public Funcionario getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Funcionario filtro) {
        this.filtro = filtro;
    }
}
