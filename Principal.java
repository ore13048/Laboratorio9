import java.util.ArrayList;

public class Principal {
    public static void main(String[] args){
        //Nombres de las ciudades y cantidad de nodos
        int nodos = 10;
        ArrayList<String> ciudades = new ArrayList();
        String ciudad1 = "Mazatenango";
        String ciudad2 = "Escuintla";
        String ciudad3 = "Rethaluleu";
        String ciudad4 = "Quetzaltenango";
        String ciudad5 = "Guatemala";
        String ciudad6 = "Chiquimula";
        String ciudad7 = "Antigua";
        String ciudad8 = "Flores";
        String ciudad9 = "Cobán";
        String ciudad10 = "Cuyotenango";
        
        //Añadiendo a la lista
        ciudades.add(ciudad1);
        ciudades.add(ciudad2);
        ciudades.add(ciudad3);
        ciudades.add(ciudad4);
        ciudades.add(ciudad5);
        ciudades.add(ciudad6);
        ciudades.add(ciudad7);
        ciudades.add(ciudad8);
        ciudades.add(ciudad9);
        ciudades.add(ciudad10);
        
        //Creando el grafo
        Grafo<String> guatemala = new Grafo(nodos, ciudades);
        
        //Creando las conexiones
        guatemala.agregarArco(ciudad1, ciudad10, 7);
        guatemala.agregarArco(ciudad10, ciudad3, 120);
        guatemala.agregarArco(ciudad2, ciudad1, 58);
        guatemala.agregarArco(ciudad2, ciudad5, 120);
        guatemala.agregarArco(ciudad2, ciudad7, 170);
        guatemala.agregarArco(ciudad5, ciudad8, 290);
        guatemala.agregarArco(ciudad3, ciudad4, 175);
        guatemala.agregarArco(ciudad5, ciudad9, 90);
        guatemala.agregarArco(ciudad2, ciudad6, 63);
        guatemala.agregarArco(ciudad5, ciudad10, 63);
        
        //Aplicando el algoritmo de floyd
        Floyd algoritmo = new Floyd();
        int[][] resultado = algoritmo.algoritmoFloyd(guatemala);
        
        //Imprimiendo la matriz
        for(int i=0; i<nodos; i++){
            for(int j=0; j<nodos; j++){
                System.out.print(resultado[i][j]+", ");
            }
            System.out.println();
        }
        
        //Calculando el centro en base a la matriz generada por floyd
        guatemala.calcularCentro(resultado);
        //Imprimiendo el nombre del centro
        System.out.println("Centro del grafo = "+guatemala.getCentro().getNombre());
        
        //Agregando un nodo
        guatemala.agregarNodo("San Pedro");
        guatemala.agregarArco("San Pedro", ciudad4, 128);
        //Eliminando Arco
        guatemala.eliminarArco(ciudad5, ciudad10);
        resultado = algoritmo.algoritmoFloyd(guatemala);
        //Imprimiendo la matriz
        for(int i=0; i<guatemala.getDimension(); i++){
            for(int j=0; j<guatemala.getDimension(); j++){
                System.out.print(resultado[i][j]+", ");
            }
            System.out.println();
        }
        
        //Calculando el centro en base a la matriz generada por floyd
        guatemala.calcularCentro(resultado);
        //Imprimiendo el nombre del centro
        System.out.println("Centro del grafo = "+guatemala.getCentro().getNombre());
        
        //PROBANDO NUEVO METODO FLOYD
        String mensaje = algoritmo.algoritmoFloydPares(guatemala, ciudad2, ciudad5);
        System.out.println(mensaje);
    }
}
