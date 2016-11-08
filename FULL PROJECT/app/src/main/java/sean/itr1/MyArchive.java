package sean.itr1;

import java.util.ArrayList;

public class MyArchive {

    private static ArrayList<Integer> personalArchive = new ArrayList<Integer>();

    static {
        personalArchive.add(1);
        personalArchive.add(3);
        personalArchive.add(5);
        personalArchive.add(7);
    }

    public static void addSeries(Series seriesToAdd) {
        addSeriesById(seriesToAdd.getId());
    }

    public static void addSeries(int id) {
        addSeriesById(id);
    }

    private static void addSeriesById(int id) {
        if (personalArchive.contains(id)) {
            return;
        } else {
            personalArchive.add(id);
        }
    }

    public static void removeSeries(int id) {
        removeSeriesById(id);
    }

    public static void removeSeries(Series seriesToRemove) {
        removeSeriesById(seriesToRemove.getId());
    }

    private static void removeSeriesById(int id) {
        for (int i = 0; i < personalArchive.size(); i++) {
            if (personalArchive.get(i) == id) {
                personalArchive.remove(i);
            }
        }
    }

    //added by andrew, for use in ShowInfo.java
    public static boolean inMyArchive(int id) {
        for (int i = 0; i < personalArchive.size(); i++) {
            if (personalArchive.get(i) == id) {
                return true;
            }
        }
        return false;
    }


    public static Series[] getMyArchive() {
        Series[] myArchiveArray = new Series[personalArchive.size()];

        for (int i = 0; i < personalArchive.size(); i++) {
            myArchiveArray[i] = SeriesArchiveApi.getSeriesById(personalArchive.get(i));
        }
        return myArchiveArray;
    }
}
