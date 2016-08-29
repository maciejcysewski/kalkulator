package pl.jcode.kalkulator;

import pl.jcode.kalkulator.App;

public class Engine {

	private String oldSign = null;
	private String sign;
	private String warning = null;
	private String memPlus = null;
	private String memMinus = null;

	private double nr1, nr2, score, number;

	private boolean afterSign = false;
	private boolean comma = false;

	/*
	 * Aktualizacja wyświetlanej wartości
	 */
	public void labelUpdate(String value) {
		if (afterSign) {
			afterSign = false;
			if ((value.equals("."))) {
				App.label.setText("0.");
			} else {
				App.label.setText(value);
			}
		} else {
			if ((App.label.getText().equals("0")) && (value.equals("0"))) {
				App.label.setText("0");
			} else if ((App.label.getText().equals("0")) && (value.equals("."))) {
				App.label.setText("0.");
			} else if ((App.label.getText().equals("0"))) {
				App.label.setText(value);
			} else {
				App.label.setText(App.label.getText()+value);
			}
		}
	}

	/*
	 * Aktualizacja wyświetlanej wartości
	 */
	public void labelUpdate(double score) {
		App.label.setText(String.valueOf(score));
		nr1 = score;
		oldSign = sign;
	}

	/*
	 * Obsługa wciśniętego znaku operacji matematycznej
	 */
	public void sign(String sign, String label) {
		if (sign != "=") {
			this.sign = sign;
		}
		if (afterSign == false) {
			afterSign = true; 
			if (oldSign != null) {
				nr2 = Double.parseDouble(label);
				comma = false;
				operation();
			} else {
				nr1 = Double.parseDouble(label);
				comma = false;
				if (sign != "=") {
					oldSign = sign;
				}
			}
		} else { 
			if (sign != "=") {
				oldSign = sign;
			}
		}
	}

	/*
	 * Obliczenia
	 */
	public void operation() {
		switch (oldSign) {
		case "+":
			score = nr1 + nr2;
			labelUpdate(score);
			break;
		case "-":
			score = nr1 - nr2;
			labelUpdate(score);
			break;
		case "*":
			score = nr1 * nr2;
			labelUpdate(score);
			break;
		case "/":
			if (nr2 == 0) {
				warning = "Nie można dzielić przez zero";
				App.label.setText(warning);
				reset();
			} else {
				score = nr1 / nr2;
				labelUpdate(score);
			}
			break;
		default:
			break;
		}
	}

	/*
	 * Przecinek
	 */
	public void comma(String value) {
		if (comma == false) {
			comma = true;
			labelUpdate(".");
		}
	}

	/*
	 * Reset
	 */
	public void reset() {
		sign = null;
		oldSign = null;
		comma = false;
		afterSign = false;
		if (warning == null) {
			App.label.setText("0");
		}
		warning = null;
	}

	/*
	 * Zmiana wartości na liczbę dodatnią lub ujemną
	 */
	public void plusMinus() {
		number = Double.parseDouble(App.label.getText());
		if (number > 0) {
			App.label.setText("-" + String.valueOf(number));
		} else if (number < 0) {
			App.label.setText(App.label.getText().replace("-", ""));
		}
	}

	/*
	 * Procent
	 */
	public void percent(double nr2) {
		if (oldSign != null) {
			nr2 = (nr1/100)*nr2;
			this.nr2 = nr2;
			App.label.setText(String.valueOf(nr2));
		}
	}

	/*
	 * Reset pamięci
	 */
	public void memoryMC() {
		memPlus = null;
		memMinus = null;
	}

	/*
	 * Wyświetlenie zapamiętanej liczby
	 */
	public void memoryMR() {
		if (memPlus != null && memMinus == null) {
			App.label.setText(memPlus);
		} else if (memPlus == null && memMinus != null) {
			App.label.setText(memMinus);
		} else if (memPlus != null && memMinus != null) {
			double memory = Double.parseDouble(memPlus) + Double.parseDouble(memMinus);
			App.label.setText(String.valueOf(memory));
		}
		afterSign = false;
	}

	/*
	 * Dodanit do pamięci liczby dodatniej
	 */
	public void memoryPlus(String memory) {
		if (Double.parseDouble(memory) >= 0) {
			memPlus = memory;
		} else {
			memPlus = memory.replace("-", "");
		}
		afterSign = true;
	}

	/*
	 * Dodanit do pamięci liczby ujemnej
	 */
	public void memoryMinus(String memory) {
		if (Double.parseDouble(memory) > 0) {
			memMinus = "-" + memory;
		} else if (Double.parseDouble(memory) < 0) {
			memMinus = memory;
		} else {
			memMinus = "0";
		}
		afterSign = true;
	}
}