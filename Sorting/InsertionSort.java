import java.util.*;

public class InsertionSort {
	
	private int[] sortArray(int[] input) {
		if( input!=null && input.length>=2 ) {
		
			int j=0, temp=0;
			for(int i=1; i<input.length; i++) {
				//System.out.println( "i=" + i);
				j=i;
				while(j>=1 && input[j]<input[j-1]) {
					//System.out.println( "j=" + j);
					temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
					j=j-1;
				}
			}
		}
		return input;
	}
	public static void main(String[] args) {
	
		InsertionSort isr1 = new InsertionSort();
		int[] inArr = {84, 32, 45, 98, 54, 35, 54};
		System.out.println(Arrays.toString(inArr));
		int[] outArr = isr1.sortArray(inArr);
		System.out.println(Arrays.toString(outArr));
	}
}