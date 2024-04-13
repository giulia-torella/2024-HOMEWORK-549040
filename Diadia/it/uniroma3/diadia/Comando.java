package it.uniroma3.diadia;
import java.util.Scanner;

/*
 * Questa classe modella un comando, che consiste al piu' di due parole 
 * (il nome del comando ed un parametro)
 * su cui si applica il comando.
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

    private String nome; // nome del comando
    private String parametro; // parametro passato al comando

    public Comando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione); // creo uno scanner con la stringa passata istruzione

		// prima parola: nome del comando
		if (scannerDiParole.hasNext()) // se l'istruzione ha un elemento
			this.nome = scannerDiParole.next();  // lo metto come nome del comando

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext()) //se l'istruzione ha un altro elemento
			this.parametro = scannerDiParole.next(); // lo metto come parametro del comando
		scannerDiParole.close(); // chiudo lo scanner
		
    } 
    
    public String getNome() { // ritorna il nome del comando
        return this.nome;
    }

    public String getParametro() { // ritorna il parametro del comando
        return this.parametro;
    }

    public boolean sconosciuto() { // ritorna true se il nome è null, altrimenti false
        return (this.nome == null);
    }
}