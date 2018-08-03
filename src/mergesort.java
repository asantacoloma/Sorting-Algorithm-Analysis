//Alejandro Santacoloma
//COP3530
//Project 2, Sorting Analysis

//mergesort class obtained from http://www.java2novice.com/java-sorting-algorithms/merge-sort/

public class mergesort {



    private int[] array;
    private int[] tempMergArr;
    private int length;


    //method implementing mergesort algorithm to sort an array of ints, given initial lower index of 0, higher index of length of array - 1
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        //call on domergesort method
        domergesort(0, length - 1);
    }

     void domergesort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {

            //identify middle index value of array
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;

            //Recursive call to sort the left side of the array
            domergesort(lowerIndex, middle);

            // Recursve call to sort the right side of the array
            domergesort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    // Method to combine and sort arrays or parts
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        // Continue comparing ints at index i and j with each other until i reaches middle of array (end of left half of array) or j reaches end of right half of array
        while (i <= middle && j <= higherIndex) {

            // If temporary array at index i is less than int at index j of same array, place int in index i to next spot k in combined array
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                // If temporary array at index i is not less than int at index j of same array, place int in index j to next spot k in combined array

                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        //if there are any remaining ints in the left half of the temporary array, place them in the final array
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
}