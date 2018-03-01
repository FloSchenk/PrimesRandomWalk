/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 */

package application.solver;

import java.util.ArrayList;

import application.primes.PrimeFinder;

public class PrimesRandomWalkSolver {

	private ArrayList<Integer> primes;
	private ArrayList<XYCoordinateTupel> tupels;
	private boolean walkLeft;

	public PrimesRandomWalkSolver() {
		primes = PrimeFinder.findPrimes(100000);
		tupels = new ArrayList<>();
		walkLeft = true;
	}

	public ArrayList<XYCoordinateTupel> start() {
		doTheRandomWalk();
		return tupels;
	}

	public void doTheRandomWalk() {
		tupels.add(new XYCoordinateTupel(0, 0));
		int lastPrime = 0;
		for (Integer actualPrime : primes) {
			int actualX = tupels.get(tupels.size() - 1).getxCoordinate();
			int actualY = tupels.get(tupels.size() - 1).getyCoordinate();
			XYCoordinateTupel tempTupel1 = new XYCoordinateTupel();
			XYCoordinateTupel tempTupel2 = new XYCoordinateTupel();
			if (walkLeft = !walkLeft) {
				tempTupel1.setxCoordinate(actualX - (actualPrime - lastPrime));
				tempTupel2.setxCoordinate(actualX - (actualPrime - lastPrime));
			} else {
				tempTupel1.setxCoordinate(actualX + (actualPrime - lastPrime));
				tempTupel2.setxCoordinate(actualX + (actualPrime - lastPrime));
			}
			tempTupel1.setyCoordinate(actualY);
			tempTupel2.setyCoordinate(actualY + 1);
			tupels.add(tempTupel1);
			tupels.add(tempTupel2);
			lastPrime = actualPrime;
		}
	}

}
