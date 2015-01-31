/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Usuario;
import TFD.DomainModel.UsuarioRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "usuarioConverter")
@SessionScoped
public class UsuarioConverter implements Serializable,Converter {

    /**
     * Creates a new instance of UsuarioConverter
     */
    public UsuarioConverter() {
    }
    
    @EJB
    UsuarioRepositorio daoUsuario;
    
    public List<Usuario> autoCompleteUsuario(String query){
        Usuario filtro = new Usuario();
        filtro.setNome(query);
        return daoUsuario.Buscar(filtro);
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoUsuario.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Usuario u = (Usuario) value;
            return u.getId().toString();
        }
    }
}
