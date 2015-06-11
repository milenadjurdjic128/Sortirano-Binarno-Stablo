package binarno.stablo.main;

import binarno.stablo.BinarnoStablo;
import binarno.stablo.CvorBinarnogStabla;

public class Main {

	public static void main(String[] args) {
		CvorBinarnogStabla koren = new CvorBinarnogStabla(9, "Milena", null, null);
		BinarnoStablo bs = new BinarnoStablo(koren);
		bs.ubaci(koren, 6, "Jasmina");
		bs.ubaci(koren, 7, "Sonja");
		
		String pretrazen = bs.pretrazi(koren, 9);
		System.out.println(pretrazen);
		bs.izbaci(7);
		bs.infix(koren);
		
	}

}
