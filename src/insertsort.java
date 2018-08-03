//Alejandro Santacoloma
//COP3530
//Project 2, Sorting Analysis

//insert sort class obtained from http://www.java2novice.com/java-sorting-algorithms/insertion-sort/

public class insertsort {

    public static void main(String a[]){
        int[] arr1 = {10,34,2,56,7,67,88,42};
        int[] arr2 = doInsertSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
    }

    //method to sort array using insert sort
    public static int[] doInsertSort(int[] input){

        // initialize variable temp, temp is a variable to help in swapping integers in array
        int temp;

        //first for loop gets unsorted integer from array then compares to sorted portion of array using inner for loop
        for (int i = 1; i < input.length; i++) {

            for(int j = i ; j > 0 ; j--){

                //if the current j index is less than the earlier (j-1) index, swap places
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }

        //once out of both for loops, array is sorted in ascending order

        //return sorted array
        return input;
    }
}
