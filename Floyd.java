/***********************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructura de Datos
* Samuel Maldonado, carnet: 
* Henry Orellana, Carnet: 13048
***********************************************/

import java.util.ArrayList;
import java.util.HashMap;

public class Floyd<T extends Comparable> {
    public Floyd(){
    }
    
    public ArrayList algoritmoFloyd(Grafo digrafo){
        construirAdyacencia(digrafo);
        return new ArrayList();
    }
    
    private void construirAdyacencia(Grafo digrafo){
        //Etiquetas de destinos
        ArrayList<Nodo> Nodes = digrafo.getNodos();
        String[][] adyacencia = new String[Nodes.size()][Nodes.size()];
        T[] nodeNames = null;
        for(int i = 0; i < Nodes.size(); i++){
            nodeNames[i] = (T)Nodes.get(i).getOrigen();
        }
        
        for(int i = 0; i < Nodes.size(); i++){
            HashMap<Integer, Conexion<T>> destinos = Nodes.get(i).getDestinos();
            adyacencia[i][i] = "0";
            for(int j = 0; j < destinos.size(); j++){
                for(int k = 0; k < Nodes.size(); k++){
                    if(destinos.get(j).getDestino().equals(nodeNames[k])){
                        adyacencia[i][k] = destinos.get(j).getValor()+"";
                    }
                }
            }
        }
    }
}
