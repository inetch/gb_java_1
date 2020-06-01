package ru.gb.hw2;

import java.lang.Math;
import java.util.Arrays;

public class MainClass2 {
    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void inverseBinArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    //  2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static int[] array3(int size){
        int[] arr   = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = i * 3;
        }
        return  arr;
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    private static void multipleLess(int[] arr, int threshold, int multiplier){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < threshold){
                arr[i] *= multiplier;
            }
        }
    }
    /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    private static void fillDiagonals(int[][] matrix, int filler){
        //IOB possibility in case of the matrix isn't a real matrix
        for(int i = 0; i < matrix.length; i++){
            matrix[i][i]    = filler;
            matrix[i][matrix[i].length - 1 - i] = filler;
        }
    }

    private static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    private static int[] getMinMax(int[] arr){
        //internal convention: the first element is min, the second - max
        int[] min_and_max   = new int[2];

        min_and_max[0]  = arr[0];
        min_and_max[1]  = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min_and_max[0]){
                min_and_max[0] = arr[i];
            }
            if(arr[i] > min_and_max[1]){
                min_and_max[1] = arr[i];
            }
        }
        return min_and_max;
    }

    /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
         если в массиве есть место, в котором сумма левой и правой части массива равны.
         Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
         граница показана символами ||, эти символы в массив не входят.
     */
    private static boolean checkBalance(int[] arr){
        //works with non-negative numbers only!
        int left_i      = 0;
        int right_i     = arr.length - 1;

        int left_sum    = arr[left_i];
        int right_sum   = arr[right_i];

        while(left_i < right_i - 1){
            if(left_sum < right_sum){
                left_sum += arr[++left_i];
            }else{
                right_sum += arr[--right_i];
            }
        }
        return left_sum == right_sum;
    }
    /*7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
         при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    private static void rotateArray(int[] arr, int shift){
        if(shift == 0) return;

        //normalize
        int sh  = shift % arr.length;
        if(sh < 0) {
            sh = arr.length + sh;
        }

        int prev = arr[0];
        int x = 0;
        for(int i = 0; i < arr.length; i++){
            x += sh;
            if(x >= arr.length){
                x -= arr.length;
            }
            int tmp = arr[x];
            arr[x] = prev;
            prev = tmp;
        }
    }

    public static void main(String[] args){
        //1
        int binArraySize    = 10;
        int[] bin_array     = new int[binArraySize];

        //fill the array
        for(int i = 0; i < binArraySize; i++){
            bin_array[i]    = (int)(Math.random() * 1.999);
        }
        System.out.println("1. Before: " + Arrays.toString(bin_array));

        inverseBinArray(bin_array);

        System.out.println("1. After:  " + Arrays.toString(bin_array));

        //2
        int arr3Size    = 8;
        int[] arr3      = array3(arr3Size);

        System.out.println("2: " + Arrays.toString(arr3));

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr6  = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3. Before: " + Arrays.toString(arr6));
        multipleLess(arr6, 6, 2);

        System.out.println("3. After:  " + Arrays.toString(arr6));

        /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
             и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        int matrixSize = 5;
        int[][] matrix  = new int[matrixSize][matrixSize];
        System.out.println("4. Before:");
        System.out.println(Arrays.deepToString(matrix));
        //printMatrix(matrix);  --deepToString
        fillDiagonals(matrix, 1);
        System.out.println("4. After:");
        //printMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));

        //5
        //fill the array
        int[] arr5  =   new int[10];
        for(int i = 0; i < arr5.length; i++){
            arr5[i]    = (int)(Math.random() * 100);
        }
        System.out.println("5: " + Arrays.toString(arr5));

        int[] min_max   = getMinMax(arr5);
        System.out.println("Min: " + min_max[0] + "; Max: " + min_max[1]);

        //6. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        int[] test  = {2, 2, 2, 1, 2, 2, 10, 1};
//        int[] test  = {2, 2, 2, 1, 2, 2, 10, 10};
//            int[] test  = {1, 1, 1, 2, 1};
//            int[] test  = {1, 1, 1, 1, 1};
//            System.out.println("6: " + checkBalance(test));
        System.out.println("6: " + checkBalance(test) + ": " + Arrays.toString(test));

        //7
        int[] to_shift = {1, 2, 3, 4, 5};
        int shift = -7;
        System.out.println("7. Before: " + Arrays.toString(to_shift));
        rotateArray(to_shift, shift);
        System.out.println("7. After shift " + shift + ": " + Arrays.toString(to_shift));
    }
}
