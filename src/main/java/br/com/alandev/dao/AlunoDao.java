package br.com.alandev.dao;

import br.com.alandev.modelos.Aluno;

import javax.persistence.EntityManager;

public class AlunoDao {

    private EntityManager em;

    public AlunoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Aluno aluno){
        this.em.persist(aluno);
    }
}
