package users;

import java.io.File;
import java.io.IOException;
import java.util.*;
import enumerations.*;
import exceptions.*;
import system.*;
import data.*;
import controllers.*;

/** Class Student */
public class Student extends User  {
    /** Declaration of field degree enumeration Degree*/
    private Degree degree;
    /** Field faculty - means faculty of student*/
    private Faculty faculty;
    /** Field year of study - means year of study of student*/ 
    private int yearOfStudy;
    /** Field transcript - means transcript for student. Transcript have marks for all courses and GPA.*/ 
    private Transcript transcript;
    /** Field course status - it is all courses of student with own status, like current or finished*/ 
    private HashMap<Course, CourseStatus> courses; 
    /** Static field limit of credits */
    private static int limitOfCredits = 19;
    /** Field speciality - means speciality of student*/ 
    private Speciality speciality;
    /** No-argument constructor*/ 
	public Student() {super();}
	/** Constructor for creating object Student with parameters
	 * 
	 * @param secondName surname of student
	 * @param firstName name of student
	 * @param id unique ID of student
	 * @param degree degree of student
	 * @param faculty faculty of student
	 * @param yearOfStudy year of study of student
	 * @param speciality speciality of student
	 */
	public Student(String secondName, String firstName, int id) {
		super(secondName, firstName, id);
	}
	public Student(String secondName, String firstName, int id,
			Degree degree, Faculty faculty, int yearOfStudy, Speciality speciality) {
		super(firstName, secondName, id);
		this.yearOfStudy = yearOfStudy;
		this.degree = degree;
		this.faculty = faculty;
		this.speciality = speciality;
		transcript = new Transcript();
		courses = new HashMap<Course, CourseStatus>(); 
	}
	/**
	 * Returns degree of student
	 * @return Degree
	 */
    public Degree getDegree() {	return degree; }
    /**
     * Update the value of the field degree
     * @param degree new degree for student
     */
    public void setDegree(Degree degree) {  this.degree = degree; }
    /** 
     * Returns faculty of students
     * @return Faculty
     */
	public Faculty getFaculty() { return faculty; }
    /**
     * Update the value of the field faculty
     * @param faculty new faculty for student
     */
	public void setFaculty(Faculty faculty) {  this.faculty = faculty; }
	/**
	 * Returns year of study of student
	 * @return integer 
	 */
	public int getYearOfStudy() { return yearOfStudy; }
	/**
	 * Update the value of the field year of study
	 * @param yearOfStudy new year of study for student
	 */
	public void setYearOfStudy(int yearOfStudy) {  this.yearOfStudy = yearOfStudy;   }
	/**
	 * Returns specility of student
	 * @return Speciality
	 */
	public Speciality getSpeciality() { return speciality; }
	/**
	 * Update the value of the field speciality 
	 * @param speciality new speciality for student
	 */
	public void setSpeciality(Speciality speciality) {  this.speciality = speciality;   }
	/**
	 * Returns courses of student with their statuses, which are FINISHED or CURRENT
	 * @return HashMap with key Course and value CourseStatus
	 */
    public HashMap<Course, CourseStatus> getCourses() { return courses; }
    /**
     * Returns the limit of credits
     * @return integer number of credits
     */
    public static int getLimitOfCredits() {  return limitOfCredits;   }
    /**
     * Update the value of field limit of credits
     * @param limitOfCredits new number of credits
     */
	public static void setLimitOfCredits(int limitOfCredits) {  Student.limitOfCredits = limitOfCredits;  }
    /**
     * Returns transcript of student
     * @return Transcript, which consists of HashMap of Student courses, Attestation and overall GPA
     */
    public Transcript viewTranscript() { return transcript; }
    /** 
     * Used to view the marks of a particular course of student 
     * @param course student chooses particular course to view marks
     * @return Attestation of the course with marks of 1st, 2nd attestations and final*/
    public Attestation viewMarks(Course course) {
    	Attestation a = null;
        for(HashMap.Entry<Course, Attestation> entry: transcript.getJournal().entrySet()) {
        	if(entry.getKey().equals(course)) 
        		a = entry.getValue();
        }
        return a;
    }
	/** 
     * Used to view all current courses of student
     * @return ArrayList that stores current courses*/
    public ArrayList<Course> viewCurrentCourses() {
    	ArrayList<Course> currentCourses = new ArrayList<>();
    	for(HashMap.Entry<Course, CourseStatus> entry: this.getCourses().entrySet()) { 
    		if(entry.getValue() == CourseStatus.CURRENT)
    			currentCourses.add(entry.getKey());
    	}
        return currentCourses;
    }
    /** 
     * Used to view the files of a particular course 
     * @param course student chooses particular course to view its files
     * @return ArrayList that stores the files of the course */
    public ArrayList<File> viewFilesOfCourse(Course course) { return course.getFiles(); }
    /**
     * Used to view information about teacher of a particular course 
     * @param course student chooses particular course to view information about teacher
     * @return String of teacher second name and first name
     */
    public String infoAboutTeacher(Course course) {
    	return "Teacher: " + course.getTeacher().getSecondName() + " " +  course.getTeacher().getFirstName();
    }
    /**
     * Used to know whether the course finished or not. This method is used in the {@link registerForCourse}
     * @param course particular course that should be checked 
     * @return boolean if course is finished, return true and if not finished return false 
     */
    public boolean isCourseFinished(Course course) {
    	for(HashMap.Entry<Course, CourseStatus> entry: this.getCourses().entrySet()) { 
    		if (entry.getKey().equals(course.getPrerequisite()) && entry.getValue() == CourseStatus.FINISHED) 
    			return true; 
    	}
    	return false;
    }
    /**
     * Used to register a student for a particular course
     * @param course student chooses particular course for registration
     * @throws ExcessOfCreditsException - to avoid an error if the student chooses more courses than it should
     */
    public void registerForCourse(Course course) throws ExcessOfCreditsException{
    	int numberOfCredits = 0;
    	if (this.isCourseFinished(course)) {
		    for(HashMap.Entry<Course, CourseStatus> entry1: this.getCourses().entrySet())
		   		numberOfCredits += entry1.getKey().getNumberOfCredits();
		   	if (numberOfCredits + course.getNumberOfCredits() <= limitOfCredits) {
		   		this.courses.put(course, CourseStatus.CURRENT);
	    		course.getStudentsOfCourse().add(this);
	    		Attestation newAtt = new Attestation();
	            transcript.addToJournal(course, newAtt);
	    	} else 
		   		throw new ExcessOfCreditsException("You have chosen more courses than you can."); }
    	}
    /**
     * Returns information about student
     * @return String
     */
	public String toString() {
		return super.toString() + "Student [degree=" + degree + ", faculty=" + faculty + ", yearOfStudy=" + yearOfStudy + ", transcript="
				+ transcript +  ", speciality=" + speciality + "]";
	}
	/**
	 * Used to update particular fields of Student
	 */
	public void updateInfo() {UserOperation.updateStudentInfo(this);}
	/**
	 * Menu of student with different options
	 */
	public void userController() {
		StudentController studentController = new StudentController(this);
		try {
			studentController.studentMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}

