package it.polito.tdp.artsmia.model;

public class TestModel {
	
	public static void main(String arg[]) {
		Model m = new Model();
		
		m.creaGrafo();
		
		System.out.println(m.getGrafoVertici()+" " + m.getGrafoArchi());
	}

}
