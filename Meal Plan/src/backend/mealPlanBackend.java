package backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class mealPlanBackend {
	
	static Map<String, int[]> masterList = new TreeMap<>();
	
	
	
	public static void main(String[] args) throws IOException {
		int totalCarbs = 0;
		int totalFat = 0;
		int totalProtein = 0;
		int totalCalories = 0;
		while (true) {
			Scanner macroScanner = new Scanner(System.in);
			System.out.println("Enter the name of the item: ");
			String nameOfItem = macroScanner.nextLine();
			//TODO: Conditionals
			if (masterList.containsKey(nameOfItem)) {
				totalCarbs += masterList.get(nameOfItem)[0];
				totalFat += masterList.get(nameOfItem)[1];
				totalProtein += masterList.get(nameOfItem)[2];
				totalCalories += masterList.get(nameOfItem)[3];
			} else {
				System.out.println("Enter amount of carbs: ");
				int carbs = Integer.parseInt(macroScanner.nextLine());
				System.out.println("Enter amount of fat: ");
				int fat = Integer.parseInt(macroScanner.nextLine());
				System.out.println("Enter amount of protein: ");
				int protein = Integer.parseInt(macroScanner.nextLine());
				System.out.println("Enter amount of calories: ");
				int calories = Integer.parseInt(macroScanner.nextLine());
				
				int[] curMacros = new int[] {carbs, fat, protein, calories};
				
				masterList.put(nameOfItem, curMacros);
				addToFile(nameOfItem, curMacros);
				
				totalCarbs += carbs;
				totalFat += fat;
				totalProtein += protein;
				totalCalories += calories;
				
			}
			System.out.println("Total carbs: " + totalCarbs);
			System.out.println("Total fat: " + totalFat);
			System.out.println("Total protein: " + totalProtein);
			System.out.println("Total calories: " + totalCalories);

		}

	}
	
	private static void addToFile(String itemName, int[] curMacros) throws IOException {
		String filePath = "C:\\Users\\matth\\Desktop\\Projects\\mealplan\\log.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
		
		String carbString = Integer.toString(curMacros[0]);
		String fatString = Integer.toString(curMacros[1]);
		String proteinString = Integer.toString(curMacros[2]);
		String calorieString = Integer.toString(curMacros[3]);
		
		writer.append(itemName + " " + carbString + " " + fatString + " " + 
		proteinString + " " + calorieString);
		
	    writer.close();
	}
	
	private static void updateMasterList() throws FileNotFoundException {
		String filePath = "C:\\Users\\matth\\Desktop\\Projects\\mealplan\\log.txt";
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String curLine = scanner.nextLine();
			String[] splitLine = curLine.split(" ");
			String itemName = splitLine[0];
			int carbs = Integer.parseInt(splitLine[1]);
			int fat = Integer.parseInt(splitLine[2]);
			int protein = Integer.parseInt(splitLine[3]);
			int calories = Integer.parseInt(splitLine[4]);
			masterList.put(itemName, new int[] {carbs, fat, protein, calories});
		}
		
		scanner.close();
		
	}

}
