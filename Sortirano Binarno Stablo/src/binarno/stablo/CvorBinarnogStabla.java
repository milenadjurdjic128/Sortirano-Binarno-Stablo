package binarno.stablo;

public class CvorBinarnogStabla {

	int kljuc;
	String podatak;
	CvorBinarnogStabla levo;
	CvorBinarnogStabla desno;

	public CvorBinarnogStabla(int kljuc, String vrednost,
			CvorBinarnogStabla levo, CvorBinarnogStabla desno) {
		super();
		this.kljuc = kljuc;
		this.podatak = vrednost;
		this.levo = levo;
		this.desno = desno;
	}

	public CvorBinarnogStabla() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Podatak: " + podatak + ", Kljuc: " + kljuc;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof CvorBinarnogStabla){
			
			CvorBinarnogStabla cv = (CvorBinarnogStabla) o;
			if(cv.kljuc == kljuc && cv.podatak.equals(podatak)) {
				return true;
			}
		}
		return false;
	}
}
