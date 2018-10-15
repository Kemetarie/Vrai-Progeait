package ihm.servlet;

import bll.factory.ManagerFactory;
import bll.manager.CandidatsManager;
import bll.manager.UtilisateursManager;
import bo.Candidats;
import bo.Utilisateurs;
import dal.exception.DaoException;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name="connect", urlPatterns = {"/QCM/connect"} )
public class ConnectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/QCM/connectjsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtilisateursManager userManager = ManagerFactory.utilisateurManager();
        try {
            Utilisateurs user = userManager.selectByEmail(req.getParameter("user"));
            //System.out.println(user.getPassword());
            if(user.getPassword() != req.getParameter("password")){
                this.doGet(req, resp);
            } else {
                CandidatsManager candidatManager = ManagerFactory.candidatsManager();
                Candidats candidat = candidatManager.selectById(user.getIdUtilisateur());
                req.getSession(true).setAttribute("user", candidat);
                req.getRequestDispatcher("/QCM/connectedjsp").forward(req, resp);
            }
        } catch (DaoException | ManagerException | ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
