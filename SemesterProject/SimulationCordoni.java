/*
 * 
 * Semester Project
 * Due Date and Time: 12/15/21 before 12:00am 
 * Purpose: to develop a simulation testing program for covid screenings
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

        //set the population size
        double populationSize = Double.parseDouble(args[0]);

        int groupNumber = 0;

        int groupSize = 8;
        
        double infectionRate = 0.02;

        double numberInfected = 0.0;

        int index = 0;

        int numberOfTests = 0;

        int numberOf1Tests = 0;

        int numberOf2Tests = 0;

        int numberOf3Tests = 0;


        int case1occurences = 0;

        int case2occurences = 0;

        int case3occurences = 0;

        int popindex = 0;

        //we are going to let 1 be infected and let 0 be healthy
        //This method is going to randomly infect the population

        numberInfected = populationSize * infectionRate;

        int intNumberInfected = (int) numberInfected;
        
        System.out.println("Number Infected: " + intNumberInfected);

        for (int i = 0; i < intNumberInfected ; i++){

            popindex = getRandomInfection(population);

            //if the index is already set to 1 we do not want to reinfect
            if(population[popindex] == 1){
                //System.out.println("Double Infection");
                
                //we keep calling random then until we find a non-infected person
                while(population[popindex] != 0){
                    //System.out.println("new Infection");
                    popindex = getRandomInfection(population);
                }//while

                population[popindex] = 1;

            }//if

            //otherwise we just infect
            else{
                population[popindex] = 1;
            }//else
            

        }//for
        

        //print out the population
        for (int i = 0; i < population.length; i++){

           //System.out.print(population[i]);
            
        }//for

        //split the population into groups of 8
        //want to make a 2 dimensional array so that we can go through each group of 8
        groupNumber = (Integer.parseInt(args[0])) / groupSize ;

        System.out.println("Group Number: " + groupNumber);
    
        //here we are going to make a copy of our group array to search through so that 
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
        //System.out.println(Arrays.deepToString(grouparray));
                

        
        //now we test for infections!
        //testing 125 groups of 8
        for (int i = 0; i < groupNumber; i++){
            
            //go through and find each group sum to see if we need to individually test

            //find sum
            //System.out.println(findArraySum(groupArrayCopy[i]));

            //if the sum is equal to 0 then we dont have an infection
            if(findArraySum(groupArrayCopy[i]) == 0){
                    
            //System.out.println("No infection in this group!");
            numberOf1Tests++;
            case1occurences++;
                
                
            }//if  

            //else we have an infection
            else{

                int subgroup1infection = 0;
                int subgroup2infection = 0 ;

                    //now we split into 2 groups of 4 and retest
                    //Here we test the first 4 in the group
                    for(int k = 0; k < groupSize/2; k++){

                        numberOf2Tests++;

                        //if we find an infection then we set the variable to one
                        //so that we can see later if we have a case 3 infection
                        if(groupArrayCopy[i][k] == 1){
                           
                            subgroup1infection = 1;

                        }//if
    
                    }//for

                    //here we test the second 4 in the group
                    for(int k = 4; k < groupSize; k++){

                        numberOf2Tests++;
                        
                        //if we find an infection then we set the variable to one
                        //so that we can see later if we have a case 3 infection
                        if(groupArrayCopy[i][k] == 1){
                            
                            subgroup2infection = 1;

                        }//if
    
                    }//for

                    //If there is both a subgroup 1 and subgroup 2 infection then we have a case 3
                    if((subgroup1infection == 1) && (subgroup2infection == 1)){

                        case3occurences++;
                        
                        //here we account for the original test of all 8, and the two tests for
                        //each group of 4
                        numberOf3Tests = numberOf3Tests + 3;

                        //we loop through for testing all 8 in the group
                        for(int j = 0; j < groupSize; j++){

                            numberOf3Tests++;
                            
                        }//for

                    }//if both subgroup


                    //if we only have a subgroup 1 or subgroup 2 infection then we have a case 2
                    else if(subgroup1infection == 1){

                        case2occurences++;

                    }//if subgroup 1

                    else if(subgroup2infection == 1){

                        case2occurences++;

                    }//if subgroup 2

            }//else

        }//for i 


        //print out the results
        System.out.println("Case 1 occurences: " +  case1occurences);
        System.out.println("Case 2 occurences: " +  case2occurences);
        System.out.println("Case 3 occurences: " +  case3occurences);
        
        System.out.println("Number of case 1 tests: " +  numberOf1Tests);
        System.out.println("Number of case 2 tests: " +  numberOf2Tests);
        System.out.println("Number of case 3 tests: " +  numberOf3Tests);

        numberOfTests = numberOf1Tests + numberOf2Tests + numberOf3Tests;

        System.out.println("Number of total tests: " +  numberOfTests);
        
    }//main

    //This method randomly infects the population
    public static int getRandomInfection(int[] populationArray)
    {
        

        int randomIndex = 0;

        Random randomize = new Random();

        randomIndex = randomize.nextInt(populationArray.length);

        //System.out.println("random index" + randomIndex);

        return randomIndex;
        
    }//getRandomInfection

    //this method find the sum of the array passed in
    public static int findArraySum(int[] array) {
        
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }//for

        return sum;
    }//find array sum

}//semester cordoni