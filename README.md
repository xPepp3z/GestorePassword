Gestore Password 🔑

Un semplice programma in Java che permette di gestire i propri servizi (es. email, social, ecc.) salvando e caricando le credenziali da un file. Include una GUI (Swing) per un utilizzo più semplice.

✨ Funzionalità

Aggiungere un nuovo servizio con email e password.

Rimuovere un servizio esistente.

Visualizzare la lista dei servizi salvati.

Salvataggio automatico su file (save.txt).

Caricamento automatico dei dati all'avvio.

Interfaccia grafica centrata e con font personalizzati.

🛠️ Tecnologie

Java 17+

Swing per la GUI

Salvataggio su file .txt

📂 Struttura del progetto
GestorePassword/
├── dati.java        # Classe per memorizzare le credenziali di un servizio

├── gestore.java     # Classe principale per gestire i servizi (aggiunta, rimozione, salvataggio)

├── gui.java         # Interfaccia grafica

├── main.java        # Entry point del programma

└── save.txt         # File di salvataggio delle credenziali

🚀 Esecuzione

Clona la repository:

git clone https://github.com/tuo-username/GestorePassword.git
cd GestorePassword


Compila i file Java:

javac GestorePassword/*.java


Avvia il programma:

java GestorePassword.main

📖 Note

Il file save.txt viene creato automaticamente nella directory principale del progetto.

Se vuoi cambiare il nome o il percorso del file di salvataggio, modifica le chiamate a:

g.caricaDaFile("save.txt");
g.salvaSuFile("save.txt");

📷 Screenshot (opzionale)

Aggiungi qui uno screenshot della GUI.

🧑‍💻 Autore

Progetto sviluppato da [Giuseppe Gravagno] come esercizio Java e Swing.
