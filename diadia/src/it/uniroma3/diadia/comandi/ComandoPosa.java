package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "posa";


	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza corrente = partita.getLabirinto().getStanzaCorrente();

		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			corrente.addAttrezzo(attrezzo);
			borsa.removeAttrezzo(nomeAttrezzo);
		}
		else {
			io.mostraMessaggio("Non c'e' spazio nella stanza per poter inserire questo attrezzo!");
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