package data;

import java.io.File;
public class CourseFile {
    private String name;
    private File file;
    
    public CourseFile() {}
    public CourseFile(String name, File file) {
	this.name = name;
	this.file = file;
}
public String getName() {return name;}
public void setName(String name) {this.name = name;}
}