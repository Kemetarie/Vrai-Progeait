package bll.manager;

import bo.Collaborateurs;
import bo.Epreuves;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface CollaborateursManager {

    List<Collaborateurs> selectAll() throws ManagerException;

    Collaborateurs selectById(Integer id) throws ManagerException, ElementNotFoundException;

}
