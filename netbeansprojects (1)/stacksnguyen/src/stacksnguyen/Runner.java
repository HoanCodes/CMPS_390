/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksnguyen;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Work Time
 */
public class Runner {
    public static void main(String[] args) {
        Runner programm = new Runner();
        programm.start();
    }

    public void start() {
        fileIn f;
        f = new fileIn();
    }
    public class Stack{
        String equation = "322+*";
        char[] eqArray = equation.toCharArray();
        
        char stack[] = new char[eqArray.length];
        
        int top = -1;
        
        public void push(char data){
            top++;
            stack[top]=data;
        }
        public char pop() {
            char data;
            data=stack[top];
            top--;
            return data;
        }
        public boolean isEmpty(){
            boolean isEmpty;
            if (top == -1) isEmpty = true;
            else isEmpty = false;
            return isEmpty;
        }
        public void reset(){
            top = -1;
        }
        public void showStack(){
            int j;

            System.out.println(" ");
            System.out.println("Stack contents ...");
            for(j=top;j>-1;j--) {
                System.out.println(stack[j]);
            }
            System.out.println(" ");
        }
        public void showStack0toTop(){
            int j;

            System.out.println(" ");
            System.out.println("Stack contents ...");
            for(j=0;j<=top;j++) {
                System.out.print(stack[j]);
            }
            System.out.println(" ");
	}
    }
    public class fileIn {
	String fname;

        public fileIn() {
            System.out.println("Constructor");
            getFileName();
            readFileContents();
        }

        public void readFileContents(){
            boolean looping;
            DataInputStream in;
            String line;
            int j, len;
            char ch;

            /* Read input from file and process. */
            try {
                in = new DataInputStream(new FileInputStream(fname));

                looping = true;
                while(looping) {
                    /* Get a line of input from the file. */
                    if (null == (line = in.readLine())) {
                        looping = false;
                        /* Close and free up system resource. */
                        in.close();
                    }
                    else {
                        System.out.println("line = "+line);
                        j = 0;
                        len = line.length();
                        for(j=0;j<len;j++){
                            System.out.println("line["+j+"] = "+line.charAt(j));
                        }
                    }
                } /* End while. */
            } /* End try. */

            catch(IOException e) {
                System.out.println("Error " + e);
            } /* End catch. */
        }

        public void getFileName(){
            Scanner in = new Scanner(System.in);

            System.out.println("Enter file name please.");
            fname = in.nextLine();
            System.out.println("You entered "+fname);
        }
    }
}
