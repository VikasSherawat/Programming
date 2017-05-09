package sorting;

import java.util.Scanner;

public class FindMedian {
	static int median =0;
	 static int length=0;
	 static int[] ar;
	 public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         ar  = new int[n];
         length=n;
         for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
         }
      quickSort(ar);
      System.out.println("Final Result");
      printArray(ar);
     } 
    
  static int partition(int[] ar, int start, int end){
	  int first =  ar[start];
	  int pivot = first,temp;
	  int last = ar[end];
	  int middle = ar[start+end/2];
	  int lIndex=0, rIndex=0;
	  if(first>last){
		  pivot = first;
		 ar[start] = last; 
	  }else if(middle>last){
		  pivot = middle;
		  ar[start+end/2]=last;
	  }
	  int i=0,j=end-1;
	  while (true) {
		  if(i>=j){
			  if(ar[i]>pivot)
			  {
				  ar[end]=ar[i];
				  ar[i]=pivot;
				  return i;
			  }else{
				  ar[end]=ar[i+1];
				  ar[i+1]=pivot;
				  return i+1;
			  }
			  
		  }
		  if(ar[i]>pivot && lIndex==0){
			  lIndex=i;
		  }
		  else if(lIndex==0)
		  i++;
		  if(ar[j]<pivot && rIndex==0){
			  rIndex = j;
		  }
		  else if(rIndex==0)
		  j--;
		  if(rIndex!=0 && lIndex!=0)
		  { temp = ar[rIndex];
		   ar[rIndex]=ar[lIndex];
		   ar[lIndex]=temp;
		   lIndex=rIndex=0;
		  }
	
	}//while loop ends here
  }
 static void quickSort(int[] ar) {
    
	 quickSortHelper(ar,0,ar.length-1);
	// System.out.println(ar[median]);
           
 }   
 
 static int quickSortHelper(int[] ar, int start, int end) {
	 if(start>=end){  
		 return 0;
	 }
     int splitpoint = partition(ar, start,end);
     quickSortHelper(ar,0,splitpoint-1);
     quickSortHelper(ar,splitpoint+1,end);
     return 1;
     
}  
 
static void printArray(int[] ar) {
   for(int n: ar){
      System.out.print(n+" ");
   }
     System.out.println("");
}
 
}
