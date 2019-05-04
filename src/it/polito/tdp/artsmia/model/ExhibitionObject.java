package it.polito.tdp.artsmia.model;

public class ExhibitionObject {
	
	private int oggetto1;
	private int oggetto2;
	private int conteggio;
	
	
	public ExhibitionObject(int object_id1, int object_id2, int conteggio) {
		super();
		this.oggetto1 = object_id1;
		this.oggetto2 = object_id2;
		this.conteggio = conteggio;
	}


	public int getOggetto1() {
		return oggetto1;
	}


	public void setOggetto1(int oggetto1) {
		this.oggetto1 = oggetto1;
	}


	public int getOggetto2() {
		return oggetto2;
	}


	public void setOggetto2(int oggetto2) {
		this.oggetto2 = oggetto2;
	}


	public int getConteggio() {
		return conteggio;
	}


	public void setConteggio(int conteggio) {
		this.conteggio = conteggio;
	}


	
}
