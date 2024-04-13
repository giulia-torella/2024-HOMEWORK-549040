package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza(String nome, Attrezzo attr) {
		Stanza room = new Stanza(nome);
		room.addAttrezzo(attr);
		return room;
	} 
	
	/*Test sul metodo hasAttrezzo() */
    @Test 
	public void testAtrioHasAttrezzoOsso() {
    	assertTrue(stanza("Atrio", new Attrezzo("osso", 1)).hasAttrezzo("osso"));
    }
    
    @Test
    public void testAtrioHasNotAttrezzoMartello() {
    	assertFalse(stanza("Atrio", new Attrezzo("osso", 1)).hasAttrezzo("martello"));
    }
    
    @Test
    public void testAtrioHasNotAttrezzoNull() {
    	assertFalse(stanza("Atrio", new Attrezzo("osso", 1)).hasAttrezzo(null));
    }
    
    /*Test sul metodo removeAttrezzo() */
    @Test
    public void testRemoveAttrezzoOsso() {
    	assertNotNull(stanza("Atrio", new Attrezzo("osso", 0)).removeAttrezzo("osso"));
    }
    
    @Test
    public void testNotRemoveAttrezzoOsso() {
    	assertNull(stanza("Atrio", new Attrezzo("osso", 0)).removeAttrezzo("martello"));
    }
    
    @Test
    public void testNotRemoveAttrezzoNull() {
    	assertNull(stanza("Atrio", new Attrezzo("osso", 0)).removeAttrezzo(null));
    }
    
    /*Test sul metodo getAttrezzo() */
    
    @Test
    public void testGetAttrezzoOsso() {
    	assertEquals("osso", stanza("Atrio", new Attrezzo("osso", 0)).getAttrezzo("osso").getNome());
    }
    
    @Test
    public void testNotGetAttrezzoOsso() {
    	assertNull(stanza("Atrio", new Attrezzo("osso", 0)).getAttrezzo(null));
    }
    
    @Test
    public void testGetAttrezzoOsso2() {
    	assertNotNull(stanza("Atrio", new Attrezzo("osso", 0)).getAttrezzo("osso"));
    }
}
