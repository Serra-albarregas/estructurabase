package com.serra.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * El controlador de la vista secundaria (<code>SecondaryController</code>) gestiona las operaciones matemáticas
 * básicas entre dos números introducidos por el usuario. Se vincula a la vista definida en el archivo FXML correspondiente
 * y gestiona eventos como cambios en los campos de texto o la selección de una operación matemática en el combo box.
 */
public class SecondaryController {

    // Definición de los elementos de la interfaz de usuario (vinculados con FXML)
    @FXML
    private TextField input1; // Primer campo de texto para el primer número

    @FXML
    private ComboBox<String> combo; // ComboBox para seleccionar la operación matemática (+, -, *, /)

    @FXML
    private TextField input2; // Segundo campo de texto para el segundo número

    @FXML
    private Label result; // Etiqueta para mostrar el resultado de la operación

    /**
     * Método que se ejecuta cuando la vista es cargada.
     * Inicializa los componentes y gestiona los eventos de la interfaz de usuario.
     */
    @FXML
    public void initialize() {
        // Actualiza el resultado cuando se presiona "Enter" en cualquiera de los campos de texto (input1 o input2)
        input1.setOnAction(event -> actualizarResultado());
        input2.setOnAction(event -> actualizarResultado());

        // Actualiza el resultado si cambia el texto en input1 o input2
        input1.textProperty().addListener((observable, oldValue, newValue) -> actualizarResultado());
        input2.textProperty().addListener((observable, oldValue, newValue) -> actualizarResultado());

        // Rellena el ComboBox con las operaciones posibles (+, -, *, /)
        combo.getItems().addAll("+", "-", "*", "/");
        combo.setValue("+"); // Valor predeterminado es la suma

        // Actualiza el resultado cuando se selecciona una nueva operación en el ComboBox
        combo.setOnAction(event -> {actualizarResultado();});
    }

    /**
     * Actualiza el resultado según los valores ingresados en los campos de texto y la operación seleccionada.
     * Realiza la operación correspondiente y muestra el resultado en la etiqueta 'result'.
     * Si ocurre un error (por ejemplo, entrada no válida o división por cero), muestra "NaN".
     */
    private void actualizarResultado() {
        try {
            // Obtiene los valores de los campos de texto y los convierte a enteros
            int valor1 = Integer.parseInt(input1.getText());
            int valor2 = Integer.parseInt(input2.getText());

            // Realiza la operación seleccionada en el ComboBox
            switch (combo.getValue()) {
                case "+":
                    result.setText(Integer.toString(valor1 + valor2)); // Suma
                    break;
                case "-":
                    result.setText(Integer.toString(valor1 - valor2)); // Resta
                    break;
                case "*":
                    result.setText(Integer.toString(valor1 * valor2)); // Multiplicación
                    break;
                case "/":
                    result.setText(Integer.toString(valor1 / valor2)); // División
                    break;
            }
            
        } catch (NumberFormatException e) {
            // Si los valores no son números válidos, muestra "NaN"
            result.setText("NaN");
        } catch (ArithmeticException e) {
            // Si ocurre un error aritmético (por ejemplo, división por cero), muestra "NaN"
            result.setText("NaN");
        }
    }
}
