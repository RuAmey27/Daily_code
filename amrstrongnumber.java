/**
 * @file amrstrongnumber.cpp
 * @author your name (you@domain.com)
 * @brief 
 * @version 0.1
 * @date 2024-06-14
 * 
 * @copyright Copyright (c) 2024
 * 
 */
// a number is armstrong number if and only if it is 3 digit number and sum of cube of all it's digits is equal to that specific number 
class Solution {
    static String armstrongNumber(int n) {
        String a="true",b="false";
        // Ensure the number is a 3-digit number
        if (n < 100 || n > 999) {
            return b;
        }

        int originalNumber = n;
        int sumOfCubes = 0;

        // Calculate the sum of the cubes of its digits
        while (n > 0) {
            int digit = n % 10;
            sumOfCubes += Math.pow(digit, 3);
            n /= 10;
        }

        // Check if the sum of the cubes of its digits equals the original number
        if(sumOfCubes == originalNumber)
        {
            return a;
        }
        else{
            return b;
        }// code here
    }
}


/**
 * base  case 
 * check input is 3 digit or not i.e n<999 && n>100
 * to get digit of any number 
 * step 1 digit =input %10
 * next input/10 until input is greater than zero
 * i.e while(input>0){
 * int digit=input%10;
 * input/=10  iterating condition of loop
 * }
 */