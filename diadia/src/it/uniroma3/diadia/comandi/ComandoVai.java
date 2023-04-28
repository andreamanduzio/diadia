package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando {

	private String direzione;
	private IO io;
	private final static String NOME = "vai";

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Giocatore giocatore = partita.getGiocatore();
		Stanza prossimaStanza = null;
		if (direzione == null) {
			this.io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
		}
		else {
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			giocatore.setCfu(giocatore.getCfu() - 1);
		}
		io.mostraMessaggio("Adesso sei in: " + partita.getLabirinto().getStanzaCorrente().getNome());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public String getParametro() {
		return this.direzione;
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