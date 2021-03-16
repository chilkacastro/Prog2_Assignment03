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
import java.util.Arrays;

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
        this.animals = new ArrayList<>(zoo.animals);    // deep copy : copy constructor of ArrayList class
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
        // Step 1: use for loop to go through  
        ArrayList<String> validTypes = Animal.getVALID_TYPES();
        for (int i = 0; i < validTypes.size(); i++)
            for (Animal animal : animals)   {                                       // go over all the animals in the zoo
                if (animal.getType().equalsIgnoreCase(validTypes.get(i)))  {        // you have one type right now | ALWAYS THINK : when can I make a decision?
                    break;
                }
            validTypes.remove(animal.getType());
            }
    }
   
}
