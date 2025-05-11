package org.fx.examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;

public class ListManagerApp extends Application {

    private final ObservableList<String> items = FXCollections.observableArrayList();
    private final ListView<String> listView = new ListView<>(items);
    private final TextField inputField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab listTab = new Tab("Lista");
        listTab.setClosable(false);
        listTab.setContent(createListTabContent());

        tabPane.getTabs().addAll(listTab);

        Scene scene = new Scene(tabPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX List Manager");
        primaryStage.show();
    }

    private VBox createListTabContent() {
        listView.setPrefHeight(150);

        HBox inputBox = new HBox(10, new Label("Nowy element:"), inputField);
        Button addButton = new Button("Dodaj");
        Button removeButton = new Button("Usuń");
        Button editButton = new Button("Edytuj");

        HBox buttonBox = new HBox(10, addButton, removeButton, editButton);
        VBox layout = new VBox(10, listView, inputBox, buttonBox);
        layout.setPadding(new Insets(10));

        // Logika przycisków
        addButton.setOnAction(e -> {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                items.add(text);
                inputField.clear();
            }
        });

        removeButton.setOnAction(e -> {
            String selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                items.remove(selected);
            }
        });

        editButton.setOnAction(e -> {
            String selected = listView.getSelectionModel().getSelectedItem();
            int index = listView.getSelectionModel().getSelectedIndex();
            String newText = inputField.getText().trim();
            if (selected != null && !newText.isEmpty()) {
                items.set(index, newText);
                inputField.clear();
            }
        });

        return layout;
    }
}

