package binarno.stablo;

public class BinarnoStablo{

	private CvorBinarnogStabla koren;

	public BinarnoStablo(CvorBinarnogStabla koren) {
		super();
		this.koren = koren;
	}

	public BinarnoStablo() {
		super();
	}


	public CvorBinarnogStabla getKoren() {
		return koren;
	}

	public void setKoren(CvorBinarnogStabla koren) {
		this.koren = koren;
	}

	public void ubaci(int kljuc, String vrednost) {
		ubaci(koren, kljuc, vrednost);
	}

	/**
	 * Ako je prazno stablo, ubacuje se kao koren, u suprotnom se proverava da li je manji kljuc ili veci od kljuca korena
	 * ako je manji proveravamo da li je slobodno mesto levo od njega, ako je veci proveravamo desno i to dok ne 
	 * nadjemo mesto na koje dodajemo cvor sa vrednoscu
	 * @param cvor koji dodajemo
	 * @param kljuc po kojem trazimo odgovarajuce mesto u stablu
	 * @param vrednost koja se unosi
	 */
	public void ubaci(CvorBinarnogStabla cvor, int kljuc, String vrednost) {

		if (praznoStablo()) {
			koren = new CvorBinarnogStabla(kljuc, vrednost, null, null);
		}

		else

		{
			if (kljuc < cvor.kljuc){
				if (cvor.levo != null) {
					ubaci(cvor.levo, kljuc, vrednost);
				}
				else {
					cvor.levo = new CvorBinarnogStabla(kljuc, vrednost, null, null);
				}
			} else if (kljuc > cvor.kljuc) {
				if (cvor.desno != null) {
					ubaci(cvor.desno, kljuc, vrednost);
				}
				else {
					cvor.desno = new CvorBinarnogStabla(kljuc, vrednost, null, null);
				}
			}
		}

	}

	public String pretrazi(CvorBinarnogStabla cvor, int kljuc) {
		if(cvor == null) {
			return null;
		}
		if(cvor.kljuc == kljuc) {
			return cvor.podatak;
		}
		while(kljuc < cvor.kljuc) {
			cvor = cvor.levo;
		}
		while(kljuc > cvor.kljuc) {
			cvor = cvor.desno;
		}
		return cvor.podatak;
	}

	public CvorBinarnogStabla pronadji(CvorBinarnogStabla cvor, int kljuc) {
		if(cvor == null) {
			return null;
		}
		if(cvor.kljuc == kljuc) {
			return cvor;
		}
		if(kljuc < cvor.kljuc) {
			cvor = cvor.levo;
		}
		if(kljuc > cvor.kljuc) {
			cvor = cvor.desno;
		}
		return cvor;
	}

	public void izbaci(int kljuc) {
		CvorBinarnogStabla cvor = pronadji(koren, kljuc);
		if (cvor == null) {
			System.out.println("Ne postoji takav cvor u stablu.");
			return;
		}

		if (cvor.levo != null && cvor.desno != null){
			CvorBinarnogStabla maxL = maxCvor(cvor.levo);
			izbaciListPolulist(maxL);
			cvor.podatak = maxL.podatak;
		} else 
			izbaciListPolulist(cvor);
	}

	public boolean praznoStablo() {
		return koren==null?true:false;
	}

	public CvorBinarnogStabla maxCvor (CvorBinarnogStabla koren) {
		while(koren.desno != null)
			koren = koren.desno;
		return koren;
	}

	public void izbaciListPolulist(CvorBinarnogStabla cvor) {
		CvorBinarnogStabla roditelj = pronadjiRoditelja(koren, cvor.kljuc);
		CvorBinarnogStabla dete = cvor.levo != null ? cvor.levo : cvor.desno;

		if (roditelj == null)
			koren = dete;
		else {
			if (roditelj.levo == cvor)
				roditelj.levo = dete;
			else
				roditelj.desno = dete;
		}
	}

	public CvorBinarnogStabla pronadjiRoditelja(CvorBinarnogStabla koren, int kljuc) {
		if(koren == null || koren.kljuc == kljuc) {
			return null;
		}
		if(kljuc < koren.kljuc) {
			if(koren.levo != null && koren.levo.kljuc == kljuc) {
				return koren;
			}
			return pronadjiRoditelja(koren.levo, kljuc);
		}
		else {
			if(koren.desno != null && koren.desno.kljuc == kljuc){
				return koren;
			}
			return pronadjiRoditelja(koren.desno, kljuc);
		}

	}


	public CvorBinarnogStabla pronadji(CvorBinarnogStabla koren, String vrednost, int kljuc){
		if (koren == null || koren.podatak == vrednost) {
			return koren;
		}

		if (kljuc < koren.kljuc) {
			return pronadji(koren.levo, vrednost, kljuc);
		}
		else {
			return pronadji(koren.desno, vrednost, kljuc);
		}
	}


	public int visina(CvorBinarnogStabla koren) {
		if(koren == null) {
			return 0;
		}
		return 1 + Math.max(visina(koren.levo), visina(koren.desno));
	}

	public void prefix(CvorBinarnogStabla cvor) {
		if(cvor == null) {
			return;
		}
		System.out.println(cvor.podatak); 
		prefix(cvor.levo);
		prefix(cvor.desno);
	}

	public void postfix(CvorBinarnogStabla cvor) {
		if(cvor == null) {
			return;
		}
		postfix(cvor.levo);
		postfix(cvor.desno);
		System.out.println(cvor.podatak); 
	}

	public void infix(CvorBinarnogStabla cvor) {
		if(cvor == null) {
			return;
		}
		infix(cvor.levo);
		System.out.println(cvor.podatak); 
		infix(cvor.desno);
	}



}
