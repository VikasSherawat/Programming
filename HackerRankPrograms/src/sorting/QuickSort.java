package sorting;

import java.util.Scanner;

public class QuickSort {

    
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int[] ar = new int[n];
         for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
         }
         quickSort(ar);
         printArray(ar);
     } 
    
  static int partition(int[] ar, int start, int end){
	  int pivot = ar[start];
	     int leftMark = start+1;
	     int rightMark = end;
	     int lIndex=0, rIndex=0;
	     int rStop =0,lStop=0;
	     int temp=0;
	           for (int i = 1; leftMark<=rightMark; i++) {
	            if(ar[leftMark]>pivot && lStop==0)
	            { 
	            	lIndex = leftMark;
	            	lStop=1;
	            }
	            else{
	            	if(lStop==0)
	                leftMark++;
	            }
	            if(ar[rightMark]<pivot && rStop==0)
	            {
	                rIndex = rightMark;
	                rStop=1;
	            }
	            else
	            {
	            	if(rStop==0)
	                rightMark--;
	            }
	            if(lIndex!=0 && rIndex!=0)
	            {
	                temp = ar[rIndex];
	                ar[rIndex]= ar[lIndex];
	                ar[lIndex] = temp;
	              //  printArray(ar);
	            	leftMark++;
	                rightMark--;
	                rStop=0;
	                lStop=0;
	                rIndex=0;
	                lIndex=0;
	            }
	        }// for loop ends here
	           temp = pivot;
	           ar[start]=ar[--leftMark];
	           ar[leftMark]=temp;
	         //  printArray(ar);
	           return rightMark;
  }
 static void quickSort(int[] ar) {
    
          quickSortHelper(ar,0,ar.length-1);
           
 }   
 
 static int quickSortHelper(int[] ar, int start, int end) {
	 if(start>=end){  
		 return 0;
	 }
     int splitpoint = partition(ar, start,end);
  //   System.out.println("Splitpoint is--"+splitpoint);
     quickSortHelper(ar,0,splitpoint-1);
     quickSortHelper(ar,splitpoint+1,end);
    // prinIndextArray(ar,end);
     return 1;
     
}  

 static void prinIndextArray(int[] ar, int end) {
	   for(int n =0;n<end;n++){
	      System.out.print(ar[n]+" ");
	   }
	     System.out.println("");
	}
 
 
static void printArray(int[] ar) {
   for(int n: ar){
      System.out.print(n+" ");
   }
     System.out.println("");
}
 

}
