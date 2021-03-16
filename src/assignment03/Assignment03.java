/*
 * The MIT License
 *
 * Copyright 2021 Chilka Castro.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package assignment03;

import java.util.Arrays;

/**
 * Assignment 3: Task 01
 * @author Chilka Castro
 */
public class Assignment03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // min method
        double[][] numss1 = {{1, 2, 3, 4, 5}, {0, 6, 8, 5}};
        System.out.println(min(numss1));
        
        // minOfRow
        double[][] numss2 = {{1, 2, 3, 4, 5}, {0, 6, 8, 5}};
        double[] minRow = minOfRow(numss2);
        System.out.println(Arrays.toString(minRow));
        
        // minOfCol
        double[][] numss3 = {{1, 2, 3, 4, 5}, {0, 6, 8, 5}, {3, -1, 4, 2}};
        double[] minCol = minOfCol(numss3);
        System.out.println(Arrays.toString(minCol));
        
        // add 
        double[][] numss4 = {{1, 2, 3}, {4, 5}};
        double[][] numss5 = {{1, 2}, {3, 4, 5}, {6, 7}};
        System.out.println(Arrays.deepToString(add(numss4, numss5)));
        
        // deleteRow
        double[][] numss6 = {{1, 2}, {3, 4, 5}, {6, 7}};
        System.out.println(Arrays.deepToString(deleteRow(numss6, 1)));
        
        // appendArray
        double[][] numss7 = {{1, 2}, {3, 4, 5}, {6}};
        double[][] numss8 = {{7}, {8, 9}};
        System.out.println(Arrays.deepToString(appendArray(numss8, numss7)));
        
        // expendArray
        double[][] numss9 = {{1, 2}, {3, 4, 5}, {6}};
        double[][] numss10 = {{7}, {8, 9}};
        System.out.println(Arrays.deepToString(expendArray(numss9, numss10)));
        
        // tranposeMatrix
        double[][] numss11 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(transposeMatrix(numss11)));
    }

    /**
     * Calculates the min value of a 2-D double array
     * @param numss the 2-D array to calculate the min value
     * @return the min value of a 2-D double array
     */
    public static double min(double[][] numss) {
        double min = Double.POSITIVE_INFINITY;

        for (double[] nums : numss)
            for (double num : nums)
                min = Math.min(num, min);

        return min;
    }

    /**
     * Calculates the min value of each row of 2-D double array
     * @param numss the 2-D array to calculate the min value of each row
     * @return the min value of each row in a 2-D double array
     */
    public static double[] minOfRow(double[][] numss) {
        // Step 1: Create a 1D array
        double[] mins = new double[numss.length];           //all default zeroes
        
        // Step 2: fill it with highest number double infinity
        Arrays.fill(mins, Double.POSITIVE_INFINITY); 
 
        // Step 3: Go over the loop to find min value of eahc row 
        for (int i = 0; i < numss.length; i++)
            for (double num : numss[i])
                mins[i] = Math.min(num, mins[i]);

        return mins;
    }

    /**
     * Calculate the min value of each column of 2-D double array
     * @param numss the 2-D array to calculate the min value of each column
     * @return the min value of each column in a 2-D double array
     */
    public static double[] minOfCol(double[][] numss) {
        int maxCol = 0;
        // Step 1: Find the longest row(maximum column length)
        for (double[] nums : numss)
            maxCol = Math.max(nums.length, maxCol);
        
        // Step 2: Create 1D array and fill it with highest number double infinity
        double[] mins = new double[maxCol];
        Arrays.fill(mins, Double.POSITIVE_INFINITY);

        // Step 3: Go to each row and column to get the min of each column
        for (double[] nums : numss)
            for (int j = 0; j < nums.length; j++)
                mins[j] = Math.min(nums[j], mins[j]);

        return mins;
    }

    /**
     * Adds two 2-D double arrays together
     * @param numss1 first 2-D double array to add
     * @param numss2 second 2-D double array to add
     * @return a new array wherein the 2-D double arrays were added
     */
    public static double[][] add(double[][] numss1, double[][] numss2) {
        // Step 1: Find the max row
        int minRow = Math.min(numss1.length, numss2.length);
        int maxRow = Math.max(numss1.length, numss2.length);

        // Step 2: Create 2-D array with no columns since different sizes
        double[][] numss3 = new double[maxRow][];

        // Step 3: Overlapping rows
        int minLen;
        for (int i = 0; i < minRow; i++) {
            // Step 3.1:  COLUMN LEVEL - Modify numss3 with the row with the longest length(longest column)
            numss3[i] = (numss1[i].length > numss2[i].length) ? numss1[i] : numss2[i];
            minLen = (numss1[i].length < numss2[i].length) ? numss1[i].length : 
                    numss2[i].length;
            // Step 3.2: COLUMN LEVEL - add only elements/columns that both sides have
            for (int j = 0; j < minLen; j++)
                numss3[i][j] = numss1[i][j] + numss2[i][j];
        }

        // Step 4: Add the remaining row
        double[][] long2DArray = (numss1.length > numss2.length) ? numss1 : numss2;
        for (int i = minRow; i < numss3.length; i++)
            numss3[i] = long2DArray[i];

        return numss3;
    }

    /**
     * Deletes a row from a 2-D double array.
     * @param numss the 2-D double array to delete a row from
     * @param idx the index of the row of the 2-D array to be deleted
     * @return a modified 2-D array of the original input 2-D array
     */
    public static double[][] deleteRow(double[][] numss, int idx) {
        double[][] numss2 = Arrays.copyOf(numss, numss.length - 1);

        for (int i = idx + 1; i < numss.length; i++)
            numss2[i - 1] = numss[i];

        return numss2;
    }

    /**
     * Appends a 2-D double array under another 2-D double array    *
     * @param numss1 first 2-D double array to append to the other 2-D double
     * array
     * @param numss2 second 2-D double array to append to the other 2-D double
     * array
     * @return a new 2-D array with both input 2-D arrays combined
     */
    public static double[][] appendArray(double[][] numss1, double[][] numss2) {
        double[][] numss3 = Arrays.copyOf(numss1, numss1.length + numss2.length);

        for (int i = 0; i < numss2.length; i++)
            numss3[i + numss1.length] = numss2[i];

        return numss3;
    }

    /**
     * Appends a 2-D double array at the right of another 2-D double array.
     * @param numss1 the first input 2-D array to append(right of another 2-D
     * array)
     * @param numss2 the second input 2-D array to append(right of another 2-D
     * array)
     * @return a new 2-D double array that has been appended
     */
    public static double[][] expendArray(double[][] numss1, double[][] numss2) {
        // Step 1: Find maximum row length and minimum row length
        int maxRow = Math.max(numss1.length, numss2.length);
        int minRow = Math.min(numss1.length, numss2.length);

        // Step 2: Variable and 2-D Arrays
        double[][] numss3 = new double[maxRow][];                // not a matrix
        double[][] short2DArray;
        int sumLen;                                // length of the two 2D array
        int maxCol;
        int minCol;

        // Step 3: for loop 2D array w/ same row index w/ the other 2D array
        for (int i = 0; i < minRow; i++) {
            sumLen = numss1[i].length + numss2[i].length;
            numss3[i] = (numss1[i].length > numss2[i].length)
                    ? Arrays.copyOf(numss1[i], sumLen) : Arrays.copyOf(numss2[i], sumLen);
            maxCol = Math.max(numss1[i].length, numss2[i].length);
            short2DArray = (numss1[i].length < numss2[i].length) ? numss1 : numss2;
            minCol = Math.min(numss1[i].length, numss2[i].length);
            for (int j = 0; j < minCol; j++)
                numss3[i][j + maxCol] = short2DArray[i][j];
        }

        // Step 4: remaining part that doesnt have matching row w/ the other 2d-array
        double[][] long2DArray = (numss1.length > numss2.length) ? numss1 : numss2;
        for (int i = minRow; i < numss3.length; i++)
            numss3[i] = long2DArray[i];
        
        return numss3;
    }

    /**
     * Flips the row and the column of a matrix
     * @param numss the input matrix to flip the row and column
     * @return a new 2-D array(flipped row & column version of input 2-D array)
     */
    public static double[][] transposeMatrix(double[][] numss) {
        // Step 1: Switch row and column of input 2D-array
        double[][] numss2 = new double[numss[0].length][numss.length];

        // Step 2: Go over row and columns of new array
        for (int i = 0; i < numss2.length; i++)
            for (int j = 0; j < numss2[i].length; j++) 
                numss2[i][j] = numss[j][i];         // switch col & row position

        return numss2;
    }
}
