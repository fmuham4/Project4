import java.util.Scanner;

/*
 * @author Mark Hallenbeck
 * Copyright© 2014, Mark Hallenbeck, All Rights Reservered.
 */



/*
 *  0 7 8 9 2 14 5 4 15 11 1 12 6 13 3 10
	6 5 0 2 9 1 10 15 13 14 3 8 11 12 4 7
	14 11 7 15 3 5 2 12 10 1 8 6 13 4 9
	13 0 10 4 2 11 12 3 9 5 14 7 6 15 1
	8 15 10 4 12 11 14 6 5 2 1 13 0 3 7
	15 6 8 2 11 7 4 13 0 9 14 1 3 12 5
	0 4 15 1 13 2 3 8 12 14 6 11 9 10 5
	1 2 7 0 11 15 3 4 10 8 12 5 14 6 13 9
	15 12 3 10 5 6 8 1 14 9 11 4 0 13 2
	3 0 12 15 1 13 14 9 6 5 11 8 2 4 7
 */

/*
3 6 1 0 14 9 7 2 15 13 10 4 11 8 12
7 4 3 1 10 12 9 6 0 5 13 2 11 15 8
6 11 10 9 14 4 3 1 8 13 15 0 7 2 12
13 9 5 4 0 8 3 11 1 15 6 10 14 2 12
8 14 1 2 3 11 9 15 12 10 0 13 4 7 5
3 4 15 12 2 5 13 9 1 6 10 11 8 7 14
15 8 11 4 9 6 12 13 10 14 3 7 1 2 0
6 8 13 10 7 4 1 0 9 3 15 12 11 14 5
3 8 2 1 12 14 15 9 11 0 6 13 4 10 7
13 1 0 9 10 3 8 5 12 11 7 14 15 2 4
 */




public class UserInterface {

int[] puzzle;


	
	public UserInterface(){
		
//		int random_int = (int)Math.floor(Math.random()*(10-9+1)+1);
		
//		puzzle = copyPuz(puzzlesList[random_int]);
//		puzzle = puzzlesList[random_int];
		readInString();		//reads in the string from the user
		
		
		System.out.print("\nThis is the puzzle you entered\n");
		
		printArray();
	}

	/**
	 * Function reads in the string from the user and stores it as an int array
	 */
	public void readInString(){
		
		String puzzleEntered;
	
		System.out.println("Enter in your puzzle as a string with a space between each number");
		
		Scanner userInput = new Scanner(System.in);		//open scanner
		
		puzzleEntered = userInput.nextLine();					//scan in string
		
		puzzle = stringToIntArray(puzzleEntered);
		
		userInput.close();   	  						//close scanner
	}
	
	/**
	 * Function converts a string to an int array
	 * @param puzzle
	 * @return int array
	 */
	int[] stringToIntArray(String puzzle)
	{
		String[] values = puzzle.split("[ ]+");			//split string into array of strings(numbers)
		
		int[] intArray = new int[values.length];			//int array for converted strings
		
		for(int x = 0; x < intArray.length; x++)			//convert to int array
		{
			intArray[x] = Integer.parseInt(values[x]);
		}
		
		return intArray;
	}
	
	public void printArray(){
		
		for(int i =0; i<puzzle.length; i++)
			System.out.print(puzzle[i] + " ");
		
		System.out.print("\n\n");
		
	}
	
	public int[] getPuzzle(){
		return puzzle;
	}
	
	int[] copyPuz(int [] puz) {
		int[] cop = new int[puz.length];
		
		for(int x = 0; x < puz.length; x++)			//convert to int array
		{
			cop[x] = puz[x];
		}
		
		return cop;
	}

}
