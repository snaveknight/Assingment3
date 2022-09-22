package library;

import java.util.ArrayList;

public class BinarySearch {

	  int binarySearch(ArrayList<Book> arr, String key)
	    {
	        int left = 0, right = arr.size() - 1;
	       
	        while (left <= right)
	        {
	            int mid = left + (right - left) / 2;
	   
	            // Check if x is present at mid
	            System.out.println(arr.indexOf(key));
	            if (arr.indexOf(key) == mid)
	                return mid;
	   
	            // If x greater, ignore left half
	            if (mid < arr.indexOf(key))
	                left = mid + 1;
	   
	            // If x is smaller, ignore right half
	            else
	                right = mid - 1;
	        }
	   
	        // if we reach here, then element was
	        // not present
	        return -1;
	    }
	  
	  public int runBinarySearchIteratively( int[] sortedArray, int key, int low, int high) {
			  	int index = Integer.MAX_VALUE;         
			  	while (low <= high) {         
				  int mid = low  + ((high - low) / 2);     
				  if (sortedArray[mid] < key) {					  
					  low = mid + 1;     
				  }
				  else if (sortedArray[mid] > key) {				  
			              high = mid - 1;         
			 	   }
				  else if (sortedArray[mid] == key) {
			              index = mid;       
			              break;        
				  }    
			 	}    
			 			 return index; }
	  
	  
	
}
