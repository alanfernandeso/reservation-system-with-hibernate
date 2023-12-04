package br.com.alandev.modelos;

import javax.persistence.*;

@Entity
@Table(name = "espacos")
public class Espaco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Column(name = "localizacao")
    private String local;

    public Espaco() {
    }

    public Espaco(long id) {
        this.id = id;
    }

    public Espaco(long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.local = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Espaco{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
