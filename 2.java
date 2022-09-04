package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    public static void main(String[] args) {
        //Сортировка пузырьком
        long startTime = System.nanoTime();
        int[] array1 = new int[100];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = ((int)(Math.random() * 31) - 15);
        }
        System.out.println(Arrays.toString(array1));
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array1.length; i++) {
                if (array1[i] < array1[i - 1]) {
                    swap(array1, i, i-1);
                    needIteration = true;
                }
            }
        }
        System.out.println(Arrays.toString(array1));
        long endTime = System.nanoTime();
        System.out.println("Время выполнения алгоритма: " + (endTime - startTime));
        //Сортировка выбором
        startTime = System.nanoTime();
        int[] array2 = new int[100];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = ((int)(Math.random() * 31) - 15);
        }
        System.out.println(Arrays.toString(array2));
        for (int left = 0; left < array2.length; left++) {
            int minInd = left;
            for (int i = left; i < array2.length; i++) {
                if (array2[i] < array2[minInd]) {
                    minInd = i;
                }
            }
            swap(array2, left, minInd);
        }
        System.out.println(Arrays.toString(array2));
        endTime = System.nanoTime();
        System.out.println("Время выполнения алгоритма: " + (endTime - startTime));
        //Сортировка вставками
        startTime = System.nanoTime();
        int[] array3 = new int[100];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = ((int)(Math.random() * 31) - 15);
        }
        System.out.println(Arrays.toString(array3));

        for (int left = 0; left < array3.length; left++) {
            // Вытаскиваем значение элемента
            int value = array3[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array3[i]) {
                    array3[i + 1] = array3[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array3[i + 1] = value;
        }
        System.out.println(Arrays.toString(array3));
        endTime = System.nanoTime();
        System.out.println("Время выполнения алгоритма: " + (endTime - startTime));
        //Членочная сортировка
        startTime = System.nanoTime();
        int[] array4 = new int[100];
        for (int i = 0; i < array4.length; i++) {
            array4[i] = ((int)(Math.random() * 31) - 15);
        }
        System.out.println(Arrays.toString(array4));
        for (int i = 1; i < array4.length; i++) {
            if (array4[i] < array4[i - 1]) {
                swap(array4, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array4[z] < array4[z - 1]) {
                        swap(array4, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array4));
        endTime = System.nanoTime();
        System.out.println("Время выполнения алгоритма: " + (endTime - startTime));
        //Сортировка Шелла
        startTime = System.nanoTime();
        int[] array5 = new int[100];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = ((int)(Math.random() * 31) - 15);
        }
        System.out.println(Arrays.toString(array5));
// Высчитываем промежуток между проверяемыми элементами
        int gap = array5.length / 2;
// Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < array5.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array5[c] > array5[c + gap]) {
                        swap(array5, c, c + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
        System.out.println(Arrays.toString(array5));
        endTime = System.nanoTime();
        System.out.println("Время выполнения алгоритма: " + (endTime - startTime));
        File file = new File("C://Users//PC//IdeaProjects//untitled//sort.dat");
        try(FileOutputStream fos=new FileOutputStream("C://Users//PC//IdeaProjects//untitled//sort.dat"))
        {
           String text =  Arrays.toString(array1) + "\n" + Arrays.toString(array2) + "\n" + Arrays.toString(array3) + "\n" +
            Arrays.toString(array4) + "\n" + Arrays.toString(array5) + "\n";
            byte[] buffer = text.getBytes();
            fos.write(buffer);
            System.out.println("The file has been written");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
