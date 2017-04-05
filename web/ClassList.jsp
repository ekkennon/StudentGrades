<%-- 
    Document   : ClassList.jsp
    Created on : Jan 30, 2017, 12:39:00 PM
    Author     : Erin K Kennon
--%>
<%@page import="business.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class List</title>
    </head>
    <body>
        <h1>Students on File:</h1>
        
        <%
            ArrayList<Student> stulist = (ArrayList<Student>) request.getAttribute("stulist");
            
            for (int i=0; i<stulist.size();i++) {
        %>
            <table border="1">
                <tr>
                    <td bgcolor="#FFFFEF">
                        Student Name: <%= stulist.get(i).getFn() %> <%= stulist.get(i).getLn() %>
                    </td>
                    <td bgcolor="#FFFFEF">
                        Student ID: <%= stulist.get(i).getSid() %>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#EEEEFE">
                        Quiz 1: <%= stulist.get(i).getQuiz1() %>
                    </td>
                    <td bgcolor="#EEEEFE">
                        Quiz 2: <%= stulist.get(i).getQuiz2() %>
                    </td>
                    <td bgcolor="#EEEEFE">
                        Quiz 3: <%= stulist.get(i).getQuiz3() %>
                    </td>
                    <td bgcolor="#EEEEFE">
                        Quiz 4: <%= stulist.get(i).getQuiz4() %>
                    </td>
                    <td bgcolor="#EEEEFE">
                        Quiz 5: <%= stulist.get(i).getQuiz5() %>
                    </td>
                    <td bgcolor="#EEEEFE">
                        Makeup Quiz: <%= stulist.get(i).getMakeupQuiz() %>
                    </td>
                    
                </tr>
                <tr>
                    <td bgcolor="#FFFFEF">
                        Quiz Average: <%= stulist.get(i).getQuizAvg() %>
                    </td>
                    <td bgcolor="#FFFFEF">
                        Problems: <%= stulist.get(i).getProblems() %>
                    </td>
                    <td bgcolor="#FFFFEF">
                        Midterm: <%= stulist.get(i).getMidterm() %>
                    </td>
                    <td bgcolor="#FFFFEF">
                        Final: <%= stulist.get(i).getFinalExam() %>
                    </td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <td bgcolor="#EEEEFE">
                        Course Grade: <%= stulist.get(i).getCourseAvg() %>
                    </td>
                    <td bgcolor="#EEEEFE">
                        Letter Grade: <%= stulist.get(i).getLetterGrade() %>
                    </td>
                </tr>
                <br>
        <%
            }
        %>
        </table>
        <br><br>
        <a href="/StudentGrades">Return To Student Input</a>
    </body>
</html>
