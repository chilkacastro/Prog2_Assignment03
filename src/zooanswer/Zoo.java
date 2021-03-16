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
package zooanswer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/**
 * A simple class of Zoo
 * @author Chilka Castro
 */
public class Zoo {
    private ArrayList<Animal> animals;
    
    public Zoo() {
        this.animals = new ArrayList<>();
    }
    
    public Zoo(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    
    public Zoo(Zoo zoo) {
        this.animals = new ArrayList<>(zoo.animals);                            // deep copy : copy constructor of ArrayList class
    }
    
    /**
     * Counts the number of a specific type of animal in the zoo
     * @param type the specific type of animal you want to count
     * @return the number of a specific type of animal in the zoo
     */
    public int countAnimals(String type) {
        int count = 0;
        
        for (Animal animal : animals)
            if (animal.getType().equalsIgnoreCase(type))
                count++;
        
        return count;
    }
    
    /**
     * Goes through VALID_TYPES and check if in the zoo there are animals 
     * belong to each of the type, if not then remove that type from the VALID_TYPES
     */
    public void updateValidTypes() {
        // Create a container so you dont need to call it again and again using the setter
        ArrayList<String> validTypes = Animal.getVALID_TYPES(); 
        boolean valid;
        
        // 1. OUTER loop : check each VALID_TYPES animals
        for (int i = 0; i < validTypes.size(); i++) {                           // nested for loop so -> outer loop 5 iterations x inner loop 100 animals = 500 iterations
            // start with false
            valid = false;      
            // 2. INNER LOOP : check if all zoo animals match with the current one valid type
            for (Animal animal : animals) {                                         // go over all the animals in the zoo
                if (animal.getType().equalsIgnoreCase(validTypes.get(i))) {         // you have one type right now | ALWAYS THINK : when can I make a decision?
                    valid = true;                                                   // if one animal belong to the type, set valid to true // if true then remove isnt activated
                    break;                                                          // if same then break | DONT DO ANYTHING |  if they are equals then keep it so you break this inner loop
                }
            // when inner loop is done(all zoo animals checked) and theres no matching so break wasn't activated
            if (!valid)  // means if (valid == false)
                validTypes.remove(i--);   // outer loop
            }
        }
    }
    
    /** VERSION 2
     * Goes through VALID_TYPES and check if in the zoo there are animals 
     * belong to each of the type, if not then remove that type from the VALID_TYPES
     */
    public void updateValidTypes2() {
        // Step 1: Create container for existing animals
        ArrayList<String> existTypes = new ArrayList<>();                       // initially empty 
        
        // Step 2: Store the existing ones(zoo animals) in the existTypes variable | no VALID_TYPES checking yet 
        for (Animal animal : animals)                       // 5 animals
            if (!existTypes.contains(animal.getType()))                          // IF I DON'T HAVE THIS TYPE YET THEN ADD IT IN MY ARRAYLIST existTypes | to avoid repetition | if it the existTypes variable doesnt contain the zoo animal's type then store it 
                existTypes.add(animal.getType());
        
        // Step 3.1:  Create a container so you dont need to call it again and again using the setter
        ArrayList<String> validTypes = Animal.getVALID_TYPES();
     
        // Step 3.2 : compare/check VALID_TYPES and existTypes
        for (int i = 0; i < validTypes.size(); i++) {      // 100               // then iteration would be 100 + 5 = 105 iterations
            if (!existTypes.contains(validTypes.get(i)))
                validTypes.remove(i--);
        }
    }
    
    /** VERSION 3
     * Goes through VALID_TYPES and check if in the zoo there are animals 
     * belong to each of the type, if not then remove that type from the VALID_TYPES
     */
    public void updateValidTypes3() {
        HashSet<String> existTypes = new HashSet<>();   // HashSet doesn't allow repetitions
        
        for (Animal animal : animals)
            existTypes.add(animal.getType());
        
        ArrayList<String> validTypes = Animal.getVALID_TYPES();
        for (int i = 0; i < validTypes.size(); i++) {
            if (!existTypes.contains(validTypes.get(i)))
                validTypes.remove(i--);
        }        
    }
    
    /**
     * Checks if the amount of female and the amount of male of a type is less
     * than a specific threshold
     * @param type the specific type you want to check
     * @return if the difference between the amount of female and the amount of
     * male of a type is less than a specific threshold
     */
    public boolean isGenderBalanced(String type) {
        int[] nums = calcGenderDistribution(type);                              // call the calcGenderDistribution method
        double threshold = 0.2;
        
        return Math.abs(nums[0] - nums[1]) < (nums[0] + nums[1]) * threshold;
    }
    
    /**
     * Checks the number of male and the number of female of a type
     * @param type the type you want to check
     * @return the number of male and the number of female of a type
     */
    public int[] calcGenderDistribution(String type) {
        // Step 1 : Create an array for male count(index 0) and female count(index 1)
        int[] nums = new int[2];        // length of 2
        
        // Step 2 : Go through all the animals in the zoo
        for (Animal animal : animals)
            // Step 2.2 : Check if the animal type is equal to the given type/parameter->input type
            if (animal.getType().equalsIgnoreCase(type))
                // Step 2.3 : if the type is the same then check for the gender 
                if (animal.getGender().equalsIgnoreCase("male"))
                    nums[0]++;          // increases count if gender type is male 
                else
                    nums[1]++;          // increases count if gender type is female 
        
        return nums;
    }
    
    /**
     * Checks the number of male and the number of female in the zoo
     * @return the number of male and the number of female of a type
     */
    public int[] calcGenderDistribution() {
        int[] nums = new int[2];      
        
        for (Animal animal : animals)
                if (animal.getGender().equalsIgnoreCase("male"))
                    nums[0]++;          // increases count if gender type is male 
                else
                    nums[1]++;          // increases count if gender type is female 
        
        return nums;
    }
 
    /**
     * Find the oldest age of a specific type
     * @param type the type you want to check
     * @return the oldest age of a specific type
     */
    public int calcOldest(String type) {
        int age = -1;
        
        for (Animal animal : animals)
            if (animal.getType().equalsIgnoreCase(type))
                age = Math.max(age, animal.getAge());
        
        return age;
    }
    
    /**
     * Removes the oldest animal of a specific type
     * @param type the type of animal you want to remove
     */
    public void removeOldest(String type) {
        int age = calcOldest(type);
        
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getType().equalsIgnoreCase(type))                // get one animal and then get its type
                if (animals.get(i).getAge() == age)
                    animals.remove(i--);                                        // use i-- to cancel the i++ | so that you do not skip another one

        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Zoo other = (Zoo) obj;
        if (!Objects.equals(this.animals, other.animals))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("The total number of animals: %s\n ", animals.size());
        str += String.format("%-10s: %s\n ", "Male", calcGenderDistribution()[0]);
        str += String.format("%-10s: %s\n ", "Female", calcGenderDistribution()[1]);
        
        for (String type : Animal.getVALID_TYPES()) {     // takes one type at a time
            str += type + ":";
            int[] nums = calcGenderDistribution(type);    // gives two values(in an array)
            
            str += String.format("%-10s: %s\n", "Number", nums[0] + nums[1]);
            str += String.format("%-10s: %s\n", "Male", nums[0]);
            str += String.format("%-10s: %s\n", "Female", nums[1]);
            str += String.format("%-10s: %s\n", "Balanced", 
                    isGenderBalanced(type) ? "Yes" : "No");
            str += String.format("%-10s: %d\n", "Oldest age", calcOldest(type));
        }        
        
        return str;
        
    }
    
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    
    
}
