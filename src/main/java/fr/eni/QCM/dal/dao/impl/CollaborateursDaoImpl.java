package dal.dao.impl;

import bo.Collaborateurs;
import bo.Profils;
import dal.dao.CollaborateursDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollaborateursDaoImpl implements CollaborateursDAO {

    private static final String SELECT_ALL_COLLAB_QUERY = "SELECT c.idCollaborateur as collab_id FROM collaborateurs c";
    private static final String SELECT_ONE_COLLAB_QUERY = "SELECT c.idCollaborateur as collab_id FROM collaborateurs c where c.idCollaborateur = ?";
    private static final String SELECT_BY_LIBELLE_QUERY = "SELECT p.codeProfil as profil_id, p.libelle as profil_libelle FROM profils p where p.libelle = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";

    private static CollaborateursDaoImpl instance;

    private CollaborateursDaoImpl() {

    }

    public static CollaborateursDaoImpl getInstance() {
        if(instance==null){
            instance = new CollaborateursDaoImpl();
        }
        return instance;
    }

    @Override
    public Collaborateurs insert(Collaborateurs element) throws DaoException {
        return null;
    }

    @Override
    public void update(Collaborateurs element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }


    @Override
    public List<Collaborateurs> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Collaborateurs> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_COLLAB_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToCollab(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    @Override
    public Collaborateurs selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Collaborateurs collaborateurs = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_COLLAB_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                collaborateurs = resultSetToCollab(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return collaborateurs;
    }

    private Collaborateurs resultSetToCollab(ResultSet resultSet) throws SQLException {

        Collaborateurs collaborateurs = new Collaborateurs();
        collaborateurs.setIdCollaborateur(resultSet.getInt("collab_id"));

        return collaborateurs;

    }
}
