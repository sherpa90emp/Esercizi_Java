package Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "esami")
public class Esame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private Integer voto;

    @Column(name = "data_esame")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    @ManyToOne
    @JoinColumn(name = "studente_id")
    private Studente studente;

    public Esame() {}

    public Esame(Integer voto, LocalDate data, Corso corso, Studente studente) {
        this.voto = voto;
        this.data = data;
        this.corso = corso;
        this.studente = studente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    @Override
    public String toString() {
        return "Esame{" +
                "id=" + id +
                ", voto=" + voto +
                ", data=" + data +
                ", corso=" + corso +
                ", studente=" + studente +
                '}';
    }
}
