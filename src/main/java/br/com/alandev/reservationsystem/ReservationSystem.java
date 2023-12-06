package br.com.alandev.reservationsystem;

import br.com.alandev.dao.AlunoDao;
import br.com.alandev.dao.EspacoDao;
import br.com.alandev.dao.ReservaDao;
import br.com.alandev.modelos.*;
import br.com.alandev.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {

    public static void main(String[] args) {

        boolean menu = true;

        while (menu){

            System.out.println("===========================");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Reservar espaço");
            System.out.println("3. Consultar reserva");
            System.out.println("4. Listar reservas");
            System.out.println("5. Confirmar reserva");
            System.out.println("6. Sair");
            int opcao = new Scanner(System.in).nextInt();

            switch (opcao){
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    reservar();
                    break;
                case 3:
                    consultarReserva();
                    break;
                case 4:
                    buscarTodasAsReservas();
                    break;
                case 5:
                    confirmarReserva();
                    break;
                case 6:
                    menu = false;
                    break;
            }

        }

    }

    private static void confirmarReserva(){
        EntityManager em = JPAUtil.getEntityManager();
        ReservaDao dao = new ReservaDao(em);
        System.out.println("Digite o ID da reserva");
        long id = new Scanner(System.in).nextInt();
        Reserva reserva = dao.consultarReserva(id);

        reserva.setStatus(ReservationStatus.CONFIRMADO);

        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();
        em.close();

        System.out.println("=================================");
        System.out.println("Reserva confirmada!");
    }

    private static void consultarReserva(){
        EntityManager em = JPAUtil.getEntityManager();
        ReservaDao dao = new ReservaDao(em);
        System.out.println("Digite o ID da reserva");
        long id = new Scanner(System.in).nextInt();
        Reserva reserva = dao.consultarReserva(id);
        System.out.println("=================================");
        System.out.println(reserva);
    }

    private static void buscarTodasAsReservas() {
        EntityManager em = JPAUtil.getEntityManager();
        ReservaDao dao = new ReservaDao(em);
        List<Reserva> reservas = dao.buscarTodas();
        //System.out.println(espacos);
        System.out.println("=================================");
        reservas.forEach(e -> System.out.println(e.toString()));
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
        System.out.println("Digite o ID do espaço");
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
