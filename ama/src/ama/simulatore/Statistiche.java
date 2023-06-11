package ama.simulatore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import ama.CentroDiRaccolta;
import ama.Citta;
import ama.mezzo.Chase;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;

public class Statistiche {

	public void stampaStatisticheFinali(Citta citta) {
		final CentroDiRaccolta centro = citta.getCentroDiRaccolta();

		final Set<Rifiuto> smaltiti = centro.getRifiutiSmaltiti();
		System.out.println("Rifiuti smaltiti in totale: " + smaltiti.size());
		System.out.println();
		
		// (VEDI DOMANDA 3 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta da ciascun mezzo impegnato:");
		final Map<Mezzo,Integer> mezzo2quantita = raccoltoPerMezzo(smaltiti);
		stampaRaccoltoPerMezzo(mezzo2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 4 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta per ogni politica:");
		final Map<Class<?>,Integer> politica2quantita = raccoltoPerPolitica(smaltiti);
		stampaRaccoltoPerPolitica(politica2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 5 - metodo da completare a seguire)
		System.out.println("Classifica finale delle politiche raccolta:");
		final List<Class<?>> classificaTipo = ordinaPolitichePerRaccolta(politica2quantita);
		stampaClassificaPolitiche(classificaTipo);
		System.out.println();

		// (VEDI DOMANDA 7 - metodo da completare a seguire)
		System.out.println("Classifica finale dei mezzi per raccolta:");
		final SortedSet<Mezzo> classificaMezzi = ordinaMezziPerRaccolta(mezzo2quantita);
		stampaClassificaMezzi(classificaMezzi);
		System.out.println();
		
	}

	public Map<Mezzo, Integer> raccoltoPerMezzo(Set<Rifiuto> smaltiti) {
		final Map<Mezzo,Integer> mezzo2quantita = new HashMap<>();
		// DA COMPLETARE (VEDI DOMANDA 3)
		for(Rifiuto r : smaltiti) {
			if(mezzo2quantita.containsKey(r.getRaccoglitore())) {
				Integer intero = mezzo2quantita.get(r.getRaccoglitore());
				mezzo2quantita.put(r.getRaccoglitore(),++intero);
			} else {
				mezzo2quantita.put(r.getRaccoglitore(),1);
			}
		}
		return mezzo2quantita;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 3
	private void stampaRaccoltoPerMezzo(final Map<Mezzo, Integer> mezzo2quantita) {
		for(Mezzo mezzo : mezzo2quantita.keySet()) {
			Integer quantita = mezzo2quantita.get(mezzo);
			if (quantita==null)
				quantita = 0;
			System.out.println("Il mezzo "+mezzo+" ha raccolto "+quantita);
		}
	}

	public Map<Class<?>, Integer> raccoltoPerPolitica(Set<Rifiuto> smaltiti) {
		final Map<Class<?>,Integer> politica2quantita = new HashMap<>();
		// DA COMPLETARE (VEDI DOMANDA 4)
		for(Rifiuto r : smaltiti) {
			if(politica2quantita.containsKey(r.getRaccoglitore().getPolitica().getClass())) {
				Integer intero = politica2quantita.get(r.getRaccoglitore().getPolitica().getClass());
				politica2quantita.put(r.getRaccoglitore().getPolitica().getClass(),++intero);
			} else {
				politica2quantita.put(r.getRaccoglitore().getPolitica().getClass(),1);
			}
		}

		return politica2quantita;
	}

	// UTILE PER STAMPARE RISULTATI DOMANDA 4
	private void stampaRaccoltoPerPolitica(final Map<Class<?>, Integer> tipo2quantita) {
		for(Class<?> tipo : tipo2quantita.keySet()) {
			Integer q = tipo2quantita.get(tipo);
			if (q==null)
				q = 0;
			System.out.println("La politica "+tipo.getSimpleName()+" ha raccolto "+q);
		}
	}
	
	 class ComparatorePerPolitica implements Comparator<Integer> {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg1.compareTo(arg0);
		}

	}
	public List<Class<?>> ordinaPolitichePerRaccolta(final Map<Class<?>, Integer> politica2quantita) {
		// DA COMPLETARE (VEDI DOMANDA 5)
		List<Class<?>> politicheOrdinate = new ArrayList<>();
		TreeMap<Integer,Class<?>> tmp = new TreeMap<Integer,Class<?>>(new ComparatorePerPolitica());
		for(Class<?> c : politica2quantita.keySet()) {
			tmp.put(politica2quantita.get(c), c);
		}
		politicheOrdinate.addAll(tmp.values());
		return politicheOrdinate;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 5
	private void stampaClassificaPolitiche(List<Class<?>> classifica) {
		for(int i=1; i<classifica.size()+1; i++)
			System.out.println(i+") "+classifica.get(i-1).getSimpleName());
	}
	
	public SortedSet<Mezzo> ordinaMezziPerRaccolta(final Map<Mezzo, Integer> mezzo2quantita) {
		// DA COMPLETARE (VEDI DOMANDA 7)
//		SortedSet<Mezzo> mezziPerRaccolta = new TreeSet<Mezzo>();
//		Map<Integer, Mezzo> tmp = new TreeMap<>(new ComparatorePerRaccolto());
//		for(Mezzo m : mezzo2quantita.keySet()) {
//			tmp.put(mezzo2quantita.get(m),m);
//		}
//		for(Integer i : tmp.keySet())
//			mezziPerRaccolta.add(tmp.get(i));
//				
//		return mezziPerRaccolta;
//		return Collections.emptySortedSet();
		Comparator<Mezzo> cmp = new Comparator<Mezzo>() {

			@Override
			public int compare(Mezzo m1, Mezzo m2) {
				if(mezzo2quantita.get(m2)-mezzo2quantita.get(m1)==0)
					return m1.hashCode()-m2.hashCode();
				return mezzo2quantita.get(m2)-mezzo2quantita.get(m1);
			}
		};
		SortedSet<Mezzo> mezziPerRaccolto = new TreeSet<>(cmp);
		mezziPerRaccolto.addAll(mezzo2quantita.keySet());
		return mezziPerRaccolto;
	}
	
	class ComparatorePerRaccolto implements Comparator<Integer> {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg0.compareTo(arg1);
		}
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 7
	private void stampaClassificaMezzi(SortedSet<Mezzo> classifica) {
		int posto = 1;
		for(Mezzo mezzo : classifica) {
			System.out.println(posto+") "+mezzo);
			posto++;
		}
	}
}