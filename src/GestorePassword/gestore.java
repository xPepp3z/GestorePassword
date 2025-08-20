package GestorePassword;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class gestore{
    private ArrayList<dati> utenti = new ArrayList<>();

    public void aggiungiUtente(String servizio, String email, String password) {

        try {
        	
            utenti.add(new dati(servizio, email, password));
            
		} catch (Exception e) {
			
			System.out.println("Errore di sistema");
		}     
    }

    public void rimuoviUtente(int index) {
    	if (index >= 0 && index < utenti.size()) {
			utenti.remove(index);
    	}
    }
    
    public void mostraServizi() {
    	for (int i = 0; i < utenti.size(); i++) {
			dati u = utenti.get(i);
			System.out.println(i + ": " + u.getServizio() + " - " + u.getEmail());
        }	
    }
    
    public ArrayList<dati> getUtenti(){
    	return utenti;
    }
    

    public void salvaSuFile(String save) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(save))) {
            oos.writeObject(utenti);  // salva l'intera lista
            System.out.println("Dati salvati correttamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    public void caricaDaFile(String save) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(save))) {
            utenti = (ArrayList<dati>) ois.readObject();
            System.out.println("Dati caricati correttamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Nessun file trovato, verrà creato al salvataggio.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    

   
}

