package application.gui.controller;

import application.solver.PrimesRandomWalkSolver;
import application.solver.XYCoordinateTupel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.LineChart.SortingPolicy;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ApplicationController {

	private final String buttonPrefix = "Start with ";
	@FXML
	HBox root;
	
	@FXML
	VBox vbox;
	@FXML
	Button startButton;
	@FXML
	Slider slider;
	
	private LineChart<Number, Number> chart;
	private NumberAxis xAxis;
	private NumberAxis yAxis;
	private XYChart.Series<Number, Number> series;

	@FXML
	public void initialize() {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				startButton.setText(buttonPrefix + " 10^(" + Math.round(newValue.doubleValue()) + ")");
			}
		});
		
		xAxis = new NumberAxis();
		yAxis = new NumberAxis();
		chart = new LineChart<>(xAxis, yAxis);
		series = new XYChart.Series<>();
		chart.getData().add(series);
		// TODO: remove dots
		vbox.getChildren().add(chart);

		// WICHTIG!!!
		chart.setAxisSortingPolicy(SortingPolicy.NONE);		
	}

	@FXML
	public void startDrawing() {
		addNewPoint(0, 0);
		Task<XYCoordinateTupel> task = new PrimesRandomWalkSolver();
		task.valueProperty().addListener(new ChangeListener<XYCoordinateTupel>() {

			@Override
			public void changed(ObservableValue<? extends XYCoordinateTupel> observable, XYCoordinateTupel oldValue,
					XYCoordinateTupel newValue) {
				if (newValue != null) {
					addNewPoint(newValue.getxCoordinate(), newValue.getyCoordinate());
				}
			}
		});
		
		Thread threadSolver = new Thread(task);
		threadSolver.setDaemon(true);
		threadSolver.start();
	}
	
	public void addNewPoint(int x, int y) {
        System.out.println("(" + x + " , " + y + ")");
		series.getData().add(new XYChart.Data<Number, Number>(x,y));
	}
	
}
