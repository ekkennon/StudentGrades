package business;

import java.util.Arrays;

/**
 *
 * @author Erin K Kennon
 */
public class Student {
    private String sid;
    private String ln;
    private String fn;
    private double quiz1;
    private double quiz2;
    private double quiz3;
    private double quiz4;
    private double quiz5;
    private double makeupQuiz;
    private double midterm;
    private double finalExam;
    private double problems;
    private double quizAvg;
    private double courseAvg;
    private String letterGrade;
    private boolean built;
    
    public Student() {
        setSid("");
        setLn("");
        setFn("");
        setQuiz1(0.0);
        setQuiz2(0.0);
        setQuiz3(0.0);
        setQuiz4(0.0);
        setQuiz5(0.0);
        setMakeupQuiz(0.0);
        setMidterm(0.0);
        setFinalExam(0.0);
        setProblems(0.0);
        setBuilt(false);
    }

    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the ln
     */
    public String getLn() {
        return ln;
    }

    /**
     * @param ln the ln to set
     */
    public void setLn(String ln) {
        this.ln = ln;
    }

    /**
     * @return the fn
     */
    public String getFn() {
        return fn;
    }

    /**
     * @param fn the fn to set
     */
    public void setFn(String fn) {
        this.fn = fn;
    }

    /**
     * @return the quiz1
     */
    public double getQuiz1() {
        return quiz1;
    }

    /**
     * @param quiz1 the quiz1 to set
     */
    public void setQuiz1(double quiz1) {
        this.quiz1 = quiz1;
    }

    /**
     * @return the quiz2
     */
    public double getQuiz2() {
        return quiz2;
    }

    /**
     * @param quiz2 the quiz2 to set
     */
    public void setQuiz2(double quiz2) {
        this.quiz2 = quiz2;
    }

    /**
     * @return the quiz3
     */
    public double getQuiz3() {
        return quiz3;
    }

    /**
     * @param quiz3 the quiz3 to set
     */
    public void setQuiz3(double quiz3) {
        this.quiz3 = quiz3;
    }

    /**
     * @return the quiz4
     */
    public double getQuiz4() {
        return quiz4;
    }

    /**
     * @param quiz4 the quiz4 to set
     */
    public void setQuiz4(double quiz4) {
        this.quiz4 = quiz4;
    }

    /**
     * @return the quiz5
     */
    public double getQuiz5() {
        return quiz5;
    }

    /**
     * @param quiz5 the quiz5 to set
     */
    public void setQuiz5(double quiz5) {
        this.quiz5 = quiz5;
    }

    /**
     * @return the makeupQuiz
     */
    public double getMakeupQuiz() {
        return makeupQuiz;
    }

    /**
     * @param makeupQuiz the makeupQuiz to set
     */
    public void setMakeupQuiz(double makeupQuiz) {
        this.makeupQuiz = makeupQuiz;
    }

    /**
     * @return the midterm
     */
    public double getMidterm() {
        return midterm;
    }

    /**
     * @param midterm the midterm to set
     */
    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    /**
     * @return the finalExam
     */
    public double getFinalExam() {
        return finalExam;
    }

    /**
     * @param finalExam the finalExam to set
     */
    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    /**
     * @return the problems
     */
    public double getProblems() {
        return problems;
    }

    /**
     * @param problems the problems to set
     */
    public void setProblems(double problems) {
        this.problems = problems;
    }
    
    /**
     * @return the built
     */
    public boolean getBuilt() {
        return built;
    }

    /**
     * @param built the built to set
     */
    public void setBuilt(boolean built) {
        this.built = built;
    }

    /**
     * @return the quizAvg
     */
    public double getQuizAvg() {
        if (!built) {
            calculateGrade();
        }
        return quizAvg;
    }
    
    private void calcQuizAvg() {
        try {
            double quizzes[] = {getQuiz1(),getQuiz2(),getQuiz3(),getQuiz4(),getQuiz5(),getMakeupQuiz()};
            Arrays.sort(quizzes);

            quizAvg = 0;
            for (int i=2;i<6;i++) {
                quizAvg += quizzes[i];
            }
            quizAvg /= 4.0;
            
            setBuilt(true);
        } catch (Exception e) {
            setBuilt(false);
        }
    }
    
    private void setQuizAvg(double qa) {
        quizAvg = qa;
    }

    /**
     * @return the courseAvg
     */
    public double getCourseAvg() {
        if (!built) {
            calculateGrade();
        }
        return courseAvg;
    }
    
    private void calcCourseAvg() {
        try {
            if (getQuizAvg() >= 89.5 && getProblems() >= 89.5 && getMidterm() >= 89.5) {
                courseAvg = getQuizAvg() + getMidterm() + getProblems() / 3.0;
            } else {
                courseAvg = ((getQuizAvg()*.5) + (getMidterm()*.15) + (getFinalExam()*.25) + (getProblems()*.1));
            }
            
            setBuilt(true);
        } catch (Exception e) {
            setBuilt(false);
        }
    }
    
    private void setCourseAvg(double ca) {
        courseAvg = ca;
    }

    /**
     * @return the letterGrade
     */
    public String getLetterGrade() {
        if (!built) {
            calculateGrade();
        }
        return letterGrade;
    }
    
    private void calcLetterGrade() {
        try {
            if (getCourseAvg() >= 89.5) {
                letterGrade = "A";
            } else if (getCourseAvg() >= 79.5) {
                letterGrade = "B";
            } else if (getCourseAvg() >= 69.5) {
                letterGrade = "C";
            } else if (getCourseAvg() >= 59.5) {
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }
            
            setBuilt(true);
        } catch (Exception e) {
            setBuilt(false);
        }
    }
    
    private void setLetterGrade(String lg) {
        letterGrade = lg;
    }
    
    public void calculateGrade() {
        calcQuizAvg();
        calcCourseAvg();
        calcLetterGrade();
        setBuilt(true);
    }
    
    @Override
    public String toString() {
        if (!getBuilt()) {
            calculateGrade();
        }
        return getSid() + "," + getFn() + "," + getLn() + "," + getQuiz1() + "," + getQuiz2() + "," + getQuiz3() + "," + getQuiz4() + "," + getQuiz5() + "," + getMakeupQuiz() + "," + getProblems() + "," + getMidterm() + "," + getFinalExam() + "," + getQuizAvg() + "," + getCourseAvg() + "," + getLetterGrade();
    }
}