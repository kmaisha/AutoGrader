import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grader {
	private boolean available;
	private Student student;
	private Dictionary dict;
	private ArrayList<String> errorList;
	File file = null;
	Scanner console = null;
	
	
	public Grader(Dictionary dict){
		this.dict = dict;
		available = true;
		errorList = new ArrayList<String>();
	}

	public boolean gradeStudent(String fileName){
		String level;
		String name;
		String id;
		String schoolName;
		String major;
		String advisor;
		
		String wordCheck;
		String level1 = "HighSchool Student";
		String level2 = "UnderGraduate Student";
		String level3 = "Graduate Student";

		
		try {
			//
			file = new File (fileName + ".txt");
			console = new Scanner (file);
			level = console.nextLine();
			name = console.nextLine();
			id = console.nextLine();
			//Received help from student named Daniel Tymecki for the selection type  
			if(level.equalsIgnoreCase(level1)){
				schoolName = console.nextLine();
				for(int i = 0; console.hasNext(); i++){
					wordCheck = console.next();
					//TA Bryan's suggestion on how to check each word
					//Used Stackflow as a reference to remove punctuation
					if(!dict.isWord(wordCheck.replaceAll("[^a-zA-Z\\-']", ""))){
						errorList.add(wordCheck.replaceAll("[^a-zA-Z\\-']", ""));
					}
				}
				student = new HighSchoolStudent (name,id,file.toString(),errorList, schoolName);
				
			}
			//Received help from student named Daniel Tymecki for the selection type  
			else if(level.equalsIgnoreCase(level2)){
				major = console.nextLine();
				for(int i = 0; console.hasNext(); i++){
					wordCheck = console.next();
					//TA Bryan's suggestion on how to check each word
					//Used Stackflow as a reference to remove punctuation
					if(!dict.isWord(wordCheck.replaceAll("[^a-zA-Z\\-']", ""))){
						errorList.add(wordCheck.replaceAll("[^a-zA-Z\\-']", ""));
					}
				}
				student = new UndergraduateStudent (name,id,file.toString(),errorList, major);

			}
			//Received help from student named Daniel Tymecki for the selection type  
			else if(level.equalsIgnoreCase(level3)){
				major = console.nextLine();
				advisor = console.nextLine();
				for(int i = 0; console.hasNext();i++){
					wordCheck = console.next();
					//TA Bryan's suggestion on how to check each word
					//Used Stackflow as a reference to remove punctuation
					if(!dict.isWord(wordCheck.replaceAll("[^a-zA-Z\\-']", ""))){
						errorList.add(wordCheck.replaceAll("[^a-zA-Z\\-']", "")); 
					}
				}
				student = new GraduateStudent (name,id,file.toString(),errorList, major, advisor);
			
			}
			console.close();
			available = false;
			return true;
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean isAvailable(){
		return available;
	}

	public Student getStudent(){
		return student;
	}
	
	public void reset(){
		available = true;
		student = null;
		errorList.clear();
		
	}


}
