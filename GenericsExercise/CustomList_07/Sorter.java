package GenericsExercise.CustomList_07;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList){
        for (int i = 0; i < customList.size(); i++) {
            T currentEl = customList.get(i);
            for (int j = i; j < customList.size(); j++) {
                if (currentEl.compareTo(customList.get(j)) > 0){
                    customList.swap(i, j);
                }

            }

        }
    }
}
