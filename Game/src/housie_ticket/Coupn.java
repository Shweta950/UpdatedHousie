package housie_ticket;

import java.util.Arrays;
import java.util.Random;

public class Coupn {
	public int[][] getTicket() {
		Random randomGenerator = new Random();
		int min = 1, max = 9, row = 3, column = 9;
		int[][] tNumber = new int[row][column]; 
		for(int i = 0;i < column;i++) {
			if(i!=0) {
				min = max+1;
				max += 10;
			}
			System.out.println("col "+i);
			
			for(int j = 0;j < row;j++) {
				int[] randomNumbers = getRandomNumber(min ,max);
				int rn = randomNumbers[(randomGenerator.nextInt(randomNumbers.length))];
				
				if(!Arrays.deepToString(tNumber).contains(rn+"")) {
					tNumber[j][i] = rn;
					//System.out.println(tNumber[j][i]);
				}
				else {
					j--;
					//System.out.println(tNumber[j][i]+" T");
				}
			}
		}
		
		sortbyColumn(tNumber, column, row) ;
		for(int i = 0;i < row;i++) {
			String noSpace = "345";
			int noOfSpace = Character.getNumericValue(noSpace.charAt(randomGenerator.nextInt(noSpace.length())));
			System.out.println("noSpace "+noOfSpace);
			int oldIndex = 0;
		for(int k = 0;k < noOfSpace;k++) {
			int newIndex = randomGenerator.nextInt(9);
			if(oldIndex != newIndex || k == 0) {
				if(i==0 && tNumber[1][newIndex] == 0 && tNumber[2][newIndex] == 0) {
					k--;
				}
				else if(i==1 && tNumber[0][newIndex] == 0 && tNumber[2][newIndex] == 0) {
					k--;
				}
				else if(i==2 && tNumber[0][newIndex] == 0 && tNumber[1][newIndex] == 0) {
					k--;
				}
				else {
				System.out.println(i+" newIndex "+newIndex);
				oldIndex = newIndex;
				tNumber[i][newIndex] = 0;
				}
			}
			else {
				k--;
			}
		}
		}
		return tNumber;
	}

	public int[] getRandomNumber(int min ,int max) {
		//System.out.println(min+" rn :- "+max);
		int[] randomNumbers;
		if(min == 1) {
			randomNumbers =	new int[9];
		}
		else if(min == 80) {
			randomNumbers =	new int[11];
			max = max+1;
		} 
		else {
			randomNumbers = new int[10];
		}
		int j = 0;
		for(int i=min;i <= max;i++) {
			randomNumbers[j]= i;
			j++;
		}
		//System.out.println("rn :- "+Arrays.toString(randomNumbers));//.toString(randomNumbers));
		return randomNumbers;
	}
	
	// Function to sort by column 
    public void sortbyColumn(int arr[][], int col, int row) { 
    	for(int i=0;i < col;i++) {
    		int[] sCol = new int[row];
    		for(int j=0;j < row;j++) {
    			sCol[j]=arr[j][i];  
    		}
    		Arrays.sort(sCol);
    		for(int k=0;k < row;k++) {
    			arr[k][i] = sCol[k];  
    		}
    	}
    } 
    
    public void showTicket(int[][] tNumber) {
    	String ticket = "";
		for(int[] val1:tNumber) {
			for(int val:val1) {
				if(val == 0) {
				ticket += "|   ";		
				}
				else {
					ticket += "| "+val+" ";	
				}
			}
			ticket += "|\n";
		}
		System.out.println(ticket);
    }
	

}
