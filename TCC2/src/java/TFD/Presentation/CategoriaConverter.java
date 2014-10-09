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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "categoriaConverter")
@SessionScoped
public class CategoriaConverter implements Serializable, Converter{
    
    
     public CategoriaConverter() {
    }

     @EJB
     CategoriaRepositorio daoCategoria;
     
     
     
      public List<Categoria> AutoCompleteCategorias (String query){
        Categoria filtro = new Categoria();
        filtro.setNome(query);
        return daoCategoria.Buscar(filtro);
    }

   
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Categoria c = (Categoria)value;
          return c.getIdCategoria().toString();
      } 
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoCategoria.Abrir(id);
        }
    }

    
  
    
}
