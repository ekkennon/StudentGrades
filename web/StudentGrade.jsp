<%-- 
    Document   : StudentGrade
    Created on : Jan 30, 2017, 9:44:15 AM
    Author     : Erin K Kennon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.Student"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade Calculation</title>
    </head>
    <body>
        <h1>Student Results:</h1>
        
        <%Student s = (Student) request.getAttribute("student");%>

        Student ID: <%= s.getSid() %><br>
        Student Name: <%= s.getFn() %> <%= s.getLn() %><br>
        <br>
        Quiz 1: <%= s.getQuiz1() %><br>
        Quiz 2: <%= s.getQuiz2() %><br>
        Quiz 3: <%= s.getQuiz3() %><br>
        Quiz 4: <%= s.getQuiz4() %><br>
        Quiz 5: <%= s.getQuiz5() %><br>
        Makeup Quiz: <%= s.getMakeupQuiz() %><br>
        Problems: <%= s.getProblems() %><br>
        Midterm: <%= s.getMidterm() %><br>
        Final: <%= s.getFinalExam() %><br>
        <br>
        Quiz Average: <%= s.getQuizAvg() %><br>
        Course Grade: <%= s.getCourseAvg() %><br>
        Letter Grade: <%= s.getLetterGrade() %><br>
        <br><br>
        <a href="/StudentGrades">Return To Student Input</a>
        <p>
            ${errorMsgs}
        </p>
    </body>
</html>
