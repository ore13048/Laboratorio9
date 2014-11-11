//Henry Orellana 13048
//Samuel Maldonado 13153
// Seccion: 30   09/11/14
// HOJA DE TRABAJO 9

// Referencias:
// https://code.google.com/p/hoja-8-grafos/source/browse/?r=8#svn%2FHoja8%2Fsrc%2Fhoja8

import java.util.Vector;


public class Matriz<V,E> implements Interfaz<V,E>{

    private Vector vertices = new Vector();
    private int[][] arcos= new int [25][25];
    
//constructor
    public Matriz(){
        
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    arcos[i][j]=0;
                }
                else{
                    arcos[i][j]=10000;
                }
            }
        }
    }
    /**
     *
     * @param label
     */
    @Override
    public void add(V label) {
        
        if(!vertices.contains(label)){
            vertices.add(label);
        }
        
        
    }

    /**
     *
     * @param vtx1
     * @param vtx2
     * @param label
     */
    @Override
    public void addEdge(V vtx1, V vtx2, E label) {
        int i = vertices.indexOf(vtx1);
        int j = vertices.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        arcos[i][j]=peso;
    }
    
    /**
     *
     */
    @Override
    public void show(){
        for(int a=0;a<vertices.size();a++){
            for(int b=0;b<vertices.size();b++){
                System.out.print(""+arcos[a][b]+" ");
            }
            System.out.println("");
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public int size(){
        return vertices.size();
    }
    
    /**
     *
     * @param label1
     * @param label2
     * @return
     */
    @Override
    public int getEdge(V label1, V label2){
        return arcos[vertices.indexOf(label1)][vertices.indexOf(label2)];
    }
    
    /**
     *
     * @param label
     * @return
     */
    @Override
    public V get(int label){
        
        return (V)vertices.get(label);
        
    }
    
    /**
     *
     * @param label
     * @return
     */
    @Override
    public int getIndex(V label){
        return vertices.indexOf(label);
    }
    
    /**
     *
     * @param label
     * @return
     */
    public boolean contains(V label){
        return vertices.contains(label);
    }
}
