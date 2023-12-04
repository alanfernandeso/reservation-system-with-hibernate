package br.com.alandev.dao;

import br.com.alandev.modelos.Aluno;
import br.com.alandev.modelos.Reserva;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ReservaDao {

    private EntityManager em;

    public ReservaDao(EntityManager em) {
        this.em = em;
    }

    public void reservar(Reserva reserva){
        this.em.persist(reserva);
    }


}
