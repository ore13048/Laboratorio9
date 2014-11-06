/***********************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructura de Datos
* Samuel Maldonado, carnet: 
* Henry Orellana, Carnet: 13048
***********************************************/

public class Floyd<T extends Comparable> {
    
    public Floyd(){
    }
    
    //Implementación del algoritmo Floyd para formar la matriz de adyacencia con las rutas mas cortas
    public int[][] algoritmoFloyd(Grafo ciudad){
        int n = ciudad.getDimension();
        int[][] matriz = ciudad.matrizAdyacencia();
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j=0; j<n; j++){
                    int aux = matriz[i][j];
                    int aux2 = matriz[i][k];
                    int aux3 = matriz[k][j];
                    int aux4 = aux2+aux3;
                    int res = Math.min(aux, aux4);
                    matriz[i][j] = res;
                }
            }
        }
        
        return matriz;
    }
    
    //Implementación del algoritmo de Floyd con el ingreso del nombre de un nodo origen y uno destino
    public String algoritmoFloydPares(Grafo ciudad, String origen, String destino){
        int[][] adyacencia = ciudad.matrizAdyacencia();
        int n=adyacencia.length;
        int D[][]=adyacencia;
        int indexOrigen = ciudad.getNombreNodos().indexOf(origen);
        int indexDestino = ciudad.getNombreNodos().indexOf(destino);

        String enlaces[][]=new String [n][n];
        String[][] aux_enlaces=new String[adyacencia.length][adyacencia.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 enlaces[i][j]="";
                 aux_enlaces[i][j]="";
           }
        }
        String enl_rec="";
        for (int k = 0; k < n; k++) {
           for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int aux=D[i][j];
                    int aux2=D[i][k];
                    int aux3=D[k][j];
                    int aux4=aux2+aux3;
                    int res=Math.min(aux,aux4);
                    if(aux!=aux4)
                    {
                       if(res==aux4)
                        {
                            enl_rec="";
                            aux_enlaces[i][j]=k+"";
                            enlaces[i][j]=enlaces(i,k,aux_enlaces,enl_rec)+(k+1);
                        }
                    }
                D[i][j]= res;
             }
            }
        }
        
        String cadena = "";
        cadena = "De " + origen + " a " + destino + " la distancia minima es = " + D[indexOrigen][indexDestino];
        
        String[] indexCiudades = enlaces[indexDestino][indexOrigen].split(" ");
        if(!enlaces[indexDestino][indexOrigen].equals("")){
            cadena += "\nDebe pasar por = ";
            for(int i=0;i<indexCiudades.length;i++){
                cadena += ciudad.getNombreNodos().get(Integer.parseInt(indexCiudades[i])-1);
            }
        }
        else{
            cadena += "\nNo debe pasar por ninguna ciudad";
        }
        return cadena;
    }
    
    //Metodo auxiliar para formar las cadenas de nombres de nodos por los que debe pasar un par de nodos para conectarse
    public String enlaces(int i,int k,String[][] aux_enlaces,String enl_rec){
        if(aux_enlaces[i][k].equals("")==true)
        {
            return "";
        }
        else
        {
            enl_rec+=enlaces(i,Integer.parseInt(aux_enlaces[i][k].toString()),aux_enlaces,enl_rec)+(Integer.parseInt(aux_enlaces[i][k].toString())+1)+" ";
            return enl_rec;
        }
    }
    
}
