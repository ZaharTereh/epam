package by.training.epam.task4xml.controller;

import by.training.epam.task4xml.controller.command.Command;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControllerServlet extends HttpServlet {

    private String fileName = "B:/Java/Task4/data/tariffs.xml";
    private final CommandProvider provider = new CommandProvider();


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{

        Command command = provider.getCommand(request.getParameter("select"));
        //request.getPart(request.getParameter("XMLFile"));
        List<List<String>> list = command.execute(fileName);

        request.setAttribute("parser",request.getParameter("select"));
        request.setAttribute("list",list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request,response);

    }
}