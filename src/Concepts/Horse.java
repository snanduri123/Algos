package Concepts;

public class Horse extends Animal {

    public void eat() {
        System.out.println("Horse eats");
    }

    public void buck() {
        System.out.println("Horse bucks");
    }

    public void eat(Animal a) {
        System.out.println("Animal eats after overloading in Horse class ");
    }

    public void eat(Horse h) {
        System.out.println("Horse eats after overloading in Horse class ");
    }

    public static void main(String[] args) {
       // runtimePolymorphism();
        staticPolymorphism();
    }

    /*****Runtime polymorphism / Dynamic polymorphism due to OVERRIDING methods **/
    public static void runtimePolymorphism(){

        //1. ** The type of actual instance determines which overridden method to call.
        Animal a = new Horse();
        a.eat(); // Horse eats
        //a.buck(); //"can not resolve" compilation error because reference a is of Animal type and it does not have buck method.

        //2.
        Animal a1 = new Animal();
        a1.eat(); // Animal eats

        //3.
        Horse h = new Horse();
        h.eat(); // Horse eats
        h.buck(); //Horse bucks

        //4. Parent class variables can't be referred by subClass type
        // Horse h2 = new Animal(); //type mismatch compilation error

        //5. can't cast parent class objects to subClass Type.
        //Horse h3 = (Horse) new Animal(); //Class cast exception
        //h3.eat(); // can't execute because of above line exception
        //h3.buck(); // can't execute because of above line exception

        //6.
        Animal a2 = (Animal) new Horse();
        a2.eat(); //Horse eats
        //a2.buck(); //"can not resolve" compilation error because reference a is of Animal type and it does not have buck method.

        //7.You can cast a reference to Animal object to Horse object only if the real object is a Horse.
        Animal a3 = new Horse();
        Horse h4 = (Horse) a3;

    }

    /****Compile time polymorphism /Static polymorphism due to OVERLOADING methods **/

    public static void staticPolymorphism(){


        Animal a1 = new Horse();
        //a1.eat(a1);  //********compilation error eat(Animal) method is not present in Animal

        Animal a2 = new Animal();
        Animal ah2 = new Horse();
        Horse h3 = new Horse();

        Horse h1 = new Horse();
        h1.eat(a2); //Animal eats after overloading in Horse class
        h1.eat(ah2); //Animal eats after overloading in Horse class
        h1.eat(h3); //Horse eats after overloading in Horse class
    }


}
