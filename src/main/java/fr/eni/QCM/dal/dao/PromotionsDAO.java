package dal.dao;

import bo.Promotions;
import dal.exception.DaoException;

public interface PromotionsDAO extends GenericDAO<Promotions, Integer>{

    Promotions selectByLibelle(String libelle) throws DaoException;

}
