package sample.Vistas;

import javafx.beans.binding.Bindings;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Restaurante extends Stage{

    private Scene scene;
    private Button btnPrueba;
    private VBox vbox, vBox2,vBox3;
    private ToolBar toolBMenu;
    private TextArea txtATexto, txtAEscritura;
    private TabPane tabPane;
    private Tab tab, tab2;
    private HBox hbox, hbox2;

    public Restaurante() {
        crearGUI();
        scene = new Scene(vbox,500,500 );
        scene.getStylesheets().add(getClass().getResource("../CSS/interfazRes.css").toExternalForm());
        setTitle("Interfaz");
        setScene(scene);
        show();
    }



    private void crearGUI () {
        iniciarComponentes();
        anadirComponentes();
    }

    private void iniciarComponentes () {
        vbox = new VBox();
        tabPane = new TabPane();
        tabPane.setId("tappanel");

        tab = new Tab();
        tab.setClosable(false);
        tab.setText("Almuerzo");
        hbox = new HBox();
        vBox2= new VBox();
        vBox3= new VBox();

        hbox.getChildren().addAll(vBox2, vBox3);
        vBox2.getChildren().addAll(new Label("Tab 2" ),new Label("Tab 25" ),new Label("Tab 26" ));
        vBox3.getChildren().addAll(new Label("Tab 3" ),new Label("Tab 35" ),new Label("Tab 36" ));
        vBox2.setPadding(new Insets(100, 100, 100, 100));
        vBox2.setSpacing(10);
        vBox3.setPadding(new Insets(100, 100, 100, 100));
        vBox3.setSpacing(10);
        vBox3.setId("platillo2");

        tab.setContent(hbox);
        tabPane.getTabs().add(tab);
        tab2 = new Tab();
        tab2.setClosable(false);
        hbox2= new HBox();
        hbox2.getChildren().add(new Label("Tab 2" ));
        tab2.setText("Pizza");
        tab2.setContent(hbox2);
        tabPane.getTabs().add(tab2);

    }
    private void anadirComponentes () {
        vbox.getChildren().addAll(tabPane);

    }
}






