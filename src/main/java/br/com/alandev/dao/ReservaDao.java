package br.com.alandev.dao;

import br.com.alandev.modelos.Aluno;
import br.com.alandev.modelos.Reserva;
import br.com.alandev.modelos.ReservationStatus;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class ReservaDao {

    private EntityManager em;

    public ReservaDao(EntityManager em) {
        this.em = em;
    }

    public void reservar(Reserva reserva){
        this.em.persist(reserva);
    }

    public List<Reserva> buscarTodas(){
        String jpql = "SELECT r FROM Reserva r";
        return em.createQuery(jpql, Reserva.class).getResultList();
    }

    public Reserva consultarReserva(long id){
        String jpql = "SELECT r FROM Reserva r WHERE r.id = ?1";
        return em.createQuery(jpql, Reserva.class)
                .setParameter(1, id)
                .getSingleResult();
    }


}
