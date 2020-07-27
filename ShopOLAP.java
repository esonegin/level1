import java.util.*;

public class Level1 {
//v3
    public static String[] ShopOLAP(int N, String[] items) {
        ArrayList<Element> resultlist = valueSortList(items);
        ArrayList<Element> dubllist = getDublList(resultlist);
        String[] resultarray = new String[resultlist.size()];
        if (dubllist.size() != 0) {
            ArrayList<Element> getSortDublList = getSortDublList(dubllist);
            ArrayList<String> getSortStringDubllist = new ArrayList<String>();
            for (int i = 0; i < getSortDublList.size(); i++) {
                getSortStringDubllist.add(String.valueOf(getSortDublList.get(i).key));
            }
            ArrayList<Element> withoutdubllist = getWithoutDublList(resultlist);
            ArrayList<Element> finallist = getSortWithDublsList(withoutdubllist, getSortDublList);
            for (int i = 0; i < finallist.size(); i++) {
                resultarray[i] = finallist.get(i).getKey() + " " + finallist.get(i).getValue();
            }
        } else if (dubllist.size() == 0) {
            for (int i = 0; i < resultlist.size(); i++) {
                resultarray[i] = resultlist.get(i).getKey() + " " + resultlist.get(i).getValue();
            }
        }

        return resultarray;
    }

    public static ArrayList<Element> getSortWithDublsList(ArrayList<Element> withoutdubllist, ArrayList<Element> getSortDublList) {
        ArrayList<Element> sortwithdublslist = new ArrayList<>();

        for (int i = 0; i < withoutdubllist.size(); i++)
            if (withoutdubllist.get(i).value > getSortDublList.get(0).value) {
                sortwithdublslist.add(withoutdubllist.get(i));
            } else break;

        for (int i = 0; i < getSortDublList.size(); i++) {
            sortwithdublslist.add(getSortDublList.get(i));
        }

        for (int i = 0; i < withoutdubllist.size(); i++)
            if (withoutdubllist.get(i).value < getSortDublList.get(0).value) {
                sortwithdublslist.add(withoutdubllist.get(i));
            }

        return sortwithdublslist;
    }


    public static ArrayList<Element> getWithoutDublList(ArrayList<Element> reslist) {
        int dublvalue = getDublList(reslist).get(0).value;
        ArrayList<Element> withoutdubllist = new ArrayList<>();
        for (int i = 0; i < reslist.size(); i++) {
            if (reslist.get(i).value != dublvalue) {
                withoutdubllist.add(reslist.get(i));
            }
        }
        return withoutdubllist;
    }

    public static ArrayList<Element> getDublList(ArrayList<Element> list) {
        ArrayList<Element> dubls = new ArrayList<Element>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getValue().equals(list.get(i + 1).getValue())) {
                dubls.add(list.get(i));
                dubls.add(list.get(i + 1));
            }
        }
        for (int i = 0; i < dubls.size() - 1; i++) {
            if (dubls.get(i) == dubls.get(i + 1)) {
                dubls.remove(i);
            }
        }

        return dubls;
    }

    public static ArrayList<Element> getSortDublList(ArrayList<Element> list) {
        ArrayList<Element> sortdubls = new ArrayList<Element>();
        ArrayList<String> stringdubls = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            stringdubls.add(list.get(i).key);
        }

        Collections.sort(stringdubls);

        for (int i = 0; i < stringdubls.size(); i++){
            sortdubls.add(new Element(stringdubls.get(i), list.get(i).value));
        }

        return sortdubls;
    }

    public static ArrayList<Element> valueSortList(String[] re) {
        ArrayList<Element> resultobjlist = resultobjlist(re);
        for (int i = 0; i < resultobjlist.size() - 1; ) {
            if (resultobjlist.get(i).key.equals(resultobjlist.get(i + 1).key)) {
                Element element = new Element(resultobjlist.get(i).key, resultobjlist.get(i).value + resultobjlist.get(i + 1).value);
                resultobjlist.set(i, resultobjlist.set(i + 1, element));
                resultobjlist.remove(i);
            } else i++;
        }
        resultobjlist.sort(new Comparator<Element>() {
            public int compare(Element o1, Element o2) {
                if (o2.getValue() == o1.getValue()) return 0;
                else if (o2.getValue() > o1.getValue()) return 1;
                else return -1;
            }
        });

        return resultobjlist;
    }


    public static ArrayList<Element> resultobjlist(String[] result) {
        Arrays.sort(result);
        ArrayList<Element> resultobjlist = new ArrayList<Element>();
        for (int i = 0; i < result.length; i++) {
            resultobjlist.add(new Element(result[i].split(" ")[0], Integer.valueOf(result[i].split(" ")[1])));
        }
        return resultobjlist;
    }

    public static class Element {
        String key;
        Integer value;

        public Element(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }
}
