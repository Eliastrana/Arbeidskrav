import java.util.*;
//Establish class
class Gangetabell { 

    public static void main(String[]args)   {
        //Take input from user
        Scanner in = new Scanner(System.in);
        System.out.println("Velg første tall i intervallet: ");

        int input1=in.nextInt();

        System.out.println("Velg det andre tallet i intervallet: ");

        int input2=in.nextInt();
        //Making sure the first number is smaller than the second
        if(input1>input2) {
            System.out.println("Det første tallet måte være mindre enn det andre!"); 
        }
            //using the input to create an interval
            for(int p=input1; p<=input2;p++){ 
                //Printing the interval with text to create the title
                System.out.println(p+ "-gangen:");
                
                //Multiplying with all the numbers between 1-10
                for(int i=1; i <= 10; i++){
                    //Multiplying the input with the 1-10
                    int sum = p * i;
            //Printing the calculation + the result 
            System.out.println(p + " * " + i + " = " + sum);
            }       
        }
      

    }   

 }