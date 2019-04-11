package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Modelos.Conexion;
import sample.Vistas.*;

public class Main extends Application implements EventHandler{

    private Scene escena;
    private MenuBar menuBar;
    private Menu menCompetencia1, menCompetencia2, menSalir,menCuadro;
    private MenuItem itmCalculadora,itmSalir, itmTaqui, itmDatos,itmCuadro,itmRestaurante,itmVengadromo;
    private BorderPane panel;

    @Override
    public void start(Stage primaryStage) throws Exception{

        panel = new BorderPane();
        CreateMenu();

        TitledPane objTP = new TitledPane();
        objTP.getStyleClass().add("danger");
        escena = new Scene(panel);
        escena.getStylesheets().add(getClass().getResource("CSS/Bootstrap3.css").toExternalForm());
        primaryStage.setTitle("Prácticas Tópicos Avanzado de Programación :)");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWN,this);
        primaryStage.show();
    }

    public void CreateMenu(){

        menuBar = new MenuBar();

        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia1.setId("menu1");
        menCompetencia2 = new Menu("Competencia 2");
        menCompetencia2.setId("menu2");
        menSalir        = new Menu("Salir");
        menSalir.setId("menu3");
        menCuadro= new Menu("Cuadro Magico");
        menCuadro.setId("menu4");

        itmCalculadora = new MenuItem("Calculadora");
        itmTaqui = new MenuItem("Taquimecanógrafo");
        itmCalculadora.setOnAction(event->EventoItem(1));
        itmTaqui.setOnAction(event -> EventoItem(3));
        itmDatos = new MenuItem("Acceso a Datos (BD)");
        itmDatos.setOnAction(event -> EventoItem(4));
        itmCuadro= new MenuItem("Cuadro Magico");
        itmCuadro.setOnAction(event -> EventoItem(5));
        itmRestaurante= new MenuItem("Interfaz Restaurante");
        itmRestaurante.setOnAction(event -> EventoItem(6));
        itmVengadromo = new MenuItem("Vengadromo");
        itmVengadromo.setOnAction(event -> EventoItem(7));


        menCompetencia1.getItems().addAll(itmCalculadora,itmTaqui,itmDatos,itmCuadro,itmRestaurante,itmVengadromo);

        itmSalir = new MenuItem("Bye");
        itmSalir.setOnAction(event -> EventoItem(2));
        itmSalir.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
        menSalir.getItems().add(itmSalir);


        menuBar.getMenus().addAll(menCompetencia1,menCompetencia2,menSalir);
        panel.setTop(menuBar);
    }

    private void EventoItem(int opc) {
        switch (opc){
            case 1: new Calculadora(); break;
            case 2: // Evento para salir o terminar el stage principal
                    System.exit(0);
                    break;
            case 3: new Taquimecanografo();
                    break;
            case 4: new ListaPeliculas();
                    break;
            case 5: new cuadro();
                    break;
            case 6: new Restaurante();
            break;
            case 7: new Vengadromo();
            break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        Conexion.getConexion();
        if( Conexion.con != null ){
            System.out.println("Conexion Exitosa!!");
        }
    }
}
