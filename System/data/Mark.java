package data;

public class Mark {
    private double grade;
    private double gpa;
    private static String charGrade = null;
	static int[] grades = {50, 55, 60, 65, 70, 75, 80, 85, 90, 95};
    public Mark(){}
    
    public double getGrade() { return grade; }

	public void setGrade(double grade) { this.grade = grade; }

	public double getGpa() { return gpa; }

	public String getCharGrade() { return charGrade; }

	public static String convertChar(double grade) { 
		String tempChar = null;
		String[] charGrades = {"D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A"};
		for (int i = grades.length; i > 0; i--) {
			if (grade >= grades[i]) {
				tempChar = charGrades[i];
				break;
			}
		}
		if (charGrade.equals(null)) {
			charGrade = "F";
		}
		return tempChar;
    }
	
	public static double convertGpa(double grade) {
		double tempGPA = 0;
		double[] gpa = {1.0, 1.33, 1.67, 2.0, 2.33, 2.67, 3.0, 3.33, 3.67, 4.0};
		for (int i = grades.length; i > 0; i--) {
			if (grade >= grades[i]) {
				tempGPA = gpa[i];
				break;
			}
		}
		return tempGPA;
	}
}

