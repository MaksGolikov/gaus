package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        double[][] arr = new double[3][4];
        double[][] mainArr = new double[3][4];
//        arr[0][0] = 4.42;
//        arr[0][1] = 12.6;
//        arr[0][2] = 5.77;
//        arr[0][3] = 1.56;
//        arr[1][0] = 0.16;
//        arr[1][1] = 3.82;
//        arr[1][2] = 6.41;
//        arr[1][3] = 4.42;
//        arr[2][0] = 7.14;
//        arr[2][1] = 4.98;
//        arr[2][2] = 8.73;
//        arr[2][3] = -2.67;


        //fill array
        //fill(arr);

        //fill array with my values
        fillWithMyValues(arr);

        double x = (arr[0][0] * (arr[1][1] * arr[2][2]
                - arr[1][2] * arr[2][1]));
        double y = (arr[0][1] * (arr[1][0] * arr[2][2]
                - arr[1][2] * arr[2][0]));
        double z = (arr[0][2] * (arr[1][0] * arr[2][1]
                - arr[1][1] * arr[2][0]));
        double determinant = x - y + z;
        System.out.println("The modulus of the given arr is " + determinant);
        if (determinant <= 0) {
            System.exit(1);
        } else {
            System.out.println(determinant + " != 0");
        }

        for (int i = 0; i < 3; i++) {
            System.arraycopy(arr[i], 0, mainArr[i], 0, 4);
        }
        //print array
        print(arr);
        //first string in tempLines
        List<Double> tempLines = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tempLines.add(arr[0][i]);
        }
        //divide first line on arr 0 0
        List<Double> temp = new ArrayList<>();
        if (arr[0][0] != 0) {
            for (int i = 0; i < 4; i++) {
                temp.add(tempLines.get(i) / arr[0][0]);
            }
        }

        //print result of divided
        /*for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i)+" ");
        }
        System.out.println();*/

        //write result in first line
        for (int i = 0; i < 4; i++) {
            arr[0][i] = temp.get(i);
        }


        //from second line minus first that multiple arr 1 0
        tempLines.clear();
        for (int i = 0; i < 4; i++) {
            tempLines.add(arr[1][i]);
        }
        for (int i = 0; i < 4; i++) {
            temp.set(i, (tempLines.get(i) - temp.get(i) * arr[1][0]));
        }

        //print result of calculation
        /*for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i)+" ");
        }
        System.out.println();*/

        //write result in second line
        for (int i = 0; i < 4; i++) {
            arr[1][i] = temp.get(i);
        }

        //from third line minus first that multiple arr 2 0
        tempLines.clear();
        for (int i = 0; i < 4; i++) {
            tempLines.add(arr[2][i]);
        }
        List<Double> firstLine = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            firstLine.add(arr[0][i]);
        }
        for (int i = 0; i < 4; i++) {
            temp.set(i, (tempLines.get(i) - firstLine.get(i) * arr[2][0]));
        }

        //write result in third line
        for (int i = 0; i < 4; i++) {
            arr[2][i] = temp.get(i);
        }

        //divide second line on arr 1 1
        List<Double> secondLine = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            secondLine.add(arr[1][i]);
            if (arr[1][1] != 0) {
                secondLine.set(i, secondLine.get(i) / arr[1][1]);
            }
        }

        //write result in second line
        for (int i = 0; i < 4; i++) {
            arr[1][i] = secondLine.get(i);
        }

        //from first line minus second line that multiple arr 0 1
        for (int i = 0; i < 4; i++) {
            temp.set(i, firstLine.get(i) - secondLine.get(i) * arr[0][1]);
        }

        //write result in first line
        for (int i = 0; i < 4; i++) {
            arr[0][i] = temp.get(i);
        }

        //from third line minus second line multiple on arr 2 1
        List<Double> thirdLine = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            thirdLine.add(arr[2][i]);
        }
        for (int i = 0; i < 4; i++) {
            temp.set(i, thirdLine.get(i) - secondLine.get(i) * arr[2][1]);
        }

        //write result in third line
        for (int i = 0; i < 4; i++) {
            arr[2][i] = temp.get(i);
        }

        //divide third line on arr 2 2
        for (int i = 0; i < 4; i++) {
            thirdLine.set(i, arr[2][i]);
            if (arr[2][2] != 0) {
                temp.set(i, thirdLine.get(i) / arr[2][2]);
            }
        }

        //write result in third line
        for (int i = 0; i < 4; i++) {
            arr[2][i] = temp.get(i);
        }

        //from first line minus third line that multiple on arr 0 2
        for (int i = 0; i < 4; i++) {
            firstLine.set(i, arr[0][i]);
        }
        for (int i = 0; i < 4; i++) {
            thirdLine.set(i, arr[2][i]);
        }
        for (int i = 0; i < 4; i++) {
            temp.set(i, firstLine.get(i) - thirdLine.get(i) * arr[0][2]);
        }

        //write result in first line
        for (int i = 0; i < 4; i++) {
            arr[0][i] = temp.get(i);
        }

        //from second line minus third that multiple on arr 1 2
        for (int i = 0; i < 4; i++) {
            secondLine.set(i, arr[1][i]);
        }
        for (int i = 0; i < 4; i++) {
            thirdLine.set(i, arr[2][i]);
        }
        for (int i = 0; i < 4; i++) {
            temp.set(i, secondLine.get(i) - thirdLine.get(i) * arr[1][2]);
        }

        //write result in second line
        for (int i = 0; i < 4; i++) {
            arr[1][i] = temp.get(i);
        }

        print(arr);

        //answer
        System.out.println("Answer");
        System.out.printf("x1 = %.2f%n", arr[0][3]);
        System.out.printf("x2 = %.2f%n", arr[1][3]);
        System.out.printf("x3 = %.2f%n", arr[2][3]);

        List<Double> lst = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lst.add(mainArr[0][i]);
        }
        double[] tempArr = {arr[0][3], arr[1][3], arr[2][3]};
        System.out.println("Check first line");
        check(lst, tempArr);
    }

    public static void fill(double[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("arr" + i + j);
                arr[i][j] = sc.nextDouble();
            }
        }
    }

    public static void print(double[][] arr) {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    public static void check(List<Double> list, double[] arr) {
        double temp = 0;
        for (int i = 0; i < 3; i++) {
            double a = list.get(i) * arr[i];
            temp += a;
        }
        System.out.printf("%.2f%n", temp);
    }

    public static void fillWithMyValues(double[][] arr) {
        arr[0][0] = 2.70;
        arr[0][1] = 2.61;
        arr[0][2] = 3.24;
        arr[0][3] = 3.05;
        arr[1][0] = 2.48;
        arr[1][1] = 0.18;
        arr[1][2] = 1.71;
        arr[1][3] = 2.55;
        arr[2][0] = 1.20;
        arr[2][1] = 3.48;
        arr[2][2] = 0.97;
        arr[2][3] = 1.35;
    }
}
