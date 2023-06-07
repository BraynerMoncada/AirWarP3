
package Ordenamiento;

import java.util.ArrayList;

/**
 *
 * @author Vidal Flores
 */
public class InsertionSort {

    public static void insertionSort(ArrayList<Integer> lista) {
        int n = lista.size();

        for (int i = 1; i < n; i++) {
            int valorActual = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j) > valorActual) {
                lista.set(j + 1, lista.get(j));
                j--;
            }

            lista.set(j + 1, valorActual);
        }
    }
}
