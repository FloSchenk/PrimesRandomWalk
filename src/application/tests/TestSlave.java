package application.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import application.primes.PrimeFinder;
import application.solver.PrimesRandomWalkSolver;
import application.solver.XYCoordinateTupel;

public class TestSlave {

	private static XYCoordinateTupel xYCoordinateTupel;
	private static PrimesRandomWalkSolver primesRandomWalkSolver;
	
	@BeforeClass
	public static void init(){
		xYCoordinateTupel = new XYCoordinateTupel();
		primesRandomWalkSolver = new PrimesRandomWalkSolver();
	}
	
	@Test
	public void testXYTupel(){
		assertNotNull(xYCoordinateTupel);
		assertEquals(0, xYCoordinateTupel.getxCoordinate());
		assertEquals(0, xYCoordinateTupel.getyCoordinate());
		xYCoordinateTupel.setxCoordinate(5);
		assertEquals(5, xYCoordinateTupel.getxCoordinate());
		xYCoordinateTupel.setyCoordinate(11);
		assertEquals(11, xYCoordinateTupel.getyCoordinate());
	}
	
	@Test
	public void testPrimesRandomWalkSolver(){
		ArrayList<XYCoordinateTupel> arrayList = primesRandomWalkSolver.start();
		assertNotNull(arrayList);
		assertNotNull(primesRandomWalkSolver.getPrimes());
		assertEquals(true, primesRandomWalkSolver.isWalkLeft());
		assertEquals(19185, arrayList.size());
		assertEquals(2, arrayList.get(1).getxCoordinate());
		assertEquals(0, arrayList.get(1).getyCoordinate());
		assertEquals(2, arrayList.get(2).getxCoordinate());
		assertEquals(1, arrayList.get(2).getyCoordinate());
		assertEquals(5, arrayList.get(10).getxCoordinate());
		assertEquals(5, arrayList.get(10).getyCoordinate());	
	}
	
	@Test
	public void testPrimeFinder(){
		ArrayList<Integer> arrayList = PrimeFinder.findPrimes(10);
		assertNotNull(arrayList);
		assertEquals(4, arrayList.size());
		assertEquals(2,(int) arrayList.get(0));
		assertEquals(3,(int) arrayList.get(1));
		assertEquals(5,(int) arrayList.get(2));
		assertEquals(7,(int) arrayList.get(3));
	}
}
