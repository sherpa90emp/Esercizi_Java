package Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "corsi")
// creando noi le tabelle (o come nel caso dei crediti alla creazione delle colonne), specifichiamo un nome più simile a quelli in uso sul db
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // aggiunge vincolo unicità e not nullable
    private String codice;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "cretidi_cfu") //con name alla creazione della colonna userà quello specificato da noi
    private Integer creditiCfu;

    @ManyToMany
    @JoinTable(
            name = "iscrizioni",
            joinColumns = @JoinColumn(name = "corso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "studente_id", referencedColumnName = "id")
    )
    private Set<Studente> studentiIscritti = new HashSet<>();

    @OneToMany(mappedBy = "corso")
    private Set<Esame> esami = new HashSet<>();

    public Corso() {
    }

    public Corso(String codice, String nome, Integer creditiCfu) {
        this.codice = codice;
        this.nome = nome;
        this.creditiCfu = creditiCfu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCreditiCfu() {
        return creditiCfu;
    }

    public void setCreditiCfu(Integer creditiCfu) {
        this.creditiCfu = creditiCfu;
    }

    public Set<Studente> getStudentiIscritti() {
        return studentiIscritti;
    }

    public void setStudentiIscritti(Set<Studente> studentiIscritti) {
        this.studentiIscritti = studentiIscritti;
    }

    public Set<Esame> getEsami() {
        return esami;
    }

    public void setEsami(Set<Esame> esami) {
        this.esami = esami;
    }

    @Override
    public String toString() {
        return "Corso{" +
                "id=" + id +
                ", codice='" + codice + '\'' +
                ", nome='" + nome + '\'' +
                ", creditiCfu=" + creditiCfu +
                ", studentiIscritti=" + studentiIscritti +
                ", esami=" + esami +
                '}';
    }
}
