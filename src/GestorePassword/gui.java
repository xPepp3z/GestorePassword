package GestorePassword;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.*;

public class gui extends JFrame {
    public gestore g1 = new gestore();

    JLabel text1 = new JLabel("Benvenuto nel contenitore delle tue password", SwingConstants.CENTER);
    JTextArea text2 = new JTextArea(
    	      "      .--------.\n" +
    	    	      "     / .------. \\\n" +
    	    	      "    / /        \\ \\\n" +
    	    	      "    | |        | |\n" +
    	    	      "   _| |________| |_\n" +
    	    	      " .' |_|        |_| '.\n" +
    	    	      " '._____ ____ _____.' \n" +
    	    	      " |     .'____'.     |\n" +
    	    	      " |    /  .--.  \\    |\n" +
    	    	      " |    | (    ) |    |\n" +
    	    	      " |    \\  '--'  /    |\n" +
    	    	      " |     '.____.'     |\n" +
    	    	      " '------------------'\n"
    	    	);
    JButton btnAggiungi = new JButton("Aggiungi un servizio");
    JButton btnRimuovi = new JButton("Rimuovi un servizio");
    JButton btnMostra = new JButton("Mostra i servizi");

    public gui() {
    	
        setTitle("Gestore Password");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); 

        // Label in alto
        JPanel titolo = new JPanel();
        titolo.add(text1, BorderLayout.NORTH);
        text1.setFont(new Font("Monospaced", Font.BOLD, 18));
        titolo.setBackground(Color.LIGHT_GRAY);
        add(titolo, BorderLayout.NORTH);
        
        //Ascii Lucchetto
        JPanel lucchettoascii = new JPanel();
        lucchettoascii.add(text2, BorderLayout.CENTER);
        text2.setEditable(false);
        text2.setOpaque(false);
        text2.setFont(new Font("Monospaced", Font.BOLD, 14));
        lucchettoascii.setBackground(Color.white);
        add(lucchettoascii);
        
        
        // Pulsanti
        JPanel pannelloBottoni = new JPanel();
        pannelloBottoni.add(btnAggiungi, BorderLayout.WEST);
        pannelloBottoni.add(btnRimuovi, BorderLayout.EAST);
        pannelloBottoni.add(btnMostra, BorderLayout.SOUTH);
        add(btnAggiungi, BorderLayout.WEST);
        add(btnRimuovi,BorderLayout.EAST);
        add(btnMostra,BorderLayout.SOUTH);

        // Eventi pulsanti
        btnAggiungi.addActionListener(e -> {
        	
            String servizio = JOptionPane.showInputDialog("Nome servizio:");
            String email = JOptionPane.showInputDialog("Email:");
            String password = JOptionPane.showInputDialog("Password:");
            
            if (servizio == null || servizio.trim().isEmpty() ||
            	email == null || email.trim().isEmpty() ||
            	password == null || password.trim().isEmpty()) {

            	JOptionPane.showMessageDialog(null, "Tutti i campi devono essere compilati!");
            	return; 
            }
            
            g1.aggiungiUtente(servizio, email, password);
        });
        
        btnRimuovi.addActionListener(e -> {
            JFrame rimuoviutente = new JFrame();
            rimuoviutente.setTitle("Rimuovi servizio");
            rimuoviutente.setSize(600, 400);
            rimuoviutente.setLocationRelativeTo(null);
            rimuoviutente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rimuoviutente.setResizable(false);
            rimuoviutente.setLayout(new BorderLayout());

            // Array di stringhe con i servizi
            
            DefaultListModel<String> model = new DefaultListModel<>();

            for (dati u : g1.getUtenti()) {
                model.addElement(u.getServizio() + " - " + u.getEmail());
            }

            JList<String> jlist = new JList<>(model);
            rimuoviutente.add(new JScrollPane(jlist), BorderLayout.CENTER);
            
            jlist.setFont(new Font("Courier New", Font.PLAIN, 18));

            // Bottone elimina

            JButton elimina = new JButton("Elimina");
            elimina.addActionListener(ev -> {
                int index = jlist.getSelectedIndex(); 
                if (index != -1) {
                    g1.rimuoviUtente(index); 
                    rimuoviutente.dispose(); 
                    JOptionPane.showMessageDialog(this, "Utente rimosso con successo!");
                } else {
                    JOptionPane.showMessageDialog(this, "Seleziona un utente da eliminare!");
                }
            });
            
            
            rimuoviutente.add(elimina, BorderLayout.SOUTH);

            rimuoviutente.setVisible(true);
        });

        
        btnMostra.addActionListener(e -> {
        	
        	JFrame mostraservizi = new JFrame();
        	mostraservizi.setTitle("Lista servizi");
        	mostraservizi.setSize(700, 400);
        	mostraservizi.setLocationRelativeTo(null);
        	mostraservizi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	mostraservizi.setResizable(false);
        	mostraservizi.setLayout(new BorderLayout());
        	
        	
        	JTextArea servizi = new JTextArea();
        	servizi.setEditable(false);
        	
        	StringBuilder sb = new StringBuilder();
        	for (dati u : g1.getUtenti()) {
        		sb.append(u.getServizio()).append(" - ").append(u.getEmail()).append(" - ").append(u.getPassword()).append("\n");
			}
        	
        	        	
        	servizi.setText(sb.toString());
        	
        	servizi.setFont(new Font("Courier New", Font.PLAIN, 18));
        	
        	JScrollPane scroll = new JScrollPane(servizi);  
        	mostraservizi.add(scroll, BorderLayout.CENTER);
        	
        	
        	mostraservizi.setVisible(true);
        });

        setVisible(true);
    }
}