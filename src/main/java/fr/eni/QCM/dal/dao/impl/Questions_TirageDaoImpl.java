package dal.dao.impl;

import bo.Questions_Tirage;
import dal.dao.MSSQLConnection;
import dal.dao.Questions_TirageDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Questions_TirageDaoImpl implements Questions_TirageDAO {

    private static final String SELECT_ALL_QUESTION_QUERY = "SELECT q.idQuestion_Tirage as question_tirage_id, q.estMarquee as question_tirage_estMarquee, q.numOrdre as question_tirage_numOrdre, q.idEpreuve as question_tirage_idEpreuve, q.idQuestion as question_tirage_idQuestion FROM question_Tirage q";
    private static final String SELECT_ONE_QUESTION_QUERY = "SELECT q.idQuestion_Tirage as question_tirage_id, q.estMarquee as question_tirage_estMarquee, q.numOrdre as question_tirage_numOrdre, q.idEpreuve as question_tirage_idEpreuve, q.idQuestion as question_tirage_idQuestion FROM question_Tirage q where q.idQuestion_Tirage = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";

    private static Questions_TirageDaoImpl instance;

    private Questions_TirageDaoImpl() {

    }

    public static Questions_TirageDaoImpl getInstance() {
        if(instance==null){
            instance = new Questions_TirageDaoImpl();
        }
        return instance;
    }
    @Override
    public Questions_Tirage insert(Questions_Tirage element) throws DaoException {
        return null;
    }

    @Override
    public void update(Questions_Tirage element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Questions_Tirage selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Questions_Tirage questions = null;

        try {
            connection = MSSQLConnection.get();
            statement = connection.prepareStatement(SELECT_ONE_QUESTION_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                questions = resultSetToQuestionTirage(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return questions;
    }

    @Override
    public List<Questions_Tirage> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Questions_Tirage> list = new ArrayList<>();

        try {
            connection = MSSQLConnection.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_QUESTION_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToQuestionTirage(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    private Questions_Tirage resultSetToQuestionTirage(ResultSet resultSet) throws SQLException {

        Questions_Tirage questions = new Questions_Tirage();
        questions.setIdQuestionTirage(resultSet.getInt("question_tirage_id"));
        questions.setNumOrdre(resultSet.getInt("question_tirage_numOrdre"));
        questions.setEstMarquee(resultSet.getBoolean("question_tirage_estMarquee"));
        questions.setIdEpreuve(resultSet.getInt("question_tirage_idEpreuve"));
        questions.setIdQuestion(resultSet.getInt("question_tirage_idQuestion"));

        return questions;

    }
}
