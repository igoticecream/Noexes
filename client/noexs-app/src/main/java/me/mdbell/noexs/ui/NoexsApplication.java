package me.mdbell.noexs.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.mdbell.noexs.ui.controllers.MainController;

public class NoexsApplication extends Application {

    public static final int VERSION_MAJOR = 1;
    public static final int VERSION_MINOR = 1;
    public static final int VERSION_PATCH = 2;

    public static final String APP_NAME = "JNoexs";
    public static final String APP_VERSION = VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Main.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
        scene.getStylesheets().add(getClass().getResource("/fonts/droid-sans-mono.css").toExternalForm());

        stage.setResizable(false);
        stage.setScene(scene);
        MainController c = loader.getController();
        c.setStage(stage);
        c.setTitle(null);
        stage.setOnHidden(v ->{
            c.stop();
            Platform.exit();
        });
        stage.show();
    }
}
