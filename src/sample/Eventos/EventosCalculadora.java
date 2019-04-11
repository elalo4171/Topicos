package sample.Eventos;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class EventosCalculadora implements EventHandler {
    String valor;
    TextField txtOperacion;


    public static double valor1, valor2, valor3=0;
    static String opracion;
    static boolean b,b1, b3=false, b4= false;
    static boolean Bandera_texto =false;

    public EventosCalculadora(String valor, TextField txtOp) {
        this.valor = valor;
        txtOperacion = txtOp;


    }

    @Override
    public void handle(Event event) {



        if(Bandera_texto ) {
            txtOperacion.clear();
            Bandera_texto =false;
        }


        switch (valor) {

            case ".":

                String pr=txtOperacion.getCharacters().toString();
                char _toCompare='.';
                int veces=0;
                char []caracteres=pr.toCharArray();
                for(int i=0;i<=caracteres.length-1;i++){
                    if(_toCompare ==caracteres[i]){
                        veces+=2;
                    }}
                if(veces>1){

                }
                else
                    txtOperacion.appendText(valor);
                break;




            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (valor3==0){
                    txtOperacion.clear();
                    valor1=0;
                    valor3=6;
                }
                b=true;
                txtOperacion.appendText(valor);


                break;

            case "+":
                opracion= "+";
                sumarValores();
                break;
            case "-":
                opracion= "-";
                resvalores();
                break;
            case "*":
                opracion= "*";
                mulValores();
                break;
            case "/":
                opracion= "/";
                divValores();
                break;
            case "=":
                switch ((int) valor3){
                    case 1:

                        sumarValores();
                        txtOperacion.setText(String.valueOf(valor1));
                        valor1=0;
                        valor3=0;

                        break;
                    case 2:
                        resvalores();
                        txtOperacion.setText(String.valueOf(valor1));
                        valor1=0;
                        valor3=0;

                        break;
                    case 3:
                        mulValores();
                        txtOperacion.setText(String.valueOf(valor1));
                        valor1=0;
                        valor3=0;
                        break;
                    default:

                        if(txtOperacion.getCharacters().toString().equals(".")){
                            valor1=0;
                            txtOperacion.setText("Nah otra vez?");
                            Bandera_texto=true;

                        }
                        else
                        {
                            txtOperacion.clear();
                        }


                        break;
                    case 4:
                        divValores();
                        if(b4){
                            txtOperacion.setText("Entre 0 really??(otro numero)");
                            Bandera_texto=true;
                            b4=false;
                        }
                        else{
                            txtOperacion.setText(String.valueOf(valor1));
                            valor1 = 0;
                            valor3 = 0;
                        }



                        break;
                }

                break;

            // obvalores();

        }



    }


    public void sumarValores(){
        valor3=1;

        if(b ){
            System.out.println(valor1);

            if(valor1!=0 && valor2!=0)
            {
                valor1+=valor2;
                valor2=0;
            }
            else{


                if(valor1!=0)
                {
                    if(txtOperacion.getText().equals(""))
                    {
                        txtOperacion.setText("Ingresa un numero");
                        Bandera_texto=true;
                    }
                    else
                    if(txtOperacion.getText().equals("") || txtOperacion.getText().equals("."))
                    {
                        valor2=0;
                    }
                    else {
                        valor2 = Double.valueOf(txtOperacion.getCharacters().toString());
                        sumarValores();
                        txtOperacion.clear();
                    }


                }
                else {

                    if(txtOperacion.getText().equals("") || txtOperacion.getText().equals("."))
                    {
                        valor1 = 0;
                        txtOperacion.setText("Reinicio");
                        Bandera_texto=true;
                    }
                    else{
                        valor1=Double.valueOf(txtOperacion.getCharacters().toString());
                        txtOperacion.clear();
                    }
                }

            }


        }
        else
        {
            txtOperacion.setText("Ingrese un numero :)");
            Bandera_texto =true;
        }


    }


    public void resvalores(){
        valor3=2;

        if(b ){
            System.out.println(valor1);

            if(valor1!=0 && valor2!=0)
            {
                valor1-=valor2;
                valor2=0;
            }
            else{


                if(valor1!=0)
                {
                    if(txtOperacion.getText().equals(""))
                    {
                        txtOperacion.setText("Ingresa un numero ");
                        Bandera_texto=true;
                    }
                    else
                    {
                        if(txtOperacion.getText().equals("") || txtOperacion.getText().equals("."))
                        {
                            valor2=0;
                        }
                        else {
                            valor2 = Double.valueOf(txtOperacion.getCharacters().toString());
                            resvalores();
                            txtOperacion.clear();
                        }
                    }

                }
                else
                {
                    if(txtOperacion.getText().equals("") || txtOperacion.getText().equals("."))
                    {
                        valor1 = 0;
                        txtOperacion.setText("Reinicio");
                        Bandera_texto=true;
                    }
                    else{
                        valor1=Double.valueOf(txtOperacion.getCharacters().toString());
                        txtOperacion.clear();
                    }
                }

            }


        }
        else
        {
            txtOperacion.setText("Ingrese un numero :)");
            Bandera_texto =true;
        }


    }

    public void mulValores(){
        valor3=3;

        if(b ){
            System.out.println(valor1);

            if(valor1!=0 && valor2!=0)
            {
                valor1*=valor2;
                valor2=0;
            }
            else{


                if(valor1!=0)
                {
                    if(txtOperacion.getText().equals(""))
                    {
                        txtOperacion.setText("Ingresa  un numero ");
                        Bandera_texto=true;
                    }
                    else
                    {
                        if(txtOperacion.getText().equals("") || txtOperacion.getText().equals("."))
                        {
                            valor2=0;
                        }
                        else {
                            valor2 = Double.valueOf(txtOperacion.getCharacters().toString());
                            mulValores();
                            txtOperacion.clear();
                        }
                    }

                }
                else
                {
                    if(txtOperacion.getText().equals("") || txtOperacion.getText().equals(".")) {
                        valor1 = 0;
                        txtOperacion.setText("Reinicio");
                        Bandera_texto = true;
                    }
                    else{
                        valor1=Double.valueOf(txtOperacion.getCharacters().toString());
                        txtOperacion.clear();
                    }
                }

            }


        }
        else
        {
            txtOperacion.setText("Ingrese un numero :)");
            Bandera_texto =true;
        }


    }

    public void divValores(){
        valor3=4;

        if(b ){
            System.out.println(valor1);

            if(valor1!=0 && valor2!=0)
            {

                valor1/=valor2;
                valor2=0;
            }
            else{


                if(valor1!=0)
                {

                    if(txtOperacion.getText().equals(""))
                    {
                        txtOperacion.setText("Ingresa  un  numero ");
                        Bandera_texto=true;
                    }
                    else
                    {
                        if(txtOperacion.getText().equals("") || txtOperacion.getText().equals("."))
                        {
                            valor2=0;
                        }
                        else {
                            valor2 = Double.valueOf(txtOperacion.getCharacters().toString());
                            if (valor2==0)
                            {
                                b4=true;
                                txtOperacion.setText("Imposible escogue otro numero");
                                Bandera_texto=true;
                            }
                            else{
                                divValores();
                                txtOperacion.clear();
                            }

                        }}

                }
                else
                {
                    if(txtOperacion.getText().equals("") || txtOperacion.getText().equals(".")) {
                        valor1 = 0;
                        txtOperacion.setText("Reinicio");
                        Bandera_texto=true;

                    }
                    else{
                        valor1=Double.valueOf(txtOperacion.getCharacters().toString());
                        txtOperacion.clear();
                    }

                }

            }


        }
        else
        {
            txtOperacion.setText("Ingrese un numero :)");
            Bandera_texto =true;
        }


    }
}