package Servlet;

import addUser.User;
import addUser.adduser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adduserServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String uname = request.getParameter("username");
            String upass = request.getParameter("userpassword");
            String uemail = request.getParameter("useremail");

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

            if (uname.isBlank() || upass.isBlank() || uemail.isBlank()) {
                request.setAttribute("msg", "Fill up the Form");
                dispatcher.forward(request, response);
            } else {

                int success = 0;
                int existingEmail = 0;
                int existingName = 0;

                try {

                    existingEmail = adduser.checkEmail(uemail);
                    existingName = adduser.checkName(uname);

                } catch (ClassNotFoundException | SQLException e) {
                    out.print(e.getStackTrace());
                }
                if (existingEmail == 1 && existingName == 1) {
                    try {

                        success = adduser.addUser(uname, uemail, upass);

                    } catch (ClassNotFoundException | SQLException e) {
                        out.print(e.getStackTrace());
                    }

                    if (success == 1) {
                        request.setAttribute("msg", "Registered");
                        dispatcher.forward(request, response);

                    } else {
                        request.setAttribute("msg", "Failed");
                        dispatcher.forward(request, response);
                    }

                } else {

                    userNameorEmailExists(existingName, existingEmail, dispatcher, request, response);

                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(adduserServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(adduserServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public void userNameorEmailExists(int existingName, int existingEmail, RequestDispatcher dispatcher,
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (existingName == 0 && existingEmail == 0) {
            request.setAttribute("msg", "Username and Email Already Exists");
            dispatcher.forward(request, response);
        } else if (existingEmail == 0) {
            request.setAttribute("msg", "Email Already Exists");
            dispatcher.forward(request, response);
        } else if (existingName == 0) {
            request.setAttribute("msg", "Username Already Exists");
            dispatcher.forward(request, response);
        }

    }

}
