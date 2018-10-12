package dal.dao;

import bo.Utilisateurs;
import dal.exception.DaoException;

public interface UtilisateursDAO extends GenericDAO<Utilisateurs,Integer> {

    Utilisateurs selectByName(String name) throws DaoException;

    Utilisateurs selectBySurname(String surname) throws DaoException;

    Utilisateurs selectByNameAndSurname(String name,String surname) throws DaoException;

    Utilisateurs selectByEmail(String email) throws DaoException;

}
