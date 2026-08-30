package com.mycompany.chillhouse.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String URL =
             "jdbc:postgresql://localhost:5432/dbchill";

    private static final String USER = "postgres";

    private static final String PASSWORD = "123456";

    private DataBaseConnection() {
        //evita crear instancias de esta clase
    }
    //mejor guardar las credfenciales en variables de entorno, o en un archivo de configuracion en lugar de escribirlas directasmente en el codigo.
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
