/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Clinicatr;
import TFD.DomainModel.ClinicatrRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "ClinicatrRepositorio")
public class ClinicatrDAO extends DAOGenerico<Clinicatr> implements ClinicatrRepositorio {
    
      public ClinicatrDAO() {
        super(Clinicatr.class);
    }
     
     
     @Override
    public List<Clinicatr> Buscar(Clinicatr obj) {
        // Corpo da consulta
        String consulta = "select cl from Clinicatr cl";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNomeClinicatr()!= null && obj.getNomeClinicatr().length() > 0) {
                filtro += " lower(cl.nomeClinicatr) like lower('%" + obj.getNomeClinicatr()+ "%')";                
            }

            if (obj.getNomeClinicatr()!= null && obj.getNomeClinicatr().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " cl.nomeClinicatr=:nomeClinicatr ";
                parametros.put("nomeClinicatr", obj.getNomeClinicatr());
            }

            if (obj.getIdClinicatr()!= null && obj.getIdClinicatr()> 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " cl.idClinicatr =:idClinicatr";
                parametros.put("idClinicatr", obj.getIdClinicatr());
            }

            

           // Se houver filtros, coloca o "where" na consulta
            if (filtro.length() > 0) {
                consulta = consulta + " where " + filtro;
            }
        }

        // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Aplica os parâmetros da consulta
        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }

        // Executa a consulta
        return query.getResultList();

    }
    
  
    
}
