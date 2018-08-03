//Alejandro Santacoloma
//COP3530
//Project 2, Sorting Analysis
//Test case generator

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class testcasegenerator {
    public static void testcasemaker( int file){
		BufferedWriter bw = null;
		FileWriter fw = null;

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

		int Filerangelist[] = new int[12];
		Filerangelist[0] = 5000;
		Filerangelist[1] = 5000;
		Filerangelist[2] = 5000;
		Filerangelist[3] = 10000;
		Filerangelist[4] = 10000;
		Filerangelist[5] = 10000;
		Filerangelist[6] = 20000;
		Filerangelist[7] = 20000;
		Filerangelist[8] = 20000;
		Filerangelist[9] = 50000;
		Filerangelist[10] = 50000;
		Filerangelist[11] = 50000;

		int range = Filerangelist[file];

		int order[] = new int[12];
		order[0] = 0;
		order[1] = 1;
		order[2] = 2;
		order[3] = 0;
		order[4] = 1;
		order[5] = 2;
		order[6] = 0;
		order[7] = 1;
		order[8] = 2;
		order[9] = 0;
		order[10] = 1;
		order[11] = 2;


		try{
			fw = new FileWriter(Filenameslist[file]);
			bw = new BufferedWriter(fw);

			//Create file in ascending order with numbers from 1 to size of range
			if(order[file] == 0) {
				int i = 1;
				while (i <= range) {

					bw.write(Integer.toString(i));
					bw.write("\n");
					i++;
				}
			}
			//Create file in descending order with numbers from size of range to 1
			else if(order[file] == 1) {
				int i = range;
				while (i > 0 ) {

					bw.write(Integer.toString(i));
					bw.write("\n");
					i--;
				}
			}
			//Create file in random order with numbers from size of range to 1
			else if(order[file] == 2) {
				int temparray[] = new int[range];
				int i = 0;
				while (i < range ) {

					temparray[i] = i+1;
					i++;
				}
				i = 0;
				while(i < range - 500){
					Random r = new Random();
					int rand = r.nextInt(499);
					int tempitem = temparray[i];
					temparray[i] = temparray[i + rand];
					temparray[i+rand] = tempitem;
					i++;
				}

				//randomize order again
				i = range - 1;
				while(i > 500){
					Random r = new Random();
					int rand = r.nextInt(499);
					rand = rand*-1;
					int tempitem = temparray[i];
					temparray[i] = temparray[i + rand];
					temparray[i+rand] = tempitem;
					i--;
				}
				//print out newly shuffled array
				i = 0;

				while(i < range) {
					bw.write(Integer.toString(temparray[i]));
					bw.write("\n");
					i++;
				}
			}




			System.out.println(Filenameslist[file]);
		}  catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}
	}



    public static void main(String[] args) {
		//create 12 text files for all the specified test cases
    	int i = 0;
		while(i<12) {
			testcasemaker(i);
			i++;
		}
    }

}

