//Henry Orellana 13048
//Samuel Maldonado 13153
// Seccion: 30   09/11/14
// HOJA DE TRABAJO 9

// Referencias:
// https://code.google.com/p/hoja-8-grafos/source/browse/?r=8#svn%2FHoja8%2Fsrc%2Fhoja8

import java.io.*;


public class Lectura{
    
    File archivo;
    FileReader fr;
    BufferedReader br;
    Interfaz grafo = new Matriz();

    
//usar direccion del archivo
    public void obtenerArchivo(String direccion) throws FileNotFoundException{
       archivo=new File(direccion); 
    }  
    
//recibir nombres de nodos
    public Interfaz arregloNombres() throws IOException{
        // Lectura del fichero
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.add(tmp[0]);
            grafo.add(tmp[1]);
        }
        return grafo;
    }
    
//recibir pesos entre nodos especificos
    public Interfaz matrizCostos() throws IOException{
        // Lectura del fichero
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;

        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }
    

}
