package com.mycompany.binaryfileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class BinaryFileIO {

    public static void main(String[] args) {
        int crn;
        float cgpa;
        Scanner sc = new Scanner(System.in);
        ObjectOutputStream oos;
        //Binary file output
        try {
            oos = new ObjectOutputStream(new FileOutputStream("student.dat"));
            System.out.println("Enter CRN and CGPA of 3 students:");
            for (int i = 0; i < 3; i++) {
                crn = sc.nextInt();
                cgpa = sc.nextFloat();
                oos.writeInt(crn);
                oos.writeFloat(cgpa);
            }
            oos.close();
        } catch (FileNotFoundException fnfe) {

            System.out.println("File doesn't exist at location!");
        } catch (IOException ioe) {
            System.out.println("File doesn't exist at location!");
        }
        //Binary File Input
        System.out.println("CRN \t CGPA");
        System.out.println("-------------------------");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"));
            for (int i = 0; i < 3; i++) {
                int dcrn = ois.readInt();
                float dcgpa = ois.readFloat();
                System.out.println(dcrn + "\t" + dcgpa);
            }
        } catch (IOException ioe) {
            System.out.println("IO Error occoured!");
        }
    }
}
