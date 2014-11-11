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


public class AlgoritmoTest {
    
    public AlgoritmoTest() {
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
     * Test of caminoCorto method, of class Algoritmo.
     */
    @Test
    public void testCaminoCorto() {
        System.out.println("caminoCorto");
        Algoritmo instance = new Algoritmo();
        instance.caminoCorto();

    }

    /**
     * Test of centroGrafo method, of class Algoritmo.
     */
    @Test
    public void testCentroGrafo() {
        System.out.println("centroGrafo");
        Algoritmo instance = new Algoritmo();
        instance.centroGrafo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarIntermedias method, of class Algoritmo.
     */
    @Test
    public void testMostrarIntermedias() {
        System.out.println("mostrarIntermedias");
        int num1 = 0;
        int num2 = 0;
        Algoritmo instance = new Algoritmo();
        instance.mostrarIntermedias(num1, num2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
