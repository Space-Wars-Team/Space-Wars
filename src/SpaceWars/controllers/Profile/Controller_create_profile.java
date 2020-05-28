package SpaceWars.controllers.Profile;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller_create_profile<datArrayList> implements Initializable {
    @FXML
    public TextField text_field;

    @FXML
    private Button submit_button;

    File file = new File("src/images/File.txt");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                add_file();

                System.out.println("username created");
                try {
                    profile_created();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void profile_created() throws IOException {
        submit_button.getScene().getWindow().hide();
        Stage profile_menu = new Stage();
        Parent profile_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/profile_menu.fxml"));
        Scene profile_scene = new Scene(profile_root);
        profile_menu.setScene(profile_scene);
        profile_menu.show();
    }


    private void add_file() {
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text_field.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
