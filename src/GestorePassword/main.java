package GestorePassword;


public class main {

	public static void main(String[] args) {	
	    gui finestra = new gui();
	    finestra.g1.caricaDaFile("save.txt");  

	    finestra.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent e) {
	            finestra.g1.salvaSuFile("save.txt");
	            System.exit(0);
	        }
	    });
	}

}
