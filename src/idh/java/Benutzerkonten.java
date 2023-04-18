package idh.java;

public class Benutzerkonten extends ATM {
	
	int Guthaben;
	int Kontonummer;
	
	public Benutzerkonten() {
		
	}
	
	
	public Benutzerkonten(int Kontonummer, int Guthaben) {
		this.Kontonummer = Kontonummer;
		this.Guthaben = Guthaben;
	}
	
	public int getKontonummer(){
		return Kontonummer;
	}
	
	public int getGuthaben() {
		return Guthaben;
	}
	
	public void abheben(int amount) {
		Guthaben = Guthaben - amount;
	}
}
