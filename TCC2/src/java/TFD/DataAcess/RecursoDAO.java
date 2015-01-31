/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;


import TFD.DomainModel.RecursoRepositorio;
import TFD.DomainModel.Recurso;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "RecursoRepositorio")
public class RecursoDAO  extends DAOGenerico<Recurso> implements RecursoRepositorio {
    
    public RecursoDAO() {
        super(Recurso.class);
    }
     
     
     @Override
    public List<Recurso> Buscar(Recurso obj) {
        // Corpo da consulta
        String consulta = "select r from Recurso r";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " lower(r.Nome) like lower('%" + obj.getNome() + "%')";                
            }

//              if (obj.getNome()!= null && obj.getNome().length() > 0) {
//                if (filtro.length() > 0) {
//                    filtro += " and ";
//                }
//                filtro += " r.nome=:nome ";
//                parametros.put("nome", obj.getNome());
//            }

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
