package application;

import db.DB;
import model.dao.ClientDao;
import model.dao.DaoFactory;
import model.entities.Client;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        ClientDao clientDao = DaoFactory.createClientDao();
        Date birthDate = new Date();

        System.out.println("Banco de dados inicializado.");

        //clientDao.insert(client);

        //System.out.println("Objeto inserido no banco de dados com sucesso!");

        //clientDao.deleteById(2);

        //System.out.println("Objeto excluído do banco de dados com sucesso!");

        /*Client client = clientDao.findById(3);
        System.out.println(client);
        client.setName("Keila Moreira da Silva Costa");
        clientDao.update(client, 3);
        System.out.println("Nome do cliente " + client.getName() + " atualizado com sucesso!");*/
        List<Client> list = clientDao.findAll();
        for (Client obj : list) {
            System.out.println(obj);
        }
        DB.closeConnection();
        System.out.println("Banco de dados encerrado.");
    }
}
