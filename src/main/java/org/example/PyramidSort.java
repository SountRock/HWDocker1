package org.example;

import java.util.Arrays;

public class PyramidSort {
    public void sort(int[] arr){
        // Построение кучи (перегруппируем массив)
        // Выдвигаем самый большой элемент в 0 позицию
        for (int i = arr.length / 2 - 1; i >= 0 ; i--){
            heapify(arr, arr.length, i);
            
            //System.out.println(Arrays.toString(arr));
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = arr.length - 1; i >= 0 ; i--){
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i]= temp;

            //System.out.println(Arrays.toString(arr));

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int sizePyramid, int root){
        int largest = root; // Инициализируем наибольший элемент как корень
        int left = 2 * root + 1; // левый = 2 * i + 1
        int right = 2 * root + 2; // правый = 2 * i + 2

        if(left < sizePyramid && arr[left] > arr[largest])
            largest = left;

        if(right < sizePyramid && arr[right] > arr[largest])
            largest = right;

        if(largest != root){
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, sizePyramid, largest); //сравниваем для следущего (largest) индекса
        }
    }
}
