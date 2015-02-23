/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author samuel
 */
public class Ordenamiento {

    public static void main(String[] args) {

        Algoritmos A = new Algoritmos();
        int[] arreglo = {22,16,17,23,24,25,26,27,48,28,6,5,4,29,30,0,1,31,32,33,34,18,35,36,37,38,39,40,41,42,43,44,45,46,52};
        Random r = new Random();

        /* Para radix
        int LENGTH = 1000000;
         Object[] list = new Object[LENGTH];

         double promedio =0;
         for (int j = 0; j < 10; j++) {
          Random generator = new Random();
        for (int i = 0; i < LENGTH; i++) {
            list[i] = generator.nextInt(LENGTH);
        }
        long start = System.nanoTime();
             long startTime = System.nanoTime();
             Object[] sortedList = Algoritmos.radixsort(list);
            long endTime = System.nanoTime();
             long duration = (endTime - startTime);         
            double seconds = (double)duration / 1000000000.0;
            System.out.println("El tiempo de Radix en " + LENGTH + "fue de: " + seconds);
            promedio+=seconds;
              
       
        }
         promedio=promedio/10;
             System.out.println("El promedio de Radix fue de " + promedio);
       

        // Sort the list.
        
       
   
        Para Radix */
        
        
       int length= 100000;

        double promedio = 0;
        for (int i = 0; i < 10; i++) {
           
              System.out.println(length);
            arreglo = new int[length + 1];
            for (int j = 0; j < length; j++) {
            arreglo[j] = r.nextInt(1000) + 1;
            }
            long startTime = System.nanoTime();
            A.Selection(arreglo);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);         
            double seconds = (double)duration / 1000000000.0;
            System.out.println("El tiempo de Insertion en " + length + " fue de: " + seconds);
            promedio+=seconds;
        }
        System.out.println(promedio);
          promedio=promedio/10;
          System.out.println("El promedio final fue " + promedio);
        
                }
        

        long startTime = System.nanoTime();

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
                
    }
    
    


