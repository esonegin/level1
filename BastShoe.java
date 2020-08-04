import java.util.ArrayList;
import java.util.*;

public class Level1  {

    static Stroka stroka = new Stroka("");

    public static String BastShoe(String command) {
        int com;
        String value = "";
        String result = "";
        if (command.contains(" ")) {
            com = Integer.parseInt(command.split(" ")[0]);
            value = command.substring(2);
        } else {
            com = Integer.parseInt(command);
        }


        if (com == 1) {
            if (stroka.getPredoperation() == 4) {
                stroka.delSpisokZnacheniy();
                stroka.setKolvoUdaleniyPodryad(0);
            }
            stroka.setValue(dobavlenie(stroka.getValue(), value));
            stroka.setPredoperation(1);
            stroka.setKolvoUdaleniyPodryad(0);
            stroka.setSpisokZnacheniy(stroka.getValue());


        } else if (com == 2) {
            if (Integer.parseInt(value) > stroka.getValue().length()) {
                if (stroka.getPredoperation() == 4) {
                    stroka.delSpisokZnacheniy();
                    stroka.setKolvoUdaleniyPodryad(0);
                }
                stroka.setValue("");
                stroka.setPredoperation(2);
                stroka.setKolvoUdaleniyPodryad(0);
                stroka.setSpisokZnacheniy(stroka.getValue());

            } else {
                if (stroka.getPredoperation() == 4) {
                    stroka.delSpisokZnacheniy();
                    stroka.setKolvoUdaleniyPodryad(0);
                }
                stroka.setValue(udalenie(stroka.getValue(), value));
                stroka.setPredoperation(2);
                stroka.setKolvoUdaleniyPodryad(0);
                stroka.setSpisokZnacheniy(stroka.getValue());

            }


        } else if (com == 4 && (stroka.getPredoperation() == 1 || stroka.getPredoperation() == 2) && stroka.getKolvoUdaleniyPodryad() == 0 && stroka.getSpisokZnacheniy().size() != 0) {

            stroka.setKolvoUdaleniyPodryad(0);

            stroka.setValue(stroka.getSpisokZnacheniy().get(stroka.getSpisokZnacheniy().size() - 2 + stroka.getKolvoUdaleniyPodryad()));

            stroka.setKolvoUdaleniyPodryad(stroka.getKolvoUdaleniyPodryad() + 1);

            stroka.setPredoperation(4);

        } else if (com == 4 && stroka.getPredoperation() == 4 && stroka.getKolvoUdaleniyPodryad() > 0 && stroka.getSpisokZnacheniy().size() - 2 - stroka.getKolvoUdaleniyPodryad() > 0) {

            stroka.setValue(stroka.getSpisokZnacheniy().get(stroka.getSpisokZnacheniy().size() - 2 - stroka.getKolvoUdaleniyPodryad()));

            stroka.setKolvoUdaleniyPodryad(stroka.getKolvoUdaleniyPodryad() + 1);
        } else if (com == 4 && stroka.getSpisokZnacheniy().size() - 2 - stroka.getKolvoUdaleniyPodryad() < 0) {
            stroka.setValue(stroka.getValue());
        }


        if (com == 1 || com == 2 || com == 4 || com == 5) {
            result = stroka.getValue();
        } else if (com == 3) {
            result = (stroka.getValue().substring(Integer.parseInt(value), Integer.parseInt(value) + 1));
        }

        //System.out.println(result);

        return result;
    }

    public static String dobavlenie(String tekushee, String dobavlyaemoe) {
        String result = tekushee + dobavlyaemoe;
        return result;
    }

    public static String udalenie(String tekushee, String kolvosimvolov) {
        String result = tekushee.substring(0, tekushee.length() - Integer.parseInt(kolvosimvolov));
        return result;
    }


    public static class Stroka {
        private String value;
        private int predoperation;
        private int kolvoUdaleniyPodryad;
        ArrayList<String> spisokZnacheniy = new ArrayList<String>();

        public Stroka(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getPredoperation() {
            return predoperation;
        }

        public int getKolvoUdaleniyPodryad() {
            return kolvoUdaleniyPodryad;
        }

        public ArrayList<String> getSpisokZnacheniy() {
            return spisokZnacheniy;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setPredoperation(int predoperation) {
            this.predoperation = predoperation;
        }

        public void setKolvoUdaleniyPodryad(int kolvoUdaleniyPodryad) {
            this.kolvoUdaleniyPodryad = kolvoUdaleniyPodryad;
        }

        public void setSpisokZnacheniy(String stroka) {
            spisokZnacheniy.add(stroka);
        }

        public void delSpisokZnacheniy() {
            for (int i = 0; i < spisokZnacheniy.size() - 1; i++) {
                spisokZnacheniy.remove(i);
            }

        }

    }
    
}
