package application;

import db.DB;
import model.dao.ClientDao;
import model.dao.DaoFactory;
import model.entities.Client;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        ClientDao clientDao = DaoFactory.createClientDao();
        Date birthDate = new Date();

        System.out.println("Banco de dados inicializado.");

        Client client = new Client(null,"Keila Costa", "14846323707", "keila.costa@gmail.com", "Rua Marechal Hermes, Maruípe, Vitória, ES", birthDate);
        clientDao.insert(client);

        System.out.println("Objeto inserido no banco de dados com sucesso!");

        DB.closeConnection();
        System.out.println("Banco de dados encerrado.");

    }
}
