/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenamiento;

import java.util.LinkedList;

/**
 *
 * @author samuel
 */
public class Algoritmos {
    
    
    public int[] Bubble(int[] arr){
        
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j<arr.length -1; j++) {
                if(arr[j-1]> arr[j]){
                    temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        return arr;
    }
    
    public int[]Insertion(int[] arr){
        for (int i = 1; i < arr.length-1; i++) {
            int temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1]>temp){
                arr[j] =arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
        return arr;
    }
    
    
    public int[]Selection(int[]arr){
        int min;
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
             if(min != i) {
                    temp = arr[min];
                    arr[min]=arr[i];
                    arr[i]=temp;
                 }
        }
        return arr;
    }
    public static int[] mergeSort(int [] lista) {
        if (lista.length <= 1) {
            return lista;
        }
        
        int[] primero = new int[lista.length / 2];
        int[] segundo = new int[lista.length - primero.length];
        System.arraycopy(lista, 0, primero, 0, primero.length);
        System.arraycopy(lista, primero.length, segundo, 0, segundo.length);
        
        mergeSort(primero);
        mergeSort(segundo);
        merge(primero, segundo, lista);
        return lista;
    }
    
    private static void merge(int[] primero, int[] segundo, int [] resultado) {
        int iPrimero = 0;
        int iSegundo = 0;
        
        int j = 0;
        while (iPrimero < primero.length && iSegundo < segundo.length) {
            if (primero[iPrimero] < segundo[iSegundo]) {
                resultado[j] = primero[iPrimero];
                iPrimero++;
                } else {
                resultado[j] = segundo[iSegundo];
                iSegundo++;
            }
            j++;
        }
        System.arraycopy(primero, iPrimero, resultado, j, primero.length - iPrimero);
        System.arraycopy(segundo, iSegundo, resultado, j, segundo.length - iSegundo);
    }
    
    
    
    
    
    public void print(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        
        
    }
    
    
    public static int heapSize;
    public static int LEFT(int i)
    {
        return 2*i+1;
    }

    public static int RIGHT(int i)
    {
        return 2*i+2;
    }


    public static void BUILD_MAX_HEAP(int A[])
    {
        heapSize = A.length;
        for(int i=A.length/2; i>=0;i--)
        {
            MAX_HEAPIFY(A, i);
        }
    }


    public static void MAX_HEAPIFY(int A[],int i)
    {
        int l=LEFT(i);
        int r=RIGHT(i);
        int largestElementIndex = -1;
        if(l<heapSize && A[l]>A[i]){
            largestElementIndex = l;
        }
        else 
        {
            largestElementIndex=i;
        }
        if(r<heapSize && A[r]>A[largestElementIndex])
        {
            largestElementIndex = r;
        }
        
        if(largestElementIndex!=i)
        {
            int temp = A[i];
            A[i]=A[largestElementIndex];
            A[largestElementIndex]=temp;
            MAX_HEAPIFY(A, largestElementIndex);
        }
    }

    public static int[] HEAP_SORT(int A[])
    {
        BUILD_MAX_HEAP(A);
        for(int i=A.length-1;i>=0;i--)        {
            int temp = A[0];
            A[0]=A[i];
            A[i]=temp;
            heapSize  = heapSize-1;
            MAX_HEAPIFY(A,0);
        }
        return A;
    }
    
    //QUICK SORT
    
    private int array[];
    private int length;
 
    public void QUICK_SORT(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
       private static LinkedList[] q = {
        new LinkedList(), // 0
        new LinkedList(), // 1
        new LinkedList(), // 2
        new LinkedList(), // 3
        new LinkedList(), // 4
        new LinkedList(), // 5
        new LinkedList(), // 6
        new LinkedList(), // 7
        new LinkedList(), // 8
        new LinkedList() // 9
    };
    
     public static Object[] radixsort(Object[] list) {
        // Get the maximum number of digits.
        int maxDigits = getMaxDigits(list);

        // Iterate through the radix depending on max digits.
        for (int r = 1; r <= maxDigits; r++) {

            // Iterate through every number.
            int radix;
            for (int n = 0; n < list.length; n++) {          
                // Figure out what queue to put it into.
                radix = getDigitAt(Integer.parseInt(list[n].toString()), r);
                // Put it into it's queue accordinmaxDigits = getMaxDigits(list);g to the radix.
                q[radix].offer(list[n]);
            }

            // Go through the queues and put the numbers back into the list.
            int a = 0;
            for (int k = 0; k < q.length; k++) {
                // Go through every element in the queue.
                while (q[k].peek() != null) {
                    list[a++] = q[k].poll();
                }
            }

        }

        // Return the list, it is now sorted.
        return list;

    }


    public static int getMaxDigits(Object list[]) {
        // Define the max digits.
        int maxDigits = 0;

        // Iterate through the list.
        int digits;
        for (int i = 0; i < list.length; i++) {

            // Cast the number to a string.
            digits = getDigits(Integer.parseInt(list[i].toString()));

            // Compare the lengths.
            if (digits > maxDigits) {
                maxDigits = digits;
            }

        }

        // Return the max digits.
        return maxDigits;
    }


    public static int getDigits(int i) {
        if (i < 10) {
            return 1;
        }
        return 1 + getDigits(i / 10);
    }

    public static int getDigitAt(int number, int radix) {
        return (int) (number / Math.pow(10, radix - 1)) % 10;
    }

    
}
