import java.util.*;

public class Level1 {
        public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
            int result = 0;
            int control = 0;
            int[] battalionf = CellDublFilter(battalion);
            for (int day = 1; control < N * M; day++) {
                if (day == 1) {
                    control = L;
                } else {
                    control = control + FourCell(N, M, battalionf) * 4
                            + ThreeCell(N, M, battalionf) * 3
                            + TwoCell(N, M, battalionf) * 2;
                }
                result = day;
            }

            return result;
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
            for(int j = 1; j < battalion.length-1; j++){
                if(list.size() < 4){
                    break;
                }
                if(battalion[battalion.length-2] == list.get(j) && battalion[battalion.length-1] == list.get(j)){
                    list.remove(j);
                    list.remove(j+1);
                    continue;
                }
                else {
                    list.add(battalion[battalion.length-2]);
                    list.add(battalion[battalion.length-1]);
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

        public static int FourCell(int N, int M, int[] battalion) {
            int four = 0;
            for (int i = 0; i < battalion.length - 1; i += 2) {
                if ((battalion[i] != 1 && battalion[i] != N) && (battalion[i + 1] != 1 && battalion[i + 1] != M)) {
                    four++;
                }
            }
            return four;
        }


        public static int ThreeCell(int N, int M, int[] battalion) {
            int two = 0;
            for (int i = 0; i < battalion.length - 1; i += 2) {
                if ((battalion[i] == 1 && battalion[i + 1] != 1 && battalion[i + 1] < M)
                        || (battalion[i] == N && battalion[i + 1] != 1 && battalion[i + 1] < M)
                        || (battalion[i] != 1 && battalion[i] < N && battalion[i + 1] == 1)
                        || (battalion[i] != 1 && battalion[i] < N && battalion[i + 1] == 4)) {
                    two++;
                }
            }
            return two;
        }

        public static int TwoCell(int N, int M, int[] battalion) {
            int three = 0;
            for (int i = 0; i < battalion.length - 1; i += 2) {
                if ((battalion[i] == 1 || battalion[i] == N) && (battalion[i + 1] == 1 || battalion[i + 1] == M)) {
                    three++;
                }
            }
            return three;
        }
    }
