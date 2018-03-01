package application.gui.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.LineChart.SortingPolicy;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class ApplicationController {

	private final String buttonPrefix = "Start with ";
	@FXML
	HBox root;
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

		// WICHTIG!!!
		chart.setAxisSortingPolicy(SortingPolicy.NONE);		
	}

	@FXML
	public void startDrawing() {
		
	}
	
	public void addNewPoint(int x, int y) {
		series.getData().add(new XYChart.Data<Number, Number>(x,y));
	}
	
}
