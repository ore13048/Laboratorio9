//Henry Orellana 13048
//Samuel Maldonado 13153
// Seccion: 30   09/11/14
// HOJA DE TRABAJO 9

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MatrizTest {
    
    public MatrizTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Matriz.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object label = null;
        Matriz instance = new Matriz();
        instance.add(label);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of addEdge method, of class Matriz.
     */
    @Test
    public void testAddEdge() {
        System.out.println("addEdge");
        int[][] arcos= new int [25][25];
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
        Object Guatemala;
        Guatemala = new Object();
        Object vtx1 = Guatemala;
        Object vtx2 = Guatemala;
        Object label = 2;
    }

    /**
     * Test of show method, of class Matriz.
     */
    @Test
    public void testShow() {
        System.out.println("show");
        Matriz instance = new Matriz();
        instance.show();

    }

    /**
     * Test of size method, of class Matriz.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Matriz instance = new Matriz();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEdge method, of class Matriz.
     */
    @Test
    public void testGetEdge() {
        System.out.println("getEdge");
        Object label1 = null;
        Object label2 = null;
        Matriz instance = new Matriz();
        int expResult = 0;
    }

    /**
     * Test of get method, of class Matriz.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int label = 0;
        Matriz instance = new Matriz();
        Object expResult = null;
    }

    /**
     * Test of getIndex method, of class Matriz.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        Object label = null;
        Matriz instance = new Matriz();
        int expResult = 0;
    }

    /**
     * Test of contains method, of class Matriz.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object label = null;
        Matriz instance = new Matriz();
        boolean expResult = false;
        boolean result = instance.contains(label);
        assertEquals(expResult, result);

    }
    
}
