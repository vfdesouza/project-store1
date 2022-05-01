package model.dao;

import db.DB;
import model.impl.ClientDaoJDBC;

public class DaoFactory {
    public static ClientDao createClientDao() {
        return new ClientDaoJDBC(DB.getConnection());
    }
}
