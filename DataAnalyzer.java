import java.io.*;
import java.util.ArrayList;
public class DataAnalyzer {

    public static int linearSearch(ArrayList<Integer> numbers, int target){
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

    public static int reverseList(ArrayList<Integer> numbers, int target){
        int left = 0;
        int right = numbers.size() - 1;

        while(left<right){
            Integer left_side = numbers.get(left);
            numbers.set(left, numbers.get(right));
            numbers.set(right, left_side);

            left++;
            right--;
        }
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i).equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = FileOperator.getIntList("nums.txt");
        // Calculate time
    long startTime = System.nanoTime(); 
    // int result = binarySearch(a, 7); 
    // int result = linearSearch(a, 7);
    int result = reverseList(a, 7);

    long endTime = System.nanoTime(); 

    if(result != -1){
        System.out.println("Location: " + result);
    }
    else{
        System.out.println("Not found");
    }



// Display time in nanoseconds and milliseconds 
    long duration = endTime - startTime; 
    System.out.println("Time taken: " + duration + " nanoseconds"); 
    System.out.println("Time taken: " + (duration / 1000000.0) + " milliseconds");
    }

}
