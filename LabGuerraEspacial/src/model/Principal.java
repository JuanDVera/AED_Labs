package model;

public class Principal {//va sumando la multiplicacion en el x,y de la nueva matriz
	
	public static int[][] multiplicacionUno(int[][] A, int[][] B){
		
		int[][] C = new int [A.length][B[0].length];
		
		for (int i = 0; i < C.length; i++) {
			  for (int j = 0; j < C[i].length; j++) {
			    for (int z = 0; z<B.length; z++) {
			      C [i][j] += A[i][z] * B[z][j]; 
			    }
			  }
			}		
		
		return C;
	}
	
	//guarda las multiplicaciones y luego va sumando y agregando en el x,y de la nueva matriz 
	public static int[][] multiplicacionDos(int[][] A, int[][] B){
		
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
		return C;	
	}
	
	// en el x,y de la nueva matriz mete el producto punto de una
	public static int[][] multiplicacionTres(int[][] A, int[][] B){
		
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
		
		return C;
	}
	
	public static void main(String[] args) {
		
		int[][] A = new int[2][3], B = new int[3][2]; 
		
		A[0][0] = 1; A[0][1] = 2; A[0][2] = 3;			B[0][0] = 5; B[0][1] = 1;
		A[1][0] = 4; A[1][1] = 5; A[1][2] = 6;			B[1][0] = 1; B[1][1] = 0;
														B[2][0] = 2; B[2][1] = 3;
		
		System.out.println();
		System.out.println("la 1");
		System.out.println();		
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(multiplicacionUno(A, B)[i][j] + " ");
			}
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println("la 2");
		System.out.println();
														
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(multiplicacionDos(A, B)[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("la 3");
		System.out.println();
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(multiplicacionTres(A, B)[i][j] + " ");
			}
			System.out.println();
		}
		
	}	
}
