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
            command1(value);
            
        } else if (com == 2) {
            command2(value);

           
        } else if (com == 4) {
            command4();

        } else if (com == 5) {
            command5();
        }

        if (com == 1 || com == 2 || com == 4 || com == 5) {
            result = stroka.getValue();

        } else if (com == 3) {
            result = command3(value);
        }

        System.out.println(result);

        return result;
    }

    public static void command1(String value) {
        stroka.setValue(stroka.getValue() + value);
   
        if (stroka.getPredoperation() == 4) {
            stroka.replaceSpisokAll();
            stroka.setSpisokAll(stroka.getValueOtkat());
            stroka.setUndoCount(0);
        }

        stroka.setPredoperation(1);
        stroka.setSpisokAll(stroka.getValue());
    }

    public static void command2(String value) {

        if (stroka.getPredoperation() == 4) {
            stroka.replaceSpisokAll();
            stroka.setSpisokAll(stroka.getValueOtkat());
            stroka.setUndoCount(0);
        }

        if (Integer.parseInt(value) > stroka.getValue().length()) {
            stroka.setValue("");
        } else {
            stroka.setValue(stroka.getValue().substring(0, stroka.getValue().length() - Integer.parseInt(value)));
        }

        stroka.setPredoperation(2);
        stroka.setSpisokAll(stroka.getValue());

    }

    public static String command3(String value) {
        String result = "";
        if(Integer.parseInt(value) < stroka.getValue().length()) {
            result = (stroka.getValue().substring(Integer.parseInt(value), Integer.parseInt(value) + 1));
        }
        else {result = "";}
        stroka.setPredoperation(3);
        return result;
    }

    public static void command4() {

        stroka.getSpisokAll();

        if (stroka.getSpisokAll().size() == 1) {
            stroka.setSpisokUndo(stroka.getValue());
            stroka.setValue("");


        } else if (stroka.getSpisokAll().size() == 2 && stroka.getUndoCount() == 0) {
            stroka.setSpisokUndo(stroka.getValue());
            stroka.setValue(stroka.getSpisokAll().get(stroka.getSpisokAll().size() - 2));

        } else if (stroka.getSpisokAll().size() == 2 && stroka.getUndoCount() > 0) {
            stroka.setSpisokUndo(stroka.getValue());
            stroka.setValue(stroka.getSpisokAll().get(0));

        } else if (stroka.getSpisokAll().size() > 2 && stroka.getUndoCount() == 0) {
            stroka.setSpisokUndo(stroka.getValue());
            stroka.setValue(stroka.getSpisokAll().get(stroka.getSpisokAll().size() - 2));

        } else if (stroka.getSpisokAll().size() > 2 && stroka.getUndoCount() > 0 && stroka.getSpisokAll().size() >= (stroka.getUndoCount() + stroka.getRedoCount())) {
            stroka.setSpisokUndo(stroka.getValue());
            stroka.setValue(stroka.getSpisokAll().get(stroka.getSpisokAll().size() - 2 - stroka.getUndoCount()));
        }

        else if (stroka.getSpisokAll().size() > 2 && stroka.getUndoCount() > 0 && stroka.getSpisokAll().size() < (stroka.getUndoCount() + stroka.getRedoCount())) {
            stroka.setSpisokUndo(stroka.getValue());
            stroka.setValue(stroka.getSpisokAll().get(0));
        }

        stroka.setPredoperation(4);
        stroka.setUndoCount(stroka.getUndoCount() + 1);
        stroka.setValueOtkat(stroka.getValue());
    }

    public static void command5() {

        stroka.getSpisokAll();
        if(stroka.getSpisokUndo().size() - 1 - stroka.getRedoCount() >= 0 && stroka.getSpisokAll().size() > 2) {
            stroka.setValue(stroka.getSpisokUndo().get(stroka.getSpisokUndo().size() - 1 - stroka.getRedoCount()));
        }
        else if(stroka.getSpisokUndo().size() - 1 - stroka.getRedoCount() >= 0 && stroka.getSpisokAll().size() == 2) {
            stroka.setValue(stroka.getSpisokUndo().get(stroka.getSpisokUndo().size() - 1));
        }
        else{
            stroka.setValue(stroka.getValue());
        }
        stroka.setSpisokAll(stroka.getValue());
        stroka.setRedoCount(stroka.getRedoCount() + 1);
        stroka.setPredoperation(5);


    }


    public static String udalenie(String tekushee, String kolvosimvolov) {
        String result = tekushee.substring(0, tekushee.length() - Integer.parseInt(kolvosimvolov));
        return result;
    }


    public static class Stroka {
        private String value;
        private int predoperation;
        ArrayList<String> spisokAll = new ArrayList<String>();
        ArrayList<String> spisokUndo = new ArrayList<String>();
        private int undoCount;
        private int redoCount;
        private String valueOtkat;

        public Stroka(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getPredoperation() {
            return predoperation;
        }

        public ArrayList<String> getSpisokAll() {
            return spisokAll;
        }

        public ArrayList<String> getSpisokUndo() {
            return spisokUndo;
        }

        public int getUndoCount() {
            return undoCount;
        }

        public int getRedoCount() {
            return redoCount;
        }

        public String getValueOtkat() {
            return valueOtkat;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setPredoperation(int predoperation) {
            this.predoperation = predoperation;
        }

        public void setSpisokAll(String stroka) {
            spisokAll.add(stroka);
        }

        public void setSpisokUndo(String stroka) {
            spisokUndo.add(stroka);
        }

        public void setUndoCount(int undoCount) {
            this.undoCount = undoCount;
        }

        public void setRedoCount(int redoCount) {
            this.redoCount = redoCount;
        }

        public void setValueOtkat(String valueOtkat) {
            this.valueOtkat = valueOtkat;
        }

        public void replaceSpisokAll() {
            spisokAll.clear();
        }


    }
}
