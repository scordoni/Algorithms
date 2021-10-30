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

        int groupNumber = 0;

        int groupSize = 8;
        

        //we are going to let 1 be infected and let 0 be healthy
        //This method is going to randomly infect the population

        for (int i = 0; i < population.length; i++){

            population[getRandomIndex(population)] = 1;

        }//for

        //print out the population
        for (int i = 0; i < population.length; i++){

           // System.out.println(population[i]);
            
        }//for

        //split the population into groups of 8
        //want to make a 2 dimensional array so that we can go through each group of 8
        groupNumber = (Integer.parseInt(args[0])) / groupSize ;
    
        int[][] grouparray = new int [groupNumber][groupSize];

        //go through the group array and input the population
        //then in each index of the group make an array the size of group size
        for (int i = 0; i < groupNumber - 1; i++){

            for ( int j = 0; j < groupSize - 1; j++){

                grouparray[i][j] = population[i];

            }//for j
        }//for i

        //print out the group array to see each group of 8
        //System.out.println(Arrays.deepToString(grouparray));
                
        
        //now we test for infections!


        
        //then go through each group, 
        //then make copy, if 1 then whole postiive
        //then make 2 copy and go through 1-4 and 4-8
        //then make 3 copy and go through individually 



       
    }//main

    //This method gets the random indexes to infect the population
    public static int getRandomIndex(int[] populationArray)
    {
        int randomIndex = 0;

        Random randomize = new Random();

        randomIndex = randomize.nextInt(populationArray.length);

        //System.out.println(randomIndex);

        return randomIndex;
        
    }//getRandomIndex



}//simulation cordoni

