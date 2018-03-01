package application.config;

public enum AppConfig{
	instance;
	
	public final String applicationTitle = "Prime Number Random Walk";
	public final int windowWidth = 1400;
	public final int windowHeight = 850;
	
	//GridSizes
	public final int[] gridSizes1x = {-3,7};
	public final int gridSizes1y = 5;
	
	public final int[] gridSizes2x = {-5, 15};
	public final int gridSizes2y = 30;
	
	public final int[] gridSizes3x = {-10, 75};
	public final int gridSizes3y = 180;
	
	public final int[] gridSizes4x = {-300, 80};
	public final int gridSizes4y = 1300;
	
	public final int[] gridSizes5x = {-500,1000};
	public final int gridSizes5y = 10000;
	
	public final int[] gridSizes6x = {-5000, 2000};
	public final int gridSizes6y = 85000;
	
	public final int[] gridSizes7x = {-25000, 5000};
	public final int gridSizes7y = 700000;
	
	public final int[] gridSizes8x = {-30000, 30000};
	public final int gridSizes8y = 6500000;
	
	public final int[] gridSizes9x = {-200000, 100000};
	public final int gridSizes9y = 60000000;
	
}