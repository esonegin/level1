import java.text.DecimalFormat;


public class Level1 {
        public static String PatternUnlock(int N, int [] hits) {
            
            double[] massivotrezkov = CheckArray(hits);
            double dlinnadouble = Dlinna(massivotrezkov);
            return FormatDlinnaString(dlinnadouble);
        }

        public static String FormatDlinnaString(double dlinna) {
            String formatstring;
            //Округляем до 5 цифр
            DecimalFormat df = new DecimalFormat("#####.#####");
            formatstring = df.format(dlinna);

            //Удаляем нули и запятую
            formatstring = formatstring.replaceAll("0", "");
            formatstring = formatstring.replaceAll(",", "");
            return formatstring;
        }


        //Формируем длинну из отрезков
        public static double Dlinna(double[] otrezki) {
            double dlinna = 0.0;
            for (int i = 0; i < otrezki.length; i++) {
                dlinna = dlinna + otrezki[i];
            }
            return dlinna;
        }

        //Формируем массив отрезков
        public static double[] CheckArray(int[] hits) {

            double[] result = new double[hits.length];
            double diagonal = 1.41421356;
            for (
                    int i = 0;
                    i < hits.length - 1; i++) {
                //Варианты для 1
                if (hits[i] == 1 && (hits[i + 1] == 6 || hits[i + 1] == 2 || hits[i + 1] == 9)) result[i] = 1;
                if (hits[i] == 1 && (hits[i + 1] == 5 || hits[i + 1] == 8)) result[i] = diagonal;

                //Варианты для 2
                if (hits[i] == 2 && (hits[i + 1] == 1 || hits[i + 1] == 8 || hits[i + 1] == 3 || hits[i + 1] == 5))
                    result[i] = 1;
                if (hits[i] == 2 && (hits[i + 1] == 6 || hits[i + 1] == 9 || hits[i + 1] == 7 || hits[i + 1] == 4))
                    result[i] = diagonal;

                //Варианты для 3
                if (hits[i] == 3 && (hits[i + 1] == 2 || hits[i + 1] == 7 || hits[i + 1] == 4)) result[i] = 1;
                if (hits[i] == 3 && (hits[i + 1] == 5 || hits[i + 1] == 8)) result[i] = diagonal;

                //Варианты для 4
                if (hits[i] == 4 && (hits[i + 1] == 5 || hits[i + 1] == 3)) result[i] = 1;
                if (hits[i] == 4 && (hits[i + 1] == 2)) result[i] = diagonal;

                //Варианты для 5
                if (hits[i] == 5 && (hits[i + 1] == 6 || hits[i + 1] == 2 || hits[i + 1] == 4)) result[i] = 1;
                if (hits[i] == 5 && (hits[i + 1] == 1 || hits[i + 1] == 3)) result[i] = diagonal;

                //Варианты для 6
                if (hits[i] == 6 && (hits[i + 1] == 1 || hits[i + 1] == 5)) result[i] = 1;
                if (hits[i] == 6 && (hits[i + 1] == 2)) result[i] = diagonal;

                //Варианты для 7
                if (hits[i] == 7 && (hits[i + 1] == 3 || hits[i + 1] == 8)) result[i] = 1;
                if (hits[i] == 7 && (hits[i + 1] == 2)) result[i] = diagonal;

                //Варианты для 8
                if (hits[i] == 8 && (hits[i + 1] == 7 || hits[i + 1] == 2 || hits[i + 1] == 9)) result[i] = 1;
                if (hits[i] == 8 && (hits[i + 1] == 3 || hits[i + 1] == 1)) result[i] = diagonal;

                //Варианты для 9
                if (hits[i] == 9 && (hits[i + 1] == 1 || hits[i + 1] == 8)) result[i] = 1;
                if (hits[i] == 9 && (hits[i + 1] == 2)) result[i] = diagonal;
            }
            return result;
        }
    }
