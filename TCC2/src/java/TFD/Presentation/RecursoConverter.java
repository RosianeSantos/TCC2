/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.RecursoRepositorio;
import TFD.DomainModel.Recurso;
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
@Named(value = "recursoConverter")
@SessionScoped
public class RecursoConverter implements Serializable, Converter {
    
    public RecursoConverter(){

}
    
     @EJB
     RecursoRepositorio daoRecurso;
    
    public List<Recurso> AutoCompleteFuncionario (String query){
        Recurso filtro = new Recurso();
        filtro.setNome(query);
        return daoRecurso.Buscar(filtro);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Recurso e = (Recurso)value;
          return e.getIdRecurso().toString();
      } 
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoRecurso.Abrir(id);
        }
    }
    
    
}
