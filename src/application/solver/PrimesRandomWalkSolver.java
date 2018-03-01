/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 */

package application.solver;

import application.primes.PrimeFinder;
import javafx.concurrent.Task;

public class PrimesRandomWalkSolver extends Task<XYCoordinateTupel> {

  private boolean[] primes;
  private XYCoordinateTupel positionBeforeXChange;
  private XYCoordinateTupel positionAfterXChange;
  private boolean walkLeft;

  public PrimesRandomWalkSolver() {
    primes = PrimeFinder.findPrimes(1000000000);
    positionBeforeXChange = new XYCoordinateTupel(0, 0);
    positionAfterXChange = new XYCoordinateTupel(0, 0);
    walkLeft = false;

  }

  @Override
  protected XYCoordinateTupel call() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  public void doTheRandomWalk() {
    double time = System.currentTimeMillis();
    int lastXChange = 0;

    for (int i = 0; i < primes.length; i++) {

      if (primes[i]) {

        positionBeforeXChange.setxCoordinate(positionAfterXChange.getxCoordinate());

        if (walkLeft) {
          positionAfterXChange.setxCoordinate(positionBeforeXChange.getxCoordinate() - (i - lastXChange));
          walkLeft = false;
        } else {
          positionAfterXChange.setxCoordinate(positionBeforeXChange.getxCoordinate() + (i - lastXChange));
          walkLeft = true;
        }
        lastXChange = i;

        if (i > 2) {
          int temp = positionBeforeXChange.getyCoordinate();
          temp++;
          positionAfterXChange.setyCoordinate(temp);
          positionBeforeXChange.setyCoordinate(temp);
        }

        //TODO hier updaten für GUI
        System.out.println("(" + positionBeforeXChange.getxCoordinate() + " , " + positionBeforeXChange.getyCoordinate() + ")(" + positionAfterXChange.getxCoordinate() + " , " + positionAfterXChange.getyCoordinate() + ")");
      }
    }
    System.out.println("Dauer für 10^9: " + (System.currentTimeMillis() - time));
  }

}
