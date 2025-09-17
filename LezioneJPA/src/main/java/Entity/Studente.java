package Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity // rende la classe una entity per aderire ad una tabella sul db
@Table(name = "studenti")
public class Studente {

        @Id // rende la colonna una primary key
        @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto incrementante
        private Long id;

        @Column(length = 50, nullable = false) // aggiungere i vincoli lunghezza max 50 e not nullable
        private String nome;

        @Column(length = 50) // aggiungere vincolo lunghezza di massimo 50 caratteri
        private String cognome;

        @Column(unique = true) // aggiunge vincolo unicità di specifico valore nella tabella
        private String matricole;

        @ManyToMany
        @JoinTable( // many to many ha bisogno di una tablella di join intermedia
                name = "iscrizioni", //specifica il nome della tabella di join
                joinColumns = @JoinColumn(name = "studente_id"), // specifica il nome della colonna che specifica l'id dello studente
                inverseJoinColumns = @JoinColumn(name = "corso_id")
        )
        private Set<Corso> corsiFrequentati = new HashSet<>();

        @OneToMany(mappedBy = "studente") //nome della proprietà Studente nella classe Esame
        private Set<Esame> esami = new HashSet<>();

        public Studente() {}

    public Studente(Long id, String nome, String cognome, String matricole, Set<Corso> corsiFrequentati, Set<Esame> esami) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.matricole = matricole;
        this.corsiFrequentati = corsiFrequentati;
        this.esami = esami;
    }

    public Studente(String nome, String cognome, String matricole) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricole = matricole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricole() {
        return matricole;
    }

    public void setMatricole(String matricole) {
        this.matricole = matricole;
    }

    public Set<Corso> getCorsiFrequentati() {
        return corsiFrequentati;
    }

    public void setCorsiFrequentati(Set<Corso> corsiFrequentati) {
        this.corsiFrequentati = corsiFrequentati;
    }

    public Set<Esame> getEsami() {
        return esami;
    }

    public void setEsami(Set<Esame> esami) {
        this.esami = esami;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", matricole='" + matricole + '\'' +
                ", corsiFrequentati=" + corsiFrequentati +
                ", esami=" + esami +
                '}';
    }
}
