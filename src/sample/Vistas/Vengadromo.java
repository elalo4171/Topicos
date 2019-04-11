package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Componentes.Vengadores;

public class Vengadromo extends Stage {

    private ProgressBar[] pgbCarriles = new ProgressBar[7];
    private VBox vBox;
    private Button btnIniciar;
    private Scene escena;
    private String[] vengadores={"Thor","Capitan America","Hulk","Iron Man","Spider Man","Black Panther","Pantera Rosa :("};
    private Vengadores[] thrVengadores = new Vengadores[7];

    public Vengadromo(){
        CrearGUI();

        this.setScene(escena);
        this.setTitle("Corriendo de Thanos");
        this.show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        for (int i=0; i<vengadores.length; i++){
            pgbCarriles[i] = new ProgressBar(0);
            thrVengadores[i] = new Vengadores(vengadores[i],pgbCarriles[i]);
            vBox.getChildren().add(pgbCarriles[i]);
        }
        btnIniciar = new Button("Iniciar Carrera");
        btnIniciar.setOnAction(event -> IniciarCarrera());
        vBox.getChildren().add(btnIniciar);
        escena = new Scene(vBox,250,300);
    }

    private void IniciarCarrera() {
        for (int i=0; i<vengadores.length; i++){
            thrVengadores[i].start();
        }
    }
}