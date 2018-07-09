package CASTRO_TOCAFFONDI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
//Autor: CASTRO TOCAFFONDI
public class Grafico {
    private final Map<String, List<Vertice>> vertices;

    public Grafico() {
        this.vertices = new HashMap<String, List<Vertice>>();
    }

    public void addVertice(String pais, List<Vertice> vertex) {
        this.vertices.put(pais, vertex);
    }

    public List<String> Mostrar(String start, String finish) {
        final Map<String, Integer> distances = new HashMap<String, Integer>();
        final Map<String, Vertice> previous = new HashMap<String, Vertice>();
        PriorityQueue<Vertice> nodes = new PriorityQueue<Vertice>();
        for(String vertex : vertices.keySet()) {
            if (vertex == start) {
		distances.put(vertex, 0);
		nodes.add(new Vertice(vertex, 0));
            } else {
		distances.put(vertex, Integer.MAX_VALUE);
		nodes.add(new Vertice(vertex, Integer.MAX_VALUE));
            }
            previous.put(vertex, null);
	}
	while (!nodes.isEmpty()) {
            Vertice smallest = nodes.poll();
            if (smallest.getId() == finish) {
                final List<String> path = new ArrayList<String>();
                while (previous.get(smallest.getId()) != null) {//******************************
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }
                return path;
            }
            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
                break;
            }
            for (Vertice neighbor : vertices.get(smallest.getId())) {
		Integer alt = distances.get(smallest.getId()) + neighbor.getDistancia();
		if (alt < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), alt);
                    previous.put(neighbor.getId(), smallest);
                    forloop:
                    for(Vertice n : nodes) {
			if (n.getId() == neighbor.getId()) {
                            nodes.remove(n);
                            n.setDistancia(alt);
                            nodes.add(n);
                            break forloop;
			}
                    }
		}
            }
	}
	return new ArrayList<String>(distances.keySet());
    }
}
