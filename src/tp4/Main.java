package ProgramacionIII.tp4;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		GrafoDirigido<String> grafo = new GrafoDirigido<>();

		// Agregar vértices
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);

		// Agregar arcos
		grafo.agregarArco(1, 2, "Arco de 1 a 2");
		grafo.agregarArco(1, 3, "Arco de 1 a 3");
		grafo.agregarArco(2, 4, "Arco de 2 a 4");

		// Mostrar cantidad de vértices
		System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());

		// Mostrar cantidad de arcos
		System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

		// Mostrar todos los vértices
		System.out.println("Vertices:");
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while (itVertices.hasNext()) {
			System.out.println(" - " + itVertices.next());
		}

		// Mostrar todos los arcos
		System.out.println("Arcos:");
		Iterator<Arco<String>> itArcos = grafo.obtenerArcos();
		while (itArcos.hasNext()) {
			Arco<String> arco = itArcos.next();
			System.out.println(" - " + arco.getVerticeOrigen() + " -> " + arco.getVerticeDestino() + " : " + arco.getEtiqueta());
		}

		// Mostrar adyacentes de 1
		System.out.println("Adyacentes de 1:");
		Iterator<Integer> itAdy = grafo.obtenerAdyacentes(1);
		while (itAdy.hasNext()) {
			System.out.println(" - " + itAdy.next());
		}

		// Mostrar arcos salientes de 1
		System.out.println("Arcos desde vértice 1:");
		Iterator<Arco<String>> itArcosDesde1 = grafo.obtenerArcos(1);
		while (itArcosDesde1.hasNext()) {
			Arco<String> arco = itArcosDesde1.next();
			System.out.println(" - " + arco.getVerticeOrigen() + " -> " + arco.getVerticeDestino() + " : " + arco.getEtiqueta());
		}

		// Verificar existencia de vértices
		System.out.println("¿Existe el vértice 3? " + grafo.contieneVertice(3));
		System.out.println("¿Existe el vértice 99? " + grafo.contieneVertice(99));

		// Verificar existencia de arcos
		System.out.println("¿Existe arco de 1 a 2? " + grafo.existeArco(1, 2));
		System.out.println("¿Existe arco de 3 a 1? " + grafo.existeArco(3, 1));

		// Obtener un arco específico
		Arco<String> arco12 = grafo.obtenerArco(1, 2);
		System.out.println("Arco de 1 a 2: " + arco12.getEtiqueta());

		// Borrar un arco y verificar
		grafo.borrarArco(1, 2);
		System.out.println("¿Existe arco de 1 a 2 después de borrar? " + grafo.existeArco(1, 2));

		// Borrar vértice y verificar
		grafo.borrarVertice(2);
		System.out.println("¿Existe el vértice 2 después de borrar? " + grafo.contieneVertice(2));
		System.out.println("¿Existe arco de 2 a 4 después de borrar vértice 2? " + grafo.existeArco(2, 4));
	}
}

