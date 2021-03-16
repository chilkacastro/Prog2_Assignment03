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

import java.util.ArrayList;

/**
 * A class of Zoo
 * @author Chilka Castro
 */
public class Zoo {
    private ArrayList<Animal> animals;

    /**
     * Default constructor 
     */
    public Zoo() {
        this.animals = new ArrayList<>();
    }

    /**
     * Constructor with all data members
     * @param animals a collection of animals
     */
    public Zoo(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    
    /**
     * Copy constructor 
     * @param zoo the zoo object to copy
     */
    public Zoo(Zoo zoo) {
        this.animals = new ArrayList<>(zoo.animals);
    }
    
    /**
     * Counts in the zoo, how many animals belong to a certain type
     * @param type the animal type to check
     * @return number of animals that belong to a certain type
     */
    public int countAnimals(String type) {
        ArrayList<Animal> countedAnimals = new ArrayList<>();
        
        for (Animal animal : animals)
            if (animal.getType().equalsIgnoreCase(type))
                countedAnimals.add(animal);
               
        return countedAnimals.size();
    }
    
    /**
     * Goes through all animals in the zoo and check if there is a valid type in
     * the ArrayList from which no animals in the zoo belong to that type. If so,
     * remove the type from the validAnimalTypes ArrayList.
     */
    public void updateValidTypes() {
        // empty ArrayList to store current zoo animals that match 
        // with the validAnimalTypes
        ArrayList<String> zooAnimalTypes = new ArrayList<>();

        // Prevents repetition && adds similar ones in zooAnimalTypes
        for (Animal animal : animals)
            for (String validType : Animal.getValidAnimalTypes())
                if (!zooAnimalTypes.contains(validType) &&                      
                        animal.getType().equalsIgnoreCase(validType))           
                    zooAnimalTypes.add(validType);

        // Remove types that doesnt exist on zooAnimalTypes 
        for (String validType : Animal.getValidAnimalTypes())
            if (!zooAnimalTypes.contains(validType))
                Animal.getValidAnimalTypes().remove(validType);
    } 
     
    /**
     * Checks if for a specific type, the difference between the number of 
     * female and number of male is less than 20% of the total number of animals
     * of that type. 
     * @param type the animal type to  be checked
     * @return True if the difference between genders is less than 20% of the 
     * total number of animals of that type and False if not. 
     */
    public boolean isGenderBalanced(String type) {
        int totalType = countAnimals(type);
        double animalRatio = 0.2;
        int femaleCount = 0;
        int maleCount = 0;
        
        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(type))
                if (animal.getGender().equalsIgnoreCase("Female"))
                    femaleCount++;
                else
                    maleCount++;  
        }
        return (animalRatio * totalType > Math.abs(maleCount - femaleCount));
    }
    
//    /**
//     * Removes the oldest animal of an animal type 
//     * @param type the input animal type wherein its oldest would be removed.
//     */
//    public void removeOldest(String type) {
//        ArrayList<Animal> oldAnimals = new ArrayList<>();
//        int oldestAge = 0;
//
//        if (Animal.isTypeValid(type)) {
//            for (Animal animal : animals) {
//                oldestAge = Math.max(oldestAge, animal.getAge());
//            }
//            
//                if (animal.getAge() == oldestAge)
//                    oldAnimals.add(animal);
//            }   
//            for (Animal animal : animals)
//                for (Animal oldAnimal : oldAnimals) 
//                    animals.remove(oldAnimal);
//            // if animal dies of old age, valid types updated
//            updateValidTypes();
//        }
//    }
    
    /**
     * Compares two zoo objects if they are the same or not
     * @param zoo the zoo object that needs to be compared
     * @return True if the zoo objects are the same and False if no
     */
    public boolean equals(Zoo zoo) {
        return this.animals.equals(zoo.animals);  
    }
    
    /**
     * Creates a String that represents a zoo
     * @return a String that represents a zoo
     */
    @Override
    public String toString() {
        int totalMale = 0;
        int totalFemale = 0;
        String str = "";
        int oldestAge;
        int female;
        int male;
        
        // Total Animal Count in the zoo
        for (Animal animal : animals) {
            if (animal.getGender().equalsIgnoreCase("Male"))
                totalMale++;
            else
                totalFemale++;
        }
        
        // Prints all animal count in the zoo(female and male)
        str += String.format("%-10s: %d\n", "Total Number of Animals", 
                animals.size());     
        str += String.format("%-10s: %d\n", "Male", totalMale);
        str += String.format("%-10s: %d\n\n", "Female", totalFemale);

        // Go over all the valid animal types and print statistics for each
        for (String validAnimalType : Animal.getValidAnimalTypes()) {
            str += String.format("%s:\n", validAnimalType);
            str += String.format("\t%-10s : %d\n", "Number", 
                    countAnimals(validAnimalType)); 
            // resets for each type
            female = 0;
            male = 0;
            oldestAge = 0;
            for (Animal animal : animals) {
                if (validAnimalType.equalsIgnoreCase(animal.getType())) {
                    if (animal.getGender().equalsIgnoreCase("Female")) 
                        female++;
                    else
                        male++;  
                    oldestAge = Math.max(animal.getAge(), oldestAge); 
                }
            }
            str += String.format("\t%-10s : %d\n", "Female", female);
            str += String.format("\t%-10s : %d\n", "Male", male);
            str += String.format("\t%-10s : %s\n", "Balanced", 
                    (isGenderBalanced(validAnimalType)) ? "Yes" : "No");
            str += String.format("\t%-10s : %d\n", "Oldest age", oldestAge);
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

        