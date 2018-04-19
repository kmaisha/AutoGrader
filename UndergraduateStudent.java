import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UndergraduateStudent extends Student{
	private String major;
	File file = null;
	PrintWriter writerUGStudent= null;
	
	public UndergraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major) {
		super(name, id, essay, errorList);
		this.major = major;	
	}
	
	
	public String getMajor(){
		return major;
	}
	public void setMajor(String major){
		this.major = major;
	}


	@Override
	void writeToFile() {
		// TODO Auto-generated method stub
	
		file = new File (getId() + "_graded.txt");
		
		try{
			
			
			writerUGStudent = new PrintWriter (file);
			writerUGStudent.println("Undergraduate Student " + this.getName() + "\nStudent ID: " + this.getId() 
									+ "\nMajor: " + this.getMajor() + "\n" + this.getPrintableErrorList());
			writerUGStudent.close();
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	
}

