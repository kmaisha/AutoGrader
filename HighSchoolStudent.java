import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HighSchoolStudent extends Student{
	private String nameOfSchool;
	File file = null;
	PrintWriter writerHSStudent= null;
	
	public HighSchoolStudent(String name, String id, String essay, ArrayList<String> errorList, String nameOfSchool) {
		super(name, id, essay, errorList);
		this.nameOfSchool = nameOfSchool;	
	}
	
	
	public String getSchoolName(){
		return nameOfSchool;
	}
	public void setSchoolName(String schoolName){
		nameOfSchool = schoolName;
	}


	@Override
	void writeToFile() {
		// TODO Auto-generated method stub
	
		file = new File (getId() + "_graded.txt");
		
		try{
			
			writerHSStudent = new PrintWriter (file);
			writerHSStudent.println("High School Student " + this.getName() + "\nStudent ID: " + this.getId() 
									+ "\nSchool Name: " + this.getSchoolName() + "\n" + this.getPrintableErrorList());
			writerHSStudent.close();
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	
}

