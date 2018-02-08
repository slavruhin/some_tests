package nested.gebaeude;

import java.util.ArrayList;
import nested.gebaeude.Gebaeude.Stockwerk.Raum;

/**
 * @author Sergej Lavruhin
 *
 */
public class Gebaeude {
	String Strassennamen;
	String Hausnummer;
	ArrayList<Stockwerk> stockwerke = new ArrayList<Stockwerk>();
	
	class Stockwerk {
		int StockwerkNummer;
		ArrayList<Raum> raume = new ArrayList<Raum>();

		class Raum {
			int RaumNummer;
			
			Raum(int RaumNummer) {
				this.RaumNummer = RaumNummer;
			}
			
			@Override
			public String toString() {
				return String.format("%d.%d / %s %s", StockwerkNummer, RaumNummer, Strassennamen, Hausnummer);
			}
		}

		Stockwerk(int StockwerkNummer, int AnzahlRaeumen) {
			this.StockwerkNummer = StockwerkNummer;
			if(AnzahlRaeumen < 1)
				AnzahlRaeumen = 1;
			for(int i = 0 ; i < AnzahlRaeumen; ++i)
				raume.add(new Raum(i));
		}
		
		Raum get(int index) {
			return index < raume.size() ? raume.get(index) : null;
		}
	}

	Gebaeude(String Strassennamen, 
			 String Hausnummer, 
			 int AnzahlStockwerke, 
			 int AnzahlRaeumen) {	
		this.Strassennamen    = Strassennamen;
		this.Hausnummer       = Hausnummer;
		
		if(AnzahlStockwerke < 1)
			AnzahlStockwerke = 1;
		for(int i = 0 ; i < AnzahlStockwerke; ++i)
			stockwerke.add(new Stockwerk(i, AnzahlRaeumen));
	}

	Stockwerk getStockwerk(int stockwerkNr) {
		return stockwerkNr < stockwerke.size() ? stockwerke.get(stockwerkNr) : null;
	}
	
	Raum getRaum(int stockwerkNr, int raumNr) {
		Stockwerk stockwerk = getStockwerk(stockwerkNr);
		return stockwerk != null ? stockwerk.get(raumNr) : null;
	}

	public static void main(String[] args) {
		Raum r = new Gebaeude("Hauptstr.", "45" ,3 ,10).getRaum(0, 2);
		if(r != null)
			System.out.println(r);
	}
}
