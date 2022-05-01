package model.impl;

import db.DB;
import db.DbException;
import model.dao.ClientDao;
import model.entities.Client;

import java.sql.*;
import java.util.List;

public class ClientDaoJDBC implements ClientDao {

    private Connection conn;

    public ClientDaoJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Client obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                            "INSERT INTO client "
                                    +"(Name, Cpf, Email, BirthDate, Address) "
                                    + "VALUES "
                                    + "(?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setString(2, obj.getCpf());
            st.setString(3, obj.getEmail());
            st.setDate(4, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setString(5, obj.getAddress());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Client obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Client findById(Integer id) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }
}
