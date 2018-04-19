import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GraduateStudent extends Student{
	private String major;
	private String advisor;
	File file = null;
	PrintWriter writerGStudent= null;
	
	public GraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major, String advisor) {
		super(name, id, essay, errorList);
		this.major = major;	
		this.advisor = advisor;
	}
	
	
	public String getMajor(){
		return major;
	}
	public void setMajor(String major){
		this.major = major;
	}

	public String getAdvisor(){
		return advisor;
	}
	public void setAdvisor(String advisor){
		this.advisor = advisor;
	}

	@Override
	void writeToFile() {
		// TODO Auto-generated method stub
	
		file = new File (getId() + "_graded.txt");
		
		try{
			
			writerGStudent = new PrintWriter (file);
			writerGStudent.println("Graduate Student " + this.getName() + "\nStudent ID: " + this.getId() 
									+ "\nMajor: " +this.getMajor() + "\nAdvisor: " + this.getAdvisor() + "\n" + this.getPrintableErrorList());
			writerGStudent.close();
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	
}

