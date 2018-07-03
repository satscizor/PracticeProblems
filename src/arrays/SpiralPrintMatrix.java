package arrays;
/*
 * TO DO
 * 
 */
public class SpiralPrintMatrix {
public static void main(String[] args) {
	int [][]matrix=new int[][] {{1,2,3,4,5},{6,7,8,9,0},{9,0,1,2,3},{4,5,6,7,8},{6,7,8,9,5}};
	for(int i=0;i<5;i++) {
		for(int j=0;j<5;j++) {
			System.out.print(matrix[i][j]+" ");
		}
		System.out.println();
	}
}

}
