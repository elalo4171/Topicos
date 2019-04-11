package sample.Componentes;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteSocket {
    private Socket socket_cliente;
    private InetAddress direccion;
    private int puerto=5000;

    byte[] ip = new byte[]{(byte)192,(byte)168,(byte)1,(byte)67};
    public ClienteSocket(){CrearSocketCliente();}

    public void CrearSocketCliente(){
        try{

            direccion= InetAddress.getByAddress(ip);
            socket_cliente= new Socket(direccion,puerto);

            BufferedReader entrada= new BufferedReader(
                    new InputStreamReader(socket_cliente.getInputStream()));
            System.out.println(entrada.readLine());

            PrintStream salida= new PrintStream(socket_cliente.getOutputStream());
            salida.println("Hola Servidor");


        }
        catch (Exception e){

        }
    }
}
