//Henry Orellana 13048
//Samuel Maldonado 13153
// Seccion: 30   09/11/14
// HOJA DE TRABAJO 9

// Referencias:
// https://code.google.com/p/hoja-8-grafos/source/browse/?r=8#svn%2FHoja8%2Fsrc%2Fhoja8	


public interface Interfaz<V,E> {

//agregar un nodo
    public void add(V label);

//agregar arista
    public void addEdge(V vtx1, V vtx2, E label);
    
//mostrar grafo
    public void show();
    
//recibir indice de un nodo
    public int getIndex(V label);
    
//recibir nodo
    public V get(int label);
    
//recibir un peso
    public int getEdge(V label1, V label2);
    
//ver existencia de un nodo
    public boolean contains(V label);
    
//cantidad de nodos
    public int size();
    
}
