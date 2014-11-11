//Henry Orellana 13048
//Samuel Maldonado 13153
// Seccion: 30   09/11/14
// HOJA DE TRABAJO 9

// Referencias:
// https://code.google.com/p/hoja-8-grafos/source/browse/?r=8#svn%2FHoja8%2Fsrc%2Fhoja8

import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        
        Algoritmo matriz = new Algoritmo(); // Matriz de adyacencia
        matriz.caminoCorto(); // Algoritmo de Floyd 
        int seleccion; 
        int opcion; 
        Scanner scan = new Scanner(System.in); 
        System.out.println("1. Buscar ruta mas corta entre dos ciudades ");
        System.out.println("2. Nombre de la ciudad en el centro del grafo");
        System.out.println("3. Modificar grafo");
        System.out.println("4. Finalizar programa");
        seleccion = scan.nextInt(); 
        
        
        while(seleccion!=4){
            
            System.out.println("\nMatriz de adyacencia");
            matriz.D.show();
            
            // Si la respuesta es 1
            if(seleccion==1){
                matriz.caminoCorto(); 
                System.out.println("Ingrese el nombre de la ciudad de salida");
                String ciudad1 = scan.next(); 
                System.out.println("Ingrese el nombre de la ciudad de destino");
                String ciudad2 = scan.next();
                if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                    System.out.println("\nLa distancia minima es: "+matriz.D.getEdge(ciudad1, ciudad2)+".");
                    if(matriz.D.getEdge(ciudad1, ciudad2)!=10000){
                        System.out.print("La ruta es: "+ciudad1);
                        matriz.mostrarIntermedias(matriz.D.getIndex(ciudad1), matriz.D.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            // Si la respuesta es 2
            else if(seleccion==2){
                matriz.centroGrafo();
            }
            
            // Si la respuesta es 3
            else if(seleccion==3){
                System.out.println("1. Hay interrupcion de trafico entre un par de ciudades");
                System.out.println("2. Establecer nueva conexion");
                opcion = scan.nextInt();
                // Si la respuesta es 1
                if(opcion==1){
                    System.out.println("Ingrese el nombre de la ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                        matriz.D.addEdge(ciudad1, ciudad2, 10000);
                    }
                }
                // Si la respuesta es 2
                else if(opcion==2){
                    System.out.println("Ingrese el nombre de la ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    System.out.println("Ingrese la distancia entre las ciudades");
                    int distancia = scan.nextInt();
                    if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                        matriz.D.addEdge(ciudad1, ciudad2, distancia);
                    }
                    else{
                        matriz.D.add(ciudad1);
                        matriz.D.add(ciudad2);
                        matriz.D.addEdge(ciudad1, ciudad2, distancia);
                    }
                }
                matriz.caminoCorto();
            }
       
            System.out.println("1. Buscar ruta mas corta entre dos ciudades ");
            System.out.println("2. Nombre de la ciudad en el centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Finalizar programa");
            seleccion = scan.nextInt();
        }
        
    }
}
