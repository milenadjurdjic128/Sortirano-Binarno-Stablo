package binarno.stablo.main;

import binarno.stablo.BinarnoStablo;
import binarno.stablo.CvorBinarnogStabla;

public class Main {

	public static void main(String[] args) {
		CvorBinarnogStabla koren = new CvorBinarnogStabla(9, "Milena", null, null);
		BinarnoStablo bs = new BinarnoStablo(koren);
		bs.ubaci(koren, 6, "Jasmina");
		bs.ubaci(koren, 7, "Sonja");
		bs.ubaci(koren, 8, "Nemanja");
		bs.ubaci(koren, 11, "Zoran");
		
		int visina = bs.visina(koren);
		System.out.println("Visina stabla je: " + visina);
		
		System.out.println("Roditelj cvora sa kljucem 7 je: " + bs.pronadjiRoditelja(koren, 7) + "\n");
		
		System.out.println("Maximalni kljuc ima: " + bs.maxCvor(koren) + "\n");
		
		String pretrazen = bs.pretrazi(koren, 6);
		System.out.println("\n" + "Pronadjen je elemenat: " + pretrazen + "\n");
		
		System.out.println("Prefix notacija: ");
		bs.prefix(koren);
	}

}
