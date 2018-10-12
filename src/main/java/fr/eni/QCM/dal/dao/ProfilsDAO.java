package dal.dao;

import bo.Profils;
import dal.exception.DaoException;

public interface ProfilsDAO extends GenericDAO<Profils,Integer>{

    Profils selectByLibelle(String libelle) throws DaoException;

}
