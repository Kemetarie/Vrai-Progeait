package dal.dao.impl;

import bo.Promotions;
import bo.Themes;
import dal.dao.PromotionsDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotionsDaoImpl implements PromotionsDAO {

    private static final String SELECT_ALL_PROMOTION_QUERY = "SELECT p.codePromo as promo_id, p.libelle as promo_libelle FROM promotions p";
    private static final String SELECT_ONE_PROMOTION_QUERY = "SELECT p.codePromo as promo_id, p.libelle as promo_libelle FROM promotions p where p.codePromo = ?";
    private static final String SELECT_BY_LIBELLE_QUERY = "SELECT p.codePromo as promo_id, p.libelle as promo_libelle FROM promotions p where p.libelle = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";

    private static PromotionsDaoImpl instance;

    private PromotionsDaoImpl() {

    }

    public static PromotionsDaoImpl getInstance() {
        if(instance==null){
            instance = new PromotionsDaoImpl();
        }
        return instance;
    }

    @Override
    public Promotions insert(Promotions element) throws DaoException {
        return null;
    }

    @Override
    public void update(Promotions element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Promotions selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Promotions promotions = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_PROMOTION_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                promotions = resultSetToPromotions(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return promotions;
    }

    @Override
    public List<Promotions> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Promotions> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_PROMOTION_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToPromotions(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    @Override
    public Promotions selectByLibelle(String libelle) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Promotions promotions = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_LIBELLE_QUERY);

            statement.setString(1, libelle);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                promotions = resultSetToPromotions(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return promotions;
    }

    private Promotions resultSetToPromotions(ResultSet resultSet) throws SQLException {

        Promotions promotions = new Promotions();
        promotions.setCodePromo(resultSet.getInt("promo_id"));
        promotions.setLibelle(resultSet.getString("promo_libelle"));

        return promotions;

    }
}
