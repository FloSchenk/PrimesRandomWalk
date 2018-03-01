package application.gui.controller;

import java.util.ArrayList;

import application.config.AppConfig;
import application.solver.PrimesRandomWalkSolver;
import application.solver.XYCoordinateTupel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.LineChart.SortingPolicy;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ApplicationController {

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
				int value = Math.round(newValue.floatValue());

				switch (value) {
				case 1:
					xAxis.setLowerBound(AppConfig.instance.gridSizes1x[0]);
					xAxis.setUpperBound(AppConfig.instance.gridSizes1x[1]);
					yAxis.setUpperBound(AppConfig.instance.gridSizes1y);
					xAxis.setTickUnit(AppConfig.instance.gridTick1x);
					yAxis.setTickUnit(AppConfig.instance.gridTick1y);
					break;
				case 2:
					xAxis.setLowerBound(AppConfig.instance.gridSizes2x[0]);
					xAxis.setUpperBound(AppConfig.instance.gridSizes2x[1]);
					yAxis.setUpperBound(AppConfig.instance.gridSizes2y);
					xAxis.setTickUnit(AppConfig.instance.gridTick2x);
					yAxis.setTickUnit(AppConfig.instance.gridTick2y);

					break;
				case 3:
					xAxis.setLowerBound(AppConfig.instance.gridSizes3x[0]);
					xAxis.setUpperBound(AppConfig.instance.gridSizes3x[1]);
					yAxis.setUpperBound(AppConfig.instance.gridSizes3y);
					xAxis.setTickUnit(AppConfig.instance.gridTick3x);
					yAxis.setTickUnit(AppConfig.instance.gridTick3y);

					break;
				case 4:
					xAxis.setLowerBound(AppConfig.instance.gridSizes4x[0]);
					xAxis.setUpperBound(AppConfig.instance.gridSizes4x[1]);
					yAxis.setUpperBound(AppConfig.instance.gridSizes4y);
					xAxis.setTickUnit(AppConfig.instance.gridTick4x);
					yAxis.setTickUnit(AppConfig.instance.gridTick4y);

					break;
				case 5:
					xAxis.setLowerBound(AppConfig.instance.gridSizes5x[0]);
					xAxis.setUpperBound(AppConfig.instance.gridSizes5x[1]);
					yAxis.setUpperBound(AppConfig.instance.gridSizes5y);
					xAxis.setTickUnit(AppConfig.instance.gridTick5x);
					yAxis.setTickUnit(AppConfig.instance.gridTick5y);
					break;
				default:
					break;
				}

			}
		});

		setupAxes();
		setupChart();
		vbox.getChildren().add(chart);

	}

	private void setupAxes() {
		setupXAxes();
		setupYAxes();
	}

	private void setupYAxes() {
		yAxis = new NumberAxis(0, AppConfig.instance.gridSizes5y, AppConfig.instance.gridTick5y);
		yAxis.setAutoRanging(false);
		yAxis.setAnimated(false);
	}

	private void setupXAxes() {
		xAxis = new NumberAxis(AppConfig.instance.gridSizes5x[0], AppConfig.instance.gridSizes5x[1],
				AppConfig.instance.gridTick5x);
		xAxis.setAutoRanging(false);
		xAxis.setAnimated(false);
	}

	private void setupChart() {
		chart = new LineChart<>(xAxis, yAxis);
		chart.setPrefHeight(700);
		chart.setAnimated(false);
		chart.setCreateSymbols(false);
		chart.setLegendVisible(false);
		chart.setAxisSortingPolicy(SortingPolicy.NONE);

		series = new XYChart.Series<>();
		chart.getData().add(series);
	}

	@FXML
	public void startDrawing() {
		ArrayList<XYCoordinateTupel> returnedList = startAlgorithm();
		for (XYCoordinateTupel xyCoordinateTupel : returnedList) {
			addNewPoint(xyCoordinateTupel.getxCoordinate(), xyCoordinateTupel.getyCoordinate());
		}
	}

	private ArrayList<XYCoordinateTupel> startAlgorithm() {
		return new PrimesRandomWalkSolver().start();
	}

	public void addNewPoint(int x, int y) {
		series.getData().add(new Data<Number, Number>(x, y));
	}

}
