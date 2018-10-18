package dal.dao.impl;

import bo.Reponses_Tirage;
import dal.dao.MSSQLConnection;
import dal.dao.Reponses_TirageDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Reponses_TirageDaoImpl implements Reponses_TirageDAO {

    private static final String SELECT_ALL_REPONSE_QUERY = "SELECT r.idQuestion_Tirage as reponse_idQuestion,r.idProposition as reponse_idPropo  FROM reponse_Tirage r";
    private static final String SELECT_ONE_REPONSE_QUERY = "SELECT r.idQuestion_Tirage as reponse_idQuestion,r.idProposition as reponse_idPropo  FROM reponse_Tirage r where r.idReponseTirage = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    private static final String INSERT_REPONSE_QUERY = "INSERT INTO reponse_Tirage(idQuestion_Tirage, idProposition) VALUES (?, ?)";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";

    private static Reponses_TirageDaoImpl instance;

    private Reponses_TirageDaoImpl() {

    }

    public static Reponses_TirageDaoImpl getInstance() {
        if(instance==null){
            instance = new Reponses_TirageDaoImpl();
        }
        return instance;
    }

    @Override
    public Reponses_Tirage insert(Reponses_Tirage element) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = MSSQLConnection.get();

            statement = connection.prepareStatement(INSERT_REPONSE_QUERY);

            statement.setInt(1, element.getIdQuestion_Tirage());
            statement.setInt(2, element.getIdProposition());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return element;
    }

    @Override
    public void update(Reponses_Tirage element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Reponses_Tirage selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Reponses_Tirage reponses = null;

        try {
            connection = MSSQLConnection.get();
            statement = connection.prepareStatement(SELECT_ONE_REPONSE_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reponses = resultSetToReponses(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return reponses;
    }

    @Override
    public List<Reponses_Tirage> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Reponses_Tirage> list = new ArrayList<>();

        try {
            connection = MSSQLConnection.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_REPONSE_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToReponses(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    private Reponses_Tirage resultSetToReponses(ResultSet resultSet) throws SQLException {

        Reponses_Tirage reponses = new Reponses_Tirage();
        reponses.setIdProposition(resultSet.getInt("test_id"));
        reponses.setIdQuestion_Tirage(resultSet.getInt("test_id"));

        return reponses;

    }
}
