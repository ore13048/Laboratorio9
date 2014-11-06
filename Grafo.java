/***********************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructura de Datos
* Samuel Maldonado, carnet: 
* Henry Orellana, Carnet: 13048
***********************************************/

import java.util.ArrayList;

public class Grafo<T extends Comparable> {
    //ATRIBUTOS
    private Nodo[] nodos;
    private Nodo<T> centro;
    private int dimension;
    private ArrayList<T> nombreNodos = new ArrayList();
    
    public Grafo(int dimension, ArrayList<T> nombreNodos){
        this.dimension = dimension;
        this.nombreNodos = nombreNodos;
        nodos = new Nodo[dimension];
        for(int i = 0; i<dimension; i++){
            nodos[i] = new Nodo(dimension, nombreNodos.get(i));
        }
    }
    
    public void agregarArco(T origen, T vecino, int valor){
        for(int i = 0; i<dimension; i++){
            if(nodos[i].getNombre().equals(origen)){
                nodos[i].agregarVecino(0, nombreNodos.indexOf(origen));
                nodos[i].agregarVecino(valor, nombreNodos.indexOf(vecino));
            }
            if(nodos[i].getNombre().equals(vecino)){
                nodos[i].agregarVecino(0, nombreNodos.indexOf(vecino));
                nodos[i].agregarVecino(valor, nombreNodos.indexOf(origen));
            }
        }
    }
    
    public void eliminarArco(String origen, String vecino){
        for(int i = 0; i<dimension; i++){
            if(nodos[i].getNombre().equals(origen)){
                nodos[i].eliminarVecino(nombreNodos.indexOf(vecino));
            }
            if(nodos[i].getNombre().equals(vecino)){
                nodos[i].eliminarVecino(nombreNodos.indexOf(origen));
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
    
    public void calcularCentro(int[][] matrizFloyd){
        int[] maximos = new int[dimension];
        
        for(int i=0; i<dimension; i++){
            maximos[i] = 0;
        }
        
        int temp = 0;
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                if(matrizFloyd[j][i]>temp){
                    temp = matrizFloyd[j][i];
                }
            }
            maximos[i] = temp;
            temp = 0;
        }
        
        int minimo = 9999;
        int indexCentro = 0;
        for(int i=0; i<dimension; i++){
            if(maximos[i]<minimo){
                minimo = maximos[i];
                indexCentro = i;
            }
        }
        centro = nodos[indexCentro];
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
    
    public void imprimirNombres(){
        //nombreNodos.get(i)
        for(int i = 0; i<dimension; i++){
            System.out.println(nodos[i].getNombre());
        }
    }
}
