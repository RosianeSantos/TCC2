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
    List<Funcionario> listagem;
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
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    /**
     *
     Criando o Metodo de salvar */
    public void salvar() {
        if(entidade.getNome().trim().length() == 0){
           exibirMensagem("Valor Inválido, preencha o campo: NOME com caracteres diferentes de espaço!");
           return;
        }
         if(entidade.getLogin().trim().length() == 0){
           exibirMensagem("Valor Inválido, preencha o campo: LOGIN com caracteres diferentes de espaço!");
           return;
        }
          if(entidade.getSenha().trim().length() == 0){
           exibirMensagem("Valor Inválido, preencha o campo: SENHA com caracteres diferentes de espaço!");
           return;
        }
          
        entidade = dao.Salvar(entidade);
        listagem = null;
        exibirMensagem("Operação realizada com Sucesso!");

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
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "FuncionarioListagem.xhtml";
    }

  
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "FuncionarioListagem.xhtml";
    }

    
    public String voltar() {
        listagem = null;
        return "FuncionarioListagem.xhtml";
    }
    
  
    public Funcionario getEntidade() {
        return entidade;
    }

    public void setEntidade(Funcionario entidade) {
        this.entidade = entidade;
    }

    public List<Funcionario> getListagem() {
        if (listagem == null) {
            Funcionario filtro = new Funcionario();
            listagem = dao.Buscar(filtro);
        }
        return listagem;
    }

  
    public void setListagem(List<Funcionario> listagem) {
        this.listagem = listagem;
    }

    
    public Funcionario getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Funcionario filtro) {
        this.filtro = filtro;
    }
}
