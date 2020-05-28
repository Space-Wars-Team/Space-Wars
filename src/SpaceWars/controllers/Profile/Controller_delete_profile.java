package SpaceWars.controllers.Profile;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_delete_profile implements Initializable {
    @FXML
    private Button button;

    @FXML
    private Label label_msg;

    @FXML
    private Button main_button;

    File file = new File("src/images/File.txt");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                delete_file();
                label_msg.setText("Username deleted!");
            }
        });
        main_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    main_menu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void main_menu() throws IOException {
        main_button.getScene().getWindow().hide();
        Stage main = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/main_menu.fxml"));
        Scene main_scene = new Scene(main_root);
        main.setScene(main_scene);
        main.show();
    }
    private void delete_file() {
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

