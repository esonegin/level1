import java.util.*;


public class Level1 {

    public static int Unmanned(int L, int N, int[][] track) {
        int time = 0;
        int rasstoyanie = 0;
        if (track.length == 0) {
            time = L;


        } else {
            Svetofors[] svetofors = arraySvetofors(track);
            //Проходим цикл, пока расстояние не станет равно длинне пути

            while (rasstoyanie < L) {

                //Проходим цикл по светофорам
                for (int i = 0; i < svetofors.length; i++) {
                    //Прибавляем время и расстояние, если не находимся на светофоре
                    if (rasstoyanie != svetofors[i].mesto) {
                        rasstoyanie++;
                        time++;
                    }
                    //Прибавляем время и расстояние, если включился зеленый
                    else if (rasstoyanie == svetofors[i].mesto
                            && (svetofors[i].TimeStep(time, svetofors[i].redtime, svetofors[i].greentime).equals("green"))) {
                        rasstoyanie++;
                        time++;
                        continue;
                    }
                    //Прибавляем только время, если светофор красный
                    else if (rasstoyanie == svetofors[i].mesto
                            && (svetofors[i].TimeStep(time, svetofors[i].redtime, svetofors[i].greentime).equals("red"))) {
                        time++;
                    }
                    break;
                }
            }
        }
        return time;

    }


    public static class Svetofors {
        int mesto;
        int redtime;
        int greentime;

        public Svetofors(int mesto, int red, int green) {
            this.mesto = mesto;
            this.redtime = red;
            this.greentime = green;
        }

        //Цвет светофора в момент времени
        public String TimeStep(int time, int red, int green) {
            String result = null;

            //Дефолтный красный
            if (time <= red - 1) {
                result = "red";
            }

            //Дефолтный зеленый
            if (time >= red && time < red + green) {
                result = "green";
            }

            //Прибавляем к 0 диапазоны, пока не получим фактическое время
            else if (time > red + green) {
                int res = 0;
                int i = 0;

                //Пока результат меньше времени
                while (res < time) {
                    //Прибавляем время красного светофора
                    res += red;
                    //Если результат больше или равен времени, то прибавляем нечетный диапазон и заканчиваем цикл
                    if (res >= time) {
                        i++;
                        break;
                    }

                    //Если результат меньше времени, то прибавляем четный цикл
                    else if (res < time) {
                        res += green;
                        i++;
                    }

                    //Если реузльтат больше или равен времени, то заканчиваем цикл
                    if (res >= time) {
                        break;
                    }

                    //Если результат меньше времени, то продолжаем цикл
                    else continue;

                }

                //Если циклов четное количество, то светофор горит зеленым
                if (res % 2 == 0) {
                    result = "green";

                    //Если циклов нечетное количество, то светофор горит красным
                } else if (res % 2 != 0) {
                    result = "red";
                }

            }
            return result;
        }
    }

    public static int DlinnaDoPervogoSvetofora(int[][] track) {
        return track[0][0];
    }

    public static int DlinnaOtPoslednegoDoKonca(int L, int[][] track) {
        int posledniy = track[(track.length - 1)][0];
        return L - posledniy;
    }

    public static int DlinnaMezhduSvetoforami(int firstsvet, int secondsvet, int[][] track) {
        int result = 0;
        for (int i = 0; i < 2; i++) {
            result = track[secondsvet][0] - track[firstsvet][0];
        }
        return result;
    }


    //Создаем массив объектов светофоров
    public static Svetofors[] arraySvetofors(int[][] opisanie) {
        Svetofors[] svetofors = new Svetofors[opisanie.length];
        for (int i = 0; i < opisanie.length; i++) {
            svetofors[i] = new Svetofors(opisanie[i][0], opisanie[i][1], opisanie[i][2]);
        }
        return svetofors;
    }
}
