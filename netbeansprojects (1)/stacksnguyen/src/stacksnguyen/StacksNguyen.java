/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksnguyen;

import java.util.Scanner;

import java.io.*;


public class StacksNguyen { 
    public static void main(String[] args) {
        StacksNguyen runner = new StacksNguyen();
        runner.start();
    }

    public void start() {
        fileIn f = new fileIn();
        
    }
    
    public class Stack{
        
    }
    public class fileIn {
	String fname;

        public fileIn() {
            getFileName();
            readFileContents();
        }

        public void readFileContents(){
            boolean looping;
            DataInputStream in;
            String line;
            int j, len;
            char ch;
            
            int x = 0;
            int y = 0;
            int z = 0;
            
            int probCount = 0;
            boolean parenTest = false;
            boolean pFixEq = false;
            boolean pFixToIFix = false;
            boolean fullSystem = false;
            
            boolean solveAddition = false;
            boolean solveSubtraction = false;
            boolean solveMultiplication = false;
            boolean solveDivision = false;

            /* Read input from file and process. */
            try {
                in = new DataInputStream(new FileInputStream(fname));
                
                System.out.println("File found!");

                looping = true;
                while(looping) {
                    /* Get a line of input from the file. */
                    if (null == (line = in.readLine())) {
                        looping = false;
                        /* Close and free up system resource. */
                        in.close();
                    }
                    else if (line.equals("parentheses tests")){
                        probCount = 0;
                        parenTest = true;
                        pFixEq = false;
                        pFixToIFix = false;
                        fullSystem = false;
                        System.out.println("Now testing parentheses count...");
                    }
                    else if (line.equals("postfix equation solving")){
                        probCount = 0;
                        parenTest = false;
                        pFixEq = true;
                        pFixToIFix = false;
                        fullSystem = false;
                        System.out.println("Now solving Postfix equations...");
                    }
                    else if (line.equals("infix to postfix conversion")){
                        probCount = 0;
                        parenTest = false;
                        pFixEq = false;
                        pFixToIFix = true;
                        fullSystem = false;
                        System.out.println("Now solving Postfix equations...");
                    }
                    else if (line.equals("full system check")){
                        probCount = 0;
                        parenTest = false;
                        pFixEq = false;
                        pFixToIFix = false;
                        fullSystem = true;
                        System.out.println("Now Activating Self-destruct Countdown Sequence...");
                    }
                    
                    else if (pFixEq == true){
                        System.out.println("stack reset");
                        init();
                        
                        for(int i = 0; i<line.length();i++){
                            
                            char c = line.charAt(i);
                            
                            if (Character.isDigit(c)){
                                System.out.println("Digit detected ("+(c)+")");
                                push(Character.getNumericValue(c));
                                System.out.println("Pushing "+stack[top]);
                            }
                            else if (c == '+'){
                                System.out.println("Additioning");
                                x = pop();
                                y = pop();
                                z = x+y;
                                push(z);
                            }
                            else if (c == '-'){
                                System.out.println("Additioning");
                                x = pop();
                                y = pop();
                                z = x-y;
                                push(z);
                            }
                            else if (c == '*'){
                                System.out.println("Additioning");
                                x = pop();
                                y = pop();
                                z = x*y;
                                push(z);
                            }
                            else if (c == '/'){
                                System.out.println("Additioning");
                                x = pop();
                                y = pop();
                                z = x/y;
                                push(z);
                            }
                        }
                        System.out.println("The summation is: "+(pop()));
                        
                    }
                    /* testing stuff out
                    else if (line.equals("addition problems")){
                        solveAddition = true;
                        solveSubtraction = false;
                        System.out.println("now solving additional problems");
                    }
                    
                    else if (line.equals("minus minus problems")){
                        solveAddition = false;
                        solveSubtraction = true;
                        System.out.println("now solving subtractional problems");
                    }
                    else if (solveAddition == true){
                        System.out.println("stack reset");
                        init();
                        
                        for(int i = 0; i<line.length();i++){
                            
                            char c = line.charAt(i);
                            
                            if (Character.isDigit(c)){
                                System.out.println("Digit detected ("+(c)+")");
                                push(Character.getNumericValue(c));
                                System.out.println("Pushing "+stack[top]);
                            }
                            else if (c == '+'){
                                System.out.println("Additioning");
                                System.out.println("Popping stack element = "+stack[top]);
                                x = pop();
                                System.out.println("Popping x = "+x);
                                
                                System.out.println("Popping stack element = "+stack[top]);
                                y = pop();
                                System.out.println("Popping y = "+y);
                                z = x+y;
                                push(z);
                            }                       
                        }
                        System.out.println("The summation is: "+(pop()));
                        
                    }
                    else if (solveSubtraction == true){
                        System.out.println("hehe");
                    }
                    was still testing stuff out */
                        
                        /*
                        System.out.println("line = "+line);
                        j = 0;
                        len = line.length();
                        for(j=0;j<len;j++){
                        System.out.println("line["+j+"] = "+line.charAt(j));
                         */
                        /*
                        if (line.equals("addition problems")){
                        System.out.println("Solving additional problems");
                        }
                        else{
                        System.out.println("nothing much here");
                        }
                         */
                        
                     
                    
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
              
        int top = -1;
        int[] stack = new int[20];
        
        public void push(int data){
            top++;
            stack[top]=data;
        }   
        public int pop() {
            int data;
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
        public void init(){
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
    }
}
