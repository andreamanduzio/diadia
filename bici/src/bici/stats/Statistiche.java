package bici.stats;

import java.util.*;

import javax.management.loading.PrivateClassLoader;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;
import bici.tipo.Bici;

public class Statistiche {

	synchronized public void stampaFinale(Zona zona) {
		final Set<Percorso> percorsi = zona.getPercorsi();

		System.out.println(percorsi.size() + " percorsi collezionati." );
		System.out.println(zona.getPercorsi());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Percorsi di ciascuna bicicletta:");
		final Map<Bici,List<Percorso>> bici2percorsi = percorsiPerBici(percorsi);
		stampaPercorsiPerBici(bici2percorsi);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println("Classifica finale delle posizioni piu' battute:");
		final SortedMap<Coordinate,Integer> pos2utilizzi = utilizzi(bici2percorsi);
		stampaUtilizzi(pos2utilizzi);
		System.out.println();
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param percorsi - insieme dei percorsi collezionati durante la simulazione
	 * @return una mappa che riporti per ogni bici (di qualsiasi tipo)
	 *         la lista dei percorsi coperti
	 */
	public Map<Bici, List<Percorso>> percorsiPerBici(Set<Percorso> percorsi) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Bici, List<Percorso>> bici2percorsi = new HashMap<>(); //ci creiamo la mappa da restituire;
		for(Percorso p : percorsi) { //ci scandiamo tutti i percorsi;
			Bici bici = p.getBici(); //da ogni percorso prendiamo la bici;
			if(!bici2percorsi.containsKey(bici)){ //controlliamo se non c'è un record per quella bici, allora...
				bici2percorsi.put(bici, new LinkedList<Percorso>()); //aggiungiamo la bici come chiave e creiamo come valore una lista vuota;
			}
			bici2percorsi.get(bici).add(p); //se già esiste la bici, aggiungo alla lista di quella bici il percorso;
		}
		return bici2percorsi;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param bici2percorsi
	 */
	private void stampaPercorsiPerBici(final Map<Bici, List<Percorso>> bici2percorsi) {
		for(Bici bici : bici2percorsi.keySet()) {
			List<Percorso> percorsi = bici2percorsi.get(bici);
			System.out.println("La bicicletta "+bici+" ha coperto "+( percorsi!=null ? percorsi.size() : 0 ) +" corse");
		}
	}
	
	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 4)</B>
	 * 	@param bici2percorsi - insiemi dei percorsi collezionati durante la simulazione
	 *                         e raggruppati per bici
	 * @return una mappa ordinata decrescente in cui figurano come chiavi 
	 *         le posizioni piu' battute come origine o destinazione di un 
	 *         percorso, come valori il numero di tali percorsi
	 */
	public SortedMap<Coordinate,Integer> utilizzi(Map<Bici, List<Percorso>> bici2percorsi) {
		// DA COMPLETARE (VEDI DOMANDA 4)
		final Map<Coordinate, Integer> coordinate2utilizzi = new HashMap<>();
		for(List<Percorso> percorsi : bici2percorsi.values())
		{
			for(Percorso p : percorsi)
			{
				conta(coordinate2utilizzi,p.getOrigine());
				conta(coordinate2utilizzi,p.getDestinazione());
			}
		}
		SortedMap<Coordinate, Integer> risultato = new TreeMap<>(new Comparator<Coordinate>() {
			
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				int cmp = coordinate2utilizzi.get(c2) - coordinate2utilizzi.get(c1);
				if(cmp == 0)
				{
					cmp = c1.compareTo(c2);
				}
				return cmp;
			}
		});
		risultato.putAll(coordinate2utilizzi);
		return risultato;
	}
	
	private void conta(Map<Coordinate, Integer> coordinate2utilizzi, Coordinate coordinata) {
		if(coordinate2utilizzi.containsKey(coordinata))
		{
			Integer occorrenze = new Integer(coordinate2utilizzi.get(coordinata).intValue()+1);
			coordinate2utilizzi.put(coordinata, occorrenze);
		}
		else coordinate2utilizzi.put(coordinata, new Integer(1));
	}
	
	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 4</EM>
	 * @param classifica delle posizioni piu' usate
	 */
	private void stampaUtilizzi(SortedMap<Coordinate,Integer> classifica) {
		int i = 0;
		for(Map.Entry<Coordinate, Integer> entry : classifica.entrySet()) {
			final Coordinate posizione = entry.getKey();
			final Integer numeri = entry.getValue();
			System.out.println(i+") "+posizione+" con "+numeri+" utilizzi");
			i++;
		}
	}

}
