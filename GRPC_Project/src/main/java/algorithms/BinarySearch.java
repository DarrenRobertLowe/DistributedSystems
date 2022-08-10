package algorithms;

import java.util.ArrayList;
import grpc.pollution.objects.*;


public class BinarySearch {
    private static boolean debug = false;
    
    
    public IoTDevice search(IoTDevice[] array, String target) {
    	IoTDevice result = null;
    	
    	int index = searchByID(array, 0, array.length-1, target, -1);
    	
    	if (index > -1) {
    		System.out.println("Setting device to " + array[index]);
    		result = array[index];
    	}
    	
        return result;
    }
    
    
    
    private static int searchByID(IoTDevice[] array, int first, int last, String target, int result)  // added int result
    {
        if (last >= first){ // while there's indices left to look through
            
            int mid         = (first+last)/2;                   // find the middle
            String name     = array[mid].getID();
            
            if (debug) System.out.println("mid is index : " +mid + " value: " + array[mid]);
            
            // if mid is the target element, stop searching now
            if(name.equalsIgnoreCase(target)) {
                if (debug) System.out.println("target found at position " +mid);
                result = mid;
            } else {
                // if we haven't found the target...
                if (target.compareToIgnoreCase(name) <= 0) {
                    if (debug) System.out.println("target " + target + " is less than " + name);
                    return searchByID(array, first, mid-1, target, result);
                } else {
                    if (debug) System.out.println("target " + target + " is greater than " + name);
                    return searchByID(array, mid+1, last, target, result);
                }
            }
        }
        
        return result; // used a result variable instead of -1
    }
}