package algorithms;
import grpc.Radiation.objects.County;

/*
 * While BubbleSort is obviously a slow algorithm, for sorting
 * 26 counties it's more than sufficient, and it's easy to
 * implement.
 */
public class BubbleSort {

	public static void sort(County[] array) {
		int len = array.length;
		
        for (int i=0;i<len-1;++i) {
        	
            for(int j=0;j<len-i-1; ++j) {
            	
                if(array[j+1].getValue() < array[j].getValue()) {
                    County swap = array[j];
                    array[j] = array[j+1];
                    array[j+1] = swap;
                }
            }
        }
    }
}