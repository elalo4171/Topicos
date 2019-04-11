package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Eventos.EventosCalculadora;

public class Calculadora extends Stage implements EventHandler {

    TextField txtOperacion;
    private VBox vBox;
    HBox[] arHBox;
    Button[] arBtns;
    private String[] valores = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
    private Scene escena;

    public Calculadora(){

        CrearGUI();

        escena = new Scene(vBox,200,200);
        setScene(escena);
        setTitle("Calculadorcita");
        addEventHandler(WindowEvent.WINDOW_SHOWN,this);
        show();

    }

    private void CrearGUI() {
        vBox = new VBox();
        txtOperacion = new TextField();
        txtOperacion.setEditable(false);
        vBox.getChildren().add(txtOperacion);

        arHBox = new HBox[4];
        arBtns = new Button[16];

        //EventosCalculadora objEC = new EventosCalculadora();
        int posBtn = 0;
        for (int i=0; i<arHBox.length; i++ ){
            arHBox[i] = new HBox();
            arHBox[i].setSpacing(10);
            arHBox[i].setPadding(new Insets(5));
            for (int j=0; j<4; j++){
                arBtns[posBtn] = new Button(valores[posBtn]);
                //arBtns[posBtn].addEventHandler(MouseEvent.MOUSE_CLICKED,this);
                arBtns[posBtn].addEventHandler(MouseEvent.MOUSE_CLICKED,new EventosCalculadora(valores[posBtn],txtOperacion));
                /*arBtns[posBtn].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.println("Hola desde el interior de tu corazon :)");
                    }
                });*/
                arBtns[posBtn].setPrefSize(50,50);
                arBtns[posBtn].setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
                arHBox[i].getChildren().add(arBtns[posBtn]);
                posBtn++;
            }
            //vBox.getChildren().add(arHBox[i]);
        }

        vBox.getChildren().addAll(arHBox[0],arHBox[1],arHBox[2],arHBox[3]);

    }

    @Override
    public void handle(Event event) {

    }
}
