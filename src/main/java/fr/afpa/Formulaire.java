package fr.afpa; // Déclaration du package

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;

// Définition de la classe Formulaire qui hérite de Application
public class Formulaire extends Application {

    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        launch(args);

    }

    /**
     * JavaFX Formulaire
     */
    // Annotation de la méthode start, point d'entrée de l'application JavaFX
    @Override
    public void start(Stage stage) throws Exception {

        // Définition des composants de l'interface utilisateur
        // Création des composants
        stage.setTitle("Formulaire");

        Label inputUserLabel = new Label("User input:");
        Label inputCopyLabel = new Label("Copy of entry:");
        Label messageLabel = new Label("DELETE !!!");
        messageLabel.setVisible(false); // Initialement invisible

        TextField inputUserField = new TextField(); // Instanciation d'un texte avec la Class TextField.
        inputUserField.setPromptText("User Input");
        TextField copyField = new TextField();
        copyField.setPromptText("Waiting for Copy");

        Button copyButton = new Button("Rewrite"); // Instanciation d'un nouveau boutton avec la Class Button.
        Button clearButton = new Button("Delete");
        Button quitButton = new Button("Quit");
        TextField textInput = new TextField();
        TextField textLocked = new TextField();
        copyButton.setStyle("-fx-background-color: #A9A9A9;");
        clearButton.setStyle("-fx-background-color: #A9A9A9;");
        quitButton.setStyle("-fx-background-color: #A9A9A9;");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Ajouter des composants au GridPane avec alignement
        gridPane.add(inputUserLabel, 0, 0);
        GridPane.setHalignment(inputUserLabel, HPos.LEFT);

        gridPane.add(inputUserField, 1, 0);
        GridPane.setHalignment(inputUserField, HPos.CENTER);

        gridPane.add(inputCopyLabel, 0, 1);
        GridPane.setHalignment(inputCopyLabel, HPos.LEFT);

        gridPane.add(copyField, 1, 1);
        GridPane.setHalignment(copyField, HPos.CENTER);

        gridPane.add(copyButton, 2, 0);
        GridPane.setHalignment(copyButton, HPos.RIGHT);

        gridPane.add(clearButton, 2, 1);
        GridPane.setHalignment(clearButton, HPos.RIGHT);

        gridPane.add(quitButton, 1, 2);
        GridPane.setHalignment(quitButton, HPos.CENTER);
        // gridPane.add(inputUserLabel, 0, 0, 1, 1);
        // gridPane.add(inputCopyLabel, 0, 1, 1, 1);
        // gridPane.add(inputUserField, 1, 0, 1, 1);
        // gridPane.add(copyField, 1, 1, 1, 1);
        // gridPane.add(copyButton, 2, 0,1, 1);
        // gridPane.add(clearButton,2, 1, 1, 1);
        // gridPane.add(quitButton, 2, 2, 1, 1);
        // // Examples avec une Vbox
        // // VBox vbox = new VBox();
        // // vbox.getChildren().addAll(copyButton, clearButton, quitButton);
        // // gridPane.add(vbox, 2, 0, 1, 2);
        // // gridPane.add(VBox, 2, 0, 1, 2);
        // gridPane.setHgap(10);
        // gridPane.setVgap(10);

        copyButton.setOnAction(event -> {
            String userInput = inputUserField.getText();
            copyField.setText(userInput);
        });
        // Gestionnaire d'évènements pour le bouton "Effacer"
        clearButton.setOnAction(event -> {
            copyField.clear();
        });
        quitButton.setOnAction(event -> {
            confirmQuit();
            // Platform.exit();
            // Fermeture de l'application
            // stage.close();
            // stage.setScene(scene);
            // stage.show();
            // Ajout de l'action au bouton "Quitter"
        });
        // ------------- GESTION DES EVENEMENTS ----------
        // ajouter un GESTIONNAIRE D'EVENEMENT à un composant graphiques
        // Gestionnaire d'évènement = classe "EventHandler"

        // Version 1 : classe interne anonyme
        // quitButton.setOnAction(new EventHandler<ActionEvent>() {

        // @Override
        // public void handle(ActionEvent event) {
        // Platform.exit();
        // }

        // });

        // Version 2 : classe nommée indépendante
        // -> il faut créer un nouveau fichier
        // quitButton.setOnAction((EventHandler<Action());/
        //

        // Version 3 : fonction lambda (aussi appellée "fonction flêchée")
        // - avec paramètre typé
        // quitButton.setOnAction((ActionEvent event) -> {
        // Platform.exit();
        // });

        // - avec paramètre non typé
        // quitButton.setOnAction(event -> {
        // Platform.exit();
        // });

        // - solution avec référence de méthode
        // quitButton.setOnAction(Formulaire::quit);

        // clearButton.setOnAction(new EventHandler<ActionEvent>() {

        // @Override
        // public void handle(ActionEvent event) {
        // messageLabel.setVisible(true);
        // }

        // });

        // copyButton.setOnAction(new EventHandler<ActionEvent>() {

        // @Override
        // public void handle(ActionEvent event) {
        // messageLabel.setVisible(false);
        // }

        // });

        // ------------- FIN GESTION DES EVENEMENTS ----------
        Scene scene = new Scene(gridPane, 400, 300);
        stage.setScene(scene);
        stage.show();
        gridPane.requestFocus();
    } // fin de la méthode "start"

    private void confirmQuit() {
        // Confirmation pop-up
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit?",
                ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Platform.exit();
        }
    }

} // fin de la classe "Formulaire"
