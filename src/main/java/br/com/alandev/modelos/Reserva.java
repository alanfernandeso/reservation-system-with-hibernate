package br.com.alandev.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Aluno aluno;
    private Espaco espaco;
    private Equipamento equipamento;

    @Column(name = "data_hora_agendamento")
    private Date dataHoraDoAgendamento;
    private ReservationStatus status;

    public Reserva(long id, Aluno aluno, Espaco espaco, Equipamento equipamento, Date dataHoraDoAgendamento, ReservationStatus status) {
        this.id = id;
        this.aluno = aluno;
        this.espaco = espaco;
        this.equipamento = equipamento;
        this.dataHoraDoAgendamento = dataHoraDoAgendamento;
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Date getDataHoraDoAgendamento() {
        return dataHoraDoAgendamento;
    }

    public void setDataHoraDoAgendamento(Date dataHoraDoAgendamento) {
        this.dataHoraDoAgendamento = dataHoraDoAgendamento;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
