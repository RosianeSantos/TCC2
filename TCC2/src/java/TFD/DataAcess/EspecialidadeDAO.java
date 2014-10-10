/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Especialidade;
import TFD.DomainModel.EspecialidadeRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "EspecialidadeRepositorio")
public class EspecialidadeDAO
            extends DAOGenerico<Especialidade> implements EspecialidadeRepositorio{
    
     public EspecialidadeDAO() {
        super(Especialidade.class);
    }
     
     
     @Override
    public List<Especialidade> Buscar(Especialidade obj) {
        // Corpo da consulta
        String consulta = "select e from Especialidade e";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " lower(e.nome) like lower('%" + obj.getNome() + "%')";                
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " e.nome=:nome ";
                parametros.put("nome", obj.getNome());
            }

            if (obj.getIdEspecialidade()!= null && obj.getIdEspecialidade()> 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " e.idEspecialidade =:idEspecialidade";
                parametros.put("idFuncionario", obj.getIdEspecialidade());
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
