package application.config;

public enum AppConfig {
	instance;

	public final String applicationTitle = "Prime Number Random Walk";
	public final int windowWidth = 1400;
	public final int windowHeight = 850;

	// GridSizes

	public final int gridTicksPerX = 10;
	public final int gridTicksPerY = 10;

	public final int[] gridSizes1x = { -3, 7 };
	public final int gridSizes1y = 4;
	public final int gridTick1x = (gridSizes1x[1] - gridSizes1x[0]) / gridTicksPerX;
	public final int gridTick1y = 1;

	public final int[] gridSizes2x = { -2, 10 };
	public final int gridSizes2y = 25;
	public final int gridTick2x = (gridSizes2x[1] - gridSizes2x[0]) / gridTicksPerX;
	public final int gridTick2y = gridSizes2y / gridTicksPerY;

	public final int[] gridSizes3x = { -5, 70 };
	public final int gridSizes3y = 168;
	public final int gridTick3x = (gridSizes3x[1] - gridSizes3x[0]) / gridTicksPerX;
	public final int gridTick3y = gridSizes3y / gridTicksPerY;

	public final int[] gridSizes4x = { -350, 70 };
	public final int gridSizes4y = 1229;
	public final int gridTick4x = (gridSizes4x[1] - gridSizes4x[0]) / gridTicksPerX;
	public final int gridTick4y = gridSizes4y / gridTicksPerY;

	public final int[] gridSizes5x = { -410, 800 };
	public final int gridSizes5y = 9592;
	public final int gridTick5x = (gridSizes5x[1] - gridSizes5x[0]) / gridTicksPerX;
	public final int gridTick5y = gridSizes5y / gridTicksPerY;

}