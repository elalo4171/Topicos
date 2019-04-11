package sample.Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static String host="localhost";
    private static String BD="mexflix";
    private static String user="topicos2";
    private static String pwd="123456";
    public static Connection con=null;

    public static void getConexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mariadb://"+host+"/"+BD,user,pwd);
        }
        catch (Exception e){}
    }
}
