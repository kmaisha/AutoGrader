import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	private ArrayList<String> dictionary = new ArrayList<>();
	Scanner console = null;
	File file = null;
	int vocabSize = 0;
	int size = dictionary.size();


	public boolean loadDictionaryFromFile(String filePath){
		file = new File (filePath);
		try {	
			
			console = new Scanner (file);
			for(vocabSize = 0; console.hasNext(); vocabSize++){
				String wordList = console.next();
				dictionary.add(vocabSize, wordList);
				
			}
			size = vocabSize;
			console.close();
			return true;
		}
		catch(FileNotFoundException e){
			//e.printStackTrace();
			return false;
		}
	}
	
	public int getVocabularySize(){
		return vocabSize;
	}

	public boolean isWord(String word){
		//TA Bryan aided me with this section of the code
		for(int i = 0; i < size; i++){
			//For the if condition, used Stackflow as a reference.
			if (dictionary.get(i).equalsIgnoreCase(word.toLowerCase())){
				return true;
			}	
		}
		return false;
	}
}
