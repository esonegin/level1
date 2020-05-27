import java.util.*;

public static class Level1 {
        public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
            int result = 0;
            int control = 0;
            for (int day = 1; control < N * M; day++) {
                if (day == 1) {
                    control = L;
                } else {
                    control = control + FourCell(N, M, battalion) * 4
                            + ThreeCell(N, M, battalion) * 3
                            + TwoCell(N, M, battalion) * 2;
                }
                result = day;
            }

            return result;
        }

        public static int[] CellDublFilter(int[] battalion) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < battalion.length - 3; i += 2)
                if (battalion[i] == battalion[i + 2] && battalion[i + 1] == battalion[i + 3]) {
                    continue;
                } else if (i < battalion.length - 1) {
                    list.add(battalion[i]);
                    list.add(battalion[i+1]);
            }
            list.add(battalion[battalion.length - 2]);
            list.add(battalion[battalion.length - 1]);
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
    }
