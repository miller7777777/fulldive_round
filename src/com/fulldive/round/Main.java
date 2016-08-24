package com.fulldive.round;

/*
Расположение	элементов	на	окружности
Задача	может	быть	реализована	на	любом	языке	по	Вашему	выбору,	однако	мы
будем	признательны,	если	это	будет	си-подобный	язык.	Входными	данными
являются	радиус	окружности	в	виде	числа	с	плавающей	точкой	и	целое	число
ширины	элемента.	Нужно	рассчитать	сколько	элементов	может	поместиться	на
окружности	заданного	радиуса,	если	расстояние	между	соседними	элементами
должно	быть	не	менее	20%	от	ширины	элемента.	Ответом	должно	быть	целое
число.	Дополнительным	плюсом	будет	если	программа	сможет	равномерно
распределить	максимальное	число	элементов	на	окружности	равномерно.	В
этом	случае	ответом	должен	стать	набор	координат	на	плоскости.
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double r = Double.parseDouble(args[0]);  //радиус, для примера 42.0
        double aRad, bRad; //углы alpha и beta в радианах. Alpha - угол между радиусами, проведенными к концам сегмента. Beta - угол между соседними сегментами.
        int n = Integer.parseInt(args[1]); // ширина элемента, для примера - 45
        int result; // рассчетное количество элементов
        int k; //число точек
        double n1; //расстояние между концами соседних отрезков
        ArrayList<Point> list; //коллекция для хранения точек

        //проверка на корректность данных
        if(n > 2 * r){
            System.err.println("Данные некорректны");
            System.exit(-1);
        }


        //вычисляем углы alpha и beta
        aRad = 2 * Math.asin(n / (2 * r));
        bRad = 2 * Math.asin(0.2 * n / (2 * r));



        //вычисляем максимальное число элементов
        result = (int) (2 * Math.PI /(aRad + bRad));

        //однако, при таком значении beta, элементы будут распределены по окружности неравномерно. Для равномерного распределения нужно изменить угол beta.

        bRad = (2 * Math.PI - result * aRad) / result;

        //вычисляем число точек, нераспределенный угол и дельту нераспределенного угла для каждого сегмента
        k = 2 * result;

        //вычисляем новое расстояние между концами соседних отрезков и проверяем, что оно не меньше, чем 0.2* n

        n1 = 2 * r * Math.sin(bRad / 2);

        if (n1 < 0.2 * n){
            System.err.println("Что-то пошло не так");
        }

        System.out.println("Numbers of segment = " + result + "\n");


//        System.out.println("Numbers of points = " + k);
//        System.out.println("Unassigned corner = " + psi);
//        System.out.println("Delta of unassigned corner = " + deltaPsi);

        list = new ArrayList<Point>();


        //создаем точки, задавая их полярные координаты и добавляем в коллекцию
        for (int i = 0; i < k; i++) {

            int kAlpha;
            int kBeta;
            double fi;
            if ((i % 2) == 0){

                kAlpha = i / 2;
                kBeta = i / 2;
            }else {
                kAlpha = (int) (i / 2) + 1;
                kBeta = (int) (i / 2);
            }
            fi = kAlpha * aRad + kBeta * bRad;
            list.add(new Point(r, fi));
        }

        //вывод координат точек в полярных координатах
        System.out.println("Polar berings: \n");
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i).getRadius() + "    " + list.get(i).getFi());
        }

        //вывод координат точек в декартовых координатах
        System.out.println("\n\nDekart berings: \n");

        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i).getX() + "    " + list.get(i).getY());
        }

    }
}
