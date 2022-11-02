import junit.framework.TestCase;

public class TestAjedrez extends TestCase {
	Ajedrez aje;
	
	public void Test() {
		aje = new Ajedrez();
	}
	
	public void testHayPiezas() {
		Test();
		assertTrue(aje.getCapturas() > -1);
	}
	
	public void testHayPiezas2() {
		//Test();
		assertFalse(aje.getCapturas() > -1);
	}
}
