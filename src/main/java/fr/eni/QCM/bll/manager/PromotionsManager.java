package bll.manager;

import bo.Promotions;
import dal.exception.DaoException;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface PromotionsManager {

    List<Promotions> selectAll() throws ManagerException;

    Promotions selectById(Integer id) throws ManagerException, ElementNotFoundException;

    Promotions selectByLibelle(String libelle) throws DaoException;

}
