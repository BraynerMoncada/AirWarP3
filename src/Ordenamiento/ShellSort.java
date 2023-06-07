/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamiento;

/**
 *
 * @author Vidal Flores
 */
public class ShellSort {
    
    public static void shellSort(int[] array) {
        int n = array.length;
        
        // Calcula el tamaño del salto inicial
        int salto = n / 2;
        
        // Realiza la clasificación con la secuencia de saltos decrecientes
        while (salto > 0) {
            for (int i = salto; i < n; i++) {
                int temp = array[i];
                int j = i;
                
                // Desplaza los elementos hacia la derecha hasta encontrar la posición correcta
                while (j >= salto && array[j - salto] > temp) {
                    array[j] = array[j - salto];
                    j -= salto;
                }
                
                array[j] = temp;
            }
            
            // Actualiza el tamaño del salto
            salto /= 2;
        }
    }
    
    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
