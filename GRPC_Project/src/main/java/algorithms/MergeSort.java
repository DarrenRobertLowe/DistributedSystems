package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

import grpc.Radiation.objects.County;
import grpc.pollution.objects.IoTDevice;
/**
 *
 * @author Darren Robert Lowe
 */



 ///// MERGE SORT //////
public class MergeSort  {
	
    public static void sort(County[] array) {
	//public static <T extends GenericsInterface> void sort(T[] array) {
        sort(array, 0, array.length-1, false);
    }
    

    //public static void sort(IoTDevice[] array) {
	public static <T extends GenericsInterface> void sort(T[] array) {
        sort(array, 0, array.length-1, true);
    }
    
    
   
    //private static void sort(County[] a, int left, int right, boolean sortByName) {
	private static <T extends GenericsInterface> void sort(T[] a, int left, int right, boolean sortByString) {
        if (left < right) {                                 // this is the escape clause to end the recursion
            
            int mid = (left + right) / 2;                   // find the middle point
            
            /* sortByName will either be true or false, and it only
             * matters for merge(), but we need to pass it to it. */
            sort(a, left, mid, sortByString);                 // sort the left
            sort(a, mid + 1, right, sortByString);            // sort the right
            merge(a, left, mid, right, sortByString);         // merge by name
        }
    }
    
    
    // MERGE
    // Merge by Name
    private static <T extends GenericsInterface> void merge(T[] a, int left, int mid, int right, boolean sortByString) {
        int i, j, k;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        
        //temporary Arrays
	    T[] LeftArray =  (T[])new GenericsInterface[n1];
	    T[] RightArray = (T[])new GenericsInterface[n2];
        
	    
        // copy data to temp arrays
        for (i = 0; i < n1; i++) {
            LeftArray[i] = a[left + i];
        }
        for (j = 0; j < n2; j++) {
            RightArray[j] = a[mid + 1 + j];
        }
        
        i = 0;      // initial index of first sub-array
        j = 0;      // initial index of second sub-array
        k = left;   // initial index of merged sub-array
        
        
        boolean isLess;
        while (i < n1 && j < n2) {
            
            // decide what way to sort things, by value (double) or by id (String)
        	if (sortByString) {
                isLess = (LeftArray[i].getID().compareTo(RightArray[j].getID()) < 0);
            } else {
                isLess = (LeftArray[i].getValue() < RightArray[j].getValue());
            }
            
            
            if (isLess) {
                a[k] = LeftArray[i];
                i++;
            } else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }// end of merge
} // end of class
