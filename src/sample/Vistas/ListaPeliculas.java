package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Componentes.ButtonCell;
import sample.Modelos.PeliculaDAO;

public class ListaPeliculas  extends Stage{

    private Scene escena;
    private VBox vBox;
    private TableView<PeliculaDAO> tbvPeliculas;
    private Button btnAgregar;

    public ListaPeliculas(){
        CrearGUI();
        setTitle("CRUD Peliculas");
        setScene(escena);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        tbvPeliculas = new TableView<>();
        CrearTabla();
        btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(event -> AgregarPelicula());
        vBox.getChildren().addAll(tbvPeliculas,btnAgregar);

        escena = new Scene(vBox,700,200);
    }

    private void AgregarPelicula() {
        new Pelicula(tbvPeliculas);
    }
    private void CrearTabla(){

        TableColumn<PeliculaDAO,Integer> tbcIdPelicula= new TableColumn<>("ID");
        tbcIdPelicula.setCellValueFactory(new PropertyValueFactory<>("idPelicula"));

        TableColumn<PeliculaDAO,String> tbcnomPelicula= new TableColumn<>("Nombre Pelicula");
        tbcnomPelicula.setCellValueFactory(new PropertyValueFactory<>("nomPelicula"));

        TableColumn<PeliculaDAO,Integer> tbcDuracion= new TableColumn<>("Duracion");
        tbcDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        TableColumn<PeliculaDAO,String> tbcdescripcion= new TableColumn<>("Descripcion");
        tbcdescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        TableColumn<PeliculaDAO,String> tbcClase= new TableColumn<>("Clase");
        tbcClase.setCellValueFactory(new PropertyValueFactory<>("clase"));

        TableColumn<PeliculaDAO,Integer> tbcidCategoria= new TableColumn<>("Categoria");
        tbcidCategoria.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));

        TableColumn<PeliculaDAO,String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<PeliculaDAO, String>, TableCell<PeliculaDAO, String>>() {
            @Override
            public TableCell<PeliculaDAO, String> call(TableColumn<PeliculaDAO, String> param) {
                return new ButtonCell(1);
            }
        });


        TableColumn<PeliculaDAO,String> tbcEliminar = new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<PeliculaDAO, String>, TableCell<PeliculaDAO, String>>() {
            @Override
            public TableCell<PeliculaDAO, String> call(TableColumn<PeliculaDAO, String> param) {
                return new ButtonCell(2);
            }
        });

        tbvPeliculas.getColumns().addAll(tbcIdPelicula,tbcnomPelicula,tbcDuracion,tbcdescripcion,tbcClase,tbcidCategoria,tbcEditar,tbcEliminar);
        tbvPeliculas.setItems(new PeliculaDAO().SELECCIONAR());
    }

}
