package br.com.alandev.modelos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Espaco espaco;
    @ManyToOne
    private Equipamento equipamento;

    @Column(name = "agendamento")
    private LocalDateTime dataHoraDoAgendamento;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reserva() {
    }

    public Reserva(Aluno aluno, Espaco espaco, Equipamento equipamento, LocalDateTime dataHoraDoAgendamento, ReservationStatus status) {
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

    public LocalDateTime getDataHoraDoAgendamento() {
        return dataHoraDoAgendamento;
    }

    public void setDataHoraDoAgendamento(LocalDateTime dataHoraDoAgendamento) {
        this.dataHoraDoAgendamento = dataHoraDoAgendamento;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
