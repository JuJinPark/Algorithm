import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Samseung.chickeDelivery;

public class TestAlogorithm {
	@Test
    public void testCountbits() {
		assertEquals(2,chickeDelivery.countBits(5));
		assertEquals(5,1 << 1);
	}
}
