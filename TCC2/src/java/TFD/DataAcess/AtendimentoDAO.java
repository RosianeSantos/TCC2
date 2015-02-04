/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Atendimento;
import TFD.DomainModel.AtendimentoRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "AtendimentoRepositorio")
public class AtendimentoDAO extends DAOGenerico<Atendimento> implements AtendimentoRepositorio {
    
     public AtendimentoDAO() {
        super(Atendimento.class);
    }
     
     
     @Override
    public List<Atendimento> Buscar(Atendimento obj) {
        String sql = "select at from Atendimento at";
        
        String filtros = "";
        
        if(obj != null){
            if(obj.getIdAtendimento()!= null && obj.getIdAtendimento()> 0 ){ 
                filtros += "at.Atendimento.idAtendimento = " + obj.getIdAtendimento();
            }
            
           
        if(obj.getHospital()!= null){
                if(filtros.length() > 0)
                    filtros += " and ";
                filtros += "at.Hospital like '%" + obj.getHospital()+ "%'"; 
            }
        
         if(obj.getPaciente()!= null){
                if(filtros.length() > 0)
                    filtros += " and ";
                filtros += "at.Paciente like '%" + obj.getPaciente()+ "%'"; 
            }
        
         if(obj.getClinicatr()!= null){
                if(filtros.length() > 0)
                    filtros += " and ";
                filtros += "at.Clinicatr like '%" + obj.getClinicatr()+ "%'"; 
            }
         
        }
        
        if(filtros.length() > 0){
            sql += " where " + filtros;
        }
        
        Query consulta = manager.createQuery(sql);
        
        return consulta.getResultList();
    }
     
     
}
