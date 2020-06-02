package SpaceWars.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_subscription implements Initializable {

    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button.getScene().getWindow().hide();
                Stage main = new Stage();
                Parent main_root = null;
                try {
                    main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/main_menu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene main_scene = new Scene(main_root);
                main.setScene(main_scene);
                main.show();
            }
        });
    }
}
