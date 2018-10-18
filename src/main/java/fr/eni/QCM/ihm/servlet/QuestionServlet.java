package ihm.servlet;

import bll.factory.ManagerFactory;
import bll.manager.PropositionsManager;
import bll.manager.QuestionsManager;
import bll.manager.Questions_TirageManager;
import bll.manager.Reponses_TirageManager;
import bo.Propositions;
import bo.Questions;
import bo.Questions_Tirage;
import bo.Reponses_Tirage;
import ch.qos.logback.core.net.SyslogOutputStream;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

@WebServlet( name="question", urlPatterns = {"/QCM/question"} )
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Questions_TirageManager questions_tirageManager = ManagerFactory.questions_tirageManager();
        Questions_Tirage questions_tirage = null;
        QuestionsManager questionsManager = ManagerFactory.questionsManager();
        Questions questions = null;
        PropositionsManager propositionsManager = ManagerFactory.propositionsManager();
        List<Propositions> list = null;
        try {
            //questions_tirage = questions_tirageManager.selectById(Integer.parseInt(req.getParameter("question")));
            questions_tirage = questions_tirageManager.selectById(Integer.parseInt(req.getParameter("idQuestionSuivante")));

            questions = questionsManager.selectById(questions_tirage.getIdQuestion());

            list = propositionsManager.selectByIdQuestion(questions.getIdQuestion());
        } catch (ManagerException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("questions_tirage",questions_tirage);
        req.setAttribute("questions",questions);
        req.setAttribute("list_propositions",list);

        req.getRequestDispatcher("/QCM/questionjsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reponses_TirageManager reponses_tirageManager = ManagerFactory.reponses_tirageManager();
        Reponses_Tirage reponses_tirage = new Reponses_Tirage();
        Questions_TirageManager questions_tirageManager = ManagerFactory.questions_tirageManager();
        Questions_Tirage questions_tirage = null;
        QuestionsManager questionsManager = ManagerFactory.questionsManager();
        Questions questions = null;
        PropositionsManager propositionsManager = ManagerFactory.propositionsManager();
        List<Propositions> listProp = null;

        int idQuestionSuivante = Integer.parseInt(req.getParameter("idQuestionSuivante"));

        if (idQuestionSuivante != 1){

            List<String> list = new ArrayList<>();
            Enumeration enumeration = req.getParameterNames();

            while (enumeration.hasMoreElements()) {
                String param = (String) enumeration.nextElement();
                if (param.contains("proposition")) {
                    list.add(param);
                }
            }

            Iterator<String> iteratorlist = list.iterator();

            while(iteratorlist.hasNext()){
                String param = (String) iteratorlist.next();
                String[] prop = param.split("proposition");
                String[] id = prop[1].split("question");
                reponses_tirage.setIdProposition(Integer.parseInt(id[0]));
                reponses_tirage.setIdQuestion_Tirage(Integer.parseInt(id[1]));

                try {
                    reponses_tirageManager.insert(reponses_tirage);
                } catch (ManagerException e) {
                    e.printStackTrace();
                }
            }

        }

        try {
            //questions_tirage = questions_tirageManager.selectById(Integer.parseInt(req.getParameter("question")));
            questions_tirage = questions_tirageManager.selectById(idQuestionSuivante);

            questions = questionsManager.selectById(questions_tirage.getIdQuestion());

            listProp = propositionsManager.selectByIdQuestion(questions.getIdQuestion());
        } catch (ManagerException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("questions_tirage",questions_tirage);
        req.setAttribute("questions",questions);
        req.setAttribute("list_propositions",listProp);

        req.getRequestDispatcher("/QCM/questionjsp").forward(req, resp);
    }
}
