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
import java.util.ArrayList;

/**
 * A class of Animal
 * @author Chilka Castro
 */
public class Animal {
    private String name;
    private String gender;
    private int age;
    private String type;
    
    private static ArrayList<String> validAnimalTypes = new ArrayList
            (Arrays.asList("Dog", "Cat", "Monkey"));

    /**
     * Default constructor
     */
    public Animal() {
        this.name = "";
        this.gender = "";
        this.age = 0;
        this.type = "";
    }

    /**
     * Constructor with all data members
     * @param name the name of the animal
     * @param gender the gender of the animal
     * @param age the age of the animal
     * @param type the type of the animal
     */
    public Animal(String name, String gender, int age, String type) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.type = (isTypeValid(type)) ? type : "";
    }
    
    /**
     * Copy constructor
     * @param animal the animal object to copy
     */
    public Animal(Animal animal) {
        this.name = animal.name;
        this.gender = animal.gender;
        this.age = animal.age;
        this.type = animal.type;
    }

    /**
     * Checks if an animal type belongs to the validAnimalTypes ArrayList
     * @param type the input animal type that needs to be validated
     * @return True if the animal type belongs to the validAnimaTypes ArrayList
     * and False if not.
     */
    public static boolean isTypeValid(String type) {
        for (String validAnimalType : validAnimalTypes)
            if (validAnimalType.equalsIgnoreCase(type))
                return true;

        return false;
    }
    
    /**
     * Compares two animal objects if they are the same or not
     * @param animal the animal object to be compared with
     * @return True if both animal objects are the same and False if not
     */
    public boolean equals(Animal animal) {
        return this.name.equals(animal.name) && 
                this.gender.equals(animal.gender) &&
                this.age == animal.age && 
                this.type.equals(animal.type); 
    }

    /**
     * Creates a String that represents an animal
     * @return a String representing an animal
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s: %s\n", "Name", name);
        str += String.format("%-10s: %s\n", "Gender", gender);
        str += String.format("%-10s: %d\n", "Age", age);
        str += String.format("%-10s: %s\n", "Type", type);
       
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (isTypeValid(type))
            this.type = type;
    }

    public static ArrayList<String> getValidAnimalTypes() {
        return validAnimalTypes;
    }

    public static void setValidAnimalTypes(ArrayList<String> validAnimalTypes) {
        Animal.validAnimalTypes = validAnimalTypes;
    }   
}

