import java.io.*;
import java.util.ArrayList;
public class DataAnalyzer {

    public int linearSearch(ArrayList<Integer> numbers, int target){
        int index = 0;
        while(index<numbers.size()){
            if(numbers.get(index) == target){
                return index;
            }
            index++;

        }
    return -1;
    }
    public static int binarySearch(ArrayList<Integer> numbers, int target){
        int min = 0;
        int max = numbers.size() - 1;

        while(min < max){
            int middleIndex = (int) Math.floor((max+min) / 2);
            if(numbers.get(middleIndex).equals(target)){
                return middleIndex;
            }
            else if(target > numbers.get(middleIndex)){
                min = middleIndex + 1;
            }
            else{
                max = middleIndex - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = FileOperator.getIntList("nums.txt");
        // Calculate time
    long startTime = System.nanoTime(); 
    int result = binarySearch(a, 10); 
    long endTime = System.nanoTime(); 



// Display time in nanoseconds and milliseconds 
    long duration = endTime - startTime; 
    System.out.println("Time taken: " + duration + " nanoseconds"); 
    System.out.println("Time taken: " + (duration / 1000000.0) + " milliseconds");
    }

}
