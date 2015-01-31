/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Agendamento;
import TFD.DomainModel.AgendamentoRepositorio;
import TFD.DomainModel.Especialidade;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "AgendamentoReciboRepositorio")
public class AgendamentoDAO  extends DAOGenerico<Agendamento> implements AgendamentoRepositorio {
    
      public AgendamentoDAO() {
        super(Agendamento.class);
    }
     
     
     @Override
    public List<Agendamento> Buscar(Agendamento obj) {
        // Corpo da consulta
        String consulta = "select ag from Agendamento ag";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getMunicipioDestino() != null && obj.getMunicipioDestino().length() > 0) {
                filtro += " lower(ag.municipioDestino) like lower('%" + obj.getMunicipioDestino() + "%')";                
            }

            if (obj.getMunicipioDestino()!= null && obj.getMunicipioDestino().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " ag.municipioDestino=:municipioDestino ";
                parametros.put("municipioDestino", obj.getMunicipioDestino());
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
