package it.polito.tdp.artsmia.model;

import java.util.*;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.*;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {

	private List<ArtObject> oggetti = new LinkedList<ArtObject>();
	
	private Map<Integer, ArtObject> oggettiMap;
	
	private Graph<ArtObject, DefaultWeightedEdge> grafo;

	public void creaGrafo() {
		
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		ArtsmiaDAO dao = new ArtsmiaDAO();
		this.oggetti = dao.listObjects();
		
		this.oggettiMap = new HashMap<>();
		for(ArtObject atemp : this.oggetti) {
			oggettiMap.put(atemp.getId(), atemp);
		}
		
		Graphs.addAllVertices(this.grafo, this.oggetti);
		
		List<ExhibitionObject> adiacenze = dao.listaAdiacenze();
		
		for(ExhibitionObject etemp : adiacenze) {
			Graphs.addEdge(grafo, oggettiMap.get(etemp.getOggetto1()), oggettiMap.get(etemp.getOggetto2()), etemp.getConteggio());
		}
		
		
	}

	public Graph<ArtObject, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}

	public int getGrafoVertici() {
		return grafo.vertexSet().size();
	}

	public int getGrafoArchi() {
		return grafo.edgeSet().size();
	}

}
