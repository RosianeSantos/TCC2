/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;



import TFD.DomainModel.Hospital;
import TFD.DomainModel.HospitalRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */

@Stateless(name = "HospitalRepositorio")
public class HospitalDAO 
            extends DAOGenerico<Hospital>
        implements HospitalRepositorio{
    
    
    public HospitalDAO() {
        super(Hospital.class);
    }
    
    
     @Override
    public List<Hospital> Buscar(Hospital obj) {
  
        String sql = "select h from Hospital h";
        
        String filtros = "";
        
        if(obj != null){
            if(obj.getIdHospital()!= null && obj.getIdHospital()> 0 ){ 
                filtros += "h.idhospital = " + obj.getIdHospital();
            
        }
            
           
        if(obj.getNomeHospital()!= null){
                if(filtros.length() > 0)
                    filtros += " and ";
                filtros += "h.nomeHospital like '%" + obj.getNomeHospital()+ "%'"; 
            
        }
        }
        
        if(filtros.length() > 0){
            sql += " where " + filtros;
        }
        
        Query consulta = manager.createQuery(sql);
        
        return consulta.getResultList();
    
    }
    
}
