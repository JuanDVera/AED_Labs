package model;

import java.util.*;

public class BattleField {
	
	private ArrayList<int[][]> matrices;
	private int[][] definitive;
	
	public BattleField() {		
		matrices = new ArrayList<int[][]>();		
	}
	
	
	public void createShips(){
		
		// two random x an y
		
		int x = 0, y = 0;
		
		int[][] matrix = new int[x][y];
		
		// random numbers while add
		
		matrices.add(matrix);
	}

	public void createShips(int m, int n){
		
		int[][] matrix = new int[m][n];

		// random
		
		matrices.add(matrix);
	}
	
	public void createShips(int[] numbers, int m, int n) {

		int[][] matrix = new int[m][n];
		
		int k = 0;
		
		for(int i =0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = numbers[k];
				k++;
			}
		}
		
		matrices.add(matrix);
	}
	
	public ArrayList<int[][]> getMatrices() {
		return matrices;
	}
	
	public int[][] getDefinitive(){
		return definitive;
	}
	
	/**
	 * <pre> A and B are matrices that A(m*n)  ^ B(n*p)
	 * first method to operate the matrices. multiply two matrices
	 * C[c(i)] += A[x,k] * B[k,y] to k < n
	 * @param A, the matrix that is going to be multiplied with B
	 * @param B, is a recorded, saved matrix from past battles
	 * @return a brand new matrix "C" with the result
	 */
	public void MultiplationOne(int[][] A, int[][] B){
		
		int[][] C = new int [A.length][B[0].length];// C(m*p)
		
		for (int i = 0; i < C.length; i++) {
			  for (int j = 0; j < C[i].length; j++) {
			    for (int z = 0; z<B.length; z++) {
			      C [i][j] += A[i][z] * B[z][j];
			    }
			  }
			}		
		
		definitive =  C;
	}
	
	//guarda las multiplicaciones, guarda sumas y agrega a la nueva matriz
	public void MultiplationTwo(int[][] A, int[][] B){
		
		int [] arreglo = new int[A.length * B[0].length * B.length];
		int k = 0;
		
		for(int i = 0; i < A.length; i++) {
			for( int j = 0; j < B[0].length; j++) {
				for(int z = 0; z < A[0].length; z++) {
				
					arreglo[k] = A[i][z] * B[z][j];
					k++;					
				}
			}
		}

		int[] suma = new int[B.length * B.length];
		int z = 0; k = 0;
		
		for(int i = 0; i < suma.length; i++) {
			while(k < arreglo.length && z < B.length) {
				suma[i] += arreglo[k];
				k++; z++;
			}
			z = 0;
		}
		
		int[][] C = new int [A.length][B[0].length];
		k = 0;
		
		for(int i = 0; i < C.length; i++) {
			for( int j = 0; j < C[0].length; j++) {
				C[i][j] = suma[k];
				k++;
			}
		}
		definitive = C;	
	}
	
	// en el x,y de la nueva matriz mete el producto punto de una
	public void MultiplationThree(int[][] A, int[][] B){
		
		int[][] C = new int[A.length][B[0].length];
		int x = 0, y  = 0, z = 0, k = 0;
		
		for(int i = 0; i < C.length; i++){
			for(int j = 0; j < C[0].length; j++){
				while(k < B.length){
					z += A[x][k] * B[k][y];
					k++;
				}
				y++; 	k = 0;
				C[i][j] = z;
				z = 0;
			}
			x++;	y = 0;
		}
		definitive = C;
	}

}
