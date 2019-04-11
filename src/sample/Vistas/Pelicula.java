package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Modelos.PeliculaDAO;


public class Pelicula extends Stage {

    private TableView<PeliculaDAO> tbvPeliculas;

    private Scene escena;
    private VBox vBox;
    private Label lblTitulo;
    private TextField txtNombPeli, txtDuraPeli, txtSinopsisPeli, txtClasePeli, txtCatPeli;
    private Button btnGuardar;

    public Pelicula(TableView tbvPeliculas){
        this.tbvPeliculas = tbvPeliculas;
        CrearUI();
        this.setScene(escena);
        this.setTitle("Altas y modificaciones de peliculas");
        this.show();
    }

    private void CrearUI() {

        vBox = new VBox();
        lblTitulo = new Label("Pelicula");
        txtNombPeli = new TextField();
        txtNombPeli.setPromptText("Nombre");
        txtDuraPeli = new TextField();
        txtDuraPeli.setPromptText("Duracion");
        txtSinopsisPeli = new TextField();
        txtSinopsisPeli.setPromptText("Sinopsis");
        txtClasePeli = new TextField();
        txtClasePeli.setPromptText("Clase");
        txtCatPeli = new TextField();
        txtCatPeli.setPromptText("Categoria");
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarPelicula());
        vBox.getChildren().addAll(lblTitulo, txtNombPeli,txtDuraPeli,txtSinopsisPeli,txtClasePeli,txtCatPeli,btnGuardar);
        escena = new Scene(vBox,250,300);
    }

    private void GuardarPelicula() {

        String nomb = txtNombPeli.getText();
        String dura = txtDuraPeli.getText();
        String sino = txtSinopsisPeli.getText();
        String clas = txtClasePeli.getText();
        String cate = txtCatPeli.getText();

        PeliculaDAO objPDAO = new PeliculaDAO();
        objPDAO.setNomPelicula(nomb);
        objPDAO.setDuracion(Integer.parseInt(dura));
        objPDAO.setDescPelicula(sino);
        objPDAO.setClase(clas);
        objPDAO.setIdCategoria(Integer.parseInt(cate));
        objPDAO.INSERTAR();

        tbvPeliculas.setItems(objPDAO.SELECCIONAR());
        tbvPeliculas.refresh();
        this.close();

    }

}