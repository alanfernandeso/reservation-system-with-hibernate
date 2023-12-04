package br.com.alandev.reservationsystem;

import br.com.alandev.dao.AlunoDao;
import br.com.alandev.dao.EspacoDao;
import br.com.alandev.dao.ReservaDao;
import br.com.alandev.modelos.*;
import br.com.alandev.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
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
                    cadastrarAluno();
                    break;
                case 3:
                    reservar();
                    break;
                case 6:
                    buscarTodosOsEspacos();
                    break;

            }


        }

    }

    private static void buscarTodosOsEspacos() {
        EntityManager em = JPAUtil.getEntityManager();
        EspacoDao dao = new EspacoDao(em);
        List<Espaco> espacos = dao.buscarTodos();
        //System.out.println(espacos);
        System.out.println("=================================");
        espacos.forEach(e -> System.out.println(e.toString()));
    }

    private static void cadastrarAluno(){
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
    }

    private static void reservar(){
        EntityManager em = JPAUtil.getEntityManager();

        System.out.println("Digite a matrícula do aluno");
        Long matricula = new Scanner(System.in).nextLong();
        System.out.println("Digite o nome espaço");
        Long espacoId = new Scanner(System.in).nextLong();
        System.out.println("Digite o ID do equipamento");
        Long equipamentoId = new Scanner(System.in).nextLong();
        System.out.println("Digite a data (dd/MM/yyyy HH:mm)");
        String data = new Scanner(System.in).nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataFormatada = LocalDateTime.parse(data, formatter);


        Aluno aluno = new Aluno(matricula);
        Espaco espaco = new Espaco(espacoId);
        Equipamento equipamento = new Equipamento(equipamentoId);
        ReservationStatus status = ReservationStatus.PENDENTE;

        Reserva reserva = new Reserva(aluno, espaco, equipamento, dataFormatada, status);
        ReservaDao dao = new ReservaDao(em);

            em.getTransaction().begin();
            dao.reservar(reserva);
            em.getTransaction().commit();
            em.close();
            System.out.println("Reserva cadastrada!");



    }

}
