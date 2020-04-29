import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class QAStorage {

	//The first 5 HashMaps under this comment are the maps that store the questions for each category
	//Ex. USQ stores the questions under the US history category. <pointValue, question>
	//**NOTE**: ALL questions MUST end in a "?" in order to be compatible with our reliability tests in SoftwareTests.java 
	public static HashMap<Integer, String> USQ = new HashMap<Integer, String>();
	public static HashMap<Integer, String> UMD = new HashMap<Integer, String>();
	public static HashMap<Integer, String> CS = new HashMap<Integer, String>();
	public static HashMap<Integer, String> GEO = new HashMap<Integer, String>();
	public static HashMap<Integer, String> MOV = new HashMap<Integer, String>();
	
	//The first 5 HashMaps under this comment are the answers that can be selected by the player for each of the 5 questions in the US History category
	//Ex. US1A stores the possible answers to the 100-point question in US History. <index (1-4), answer>
	public static HashMap<Integer, String> US1A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> US2A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> US3A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> US4A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> US5A = new HashMap<Integer, String>();
	
	//The first 5 HashMaps under this comment are the answers that can be selected by the player for each of the 5 questions in the UMASS Dartmouth category
	public static HashMap<Integer, String> UMD1A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> UMD2A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> UMD3A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> UMD4A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> UMD5A = new HashMap<Integer, String>();
	
	//The first 5 HashMaps under this comment are the answers that can be selected by the player for each of the 5 questions in the Computer Science category
	public static HashMap<Integer, String> CS1A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> CS2A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> CS3A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> CS4A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> CS5A = new HashMap<Integer, String>();
	
	//The first 5 HashMaps under this comment are the answers that can be selected by the player for each of the 5 questions in the Geography category
	public static HashMap<Integer, String> GEO1A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> GEO2A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> GEO3A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> GEO4A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> GEO5A = new HashMap<Integer, String>();
	
	//The first 5 HashMaps under this comment are the answers that can be selected by the player for each of the 5 questions in the Movies category
	public static HashMap<Integer, String> MOV1A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> MOV2A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> MOV3A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> MOV4A = new HashMap<Integer, String>();
	public static HashMap<Integer, String> MOV5A = new HashMap<Integer, String>();
	
	//These last 5 HashMaps reflect the CORRECT answer for each of the questions in each category.
	//Ex. USA stores the correct answers for the US History category. <pointValue, question>
	public static HashMap<Integer, String> USA = new HashMap<Integer, String>();
	public static HashMap<Integer, String> UMDA = new HashMap<Integer, String>();
	public static HashMap<Integer, String> CSA = new HashMap<Integer, String>();
	public static HashMap<Integer, String> GEOA = new HashMap<Integer, String>();
	public static HashMap<Integer, String> MOVA = new HashMap<Integer, String>();

	//This method takes the selected answer and checks to see if it matches the correct answer
	public static boolean isAnswerCorrect(String correct, String ans) {
		if(ans.equals(correct)) {
			return true;
		}
		return false;
	}
	
	//Method to load the input.txt file into HashMaps for questions and answers
	
	//Format of the input.txt file goes from each question, top to bottom and from each category, left to right
	//Question
	//Possible Answer
	//Possible Answer
	//Possible Answer
	//Possible Answer
	//.... for all questions and possible answers
	//After all 25 questions and possible answers are in the file, the CORRECT answers are stored (duplicate of one of the possible answers)
	public static void read(File f) {	

		try {
			Scanner s = new Scanner(f);
			
			USQ.put(100, s.nextLine());
			US1A.put(1, s.nextLine());
			US1A.put(2, s.nextLine());
			US1A.put(3, s.nextLine());
			US1A.put(4, s.nextLine());
			
			USQ.put(200, s.nextLine());
			US2A.put(1, s.nextLine());
			US2A.put(2, s.nextLine());
			US2A.put(3, s.nextLine());
			US2A.put(4, s.nextLine());
			
			USQ.put(300, s.nextLine());
			US3A.put(1, s.nextLine());
			US3A.put(2, s.nextLine());
			US3A.put(3, s.nextLine());
			US3A.put(4, s.nextLine());
			
			USQ.put(400, s.nextLine());
			US4A.put(1, s.nextLine());
			US4A.put(2, s.nextLine());
			US4A.put(3, s.nextLine());
			US4A.put(4, s.nextLine());
			
			USQ.put(500, s.nextLine());
			US5A.put(1, s.nextLine());
			US5A.put(2, s.nextLine());
			US5A.put(3, s.nextLine());
			US5A.put(4, s.nextLine());
			
			UMD.put(100, s.nextLine());
			UMD1A.put(1, s.nextLine());
			UMD1A.put(2, s.nextLine());
			UMD1A.put(3, s.nextLine());
			UMD1A.put(4, s.nextLine());
			
			UMD.put(200, s.nextLine());
			UMD2A.put(1, s.nextLine());
			UMD2A.put(2, s.nextLine());
			UMD2A.put(3, s.nextLine());
			UMD2A.put(4, s.nextLine());
			
			UMD.put(300, s.nextLine());
			UMD3A.put(1, s.nextLine());
			UMD3A.put(2, s.nextLine());
			UMD3A.put(3, s.nextLine());
			UMD3A.put(4, s.nextLine());
			
			UMD.put(400, s.nextLine());
			UMD4A.put(1, s.nextLine());
			UMD4A.put(2, s.nextLine());
			UMD4A.put(3, s.nextLine());
			UMD4A.put(4, s.nextLine());
			
			UMD.put(500, s.nextLine());
			UMD5A.put(1, s.nextLine());
			UMD5A.put(2, s.nextLine());
			UMD5A.put(3, s.nextLine());
			UMD5A.put(4, s.nextLine());
			
			CS.put(100, s.nextLine());
			CS1A.put(1, s.nextLine());
			CS1A.put(2, s.nextLine());
			CS1A.put(3, s.nextLine());
			CS1A.put(4, s.nextLine());
			
			CS.put(200, s.nextLine());
			CS2A.put(1, s.nextLine());
			CS2A.put(2, s.nextLine());
			CS2A.put(3, s.nextLine());
			CS2A.put(4, s.nextLine());
			
			CS.put(300, s.nextLine());
			CS3A.put(1, s.nextLine());
			CS3A.put(2, s.nextLine());
			CS3A.put(3, s.nextLine());
			CS3A.put(4, s.nextLine());
			
			CS.put(400, s.nextLine());
			CS4A.put(1, s.nextLine());
			CS4A.put(2, s.nextLine());
			CS4A.put(3, s.nextLine());
			CS4A.put(4, s.nextLine());
			
			CS.put(500, s.nextLine());
			CS5A.put(1, s.nextLine());
			CS5A.put(2, s.nextLine());
			CS5A.put(3, s.nextLine());
			CS5A.put(4, s.nextLine());
			
			GEO.put(100, s.nextLine());
			GEO1A.put(1, s.nextLine());
			GEO1A.put(2, s.nextLine());
			GEO1A.put(3, s.nextLine());
			GEO1A.put(4, s.nextLine());
			
			GEO.put(200, s.nextLine());
			GEO2A.put(1, s.nextLine());
			GEO2A.put(2, s.nextLine());
			GEO2A.put(3, s.nextLine());
			GEO2A.put(4, s.nextLine());
			
			GEO.put(300, s.nextLine());
			GEO3A.put(1, s.nextLine());
			GEO3A.put(2, s.nextLine());
			GEO3A.put(3, s.nextLine());
			GEO3A.put(4, s.nextLine());
			
			GEO.put(400, s.nextLine());
			GEO4A.put(1, s.nextLine());
			GEO4A.put(2, s.nextLine());
			GEO4A.put(3, s.nextLine());
			GEO4A.put(4, s.nextLine());
			
			GEO.put(500, s.nextLine());
			GEO5A.put(1, s.nextLine());
			GEO5A.put(2, s.nextLine());
			GEO5A.put(3, s.nextLine());
			GEO5A.put(4, s.nextLine());
			
			MOV.put(100, s.nextLine());
			MOV1A.put(1, s.nextLine());
			MOV1A.put(2, s.nextLine());
			MOV1A.put(3, s.nextLine());
			MOV1A.put(4, s.nextLine());
			
			MOV.put(200, s.nextLine());
			MOV2A.put(1, s.nextLine());
			MOV2A.put(2, s.nextLine());
			MOV2A.put(3, s.nextLine());
			MOV2A.put(4, s.nextLine());
			
			MOV.put(300, s.nextLine());
			MOV3A.put(1, s.nextLine());
			MOV3A.put(2, s.nextLine());
			MOV3A.put(3, s.nextLine());
			MOV3A.put(4, s.nextLine());
			
			MOV.put(400, s.nextLine());
			MOV4A.put(1, s.nextLine());
			MOV4A.put(2, s.nextLine());
			MOV4A.put(3, s.nextLine());
			MOV4A.put(4, s.nextLine());
			
			MOV.put(500, s.nextLine());
			MOV5A.put(1, s.nextLine());
			MOV5A.put(2, s.nextLine());
			MOV5A.put(3, s.nextLine());
			MOV5A.put(4, s.nextLine());
			
			USA.put(1, s.nextLine());
			USA.put(2, s.nextLine());
			USA.put(3, s.nextLine());
			USA.put(4, s.nextLine());
			USA.put(5, s.nextLine());
			
			UMDA.put(1, s.nextLine());
			UMDA.put(2, s.nextLine());
			UMDA.put(3, s.nextLine());
			UMDA.put(4, s.nextLine());
			UMDA.put(5, s.nextLine());
			
			CSA.put(1, s.nextLine());
			CSA.put(2, s.nextLine());
			CSA.put(3, s.nextLine());
			CSA.put(4, s.nextLine());
			CSA.put(5, s.nextLine());
			
			GEOA.put(1, s.nextLine());
			GEOA.put(2, s.nextLine());
			GEOA.put(3, s.nextLine());
			GEOA.put(4, s.nextLine());
			GEOA.put(5, s.nextLine());
			
			MOVA.put(1, s.nextLine());
			MOVA.put(2, s.nextLine());
			MOVA.put(3, s.nextLine());
			MOVA.put(4, s.nextLine());
			MOVA.put(5, s.nextLine()); 
			
			s.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
}
