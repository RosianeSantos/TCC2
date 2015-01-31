/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Cidade;
import TFD.DomainModel.CidadeRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "ICidadeRepositorio")
public class CidadeDAO 
        extends DAOGenerico<Cidade>
        implements CidadeRepositorio{
    
    public CidadeDAO() {
        super(Cidade.class);
    }
    
    
    @Override
    public List<Cidade> Buscar(Cidade obj) {
        // Corpo da consulta
        String consulta = "select c from Cidade c";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " lower(c.nome) like lower('%" + obj.getNome() + "%')";                
            }

            if (obj.getEstado()!= null && obj.getEstado().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " c.estado=:estado ";
                parametros.put("estado", obj.getEstado());
            }

            if (obj.getIdCidade()!= null && obj.getIdCidade()> 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " c.idCidade =:idCidade";
                parametros.put("idCidade", obj.getIdCidade());
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
