package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza corrente = partita.getLabirinto().getStanzaCorrente();
		if(borsa.getPesoRimanente(attrezzo)) {
			borsa.addAttrezzo(attrezzo);
			corrente.removeAttrezzo(attrezzo);
		} 
		else {
			io.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
