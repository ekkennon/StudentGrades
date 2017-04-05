package servlets;

import business.Student;
import business.StudentIO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Erin K Kennon
 */
public class CalculateGradesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorMsg = "";
        String url = "/StudentGrade.jsp";
        Student s1 = new Student();
        String field;
        
        field = "sid";
        try {
            String sid = request.getParameter(field);
            if (sid.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                s1.setSid(sid);
            }
        } catch(Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() +"<br>";
        }
        
        field = "lastname";
        try {
            String ln = request.getParameter(field);
            if (ln.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                s1.setLn(ln);
            }
        } catch(Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() +"<br>";
        }
        
        field = "firstname";
        try {
            String fn = request.getParameter(field);
            if (fn.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                s1.setFn(fn);
            }
        } catch(Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() +"<br>";
        }
        
        field = "q1";
        try {
            String sq1 = request.getParameter(field);
            if (sq1.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                double q1 = Double.parseDouble(sq1);
                
                if (q1 < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setQuiz1(q1);
                }
            }
        } catch(Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() +"<br>";
        }
        
        field = "q2";
        try {
            String sq2 = request.getParameter(field);
            if (sq2.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                double q2 = Double.parseDouble(sq2);
                
                if (q2 < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setQuiz2(q2);
                }
            }
        } catch (Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() + "<br>";
        }
        
        field = "q3";
        try {
            String sq3 = request.getParameter(field);
            if (sq3.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                double q3 = Double.parseDouble(sq3);
               
                if (q3 < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setQuiz3(q3);
                }
            }
        } catch (Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() + "<br>";
        }
        
        field = "q4";
        try {
            String sq4 = request.getParameter(field);
            if (sq4.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                double q4 = Double.parseDouble(sq4);
               
                if (q4 < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setQuiz4(q4);
                }
            }
        } catch (Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() + "<br>";
        }
        
        field = "q5";
        try {
            String sq5 = request.getParameter(field);
            if (sq5.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
               double q5 = Double.parseDouble(sq5);
               
                if (q5 < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setQuiz5(q5);
                }
            }
        } catch (Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() + "<br>";
        }
        
        field = "qmkup";
        try {
            String sqmkup = request.getParameter(field);
            if (sqmkup.isEmpty()) {
                sqmkup = "0";
            } else {
                double qmkup = Double.parseDouble(sqmkup);
               
                if (qmkup < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setMakeupQuiz(qmkup);
                }
            }
        } catch (Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() + "<br>";
        }
        
        field = "midterm";
        try {
            String smidterm = request.getParameter(field);
            if (smidterm.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                double midterm = Double.parseDouble(smidterm);
               
                if (midterm < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setMidterm(midterm);
                }
            }
        } catch (Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() + "<br>";
        }
        
        field = "final";
        try {
            String sfinal = request.getParameter(field);
            if (sfinal.isEmpty()) {
                sfinal = "0";
            } else {
                double dfinal = Double.parseDouble(sfinal);
               
                if (dfinal < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setFinalExam(dfinal);
                }
            }
        } catch (Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() + "<br>";
        }
        
        field = "probs";
        try {
            String sprobs = request.getParameter(field);
            if (sprobs.isEmpty()) {
                throw new IllegalArgumentException("Bad or missing field: " + field);
            } else {
                double probs = Double.parseDouble(sprobs);
               
                if (probs < 0) {
                    throw new NumberFormatException("Negative score on " + field);
                } else {
                    s1.setProblems(probs);
               }
            }
        } catch (Exception e) {
            errorMsg += field + " value bad or invalid. " + e.getMessage() + "<br>";
        }
        
        request.setAttribute("student",s1);
        
        if (errorMsg.equals("")) {
            ServletContext context = getServletContext();
            String path = context.getRealPath("/WEB-INF/classlist.txt");
            if (!StudentIO.addStudent(s1,path)) {
                errorMsg = "Unable to save student data";
                request.setAttribute("errorMsgs", errorMsg);
            }
        } else {
            url = "/Students.jsp";
            request.setAttribute("errorMsgs", errorMsg);
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Student Grades";
    }// </editor-fold>

}
