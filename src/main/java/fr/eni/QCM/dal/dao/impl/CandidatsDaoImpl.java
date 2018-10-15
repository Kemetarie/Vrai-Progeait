package dal.dao.impl;

import bo.Candidats;
import bo.Epreuves;
import bo.Promotions;
import dal.dao.CandidatsDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatsDaoImpl implements CandidatsDAO {

    private static final String SELECT_ALL_CANDIDAT_QUERY = "SELECT c.idCandidat as candidat_id , c.codePromotion as candidat_codePromo , c.idEpreuve as candidat_idEpreuve FROM candidats c";
    private static final String SELECT_ONE_CANDIDAT_QUERY = "SELECT c.idCandidat as candidat_id , c.codePromotion as candidat_codePromo , c.idEpreuve as candidat_idEpreuve FROM candidats c where c.idCandidat = ?";
    private static final String SELECT_ONE_NOTE_BY_NAME_QUERY = "SELECT n.id FROM note n where n.nom = ?";
    private static final String INSERT_EPREUVE_QUERY = "INSERT INTO epreuves(dateDebutValidite, dateFinValidite,tempsEcoule, note_obtenu, niveau_obtenu, etat) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_NOTE_QUERY = "DELETE FROM note WHERE id = ?";
    private static final String UPDATE_NOTE_QUERY = "UPDATE note SET nom = ?, content = ? WHERE id = ?";

    private static CandidatsDaoImpl instance;

    public CandidatsDaoImpl() {
    }

    public static CandidatsDaoImpl getInstance() {
        if(instance==null){
            instance = new CandidatsDaoImpl();
        }
        return instance;
    }

    @Override
    public Candidats insert(Candidats element) throws DaoException {
        return null;
    }

    @Override
    public void update(Candidats element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public List<Candidats> selectAll() throws DaoException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Candidats> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_CANDIDAT_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToCandidats(resultSet));
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    @Override
    public Candidats selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Candidats candidats = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_CANDIDAT_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                candidats = resultSetToCandidats(resultSet);
            }
        } catch (SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return candidats;
    }

    private Candidats resultSetToCandidats(ResultSet resultSet) throws SQLException {

        EpreuvesDaoImpl epreuvesDao = new EpreuvesDaoImpl();
        Epreuves epreuves = new Epreuves();

        PromotionsDaoImpl promotionsDao = new PromotionsDaoImpl();
        Promotions promotions = new Promotions();

        Candidats candidats = new Candidats();
        candidats.setIdCandidat(resultSet.getInt("candidat_id"));
        try {
            promotions = promotionsDao.selectById(resultSet.getInt("candidat_idEpreuve"));
            epreuves = epreuvesDao.selectById(resultSet.getInt("candidat_idEpreuve"));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        candidats.setPromotions(promotions);
        candidats.setEpreuves(epreuves);

        return candidats;

    }
}
