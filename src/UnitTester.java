import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTester {
	
	
	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");  
    }
	
	@Test
	public void testInitializer(){
		Initializer init = new Initializer(9,3);
		System.out.println("test case find max");  
        
}
	
}
