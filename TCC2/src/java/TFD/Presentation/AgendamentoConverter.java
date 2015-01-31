/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Agendamento;
import TFD.DomainModel.AgendamentoRepositorio;
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
@Named(value = "agendamentoReciboConverter")
@SessionScoped
public class AgendamentoConverter implements Serializable, Converter{
    
     public AgendamentoConverter(){
    }

     @EJB
     AgendamentoRepositorio daoRecibo;
    
     
     public List<Agendamento> AutoCompleteFuncionario (String query){
        Agendamento filtro = new Agendamento();
        filtro.setFinalidade(query);
        return daoRecibo.Buscar(filtro);
    }
     
     
     @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Agendamento ag = (Agendamento)value;
          return ag.getIdAgendamento().toString();
      } 
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoRecibo.Abrir(id);
        }
    }
    
}
