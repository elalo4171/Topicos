package sample.Componentes;


import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.Modelos.PeliculaDAO;

public class ButtonCell extends TableCell<PeliculaDAO,String>
{
    private Button celdaBoton;
    private int opc;
    PeliculaDAO objP;

    public ButtonCell(int opc){

        this.opc = opc;

        if( this.opc == 1 ) {
            celdaBoton = new Button("Editar");
            celdaBoton.setOnAction(event -> Editar());
        }
        else {
            celdaBoton = new Button("Eliminar");
            celdaBoton.setOnAction(event -> Eliminar());

        }
    }

    private void Editar(){

        // Aqui va el codigo para mostrar el formulario de edicion

    }

    private void Eliminar(){
        objP = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
        objP.ELIMINAR();
        ButtonCell.this.getTableView().setItems(objP.SELECCIONAR());
        ButtonCell.this.getTableView().refresh();
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty )
            setGraphic(celdaBoton);
    }
}
