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
    primes = PrimeFinder.findPrimes(1000);//1000000000
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

        //TODO update here
        System.out.print("(" + actualPosition.getxCoordinate() + " , " + actualPosition.getyCoordinate() + ")");

        int temp = actualPosition.getyCoordinate();
        temp++;
        actualPosition.setyCoordinate(temp);

        //TODO hier updaten für GUI Delete SySo
        System.out.println("(" + actualPosition.getxCoordinate() + " , " + actualPosition.getyCoordinate() + ")");
      }
    }
    //TODO Delete Syso
    System.out.println("Dauer für 10^9: " + (System.currentTimeMillis() - time));
  }

}
