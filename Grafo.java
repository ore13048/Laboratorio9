import java.util.ArrayList;

public class Grafo<T extends Comparable> {
    //ATRIBUTOS
    private Nodo[] nodos;
    private Nodo<T> centro;
    private int dimension;
    private ArrayList<T> nombreNodos;
    
    public Grafo(int dimension, ArrayList<T> nombreNodos){
        this.dimension = dimension;
        this.nombreNodos = nombreNodos;
        nodos = new Nodo[dimension];
        for(int i = 0; i<dimension-1; i++){
            nodos[i] = new Nodo(dimension, nombreNodos.get(i));
        }
    }
    
    public void agregarArco(T origen, T vecino, int valor){
        for(int i = 0; i<dimension; i++){
            if(nodos[i].getNombre().equals(origen)){
                nodos[i].agregarVecino(nombreNodos.indexOf(origen), 0);
                nodos[i].agregarVecino(nombreNodos.indexOf(vecino), valor);
            }
            if(nodos[i].getNombre().equals(vecino)){
                nodos[i].agregarVecino(nombreNodos.indexOf(vecino), 0);
                nodos[i].agregarVecino(nombreNodos.indexOf(origen), valor);
            }
        }
    }
    
    public void eliminarArco(String origen, String vecino){
        for(int i = 0; i<dimension; i++){
            if(nodos[i].getNombre().equals(origen)){
                nodos[i].agregarVecino(nombreNodos.indexOf(vecino), 9999);
            }
            if(nodos[i].getNombre().equals(vecino)){
                nodos[i].agregarVecino(nombreNodos.indexOf(origen), 9999);
            }
        }
    }
    
    public void agregarNodo(T nombreNodo){
        boolean existente = false;
        if(nombreNodos.contains(nombreNodo)){
            System.out.println("Este nodo ya existe");
            existente = true;
        }
        if(!existente){
            //Agregando el nodo
            dimension = dimension + 1;
            nombreNodos.add(nombreNodo);
            Nodo nodo = new Nodo(dimension, nombreNodo);
            
            //Reacomodamiento de todos los nodos
            Nodo[] newNodos = new Nodo[dimension];
            
            for(int i = 0; i<dimension-1; i++){
                newNodos[i] = new Nodo(dimension, nombreNodos.get(i));
                for(int j = 0; j<dimension-1; j++){
                    newNodos[i].agregarVecino(Integer.parseInt(nodos[i].getVecinos()[j]), j);
                }
            }
            newNodos[dimension-1] = nodo;
            nodos = newNodos;
        }
    }
    
    public int[][] matrizAdyacencia(){
        int[][] matriz = new int[dimension][dimension];
        for(int i=0; i<dimension; i++){
           for(int j=0; j<dimension; j++){
               matriz[i][j] = Integer.parseInt(nodos[i].getVecinos()[j]);
           }
        }
        return matriz;
    }
    
    public int getDimension(){
        return dimension;
    }
    
    public ArrayList<T> getNombreNodos(){
        return nombreNodos;
    }
    
    public Nodo<T> getCentro(){
        return centro;
    }
}
