//Alejandro Santacoloma
//COP3530
//Project 2, Sorting Analysis
//Sorting testing


import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class readandsort {


    public static int[] readfile(String filename){

        //array storing test case file names
        String Filenameslist[] = new String[12];
        Filenameslist[0] = "5Kascend.txt";
        Filenameslist[1] = "5Kdescend.txt";
        Filenameslist[2] = "5Krandom.txt";
        Filenameslist[3] = "10Kascend.txt";
        Filenameslist[4] = "10Kdescend.txt";
        Filenameslist[5] = "10Krandom.txt";
        Filenameslist[6] = "20Kascend.txt";
        Filenameslist[7] = "20Kdescend.txt";
        Filenameslist[8] = "20Krandom.txt";
        Filenameslist[9] = "50Kascend.txt";
        Filenameslist[10] = "50Kdescend.txt";
        Filenameslist[11] = "50Krandom.txt";

        //initialize file object named list
        File list = new File(filename);

        //initialize file scanner
        Scanner filescan = null;

        try {
            //set filescan to be a scanner object for list file
            filescan = new Scanner(list);

        }
        catch (IOException e) {

            System.out.println("something is wrong");
        }

        //initialize size variable as 0, size variable is the number of integers that are going to be read from a file
        int size = 0;

        //size variable is set to be the total number of integers that are going to be read from a file
        if (filename.equals(Filenameslist[9]) || filename.equals(Filenameslist[10]) || filename.equals(Filenameslist[11])) {
            size = 50000;

        } else if (filename.equals(Filenameslist[6]) || filename.equals(Filenameslist[7]) || filename.equals(Filenameslist[8])) {
            size = 20000;
        } else if (filename.equals(Filenameslist[3]) || filename.equals(Filenameslist[4]) || filename.equals(Filenameslist[5])) {
            size = 10000;
        } else if (filename.equals(Filenameslist[0]) || filename.equals(Filenameslist[1]) || filename.equals(Filenameslist[2])) {
            size = 5000;
        }

        //Initialize array named unsorted
        int[] unsorted = new int[size];


        int i = 0;
        //While loop to read all lines from file and store in array named unsorted
        while (filescan.hasNextInt() == true) {
            //start of while loop
            //get next int
            unsorted[i] = filescan.nextInt();

            i++;

        }

        return unsorted;
    }




    //Access, read, and store information in each file in an array, then call cort method and time, store times in a text file
    public static void main(String[] args) {


        String Filenameslist[] = new String[12];
        Filenameslist[0] = "5Kascend.txt";
        Filenameslist[1] = "5Kdescend.txt";
        Filenameslist[2] = "5Krandom.txt";
        Filenameslist[3] = "10Kascend.txt";
        Filenameslist[4] = "10Kdescend.txt";
        Filenameslist[5] = "10Krandom.txt";
        Filenameslist[6] = "20Kascend.txt";
        Filenameslist[7] = "20Kdescend.txt";
        Filenameslist[8] = "20Krandom.txt";
        Filenameslist[9] = "50Kascend.txt";
        Filenameslist[10] = "50Kdescend.txt";
        Filenameslist[11] = "50Krandom.txt";


        int[] unsorted;
        int[] sorted;

        long startTime = 0;
        long estimatedTime = 0;

        ArrayList timetrials = new ArrayList();

        int trial = 0;

        int i = 0;

        //while loop to read testcase, sort and time each case for sorting algorithms
        while(i < 12) {

            //repeat sort 5 times
            System.out.println(i);
            //insertionsort time trials

            //inner loop to test and record time for insertion sort five times

            trial = 0;
            while(trial < 5){
                unsorted = readfile(Filenameslist[i]); //read file and store information in array

                startTime = System.nanoTime(); // start timer
                sorted = insertsort.doInsertSort(unsorted); // call on insertion sort method
                estimatedTime = System.nanoTime() - startTime; //calculate elapsed time

                timetrials.add(estimatedTime);

                trial++;
            }


            // Mergesort time trials
            //inner loop to test and record time for merge sort five times
            trial = 0;
            while(trial < 5){
                unsorted = readfile(Filenameslist[i]); // read file and store information in array

                mergesort mms = new mergesort();

                startTime = System.nanoTime();//start timer
                mms.sort(unsorted); //call on merge sort method
                estimatedTime = System.nanoTime() - startTime; //calculate elapsed time

                timetrials.add(estimatedTime);

                trial++;
            }

            i++;
        }

        //array storing test case names
        String timetrialnames[] = new String[24];
        timetrialnames[0] = "5Kascend insert sort";
        timetrialnames[1] = "5Kascend merge sort";
        timetrialnames[2] = "5Kdescend insert sort";
        timetrialnames[3] = "5Kdescend merge sort";
        timetrialnames[4] = "5Krandom insert sort";
        timetrialnames[5] = "5Krandom merge sort";
        timetrialnames[6] = "10Kascend insert sort";
        timetrialnames[7] = "10Kascend merge sort";
        timetrialnames[8] = "10Kdescend insert sort";
        timetrialnames[9] = "10Kdescend merge sort";
        timetrialnames[10] = "10Krandom insert sort";
        timetrialnames[11] = "10Krandom merge sort";
        timetrialnames[12] = "20Kascend insert sort";
        timetrialnames[13] = "20Kascend merge sort";
        timetrialnames[14] = "20Kdescend insert sort";
        timetrialnames[15] = "20Kdescend merge sort";
        timetrialnames[16] = "20Krandom insert sort";
        timetrialnames[17] = "20Krandom merge sort";
        timetrialnames[18] = "50Kascend. insert sort";
        timetrialnames[19] = "50Kascend merge sort";
        timetrialnames[20] = "50Kdescend insert sort";
        timetrialnames[21] = "50Kdescend merge sort";
        timetrialnames[22] = "50Krandom insert sort";
        timetrialnames[23] = "50Krandom merge sort";


        try {

            // create a new writer
            File timefile = new File("timetrials.txt");

            PrintWriter pw = new PrintWriter(timefile);

            // print times
            int line = 0;
            int test = 0;

            // Print time trial name in runtime data file
            pw.println(timetrialnames[0]);

            while (line < 120) {
                test = 0;
                // Get runtime stored in timetrials array and print in runtime data file
                pw.println(timetrials.get(line));

                // while loop checks what line currently printing on, if printing on a specific line, prints testcase title in runtime file so runtime data is organized
                while(test < 24){
                    if(line == (test*5)-1){
                        pw.println(timetrialnames[test]);
                        break;
                    }
                    test++;
                }

                line++;
            }
            // close print writer object
            pw.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
