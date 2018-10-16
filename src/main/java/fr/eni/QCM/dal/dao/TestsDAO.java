package dal.dao;

import bo.Tests;
import dal.exception.DaoException;

import java.util.List;

public interface TestsDAO extends GenericDAO<Tests,Integer> {

    Tests selectByLibelle(String libelle) throws DaoException;

    List<Tests> selectAllTestsByEpreuveId(int idEpreuve) throws DaoException;
}
