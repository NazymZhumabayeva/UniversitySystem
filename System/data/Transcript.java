package data;

import java.io.Serializable;
import java.util.HashMap;

public class Transcript implements Serializable {

    private HashMap<Course, Attestation> journal;
    private double gpa;
    
	public Transcript() {
		this.gpa = 0;
		journal = new HashMap<Course, Attestation>();
	}
	public double countGpa() {
        double sum = 0;
        double credits = 0;
        for (HashMap.Entry<Course, Attestation> entry: journal.entrySet()) {
        	double gpaOfCourse = Mark.convertGpa(entry.getValue().getTotal());
        	sum += entry.getKey().getNumberOfCredits() * gpaOfCourse;
        	credits += entry.getKey().getNumberOfCredits();}
        this.gpa = sum / credits;
        return sum / credits;
    }
	public HashMap<Course, Attestation> getJournal() { return journal; }
    public double getGpa() { return gpa; }

    public void addToJournal(Course course, Attestation newAtt) {
        this.getJournal().put(course, newAtt);
      }
    
	public String toString() { return " gpa=" + gpa + "]"; } 
	public void print() {
		for (HashMap.Entry<Course, Attestation> entry: journal.entrySet()){
			double total = entry.getValue().getTotal();
			System.out.println("Transcript /n" + 
					entry.getKey().printName() + " " + entry.getValue().toString() + " " + total + " " +
					"gpa: " + Mark.convertGpa(total) + " " + "charGrade: " + Mark.convertChar(total));
		}
		System.out.println(" /n " + this.toString());
	}
	
}

