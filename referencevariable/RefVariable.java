package referencevariable;
/*It is a type of variable which is used to store address of an object.
• Within a reference variables we can’t store primitive values.
• Within a primitive variables we can’t store store address of an object.
• Within one reference variables we can store ONLY ONE OBJECT ADDRESS.
• Multiple reference variables can point to same object.
• If Multiple reference variables points to same object then, changes done on the 
data of the object by one reference variable will impact other reference variables.
• If two reference variables points to different objects then, changes done on the 
data of one object by one reference variable will NOT impact other reference 
variables
*/
public class RefVariable {
    int r = 100; // Declaring r as a member variable of the class

    public static void main(String[] args) {
        RefVariable ref = new RefVariable();
        System.out.println(ref);
        
        
//        int ref5=new RefVariable();//it throw error

        RefVariable ref1 = new RefVariable();
        RefVariable ref2 = ref1;
        System.out.println("Address of Variable ref1=" + ref1);
        System.out.println("Address of Variable ref1=" + ref2);

        System.out.println("Value of r fram ref1=" + ref1.r);
        System.out.println("Value of r fram ref2=" + ref2.r);
        ref2.r=300;
        System.out.println("Value of r fram ref1=" + ref1.r);
        System.out.println("Value of r fram ref=" + ref.r);
    }
}
