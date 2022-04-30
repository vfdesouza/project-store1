package application;

import db.DB;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {
        Connection conn = DB.getConnetion();
        System.out.println("Banco de dados inicializado.");
        DB.closeConnection();
        System.out.println("Banco de dados encerrado.");
    }
}
