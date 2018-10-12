package bll.manager;

import bo.Profils;
import dal.exception.DaoException;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface ProfilsManager {

    List<Profils> selectAll() throws ManagerException;

    Profils selectById(Integer id) throws ManagerException, ElementNotFoundException;

    Profils selectByLibelle(String libelle) throws DaoException;

}
