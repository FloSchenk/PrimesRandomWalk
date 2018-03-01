/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 */

package application.solver;

import application.primes.PrimeFinder;
import javafx.concurrent.Task;

public class PrimesRandomWalkSolver extends Task<XYCoordinateTupel> {

  private boolean[] primes;
  private XYCoordinateTupel actualPosition;
  private boolean walkLeft;

  public PrimesRandomWalkSolver() {
    primes = PrimeFinder.findPrimes(100);//1000000000
    actualPosition = new XYCoordinateTupel(0, 0);
    walkLeft = false;

  }

  @Override
  protected XYCoordinateTupel call() throws Exception {
    doTheRandomWalk();
    return null;
  }

  public void doTheRandomWalk() {
    double time = System.currentTimeMillis();
    int lastXChange = 0;

    for (int i = 0; i < primes.length; i++) {

      if (primes[i]) {

        if (walkLeft) {
          actualPosition.setxCoordinate(actualPosition.getxCoordinate() - (i - lastXChange));
          walkLeft = false;
        } else {
          actualPosition.setxCoordinate(actualPosition.getxCoordinate() + (i - lastXChange));
          walkLeft = true;
        }
        lastXChange = i;
        // TODO: replace sleep with cyclic barrier
        try {
        	Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        actualPosition = new XYCoordinateTupel(actualPosition.getxCoordinate(),actualPosition.getyCoordinate());
        updateValue(actualPosition);
        try {
        	Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.print("(" + actualPosition.getxCoordinate() + " , " + actualPosition.getyCoordinate() + ")");

        int temp = actualPosition.getyCoordinate();
        temp++;
        actualPosition.setyCoordinate(temp);

        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        actualPosition = new XYCoordinateTupel(actualPosition.getxCoordinate(),actualPosition.getyCoordinate());
        updateValue(actualPosition);
        try {
        	Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println("(" + actualPosition.getxCoordinate() + " , " + actualPosition.getyCoordinate() + ")");
      }
    }
    //TODO Delete Syso
    System.out.println("Dauer für 10^9: " + (System.currentTimeMillis() - time));
  }

}
