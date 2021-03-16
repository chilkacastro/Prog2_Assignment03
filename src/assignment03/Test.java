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
 *
 * @author Chilka Castro
 */
public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Copain", "female", 5, "Dog");
        Animal animal2 = new Animal("Stitch", "female", 12, "Dog");
        Animal animal3 = new Animal("Bambi", "feMale", 1, "Dog");
        Animal animal4 = new Animal("Bravo", "maLE", 3, "Dog");
        Animal animal5 = new Animal("Charlie", "male", 3, "Dog");
        Animal animal6 = new Animal("Luc", "male", 9, "Dog");
        Animal animal7 = new Animal("Garfield", "Male", 6, "Cat");
        Animal animal8 = new Animal("Alpha", "Male", 7, "Cat");
        Animal animal9 = new Animal("Alpha", "female", 7, "Cat");
        Animal animall0 = new Animal("Alpha", "female", 7, "Cat");
        Animal animal11 = new Animal("Alpha", "female", 7, "Cat");
        Animal animal12 = new Animal("Alpha", "female", 9, "cat");
        Animal animal13= new Animal("Alpha", "female", 7, "cat");
        Animal animal14= new Animal("Alpha", "female", 7, "cat");
        Animal animal15= new Animal("Alpha", "female", 25, "cat");
        Animal animal16= new Animal("Alpha", "female", 7, "monkey");
        Animal animal17= new Animal("Alpha", "female", 7, "monkey");
        Animal animal18 = new Animal("Alpha", "female", 7, "monkey");
        Animal animal19= new Animal("Alpha", "female", 7, "monkey");
        Animal animal20 = new Animal("Alpha", "female", 7, "monkey");
        Animal animal21 = new Animal("Alpha", "female", 7, "monkey");
        Animal animal22 = new Animal("Alpha", "male", 7, "monkey");
        Animal animal23 = new Animal("Alpha", "male", 7, "monkey");
        Animal animal24 = new Animal("Alpha", "male", 7, "monkey");
        Animal animal25 = new Animal("Alpha", "male", 7, "monkey");
        Animal animal26 = new Animal("Alpha", "male", 7, "monkey");
        Animal animal27 = new Animal("Alpha", "male", 7, "monkey");
        Animal animal28 = new Animal("Alpha", "male", 20, "monkey");
        
        //System.out.println(animal1);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);
        animals.add(animal6);
        animals.add(animal7);
        animals.add(animal8);
        animals.add(animal9);
        animals.add(animall0);
        animals.add(animal11);
        animals.add(animal12);
        animals.add(animal13);
        animals.add(animal14);
        animals.add(animal15);
        animals.add(animal16);
        animals.add(animal17);
        animals.add(animal18);
        animals.add(animal19);
        animals.add(animal20);
        animals.add(animal21);
        animals.add(animal22);
        animals.add(animal23);
        animals.add(animal24);
        animals.add(animal25);
        animals.add(animal26);
        animals.add(animal27);
        animals.add(animal28);
        Zoo zoo1 = new Zoo(animals);
        
        System.out.println(zoo1);
        
        
        
    }

}
