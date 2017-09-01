import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {
	Squarelotron s = new Squarelotron(4);

	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSquarelotron() {
		assertTrue(s.squarelotron[0][0] == 1);
		assertTrue(s.squarelotron[0][1] == 2);
		assertTrue(s.squarelotron[0][2] == 3);
		assertTrue(s.squarelotron[0][3] == 4);
		assertTrue(s.squarelotron[1][0] == 5);
		assertTrue(s.squarelotron[1][1] == 6);
		assertTrue(s.squarelotron[1][2] == 7);
		assertTrue(s.squarelotron[1][3] == 8);
		assertTrue(s.squarelotron[2][0] == 9);
		assertTrue(s.squarelotron[2][1] == 10);
		assertTrue(s.squarelotron[2][2] == 11);
		assertTrue(s.squarelotron[2][3] == 12);
		assertTrue(s.squarelotron[3][0] == 13);
		assertTrue(s.squarelotron[3][1] == 14);
		assertTrue(s.squarelotron[3][2] == 15);
		assertTrue(s.squarelotron[3][3] == 16);
		assertTrue(s.size == 4);
	}

	@Test
	public void testUpsideDownFlip() {
		Squarelotron flip = new Squarelotron(4).upsideDownFlip(1);
		assertTrue(flip.squarelotron[0][0] == 13);
		assertTrue(flip.squarelotron[0][1] == 14);
		assertTrue(flip.squarelotron[0][2] == 15);
		assertTrue(flip.squarelotron[0][3] == 16);
		assertTrue(flip.squarelotron[1][0] == 9);
		assertTrue(flip.squarelotron[1][1] == 6);
		assertTrue(flip.squarelotron[1][2] == 7);
		assertTrue(flip.squarelotron[1][3] == 12);
		assertTrue(flip.squarelotron[2][0] == 5);
		assertTrue(flip.squarelotron[2][1] == 10);
		assertTrue(flip.squarelotron[2][2] == 11);
		assertTrue(flip.squarelotron[2][3] == 8);
		assertTrue(flip.squarelotron[3][0] == 1);
		assertTrue(flip.squarelotron[3][1] == 2);
		assertTrue(flip.squarelotron[3][2] == 3);
		assertTrue(flip.squarelotron[3][3] == 4);
		assertTrue(flip.size == 4);
		Squarelotron doubleFlip = flip.upsideDownFlip(1);
		assertTrue(s.squarelotron[0][0] == doubleFlip.squarelotron[0][0]);
		assertTrue(s.squarelotron[2][2] == doubleFlip.squarelotron[2][2]);
	}

	@Test
	public void testMainDiagonalFlip() {
		Squarelotron flip = new Squarelotron(4).mainDiagonalFlip(1);
		assertTrue(flip.squarelotron[0][0] == 1);
		assertTrue(flip.squarelotron[0][1] == 5);
		assertTrue(flip.squarelotron[0][2] == 9);
		assertTrue(flip.squarelotron[0][3] == 13);
		assertTrue(flip.squarelotron[1][0] == 2);
		assertTrue(flip.squarelotron[1][1] == 6);
		assertTrue(flip.squarelotron[1][2] == 7);
		assertTrue(flip.squarelotron[1][3] == 14);
		assertTrue(flip.squarelotron[2][0] == 3);
		assertTrue(flip.squarelotron[2][1] == 10);
		assertTrue(flip.squarelotron[2][2] == 11);
		assertTrue(flip.squarelotron[2][3] == 15);
		assertTrue(flip.squarelotron[3][0] == 4);
		assertTrue(flip.squarelotron[3][1] == 8);
		assertTrue(flip.squarelotron[3][2] == 12);
		assertTrue(flip.squarelotron[3][3] == 16);
		assertTrue(flip.size == 4);
		Squarelotron doubleFlip = flip.mainDiagonalFlip(1);
		assertTrue(s.squarelotron[0][0] == doubleFlip.squarelotron[0][0]);
		assertTrue(s.squarelotron[2][2] == doubleFlip.squarelotron[2][2]);
	}

	@Test
	public void testRotateRight() {
		s.rotateRight(1);
		s.rotateRight(-1);
		assertTrue(s.squarelotron[0][0] == 1);
		s.rotateRight(-2);
		assertTrue(s.squarelotron[0][0] == 16);
		
		Squarelotron r = new Squarelotron(5);
		Squarelotron t = new Squarelotron(5);
		t.rotateRight(-5);
		t.rotateRight(5);
		assertEquals(r.squarelotron[3][4], t.squarelotron[3][4]);
		t.rotateRight(-1);
		assertEquals(r.squarelotron[0][0], t.squarelotron[4][0]);
	}

}
