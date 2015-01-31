/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Usuario;
import TFD.DomainModel.UsuarioRepositorio;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rosy
 */
@Named(value = "autenticacaoController")
@SessionScoped
public class AutenticacaoController
         implements Serializable {

    /**
     * Creates a new instance of AutenticacaoController
     */
    public AutenticacaoController() {
         
    }
    
    
//       @EJB
    UsuarioRepositorio dao;
    private String login, senha;
    Usuario usuario;
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("TCC2PU");
    private EntityManager em;

  
    
    public void Mensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String validar() {
        try {
        usuario = buscarUsuario(login,senha);

        if (usuario == null) {
            Mensagem("Login ou senha não correspondem!");
            return "login.xhtml";
        } else {
            if (senha.equals(usuario.getSenha())) {

                HttpSession session;

                FacesContext ctx = FacesContext.getCurrentInstance();
                session = (HttpSession) ctx.getExternalContext().getSession(false);
                session.setAttribute("usuarioAutenticado", usuario);

               // AppendLog("Login");

                return "Template.xhtml";
            } else {
                Mensagem("Login ou senha não correspondem");
                return "login.xhtml";
            }
        }
        } catch(Exception ex){
            Mensagem("Login ou senha não correspondem");
            return "login.xhtml";
        }

    }

    public String logout() {
        HttpSession session;

        FacesContext ctx = FacesContext.getCurrentInstance();
        session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.setAttribute("usuarioAutenticado", null);

       // AppendLog("Logout");
        
        Enumeration<String> vals = session.getAttributeNames(); 
        
        while(vals.hasMoreElements()){
            session.removeAttribute(vals.nextElement());
        }

        return "login.xhtml";

    }
    
    public Usuario buscarUsuario(String login, String senha) {
        em = factory.createEntityManager();
        Usuario usuario = null;
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND f.senha = :senha");
            query.setParameter("login", login);
            query.setParameter("senha", senha);
 
            usuario = (Usuario) query.getSingleResult();
 
        } catch (NoResultException e) {
            System.out.println("DAO: Não foi encontrado resultado!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
 
        return usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    
   
    
    
}
