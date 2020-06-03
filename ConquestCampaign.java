import java.util.*;
import java.util.ArrayList;

public class Level1 {
        public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
            int[][] table = FirstStepDesant(N, M, battalion);
            int vertgran = table.length;
            int gorizgran = table[0].length;


            boolean res = true;
            int day = 0;


            while (res)


                for (int i = 0; i < vertgran; i++) {
                    for (int j = 0; j < gorizgran; j++) {


                        //Увеличиваю на +1 все ненулевые клетки
                        if (table[i][j] != 0) table[i][j] += 1;

                        //Увеличиваю на +1 все клетки у которых соседи +2
                        if ((table[i][j] == 0
                                && i > 0 && i < vertgran - 1
                                && j > 0 && j < gorizgran - 1
                                && table[i][j - 1] != 0)

                                ||
                                (table[i][j] == 0
                                        && i >= 0 && i < vertgran - 1
                                        && j >= 0 && j < gorizgran - 1
                                        && table[i][j + 1] != 0)
                                ||
                                (table[i][j] == 0
                                        && i >= 0 && i < vertgran - 1
                                        && j >= 0 && j <= gorizgran - 1
                                        && table[i + 1][j] != 0)
                                ||
                                (table[i][j] == 0
                                        && i > 0 && i <= vertgran - 1
                                        && j >= 0 && j <= gorizgran - 1
                                        && table[i - 1][j] > 1)

                                ||
                                (table[i][j] == 0
                                        && i > 0 && i <= vertgran - 1
                                        && j > 0 && j <= gorizgran - 1
                                        && table[i][j - 1] > 1)

                        ) table[i][j] += 1;

                    }

                    //Проверяем остались ли нулевые клетки
                    for (int k = 0; k < vertgran; k++) {
                        for (int l = 0; l < gorizgran; l++) {

                            if (table[k][l] == 0) {
                                res = true;
                            } else {
                                res = false;

                            }
                        }

                    }
                }

            /*Выводим поле в косноль

            for (int n = 0; n < table.length; n++) {
                for (int m = 0; m < table[0].length; m++) {
                    System.out.print(" " + table[n][m] + " ");
                }
                System.out.println();
            }*/

            //Если заняты все клетки, возвращаем 1 день
            if (CellDublFilter(battalion).length / 2 == N * M) {
                day = 1;
            } else {
                day = table[battalion[0] - 1][battalion[1] - 1] + 1;
            }
            return day;
        }


        public static int[][] FirstStepDesant(int N, int M, int[] battalion) {
            int[][] table = new int[N][M];
            battalion = CellDublFilter(battalion);
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    table[i][j] = 0;
                }
            }
            for (int k = 0; k < battalion.length - 1; k += 2) {
                table[battalion[k] - 1][battalion[k + 1] - 1] = 1;
            }
            return table;
        }

        public static int[] CellDublFilter(int[] battalion) {
            ArrayList<Integer> list = new ArrayList<>();
            //Сравниваем текущую пару цифр со следующей и добавляем в список, если они не равны
            for (int i = 0; i < battalion.length - 3; i += 2)
                if (battalion[i] == battalion[i + 2] && battalion[i + 1] == battalion[i + 3]) {
                    continue;
                } else if (i < battalion.length - 1) {
                    list.add(battalion[i]);
                    list.add(battalion[i + 1]);
                }
            if (list.size() == 0) {
                list.add(battalion[0]);
                list.add(battalion[0]);
            }

            //Сравниваем последнюю пару с остальными и добавляем в список, если они не равны
            for (int j = 1; j < battalion.length - 1; j++) {
                if (list.size() == 2 && list.get(j) != battalion[battalion.length - 2] && list.get(j) != battalion[battalion.length - 1]) {
                    list.add(battalion[battalion.length - 2]);
                    list.add(battalion[battalion.length - 1]);
                    break;
                }
                if (list.size() == 2 && list.get(j) == battalion[battalion.length - 2] && list.get(j) == battalion[battalion.length - 1]) {
                    break;
                }
                if (list.size() < 4 && list.get(j) != battalion[battalion.length - 2] && list.get(j) != battalion[battalion.length - 1]) {
                    list.add(battalion[battalion.length - 2]);
                    list.add(battalion[battalion.length - 1]);
                    break;
                }
                if (battalion[battalion.length - 2] == list.get(j) && battalion[battalion.length - 1] == list.get(j)) {
                    list.remove(j);
                    list.remove(j + 1);
                    continue;
                } else {
                    list.add(battalion[battalion.length - 2]);
                    list.add(battalion[battalion.length - 1]);
                    break;
                }
            }
            //Переводим список в массив
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }
