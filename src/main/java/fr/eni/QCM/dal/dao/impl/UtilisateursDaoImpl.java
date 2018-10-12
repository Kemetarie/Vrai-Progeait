package dal.dao.impl;

import bo.Themes;
import bo.Utilisateurs;
import dal.dao.UtilisateursDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateursDaoImpl implements UtilisateursDAO {

    private static final String SELECT_ALL_USER_QUERY = "SELECT u.idUtilisateur as util_id, u.nom as util_nom , u.prenom as util_prenom , u.email as util_email , u.motDePasse as util_password FROM utilisateurs u ";
    private static final String SELECT_ONE_USER_QUERY = "SELECT u.idUtilisateur as util_id, u.nom as util_nom , u.prenom as util_prenom , u.email as util_email , u.motDePasse as util_password FROM utilisateurs u where u.idUtilisateur = ?";
    private static final String SELECT_BY_NAME_QUERY = "SELECT u.idUtilisateur as util_id, u.nom as util_nom , u.prenom as util_prenom , u.email as util_email , u.motDePasse as util_password FROM utilisateurs u where u.nom = ?";
    private static final String SELECT_BY_SURNAME_QUERY = "SELECT u.idUtilisateur as util_id, u.nom as util_nom , u.prenom as util_prenom , u.email as util_email , u.motDePasse as util_password FROM utilisateurs u where u.prenom = ?";
    private static final String SELECT_BY_NAME_AND_SURNAME_QUERY = "SELECT u.idUtilisateur as util_id, u.nom as util_nom , u.prenom as util_prenom , u.email as util_email , u.motDePasse as util_password FROM utilisateurs u where u.nom = ? AND u.prenom = ?";
    private static final String SELECT_BY_EMAIL_QUERY = "SELECT u.idUtilisateur as util_id, u.nom as util_nom , u.prenom as util_prenom , u.email as util_email , u.motDePasse as util_password FROM utilisateurs u where u.email = ?";
    private static final String SELECT_ONE_THEME_BY_LIBELLE_QUERY = "SELECT t.idTheme as theme_id FROM themes t where t.libelle = ?";
    private static final String INSERT_EPREUVE_QUERY = "INSERT INTO epreuves(dateDebutValidite, dateFinValidite,tempsEcoule, note_obtenu, niveau_obtenu, etat) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_NOTE_QUERY = "DELETE FROM note WHERE id = ?";
    private static final String UPDATE_NOTE_QUERY = "UPDATE note SET nom = ?, content = ? WHERE id = ?";

    private static UtilisateursDaoImpl instance;

    private UtilisateursDaoImpl() {

    }

    public static UtilisateursDaoImpl getInstance() {
        if(instance == null) {
            instance = new UtilisateursDaoImpl();
        }
        return instance;
    }

    @Override
    public Utilisateurs insert(Utilisateurs element) throws DaoException {
        return null;
    }

    @Override
    public void update(Utilisateurs element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Utilisateurs selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utilisateurs utilisateurs = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_USER_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                utilisateurs = resultSetToUtilisateurs(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return utilisateurs;
    }

    @Override
    public List<Utilisateurs> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Utilisateurs> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_USER_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToUtilisateurs(resultSet));
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    @Override
    public Utilisateurs selectByName(String name) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utilisateurs utilisateurs = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_NAME_QUERY);

            statement.setString(1, name);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                utilisateurs = resultSetToUtilisateurs(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectBySurname(String surname) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utilisateurs utilisateurs = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_SURNAME_QUERY);

            statement.setString(1, surname);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                utilisateurs = resultSetToUtilisateurs(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectByNameAndSurname(String name, String surname) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utilisateurs utilisateurs = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_NAME_AND_SURNAME_QUERY);

            statement.setString(1, name);
            statement.setString(2, surname);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                utilisateurs = resultSetToUtilisateurs(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectByEmail(String email) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utilisateurs utilisateurs = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_EMAIL_QUERY);

            statement.setString(1, email);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                utilisateurs = resultSetToUtilisateurs(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return utilisateurs;
    }

    private Utilisateurs resultSetToUtilisateurs(ResultSet resultSet) throws SQLException {

        Utilisateurs utilisateurs = new Utilisateurs();
        utilisateurs.setIdUtilisateur(resultSet.getInt("util_id"));
        utilisateurs.setNom(resultSet.getString("util_nom"));
        utilisateurs.setPrenom(resultSet.getString("util_prenom"));
        utilisateurs.setEmail(resultSet.getString("util_email"));
        utilisateurs.setPassword(resultSet.getString("util_password"));

        return utilisateurs;
    }
}
