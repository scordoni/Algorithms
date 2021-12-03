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

        int numberOf1Tests = 0;

        int numberOf2Tests = 0;

        int numberOf3Tests = 0;


        int case1occurences = 0;

        int case2occurences = 0;

        int case3occurences = 0;

        int numberOfSick = 0;

        //we are going to let 1 be infected and let 0 be healthy
        //This method is going to randomly infect the population

        numberInfected = populationSize * infectionRate;

        int intNumberInfected = (int) numberInfected;
        
        System.out.println("Number Infected: " + intNumberInfected);

        for (int i = 0; i < intNumberInfected ; i++){

            population[getRandomInfection(population)] = 1;

        }//for
        

        //print out the population
        for (int i = 0; i < population.length; i++){

           //System.out.print(population[i]);
            
        }//for

        //split the population into groups of 8
        //want to make a 2 dimensional array so that we can go through each group of 8
        groupNumber = (Integer.parseInt(args[0])) / groupSize ;

        System.out.println("Group Number: " + groupNumber);
    
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

                //we have to test 2 groups of 4
                if(findArraySum(groupArrayCopy[i]) == 1){

                    //System.out.println("We have one infection!"); 
                    numberOf2Tests = numberOf2Tests + 3;
                    case2occurences++;

                    int subgroup1infection = 0;
                    int subgroup2infection = 0 ;

                    //now we split into 2 groups of 4 and retest
                    for(int k = 0; k < groupSize/2; k++){
                        
                        if(groupArrayCopy[i][k] == 1){
                            subgroup1infection = 1;
                            //System.out.println("We have a sub-group 1 infection!"); 
                        }//if
    
                    }//for
    
                    for(int k = 4; k < groupSize; k++){
    
                        if(groupArrayCopy[i][k] == 1){
                            subgroup2infection = 1;
                            //System.out.println("We have a sub-group 2 infection!"); 
                        }//if
    
                    }//for

                    if(subgroup1infection == 1){
                        numberOf2Tests = numberOf2Tests + 4; 
                    }//if

                    if(subgroup2infection == 1){
                        numberOf2Tests = numberOf2Tests + 4; 
                    }//if
                        
                }// if

                //else more then one person is infected
                else if(findArraySum(groupArrayCopy[i]) > 1){

                    //System.out.println("We have more than one infection!"); 
                    case3occurences++;
                    numberOf3Tests = numberOf3Tests + 11;

                    for(int k = 4; k < groupSize; k++){
    
                        if(groupArrayCopy[i][k] == 1){
                            numberOfSick++;
                                
                            //System.out.println("We have " + numberOfSick + " infections!"); 
                        }//if
    
                    }//for
                                   
                }//else if

            }//else

        }//for i 

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

        //System.out.println(randomIndex);

        return randomIndex;
        
    }//getRandomInfection

    public static int findArraySum(int[] array) {
        
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }//for

        return sum;
    }//find array sum



}//semester cordoni