package br.com.alandev.dao;

import br.com.alandev.modelos.Espaco;

import javax.persistence.EntityManager;
import java.util.List;

public class EspacoDao {

    private EntityManager em;

    public EspacoDao(EntityManager em) {
        this.em = em;
    }

    public Espaco buscaPorId (Long id){
        return em.find(Espaco.class, id);
    }


}
