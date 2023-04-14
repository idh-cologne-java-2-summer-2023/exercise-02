package idh.java;

public class User {
private String name;
private int kontonummer;
private int geld;

public User(int kontonummer, int geld) {
this.kontonummer = kontonummer;
this.geld = geld;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getKontonummer() {
	return kontonummer;
}

public void setKontonummer(int kontonummer) {
	this.kontonummer = kontonummer;
}

public int getGeld() {
	return geld;
}

public void setGeld(int geld) {
	this.geld = geld;
}


}
