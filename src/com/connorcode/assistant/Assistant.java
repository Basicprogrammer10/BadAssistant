package com.connorcode.assistant;

import com.connorcode.assistant.app.Action;
import com.connorcode.assistant.app.App;
import com.connorcode.assistant.app.Displayable;
import com.connorcode.assistant.app.Response;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main class for our Virtual Assistant. Include application UI elements
 * and provides functionality to handle command by delegating
 * it to different apps.
 */
public class Assistant extends Application {

    private static Assistant instance;
    private final ObservableList<Displayable> displayItems = FXCollections.observableArrayList();
    private final List<Action> actions = new ArrayList<>();
    private final ListView<Displayable> displayItemsListView = new ListView<>(displayItems);
    private final TextField commandTextField = new TextField();
    private final App[] apps = getAvailableApps();
    private final int SESSION_ID = new Random().nextInt();

    public Assistant() {
        instance = this;
    }

    /**
     * Provide a way to get the instance of the only Assistant
     * object created through the lifecycle of the application
     *
     * @return instance
     */
    public static Assistant getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch();
    }

    private static App[] getAvailableApps() {
        return Config.getCOMMANDS();
    }

    @Override
    public void start(Stage stage) {
        initUILayout(stage);
        initUIListener();
        initAppActions();
    }

    /**
     * Registers available actions from each app
     */
    private void initAppActions() {
        for (App app : apps) {
            actions.addAll(app.getActions());
        }
    }

    private void initUIListener() {

        EventHandler<ActionEvent> doCommand = event -> {
            String command = commandTextField.getText().toLowerCase();
            commandTextField.setText("");
            handleCommand(command);
        };

        commandTextField.setOnAction(doCommand);

        displayItemsListView.setCellFactory(new Callback<>() {

            @Override
            public ListCell<Displayable> call(ListView<Displayable> response) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Displayable response, boolean empty) {
                        super.updateItem(response, empty);
                        super.setText("");
                        super.setGraphic(null);
                        super.setStyle("-fx-font: " + Config.FONT_SIZE + "px '" + Config.FONT + "';");
                        if (response != null) response.update(this);
                    }
                };
            }
        });
    }

    private void initUILayout(Stage stage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setCenter(displayItemsListView);

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setPrefHeight(50);
        hbox.setAlignment(Pos.CENTER);

        HBox.setHgrow(commandTextField, Priority.ALWAYS);
        hbox.getChildren().addAll(new Label("> "), commandTextField);
        root.setBottom(hbox);
        stage.setTitle("Assistant - Connor Slade - V" + Config.VERSION);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    /**
     * Handle an inputted command by
     * finding the most relevant AppAction to run it.
     * If most relevant AppAction does not have enough relevance score,
     * respond by indicating so
     *
     * @param command Command to Parse and Run
     */
    private void handleCommand(String command) {
        if (command.equals("")) return;

        Action bestAction = null;
        double bestActionScore = 0;
        for (Action action : actions) {
            double actionScore = action.getLikelihood(command);
            if (actionScore >= bestActionScore) {
                bestAction = action;
                bestActionScore = actionScore;
            }
        }

        displayItems.add(new EnteredCommand(command));
        if (bestActionScore > 0.5) {
            try {
                bestAction.doCommand(command);
            } catch (Exception e) {
                e.printStackTrace();
                displayItem(new Response("Erm... An error occurred :/"));
            }
            return;
        }

        // If chat-bot is disabled
        if (!Config.CHAT_BOT) {
            displayItem(new Response("I have no Idea that what means..."));
            return;
        }

        try {
            String msg = URLEncoder.encode(command, StandardCharsets.UTF_8.toString());
            JSONObject response = Unirest.get("https://api.monkedev.com/fun/chat?msg=" + msg + "&uid=" + SESSION_ID)
                .header("accept", "application/json")
                .asJson().getBody().getObject();
            displayItem(new Response(response.getString("response")));
        } catch (UnirestException | UnsupportedEncodingException e) {
            displayItem(new Response("I have no Idea that what means..."));
        }
    }

    /**
     * Adds an item to the displayable list
     *
     * @param item Item to add
     */
    public void displayItem(Displayable item) {
        displayItems.add(item);
        displayItemsListView.scrollTo(item);
    }
}


