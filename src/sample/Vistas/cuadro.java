package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class cuadro extends Stage implements EventHandler {
    static RandomAccessFile archivo;
    static RandomAccessFile archivofinal;
    TextField txtOperacion;
    private VBox vBox, vBox2;
    HBox[] arHBox;
    Button[] arBtns;
    Button btn1, btn2;
    int contador=0;
    private String[] valores;

    private Scene escena;

    public cuadro(){

        try{

            CrearGUI2();
        }catch (Exception e)
        {

        }

        escena = new Scene(vBox,800,800);
        setScene(escena);
        setTitle("Cuadro Magico");
        addEventHandler(WindowEvent.WINDOW_SHOWN,this);
        show();


    }
    private void CrearGUI2() throws IOException {

        vBox = new VBox();
        btn1= new Button("Aceptar");
        btn2= new Button("Borrar");
        txtOperacion = new TextField("Ingresa un numero impar");

        vBox.getChildren().add(txtOperacion);
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().add(btn1);
        vBox.getChildren().add(btn2);
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
        btn2.addEventHandler(MouseEvent.MOUSE_CLICKED, handler2);


    }

    private void CrearGUI(int n) throws IOException {
        arHBox = new HBox[n];
        arBtns = new Button[n*n];
        int posx;
        int posy=1;
        posx=(n/2)+1;
        String valorfinal;
        int bposx=1;
        int bposy=1;
        String valor;
        archivo = new RandomAccessFile("numero","rw");
        archivofinal = new RandomAccessFile("numerosfinal", "rw");
        for(int i=0;i<(n*n);i++){
            valor=String.valueOf(posx);
            valor=valor+String.valueOf(posy);
            if(repetidos(valor)){
                posx--;
                posy++;
                posy++;

                if(posx>n)
                    posx=1;
                if(posy<1)
                    posy=n;
                if(posy>n && posx<1)
                {
                    posx=n;
                    posy-=n;

                }
                valor=String.valueOf(posx);
                valor=valor+String.valueOf(posy);
            }
            posx++;
            posy--;
            if(posx>n)
                posx=1;
            if(posy<1)
                posy=n;
            archivo.seek(archivo.length());
            archivo.writeUTF(valor);
            archivo.writeInt(i+1);


        }


        for(int i=0;i<n;i++){
            for (int k=0;k<n;k++)
            {
                valorfinal=String.valueOf(k+1);
                valorfinal=valorfinal+String.valueOf(i+1);

                archivofinal.seek(archivofinal.length());
                int v=buscar(valorfinal);

                archivofinal.writeInt(v);
            }
        }
        //EventosCalculadora objEC = new EventosCalculadora();
        int posBtn = 0;
        archivofinal.seek(0);
        for (int i=0; i<arHBox.length; i++ ){
            arHBox[i] = new HBox();
            arHBox[i].setSpacing(10);
            arHBox[i].setPadding(new Insets(5));
            for (int j=0; j<n; j++){
                arBtns[posBtn] = new Button(String.valueOf(archivofinal.readInt()));

                arBtns[posBtn].setPrefSize(55,55);
                arBtns[posBtn].setStyle("-fx-font: 18 arial; -fx-base: white;");
                arHBox[i].getChildren().add(arBtns[posBtn]);
                posBtn++;
            }
            //vBox.getChildren().add(arHBox[i]);
        }
        for(int i=0;i<arHBox.length;i++)
        {
            vBox2.getChildren().addAll(arHBox[i]);
        }
        imprimri();
        imprimrifinal();
        archivo.setLength(0);
        archivo.close();
        archivofinal.setLength(0);
        archivofinal.close();
    }

    @Override
    public void handle(Event event) {

    }

    EventHandler<MouseEvent> handler1 = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(contador==0){
                vBox2 = new VBox();

                contador++;
                try {
                    if(Integer.parseInt(txtOperacion.getText())%2!=0)

                    {
                        CrearGUI( Integer.parseInt(txtOperacion.getText()));
                        vBox.getChildren().add(vBox2);
                        vBox2.setAlignment(Pos.CENTER);
                        vBox.setAlignment(Pos.CENTER);
                    }
                    else
                        txtOperacion.setText("Ingresa un numero valido");




                }
                catch (Exception e){
                txtOperacion.setText("Ingresa un numero correcto");
                }
            }
            else {
                vBox2.getChildren().clear();
                contador--;
            }


        }
    };
    EventHandler<MouseEvent> handler2 = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

            vBox2.getChildren().clear();
            contador--;

        }
    };



    static public boolean repetidos(String n) throws IOException{

        archivo.seek(0);
        while(archivo.getFilePointer() < archivo.length()){

            if(archivo.readUTF().equals(n))
                return true;
            archivo.readInt();

        }

        return false;
    }

    static public void imprimri() throws IOException{
        archivo.seek(0);
        while(archivo.getFilePointer() < archivo.length()){
            System.out.println(archivo.readUTF());
            System.out.println(archivo.readInt());

        }
    }
    static public void imprimrifinal() throws IOException{
        archivofinal.seek(0);
        while(archivofinal.getFilePointer() < archivofinal.length()){

            System.out.println(archivofinal.readInt());

        }
    }
    static public int buscar(String busqueda) throws IOException{
        archivo.seek(0);
        while(archivo.getFilePointer() < archivo.length()){

            if(archivo.readUTF().equals(busqueda))

                return archivo.readInt();
            archivo.readInt();
        }

        return 6;

    }
}
