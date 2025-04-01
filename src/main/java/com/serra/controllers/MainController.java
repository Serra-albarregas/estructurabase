package com.serra.controllers;

import com.serra.App;
import com.serra.SceneID;
import com.serra.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * El controlador de la vista principal (<code>MainController</code>) se encarga de manejar
 * la interacción del usuario en la interfaz principal. Este controlador se vincula a la vista
 * definida en el archivo FXML correspondiente y gestiona eventos y acciones dentro de la interfaz.
 */
public class MainController {
    
    // Definición de los elementos de la interfaz de usuario (vinculados con FXML)
    @FXML
    private VBox vBox; // Contenedor principal de la interfaz, se ajusta dinámicamente

    @FXML
    private StackPane stackPane; // Contenedor secundario, utilizado para organizar el contenido

    @FXML
    private Label console; // Etiqueta que muestra información sobre el tamaño de la ventana

    @FXML
    private Button pressButton; // Botón que al ser presionado cambia de escena

    @FXML
    private ImageView imageView; // Vista de imagen para mostrar una imagen en la interfaz

    /**
     * Método que se ejecuta cuando la vista es cargada.
     * Inicializa los componentes y gestiona los eventos de la interfaz de usuario.
     */
    @FXML
    public void initialize() {
        // Establece la imagen en el componente imageView
        imageView.setImage(new Image(App.class.getResource("images/math.png").toExternalForm()));

        // Configura el evento de acción para el botón pressButton
        pressButton.setOnAction(event -> {
            // Carga la escena secundaria cuando el botón es presionado
            SceneManager.getInstance().loadScene(SceneID.SECONDARY);
        });

        // Ajusta la imagen cuando cambia el tamaño de la ventana (VBox)
        vBox.heightProperty().addListener((observable, oldValue, newValue) -> ajustarImagen());
        vBox.widthProperty().addListener((observable, oldValue, newValue) -> ajustarImagen());
    }

    /**
     * Ajusta el tamaño de la imagen dentro de imageView según el tamaño de la ventana.
     * La imagen se redimensiona cuando cambia la altura de la ventana.
     * También actualiza el texto en el label 'console' con las dimensiones actuales de la ventana.
     */
    private void ajustarImagen() {
        // Obtiene la altura del VBox (contenedor principal)
        double height = vBox.getHeight();

        // Muestra el tamaño de la ventana en el console (etiqueta)
        console.setText("Tamaño de ventana: " + vBox.getWidth() + "-" + vBox.getHeight());

        // Si la altura es mayor que 0, ajusta la altura de la imagen
        if (height > 0) {
            imageView.setFitHeight(height - 40); // Ajusta la altura de la imagen
        }
    }
}
