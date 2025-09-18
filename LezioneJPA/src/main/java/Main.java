import Entity.Corso;
import Entity.Studente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//test di operazioni CRUD
// CREATE A READ UPDATE
public class Main {

    private static final SessionFactory factory = HibernateUtil.buildSessionFactory();

    public static void main(String[] args) {
        //test creazione studente
        Long idStudente = createStudent();

        //test recupero studente
        getSudentById(idStudente);

        //test update del cognome
        updateStudent(idStudente, "Verdi");
        getSudentById(idStudente);

        //test eliminazione utente
        deleteStudent(idStudente);
        getSudentById(idStudente);

        // test insermimento studenti e corsi
        inserisciDati();
        getSudentById(2L);
    }

    /**
     * esegue una query selec sul db puntando per id
     *
     * @param idStudente
     * @return
     */
    private static Studente getSudentById(Long idStudente) {
        try (Session session = factory.openSession()) {
            if (idStudente != null) {
                Studente s = session.get(Studente.class, idStudente);
                System.out.println(s);
                return s;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * esegue una insert sul db creando un nuovo studente
     */
    public static Long createStudent() {
        Transaction transaction = null; // una transazione db crea un contesto di query
        Studente nuovoStudente = new Studente("Mario", "Rossi", "MARO001");

        try (Session session = factory.openSession()) { //una sessione di interrogazione al db
            transaction = session.beginTransaction(); // inizia il contesto transazionale
            session.persist(nuovoStudente);

            transaction.commit(); // committa il contesto transazionale eseguendo tutte le query in esso (fra begin e commit)
            return nuovoStudente.getId();
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        }
        return 0L;
    }


    /**
     * metodo che aggiorna cognome di uno studente
     */
    public static void updateStudent(Long idStudente, String nuovoCognome) {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            Studente studente = session.get(Studente.class, idStudente);
            if (studente != null) {
                studente.setCognome(nuovoCognome);
            } else {
                System.out.println("Utente con id " + idStudente + " non trovato!");
            }

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback(); // annulla le operazioni (query) fatte durante la transazione
            ex.printStackTrace();
        }
    }

    public static void deleteStudent(Long idStudente) {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            Studente studente = session.get(Studente.class, idStudente);
            if (studente != null) {
                session.remove(studente);
                transaction.commit();
                System.out.println("> Studente con id " + idStudente + " cancellato!");
            } else {
                System.out.println("> Impossibile eliminare sudente con id " + idStudente + " non trovato!");
                transaction.rollback();
            }
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback(); // evita nullpointer
            ex.printStackTrace();
        }
    }

    /**
     * inserisce degli studenti a dei corsi
     */
    public static void inserisciDati() {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            //creo 3 studenti
            Studente s1 = new Studente("Andrea", "Chiappi", "ANCH001");
            Studente s2 = new Studente("Laura", "Chicchi", "LACH001");
            Studente s3 = new Studente("Marco", "Nigi", "MANI001");

            //creo 3 corsi
            Corso c1 = new Corso("BIO001", "Analisi 1", 6 );
            Corso c2 = new Corso("BIO002", "Fisica 1", 6 );
            Corso c3 = new Corso("BIO003", "Chimica Inorganica 1", 9 );

            //preparo le insert
            session.persist(s1);
            session.persist(s2);
            session.persist(s3);
            session.persist(c1);
            session.persist(c2);
            session.persist(c3);

            transaction.commit();

            session.refresh(s1);
            session.refresh(s2);
            session.refresh(s3);
            session.refresh(c1);
            session.refresh(c2);
            session.refresh(c3);

            // iscrizione studenti ai corsi
            //TODO da finire l'iscrizione
            //si crea uno stack overflow se proviamo a stampare gli studenti (modo più semplice è interrompere la stampa dei corsi = to string rimozione stampa lista studenti
            s1.addCorso(c1);
            s1.addCorso(c2);
            s1.addCorso(c3);
            s2.addCorso(c1);
            s2.addCorso(c2);
            s2.addCorso(c3);
            s3.addCorso(c1);
            s3.addCorso(c2);
            s3.addCorso(c3);
        } catch (Exception ex) { // è possibile fare anche il rollback quando è presente una specifica  eccezione
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        }
    }
}
