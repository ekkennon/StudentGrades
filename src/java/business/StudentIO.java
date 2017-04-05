package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
/**
 *
 * @author Erin K Kennon
 */
public class StudentIO {
    public static boolean addStudent(Student s, String path) {
        try (PrintWriter out = new PrintWriter(new FileWriter(new File(path), true))) {//try-with-resources
            out.println(s.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static ArrayList<Student> getStudent(String path) throws IOException {
        ArrayList<Student> studentList = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(path));
        String studentLine[];

        while (in.ready()) {
            studentLine = in.readLine().split(",");
            Student s = new Student();
            String setMethods[] = {"Sid","Ln","Fn","Quiz1","Quiz2","Quiz3","Quiz4","Quiz5","MakeupQuiz","Problems","Midterm","FinalExam"};
            Class stuClass = s.getClass();
            Method m;

            for (int i=0; i<setMethods.length ;i++) {
                switch (setMethods[i]) {
                    case "Sid":
                    case "Ln":
                    case "Fn":
                        try {
                            m = stuClass.getMethod("set"+setMethods[i],String.class);
                            m.invoke(s,studentLine[i]);

                        } catch (Exception e) {
                        }
                        break;
                        
                    default:
                        try {
                            m = stuClass.getMethod("set"+setMethods[i], double.class);
                            m.invoke(s,Double.parseDouble(studentLine[i]));

                        } catch (Exception e) {
                        }
                        break;
                    }
                }
                studentList.add(s);
            }
            in.close();
        
        return studentList;
    }
}