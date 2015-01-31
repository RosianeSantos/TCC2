/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Usuario;
import TFD.DomainModel.UsuarioRepositorio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController
    extends ControllerGenerico<Usuario> implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
        filtro = new Usuario();
        entidade = new Usuario(); 
    }
    
    @EJB
    UsuarioRepositorio dao;
    
    
    public String novaSenha(){
        
        return "novaSenha.xhtml";
    }
    
    
    @Override
    public void salvar() {
        if(dao.Salvar(entidade)){
            listagem = null; 
        } else {
            //mensagem de erro
        }
    }

    @Override
    public String novo(){
        entidade = new Usuario();
        return "cadastrarUsuario.xhtml";
    }
    
    @Override
    public String abrir() {
        return "cadastrarUsuario.xhtml";
    }

    @Override
    public String cancelar() {
        return "login.xhtml";
    }

    
    @Override
    public String excluir() {
        if(dao.Apagar(entidade)){
            listagem = null; 
            return "";
        } else {
            return "";
        }
    }

    @Override
    public void filtrar() {
        listagem = dao.Buscar(filtro);
    }

    public UsuarioRepositorio getDao() {
        return dao;
    }

    public void setDao(UsuarioRepositorio dao) {
        this.dao = dao;
    }
}
