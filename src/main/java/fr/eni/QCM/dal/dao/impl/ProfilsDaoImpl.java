package dal.dao.impl;

import bo.Profils;
import bo.Promotions;
import bo.Reponses_Tirage;
import dal.dao.ProfilsDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfilsDaoImpl implements ProfilsDAO {

    private static final String SELECT_ALL_PROFIL_QUERY = "SELECT p.codeProfil as profil_id, p.libelle as profil_libelle FROM profils p";
    private static final String SELECT_ONE_PROFIL_QUERY = "SELECT p.codeProfil as profil_id, p.libelle as profil_libelle FROM profils p where p.codeProfil = ?";
    private static final String SELECT_BY_LIBELLE_QUERY = "SELECT p.codeProfil as profil_id, p.libelle as profil_libelle FROM profils p where p.libelle = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";

    private static ProfilsDaoImpl instance;

    private ProfilsDaoImpl() {

    }

    public static ProfilsDaoImpl getInstance() {
        if(instance==null){
            instance = new ProfilsDaoImpl();
        }
        return instance;
    }

    @Override
    public Profils insert(Profils element) throws DaoException {
        return null;
    }

    @Override
    public void update(Profils element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public List<Profils> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Profils> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_PROFIL_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToProfils(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    @Override
    public Profils selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Profils profils = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_PROFIL_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                profils = resultSetToProfils(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return profils;
    }

    @Override
    public Profils selectByLibelle(String libelle) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Profils profils = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_LIBELLE_QUERY);

            statement.setString(1, libelle);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                profils = resultSetToProfils(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return profils;
    }


    private Profils resultSetToProfils(ResultSet resultSet) throws SQLException {

        Profils profils = new Profils();
        profils.setCodeProfil(resultSet.getInt("profil_id"));
        profils.setLibelle(resultSet.getString("profil_libelle"));

        return profils;

    }
}
