/***********************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructura de Datos
* Samuel Maldonado, carnet: 
* Henry Orellana, Carnet: 13048
***********************************************/

import java.util.ArrayList;

public class Nodo<T extends Comparable> {
    //ATRIBUTOS
    private T nombre;
    private String[] vecinos;
    
    //METODOS
    public Nodo(int dimension, T nombre){
        this.nombre = nombre;
        this.vecinos = new String[dimension];
        for(int i = 0; i<dimension; i++){
            vecinos[i] = "9999";
        }
    }
    
    public void agregarVecino(int valor, int columna){
        vecinos[columna] = valor+"";
    }
    
    public void eliminarVecino(int columna){
        vecinos[columna] = "0";
    }
    
    public T getNombre(){
        return nombre;
    }
    
    public void setNombre(T nombre){
        this.nombre = nombre;
    }
    
    public String[] getVecinos(){
        return vecinos;
    }
}
