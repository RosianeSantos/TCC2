/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Atendimento;
import TFD.DomainModel.AtendimentoRepositorio;
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
@Named(value = "atendimentoConverter")
@SessionScoped
public class AtendimentoConverter implements Serializable, Converter{
   
    public AtendimentoConverter(){
    }

     @EJB
     AtendimentoRepositorio daoAtendimento;
    
     
     public List<Atendimento> AutoCompleteAtendimento (String query){
        Atendimento filtro = new Atendimento();
        filtro.setNome(query);
        return daoAtendimento.Buscar(filtro);
    }
     
     
     @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Atendimento at = (Atendimento)value;
          return at.getIdAtendimento().toString();
      } 
    }
    
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoAtendimento.Abrir(id);
        }
    }
    
}
