package com.company;

import java.util.ArrayList;

public class Main {
    public static class student{
        String Fam;
        int Year;
        int Scores;
        static int count = 0;

    }
    public static void swap(ArrayList<student> list, int ind1, int ind2) {
        student tmp = list.get(ind1);
        list.set(ind1, list.get(ind2));
        list.set(ind2,tmp);
    }
    public static void main(String[] args) {
        ArrayList<student> list = new ArrayList<>();
        student Vova = new student();
        Vova.Fam = "Романов";
        Vova.Year = 2003;
        Vova.Scores = 98;
        student.count++;
        list.add(Vova);
        student Lexa = new student();
        Lexa.Fam = "Калоша";
        Lexa.Year = 2003;
        Lexa.Scores = 67;
        student.count++;
        list.add(Lexa);
        student Ivan = new student();
        Ivan.Fam = "Белокобыльский";
        Ivan.Year = 2003;
        Ivan.Scores = 96;
        student.count++;
        list.add(Ivan);
        student Valik = new student();
        Valik.Fam = "Воронин";
        Valik.Year = 2003;
        Valik.Scores = 93;
        student.count++;
        list.add(Valik);
        for (int left = 0; left < student.count; left++) {
            int minInd = left;
            for (int i = left; i < student.count; i++) {
                if (list.get(i).Scores < list.get(minInd).Scores) {
                    minInd = i;
                }
            }
            swap(list, left, minInd);
        }
        for (int i = 0; i < list.size();i++) {
            System.out.println(list.get(i).Fam + " " + list.get(i).Year + " " + list.get(i).Scores);
        }
    }
}
