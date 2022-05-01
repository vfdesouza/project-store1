package model.impl;

import db.DB;
import db.DbException;
import model.dao.ClientDao;
import model.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoJDBC implements ClientDao {

    private Connection conn;

    public ClientDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Client obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO client "
                            + "(Name, Cpf, Email, BirthDate, Address) "
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
    public void update(Client obj, Integer id) {
        PreparedStatement st = null;
        ResultSet rs;
        try {
            st = conn.prepareStatement(
                    "UPDATE client "
                            + "SET Name = ?, Cpf = ?, Email = ?, BirthDate = ?, Address = ? "
                            + "WHERE (IdClient = ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setString(2, obj.getCpf());
            st.setString(3, obj.getEmail());
            st.setDate(4, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setString(5, obj.getAddress());
            st.setInt(6, id);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM client "
                            + "WHERE idClient = ?",
                    Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Client findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM client WHERE IdClient = ?");

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Client obj = instantiateClient(rs);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Client instantiateClient(ResultSet rs) throws SQLException {
        Client obj = new Client();
        obj.setName(rs.getString("Name"));
        obj.setCpf(rs.getString("Cpf"));
        obj.setEmail(rs.getString("Email"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setAddress(rs.getString("Address"));
        return obj;
    }

    @Override
    public List<Client> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM client ORDER BY Name;");

            rs = st.executeQuery();

            List<Client> list = new ArrayList<>();

            while (rs.next()) {
                Client obj = instantiateClient(rs);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
