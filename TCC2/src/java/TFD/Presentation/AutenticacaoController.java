/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TFD.Presentation;

import TFD.DataAcess.FuncionarioDAO;
import TFD.DomainModel.Funcionario;
import TFD.DomainModel.FuncionarioRepositorio;
import java.io.Serializable;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rosy
 */
@Named(value = "autenticacaoController")
@SessionScoped
public class AutenticacaoController
        implements Serializable {

    @EJB
    FuncionarioRepositorio dao;

    private String login, senha;
    Funcionario funcionario;

    /**
     * Creates a new instance of AutenticacaoController
     */
    public AutenticacaoController() {

        dao = new FuncionarioDAO();
        funcionario = new Funcionario();
//        login = new Funcionario();

    }

    public void exibirMensagem(String msg) {

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    public String validar(){
        String home = "TemplateUsuario.xhtml";
        String adm = "Template.xhtml";
        try {
            funcionario = dao.Validar(login);
            if (funcionario == null) {
                exibirMensagem("Login ou Senha não Correspondem!");
                return "login.xhtml";
            } 
            else {
                if (((funcionario.getNome().equals("administrador"))) && (funcionario.getIdFuncionario() == 2)) {
                        HttpSession session;
                        FacesContext ctx = FacesContext.getCurrentInstance();
                        session = (HttpSession) ctx.getExternalContext().getSession(false);
                        session.setAttribute("FuncionarioAutenticado", funcionario);
                        exibirMensagem("Seja Bem Vindo" + funcionario.getNome() + "!");
                        return adm;
                    
                }
                else {
                    HttpSession session;
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    session = (HttpSession) ctx.getExternalContext().getSession(false);
                    session.setAttribute("FuncionarioAutenticado", funcionario);
                    exibirMensagem("Seja Bem Vindo" + funcionario.getNome() + "!");
                    return home;
                }
            }
        }catch (Exception ex) {
            exibirMensagem("Login ou Senhas Inválidos");
            return "login.xhtml";
        }       
    }
    

    

    

    public String logout() {

        HttpSession session;

        FacesContext ctx = FacesContext.getCurrentInstance();
        session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.setAttribute("FuncionarioAutenticado", null);

        Enumeration<String> vals = session.getAttributeNames();

        while (vals.hasMoreElements()) {
            session.removeAttribute(vals.nextElement());
        }

        return "login.xhtml";
    }

    //---------
    public FuncionarioRepositorio getDao() {
        return dao;
    }

    public void setDao(FuncionarioRepositorio dao) {
        this.dao = dao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
