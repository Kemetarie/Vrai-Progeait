package bll.manager;

import bo.Utilisateurs;
import dal.exception.DaoException;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface UtilisateursManager {

    List<Utilisateurs> selectAll() throws ManagerException;

    Utilisateurs selectById(Integer id) throws ManagerException, ElementNotFoundException;

    Utilisateurs selectByName(String name) throws DaoException;

    Utilisateurs selectBySurname(String surname) throws DaoException;

    Utilisateurs selectByNameAndSurname(String name,String surname) throws DaoException;

    Utilisateurs selectByEmail(String email) throws DaoException;

    Utilisateurs selectByEmailAndPsw(String email,String psw) throws DaoException;
}
