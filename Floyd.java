/***********************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructura de Datos
* Samuel Maldonado, carnet: 
* Henry Orellana, Carnet: 13048
***********************************************/

importación  java.util.ArrayList ;
importación  java.util.HashMap ;

público  de clase  Floyd <T extiende  Comparable > {
    pública  Floyd () {
    }
    
    público  ArrayList  algoritmoFloyd ( Grafo  dígrafo ) {
        construirAdyacencia (dígrafo);
        volver  nuevo  ArrayList ();
    }
    
    privada  vacío  construirAdyacencia ( Grafo  dígrafo ) {
        // Etiquetas de Destinos
        ArrayList < Nodo >  Nodos  = dígrafo . getNodos ();
        Cadena [] [] adyacencia =  nuevos  Cuerda [ Nodos . size ()] [ Nodos . size ()];
        T [] nombres de nodo =  nulo ;
        para ( int i =  0 ; i <  Nodos . size (); i ++ ) {
            nombres de los nodos [i] = ( T ) Nodos . get (i) . getOrigen ();
        }
        
        para ( int i =  0 ; i <  Nodos . size (); i ++ ) {
            HashMap < Entero , Conexion < T > > Destinos =  Nodos . get (i) . getDestinos ();
            adyacencia [i] [i] =  "0" ;
            para ( int j =  0 ; j < Destinos . size (); j ++ ) {
                para ( int k =  0 ; k <  Nodos . size (); k ++ ) {
                    si (Destinos . get (j) . getDestino () . equals (nombres de los nodos [k])) {
                        adyacencia [i] [k] = Destinos . get (j) . getValor () + "" ;
                    }
                }
            }
        }
    }
}
