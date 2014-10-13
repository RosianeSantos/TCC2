/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Carro;
import TFD.DomainModel.CarroRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "CarroRepositorio")
public class CarroDAO extends DAOGenerico<Carro>
        implements CarroRepositorio {
    
    public CarroDAO() {
        super(Carro.class);
    }

    
    @Override
    public List<Carro> Buscar(Carro obj) {
        // Corpo da consulta
        String consulta = "select ca from Carro ca";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
           if(obj!=null){
               if (obj.getModelo()!= null && obj.getModelo().length() > 0) {
                filtro += " lower(ca.modelo) like lower('%" + obj.getModelo()+ "%')";                
            }


        if (obj.getQuantidade()!= null && obj.getQuantidade().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " ca.quantidade=:quantidade ";
                parametros.put("quantidade", obj.getQuantidade());
            }


        if (obj.getIdCarro()!= null && obj.getIdCarro()> 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " ca.idCarro =:idCarro ";
            parametros.put("idCarro", obj.getIdCarro());
        }

        if (obj.getPlaca()!= null && obj.getPlaca().length() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " ca.placa=:placa";
            parametros.put("placa", obj.getPlaca());
        }

        if (obj.getCategoria()!= null && obj.getCategoria().toString().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " ca.categoria=:categoria ";
                parametros.put("categoria", obj.getCategoria());
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
