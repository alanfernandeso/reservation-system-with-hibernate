package br.com.alandev.reservationsystem;

import br.com.alandev.dao.AlunoDao;
import br.com.alandev.modelos.Aluno;
import br.com.alandev.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ReservationSystem {

    public static void main(String[] args) {

        boolean menu = true;

        while (menu){

            System.out.println("===========================");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Alterar cadastro do aluno");
            System.out.println("3. Reservar espaço");
            System.out.println("4. Consultar reserva");
            System.out.println("5. Cancelar reserva");
            System.out.println("6. Listar espaços");
            System.out.println("7. Confirmar reserva");
            System.out.println("8. Sair");
            int opcao = new Scanner(System.in).nextInt();

            switch (opcao){
                case 1:

                    EntityManager em = JPAUtil.getEntityManager();

                    System.out.println("Digite o nome");
                    String nome = new Scanner(System.in).nextLine();
                    System.out.println("Digite o email");
                    String email = new Scanner(System.in).nextLine();

                    Aluno aluno = new Aluno(nome, email);
                    AlunoDao dao = new AlunoDao(em);

                    em.getTransaction().begin();
                    dao.cadastrar(aluno);
                    em.getTransaction().commit();
                    em.close();

                case 6:

                    EntityManager em = JPAUtil.getEntityManager();


            }


        }

    }

}
