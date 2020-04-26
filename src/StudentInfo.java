public class StudentInfo {
    //* Attribute
    private double score;
    private String name;
    private String id;
    private String grade;

    private int lowA;
    private int highBP;
    private int lowBP;
    private int highB;
    private int lowB;
    private int highCP;
    private int lowCP;
    private int highC;
    private int lowC;
    private int highDP;
    private int lowDP;
    private int highD;
    private int lowD;

    public StudentInfo(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    //* Setting method
    public void setGrade(int lowA, int highBP, int lowBP, int highB, int lowB, int highCP, int lowCP, int highC, int lowC, int highDP, int lowDP, int highD, int lowD) {
        this.lowA = lowA;
        this.highBP = highBP;
        this.lowBP = lowBP;
        this.highB = highBP;
        this.lowBP = lowBP;
        this.highC = highC;
        this.lowC = lowC;
        this.highDP = highDP;
        this.lowDP = lowDP;
        this.highD = highD;
        this.lowD = lowD;
        grade = calGrade(score);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(String id) {
        this.id = id;
    }

    //* Getting method
    public double getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
    public String getID() {
        return id;
    }
    public String getGrade() {
        return grade;
    }

    // TODO Customize Calculaing 
    public String calGrade(double score) {
        if (score >= lowA && score <= 100) {
            return "A";
        }
        else if (score < highBP && score >= lowBP) {
            return "B+";
        }
        else if (score < highB && score >= lowB) {
            return "B";
        }
        else if (score < highCP && score >= lowCP) {
            return "C+";
        }
        else if (score < highC && score >= lowC) {
            return "C";
        }
        else if (score < highDP && score >= lowDP) {
            return "D+";
        }
        else if (score < highD && score >= lowD) {
            return "D";
        }
        else if (score >= 0 && score < lowD) {
            return "F";
        }
        return null;
    }
}