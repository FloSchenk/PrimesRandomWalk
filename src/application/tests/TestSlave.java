package application.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import application.primes.PrimeFinder;
import application.solver.PrimesRandomWalkSolver;
import application.solver.XYCoordinateTupel;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
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
		Assert.assertEquals(0, xYCoordinateTupel.getxCoordinate());
		Assert.assertEquals(0, xYCoordinateTupel.getyCoordinate());
		xYCoordinateTupel.setxCoordinate(5);
		Assert.assertEquals(5, xYCoordinateTupel.getxCoordinate());
		xYCoordinateTupel.setyCoordinate(11);
		Assert.assertEquals(11, xYCoordinateTupel.getyCoordinate());
	}
	
	@Test
	public void testPrimesRandomWalkSolver(){
		ArrayList<XYCoordinateTupel> arrayList = primesRandomWalkSolver.start();
		assertNotNull(arrayList);
		System.out.println(arrayList.get(arrayList.size()-1));
		assertNotNull(primesRandomWalkSolver.getPrimes());
		Assert.assertEquals(true, primesRandomWalkSolver.isWalkLeft());
		Assert.assertEquals(19185, arrayList.size());
		Assert.assertEquals(2, arrayList.get(1).getxCoordinate());
		Assert.assertEquals(0, arrayList.get(1).getyCoordinate());
		Assert.assertEquals(2, arrayList.get(2).getxCoordinate());
		Assert.assertEquals(1, arrayList.get(2).getyCoordinate());
		Assert.assertEquals(5, arrayList.get(10).getxCoordinate());
		Assert.assertEquals(5, arrayList.get(10).getyCoordinate());	
	}
	
	@Test
	public void testPrimeFinder(){
		ArrayList<Integer> arrayList = PrimeFinder.findPrimes(10);
		assertNotNull(arrayList);
		Assert.assertEquals(4, arrayList.size());
		Assert.assertEquals(2,(int) arrayList.get(0));
		Assert.assertEquals(3,(int) arrayList.get(1));
		Assert.assertEquals(5,(int) arrayList.get(2));
		Assert.assertEquals(7,(int) arrayList.get(3));
	}
}
