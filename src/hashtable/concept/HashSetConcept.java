package hashtable.concept;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Internal working of Set/HashSet in Java
 * @author nitin
 * https://www.geeksforgeeks.org/internal-working-of-sethashset-in-java/
 *
 */
public class HashSetConcept {

	public static void main(String args[]) 
    {
        // creating a HashSet
        HashSet<String> hs = new HashSet<>();
        Set<String>  st=new LinkedHashSet();
         
        // adding elements to hashset
        // using add() method
        boolean b1 = hs.add("Geeks");
        boolean b2 = hs.add("GeeksforGeeks");
        hs.remove(0);
        
         
        // adding duplicate element
        boolean b3 = hs.add("Geeks");
         
        // printing b1, b2, b3
        System.out.println("b1 = "+b1);
        System.out.println("b2 = "+b2);
        System.out.println("b3 = "+b3);
        
         
        // printing all elements of hashset
        System.out.println(hs);
             
    }

}
