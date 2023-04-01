package it.uniroma3.diadia;
//CIAO SONO QUI DOPO GITHUB

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole IOconsoleDiaDia;

	public DiaDia(IOConsole output) {
		this.partita = new Partita();
		this.IOconsoleDiaDia = output;
	}

	public void gioca() {
		String istruzione; 

		IOconsoleDiaDia.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = IOconsoleDiaDia.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		String nome = comandoDaEseguire.getNome();
		if(nome == null) {
			IOconsoleDiaDia.mostraMessaggio("Devi digitare un comando tra quelli indicati..RIPROVA!");
			return false;
		}
		
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			IOconsoleDiaDia.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			IOconsoleDiaDia.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			IOconsoleDiaDia.mostraMessaggio(elencoComandi[i]+" ");
		IOconsoleDiaDia.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			IOconsoleDiaDia.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IOconsoleDiaDia.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		IOconsoleDiaDia.mostraMessaggio(" " + partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IOconsoleDiaDia.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	
	private void prendi(String nomeAttrezzo) {
		Attrezzo attrezzoInStanza = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoInStanza);
		IOconsoleDiaDia.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoInStanza);
	}

	
	private void posa(String nomeAttrezzo) {
		Attrezzo attrezzoInBorsa = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoInBorsa);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		IOconsoleDiaDia.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
	}

	
	public static void main(String[] argc) {
		IOConsole output = new IOConsole();
		DiaDia gioco = new DiaDia(output);
		gioco.gioca();
	}
}