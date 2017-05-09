import java.util.*;
public class Inverse {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	double[][] inp = new double[N][N];
	//take input from user
	for (int i = 0; i < inp.length; i++) {
		for (int j = 0; j < inp.length; j++) {
			inp[i][j]=in.nextDouble();
		}
	}
	Inverse obj = new Inverse();
	double[][] output = obj.inverseMatrix(inp);
	System.out.println("The inverse matrix is--->>>>");
	for (int i = 0; i < output.length; i++) {
		for (int j = 0; j < output.length; j++) {
			System.out.print(output[i][j]+" ");
		}
		System.out.println();
	}
}

public double[][] inverseMatrix(double[][]in){
	int len=in.length, breadth=in[0].length;
	
	double[][] output  = new double[len][breadth]; // to give the output to array
	double[][] orgArr  = new double[len][breadth*2]; // to store the original array values
	double[][] tempArr = new double[len][breadth*2]; // temporary array to store the in-between values

	//initialize the identity matrix of same size
	for (int i=0;i<len;i++){
		for (int j=0;j<breadth*2;j++){
			if (j-i==len) 
				orgArr[i][j]=1;
			if(j<breadth)
				orgArr[i][j]=in[i][j];
		}
	}
	// convert the original matrix elements into zero below the mid row
	for (int i=0;i<len;i++){
		for (int j=0;j<len;j++){
			for (int k=0;k<breadth*2;k++){
				if (i==j)
					tempArr[i][k]=orgArr[i][k]/orgArr[i][i];
				else
					tempArr[j][k]=orgArr[j][k];
			}
		}
		orgArr=copyArray(tempArr);		
		for (int j=i+1;j<len;j++){
			for (int k=0;k<breadth*2;k++){
				tempArr[j][k]=orgArr[j][k]-orgArr[i][k]*orgArr[j][i];
			}
		}
		orgArr=copyArray(tempArr);
	}
	// convert the original matrix elements into zero above the mid row
	for (int i=breadth-1;i>0;i--){
		for (int j=i-1;j>=0;j--){
			for (int k=0;k<breadth*2;k++){
				tempArr[j][k]=orgArr[j][k]-orgArr[i][k]*orgArr[j][i];
			}
		}
		orgArr=copyArray(tempArr);
	}
	//right part of matrix is the inverse matrix
	for (int i=0;i<len;i++){
		for (int j=breadth;j<breadth*2;j++){
			output[i][j-breadth]=tempArr[i][j];
		}
	}
	return output;
}

public double[][] copyArray(double[][]in){
	double[][]output= new double[in.length][in[0].length];
	for(int v=0;v<in.length;v++){
		for (int s=0;s<in[0].length;s++){
			output[v][s]=in[v][s];
		}
	}
	return output;
}
}
