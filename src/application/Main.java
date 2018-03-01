
package application;

import application.gui.Application;
import application.solver.PrimesRandomWalkSolver;

public class Main {

  public static void main(String... args) {
    PrimesRandomWalkSolver primesRandomWalkSolver = new PrimesRandomWalkSolver();
    primesRandomWalkSolver.doTheRandomWalk();
    Application app = new Application();
    app.setArguments(args);
    app.startApplication();
  }
}
