/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Controller;

import TFD.Entidade.Funcionario;
import TFD.Negocio.IFuncionarioRepositorio;
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
    IFuncionarioRepositorio dao;
    

    /**
     * Creates a new instance of FuncionarioController
     */
    public FuncionarioController() {
        entidade = new Funcionario();
        filtro = new Funcionario();
    }

    /**
     *
     * @param msg
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

    /**
     *
     * @return
     */
    public String editar() {
        return "FuncionarioEditar.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String novo(){
        return "FuncionarioEditar.xhtml";
    }

    /**
     *
     * @return
     */
    public String criar() {
        entidade = new Funcionario();
        return "FuncionarioEditar.xhtml";
    }

    /**
     *
     * @return
     */
    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "FuncionarioListagem.xhtml";
    }

    /**
     *
     * @return
     */
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "FuncionarioListagem.xhtml";
    }

    /**
     *
     * @return
     */
    public String voltar() {
        listagem = null;
        return "FuncionarioListagem.xhtml";
    }
    
    /**
     *
     * @return
     */
    public Funcionario getEntidade() {
        return entidade;
    }

    /**
     *
     * @param entidade
     */
    public void setEntidade(Funcionario entidade) {
        this.entidade = entidade;
    }

    /**
     *
     * @return
     */
    public List<Funcionario> getListagem() {
        if (listagem == null) {
            Funcionario filtro = new Funcionario();
            listagem = dao.Buscar(filtro);
        }
        return listagem;
    }

    /**
     *
     * @param listagem
     */
    public void setListagem(List<Funcionario> listagem) {
        this.listagem = listagem;
    }

    /**
     *
     * @return
     */
    

    /**
     *
     * @param listagemTipos
     */
   

    /**
     *
     * @return
     */
    public Funcionario getFiltro() {
        return filtro;
    }

    /**
     *
     * @param filtro
     */
    public void setFiltro(Funcionario filtro) {
        this.filtro = filtro;
    }
}
