package com.acme.algorithms.searching;

import java.util.Arrays;

/**
 * Algoritmo de Burbuja.
 * 		El algoritmo seguire los siguientes pasos:
 *		Se tomar el primer elemento y se compara con el siguiente
 *	   	En caso de que sea mayor se intercambiara los elementos de posicion
 *		En caso de que sea menor se hara nada
 *		del lado derecho se ira creando la particion ordenada
 * 
 * @author josel.rojas
 *
 */
public class BubbleSort {
	
	public static void main(String... args) {
		
		int[] numbersToOrder = new int[]{8, 5, 12, 2, 7, 1};
		//int[] numbersToOrder = new int[]{18, 32, -11, 6, 68, 2, -34};
		int temp = 0;
		
		//Take each element in array to compare between them.
		//We compare up to length 2 to can compare i+1
		//Loop from 8 (position 0) up to 2 (position 3)
		OUTER_LOOP: for(int i = 0; i < numbersToOrder.length; i++) {
						
			//First, newly take first element and compare with next element. So, 8 and 5
			INNER_LOOP: for(int j = 0; j < (numbersToOrder.length - i - 1); j++) {
				
				// 1.- 8 > 5
				// 2.- 8 > 12
				// 3.- 12 > 2
				//4.- 
				if(numbersToOrder[j] > numbersToOrder[j+1]) {
					
					//Backup to value to move.
					//Fisrt, take 5 and backup.
					//Second, it does not happend nothing
					//Third, take 2 and backup. 
					temp = numbersToOrder[j+1];
					//System.out.println("Value to move to left: " + temp);
					
					//Interchange values according to order.
					//First, 8 is assigned to position j+1 and minor value, 5 is assigned to first position
					//Third, 12 is assigned to position j+1 and minor value, 2 is assigned to first position
					numbersToOrder[j+1] = numbersToOrder[j];
					numbersToOrder[j] = temp;
					
					//When j = 0 the values are ordered to: 5, 8, 12, 2, 7
					//When j = 1 loop does not entry to this section because 8 > 12 = false
					//When j = 2 the values are ordered to: 5, 8, 2, 12, 7
					//When j = 3 loop does not entry to this section because 12 > 7 = false
					
					
				}
				
				System.out.println("When i = " + i + " and j = " + j + "\n\tnumbersToOrder: " + Arrays.toString(numbersToOrder));
				
			}
						
		}
		
	}

}
