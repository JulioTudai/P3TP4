package ProgramacionIII.tp4;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, HashMap<Integer, Arco<T>>> vertices = new HashMap<>();


	@Override
	/// TERMINADO
	public void agregarVertice(int verticeId) {
		if(!vertices.containsKey(verticeId)){
			vertices.put(verticeId,new HashMap<>());
		}
	}

	@Override
	/// TERMINADO
	public void borrarVertice(int verticeId) {
		vertices.remove(verticeId);
		/// Borra todos los arcos que llegan al vértice desde otros vértices
		/// Vaues() devuelve todos los values te los hasmap presentes en vertices
		for (HashMap<Integer, Arco<T>> adyacentes : vertices.values()) {
			adyacentes.remove(verticeId); // remueve si existe el destino
		}
	}

	@Override
	/// TERMINADO
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
		this.vertices.putIfAbsent(verticeId1, new HashMap<>());
		this.vertices.get(verticeId1).put(verticeId2, arco);

	}

	@Override
	/// TERMINADO
	public void borrarArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1) && vertices.get(verticeId1).containsKey(verticeId2)) {
			vertices.get(verticeId1).remove(verticeId2);
		}
	}

	@Override
	/// TERMINADO
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		/// forma peruana se me rompe con obtener arco
		/*Arco aquito = this.obtenerArco(verticeId1,verticeId2);
		if(aquito == null){
			return false;
		}
		return true;
		 */
		///forma pro:
		return vertices.containsKey(verticeId1) && vertices.get(verticeId1).containsKey(verticeId2);

	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1) && vertices.get(verticeId1).containsKey(verticeId2)){
			return vertices.get(verticeId1).get(verticeId2);
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		Set<Integer> todosLosVertices = new HashSet<>();
		/// transformo cada vertice origen en un map, para poder usar el metodo geykey()
		for (Map.Entry<Integer, HashMap<Integer,Arco<T>>> entrada : vertices.entrySet()) {
			Integer origen = entrada.getKey();
			todosLosVertices.add(origen);
			/// entrada.getValue() devuelve el hashmap Interno del origen
			HashMap<Integer, Arco<T>> adyacentes = entrada.getValue();
			/// KeySetdevuelve todas las claves.
			todosLosVertices.addAll(adyacentes.keySet()); // agrega todos los destinos
		}
		return todosLosVertices.size();
	}

	@Override
	/// TERMINADO TOTALMETNE SOLITO BB
	public int cantidadArcos() {
		int suma = 0;
		for (HashMap<Integer, Arco<T>> hijo : vertices.values()){
			suma += hijo.values().size();
		}
		return suma;
	}

	@Override
	/// TERMINADO
	public Iterator<Integer> obtenerVertices() {
		/// el set no permite repetidos asi no agregamos vertices que ya fueron agregados por set destinos de otro origen.
		Set<Integer> todosLosVertices= new HashSet<>();
		/// Map.Entry sirve para manejar mas comodo las solicitudes get key y get values
		/// vertices.EntrySet() devuelve un mapa con toods los origenes "basicamente lo mismo pero mas facil de maneajar para esta tarea
		for (Map.Entry<Integer, HashMap<Integer,Arco<T>>> origenes : vertices.entrySet()){
			todosLosVertices.add(origenes.getKey());

			todosLosVertices.addAll(origenes.getValue().keySet());
		}
		return todosLosVertices.iterator();
	}

	@Override
	/// Terminado y solito pa
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if(!vertices.containsKey(verticeId)){
			return Collections.emptyIterator();
		}
		return vertices.get(verticeId).keySet().iterator();
	}

	@Override
	/// terminado y solito pa
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> arcosEncontrados = new ArrayList<>();
		for(HashMap<Integer,Arco<T>> arcos : vertices.values()){
			arcosEncontrados.addAll(arcos.values());
		}
		return arcosEncontrados.iterator();
	}

	@Override
	/// TERMINADO Y SOLITO PA
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if(!vertices.containsKey(verticeId)){
			Collections.emptyIterator();
		}
		return vertices.get(verticeId).values().iterator();
	}

}
