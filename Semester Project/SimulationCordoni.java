/*
 * 
 * Semester Project
 * Due Date and Time: 12/15/21 before 12:00am 
 * Purpose: to devolp a simulation testing program for covid screenings
 * Input: The user will be inputting a population number to test the simulation on
 * Output: The program will output the infection rate of the population
 * @author Shannon Cordoni 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class SimulationCordoni {

    //Declare keyboard 
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {

        
        //output population
        System.out.println("Population Simulation Number: " + args[0]);



        //Declare and initialize variables 
       
        //start with population being 1000
        int[] population = new int[Integer.parseInt(args[0])];

        double populationSize = Double.parseDouble(args[0]);

        int groupNumber = 0;

        int groupSize = 8;
        
        double infectionRate = 0.02;

        double numberInfected = 0.0;

        int index = 0;

        int numberOfTests = 0;

        int positiveCase = 0;

        int negativeCase = 0;

        //we are going to let 1 be infected and let 0 be healthy
        //This method is going to randomly infect the population

        numberInfected = populationSize * infectionRate;

        int intNumberInfected = (int) numberInfected;
        
        System.out.println(intNumberInfected);

        for (int i = 0; i < intNumberInfected ; i++){

            population[getRandomInfection(population)] = 1;

        }//for
        

        //print out the population
        for (int i = 0; i < population.length; i++){

           //System.out.println(population[i]);
            
        }//for

        //split the population into groups of 8
        //want to make a 2 dimensional array so that we can go through each group of 8
        groupNumber = (Integer.parseInt(args[0])) / groupSize ;
    
        //here we are going to make a copy of our group array to seach through so that 
        //we still have an original 
        int[][] grouparray = new int [groupNumber][groupSize];

        int[][] groupArrayCopy = grouparray.clone();

       
        //go through the group array and input the population
        //then in each index of the group make an array the size of group size
        for (int i = 0; i < groupNumber; i++){

            for ( int j = 0; j < groupSize; j++){

                grouparray[i][j] = population[index];
                index++;
            }//for j
        }//for i

        //print out the group array to see each group of 8
        System.out.println(Arrays.deepToString(grouparray));
                

        //now we test for infections!
        //testing 125 groups of 8
        for (int i = 0; i < groupNumber; i++){

            if(groupArrayCopy[i] == 1){
                //then we divide
                
              if((groupArrayCopy[i][j] == 1) && (groupArrayCopy[i][j] == 0)){

                //test all members of infected group
              }//if

              //else both groups are infected and all must be tested
              else{

                    for ( int j = 0; j < groupSize; j++){
        
                        numberOfTests++;

                        if (groupArrayCopy[i][j] == 1){
                            positiveCase++;
                        }//if

                        else{
                            negativeCase++;
                        }//else

                    }//for j
                
              }//else

            }//if

            //else there was no infection found
            else{
                numberOfTests++;
            }//else


        }//for
        

       
    }//main

    //This method randomly infects the population
    public static int getRandomInfection(int[] populationArray)
    {
        int randomIndex = 0;

        Random randomize = new Random();

        randomIndex = randomize.nextInt(populationArray.length);

        //System.out.println(randomIndex);

        return randomIndex;
        
    }//getRandomInfection



}//semester cordoni