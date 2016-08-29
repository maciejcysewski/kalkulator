package pl.jcode.kalkulator;

/**
 * Kalkulator
 *
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

	Engine engine = new Engine();

	static Label label;
	String value;
	String comma;
	
	public static void main( String[] args ) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane, 230, 330);

		//primaryStage
		primaryStage.setTitle("Kalkulator");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

		//label
		label = new Label("0");
		label.setPrefHeight(80);
		label.setPrefWidth(230);
		label.setAlignment(Pos.CENTER_RIGHT);
		gridPane.add(label, 0, 0, 4, 1);

		//button MC
		Button buttonMC = new Button("MC");
		buttonMC.setPrefHeight(20);
		buttonMC.setPrefWidth(60);
		gridPane.add(buttonMC, 0, 1);
		buttonMC.setOnAction(e -> {
			engine.memoryMC();
		});

		//button MR
		Button buttonMR = new Button("MR");
		buttonMR.setPrefHeight(20);
		buttonMR.setPrefWidth(60);
		gridPane.add(buttonMR, 1, 1);
		buttonMR.setOnAction(e -> {
			engine.memoryMR();
		});

		//button M+
		Button buttonMPlus = new Button("M+");
		buttonMPlus.setPrefHeight(20);
		buttonMPlus.setPrefWidth(60);
		gridPane.add(buttonMPlus, 2, 1);
		buttonMPlus.setOnAction(e -> {
			engine.memoryPlus(label.getText());
		});

		//button M-
		Button buttonMMinus = new Button("M-");
		buttonMMinus.setPrefHeight(20);
		buttonMMinus.setPrefWidth(60);
		gridPane.add(buttonMMinus, 3, 1);
		buttonMMinus.setOnAction(e -> {
			engine.memoryMinus(label.getText());
		});

		//button CE
		Button buttonCE = new Button("CE");
		buttonCE.setPrefHeight(50);
		buttonCE.setPrefWidth(60);
		gridPane.add(buttonCE, 0, 2);
		buttonCE.setOnAction(e -> {
			engine.reset();
		});

		//button %
		Button buttonPercent = new Button("%");
		buttonPercent.setPrefHeight(50);
		buttonPercent.setPrefWidth(60);
		gridPane.add(buttonPercent, 1, 2);
		buttonPercent.setOnAction(e -> {
			engine.percent(Double.parseDouble(label.getText()));
		});

		//button +/-
		Button buttonPlusMinus = new Button("+/-");
		buttonPlusMinus.setPrefHeight(50);
		buttonPlusMinus.setPrefWidth(60);
		gridPane.add(buttonPlusMinus, 2, 2);
		buttonPlusMinus.setOnAction(e -> {
			engine.plusMinus();
		});

		//button /
		Button buttonSplit = new Button("/");
		buttonSplit.setPrefHeight(50);
		buttonSplit.setPrefWidth(60);
		gridPane.add(buttonSplit, 3, 2);
		buttonSplit.setOnAction(e -> {
			engine.sign(buttonSplit.getText(), label.getText());
		});

		//button 7
		Button button7 = new Button("7");
		button7.setPrefHeight(50);
		button7.setPrefWidth(60);
		gridPane.add(button7, 0, 3);
		button7.setOnAction(e -> {
			engine.labelUpdate(button7.getText());
		});

		//button 8
		Button button8 = new Button("8");
		button8.setPrefHeight(50);
		button8.setPrefWidth(60);
		gridPane.add(button8, 1, 3);
		button8.setOnAction(e -> {
			engine.labelUpdate(button8.getText());
		});

		//button 9
		Button button9 = new Button("9");
		button9.setPrefHeight(50);
		button9.setPrefWidth(60);
		gridPane.add(button9, 2, 3);
		button9.setOnAction(e -> {
			engine.labelUpdate(button9.getText());
		});

		//button *
		Button buttonMulti = new Button("X");
		buttonMulti.setPrefHeight(50);
		buttonMulti.setPrefWidth(60);
		gridPane.add(buttonMulti, 3, 3);
		buttonMulti.setOnAction(e -> {
			engine.sign("*", label.getText());
		});

		//button 4
		Button button4 = new Button("4");
		button4.setPrefHeight(50);
		button4.setPrefWidth(60);
		gridPane.add(button4, 0, 4);
		button4.setOnAction(e -> {
			engine.labelUpdate(button4.getText());
		});

		//button 5
		Button button5 = new Button("5");
		button5.setPrefHeight(50);
		button5.setPrefWidth(60);
		gridPane.add(button5, 1, 4);
		button5.setOnAction(e -> {
			engine.labelUpdate(button5.getText());
		});

		//button 6
		Button button6 = new Button("6");
		button6.setPrefHeight(50);
		button6.setPrefWidth(60);
		gridPane.add(button6, 2, 4);
		button6.setOnAction(e -> {
			engine.labelUpdate(button6.getText());
		});

		//button -
		Button buttonMinus = new Button("-");
		buttonMinus.setPrefHeight(50);
		buttonMinus.setPrefWidth(60);
		gridPane.add(buttonMinus, 3, 4);
		buttonMinus.setOnAction(e -> {
			engine.sign(buttonMinus.getText(), label.getText());
		});

		//button 1
		Button button1 = new Button("1");
		button1.setPrefHeight(50);
		button1.setPrefWidth(60);
		gridPane.add(button1, 0, 5);
		button1.setOnAction(e -> {
			engine.labelUpdate(button1.getText());
		});

		//button 2
		Button button2 = new Button("2");
		button2.setPrefHeight(50);
		button2.setPrefWidth(60);
		gridPane.add(button2, 1, 5);
		button2.setOnAction(e -> {
			engine.labelUpdate(button2.getText());
		});

		//button 3
		Button button3 = new Button("3");
		button3.setPrefHeight(50);
		button3.setPrefWidth(60);
		gridPane.add(button3, 2, 5);
		button3.setOnAction(e -> {
			engine.labelUpdate(button3.getText());
		});

		//button +
		Button buttonPlus = new Button("+");
		buttonPlus.setPrefHeight(50);
		buttonPlus.setPrefWidth(60);
		gridPane.add(buttonPlus, 3, 5);
		buttonPlus.setOnAction(e -> {
			engine.sign(buttonPlus.getText(), label.getText());
		});

		//button 0
		Button button0 = new Button("0");
		button0.setPrefHeight(50);
		button0.setPrefWidth(60);
		gridPane.add(button0, 0, 6);
		button0.setOnAction(e -> {
			engine.labelUpdate(button0.getText());
		});

		//button comma
		Button buttonComma = new Button(",");
		buttonComma.setPrefHeight(50);
		buttonComma.setPrefWidth(60);
		gridPane.add(buttonComma, 1, 6);
		buttonComma.setOnAction(e -> {
			engine.comma(buttonComma.getText());
		});

		//button <X backspace
		Button buttonBS = new Button("BackS");
		buttonBS.setPrefHeight(50);
		buttonBS.setPrefWidth(60);
		gridPane.add(buttonBS, 2, 6);
		buttonBS.setDisable(true); //napisać obsługę przycisku i aktuwować button na 'true'

		//button =
		Button buttonResult = new Button("=");
		buttonResult.setPrefHeight(50);
		buttonResult.setPrefWidth(60);
		gridPane.add(buttonResult, 3, 6);
		buttonResult.setOnAction(e -> {
			engine.sign(buttonResult.getText(), label.getText());
		});
	}
}