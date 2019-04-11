package sample.Componentes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
    private  ServerSocket servidor;
    private Socket socket_servidor;
    int noCte=0;
    public  void ServidorSocket(){CrearServer();}

    public void CrearServer(){
        try{


            servidor= new ServerSocket(5000);
            do{
                System.out.println("Servidor en espera....");
                socket_servidor=servidor.accept();
                noCte++;
                System.out.println("Llego el cliente "+ noCte);
                PrintStream salida=new PrintStream(socket_servidor.getOutputStream());
                salida.println("Bienvenidos :)");

                BufferedReader entrada= new BufferedReader(new InputStreamReader(socket_servidor.getInputStream()));
                        socket_servidor.getInputStream();
                System.out.println("El cliente dice: " + entrada.readLine());

                socket_servidor.close();


            }
            while (true);

        }
        catch (Exception e){

        }


    }
}
