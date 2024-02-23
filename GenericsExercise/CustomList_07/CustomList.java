package GenericsExercise.CustomList_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> data;

    public CustomList(){
        this.data = new ArrayList<>();
    }

    //void add(T element)
    public void add(T element){
        this.data.add(element);
    }
	//T remove(int index)
    public T remove(int index){
        checkIndex(index);
        return this.data.remove(index);
    }
	//boolean contains(T element)
    public boolean contains(T element){
        return this.data.contains(element);
    }
	//void swap(int index, int index)
    public void swap(int firsIdx, int secondIdx){
        checkIndex(firsIdx);
        checkIndex(secondIdx);

        T firstEl = this.data.get(firsIdx);
        T secondEl = this.data.get(secondIdx);

        this.data.set(firsIdx, secondEl);
        this.data.set(secondIdx, firstEl);
    }
	//int countGreaterThan(T element)
    public int countGreaterThan(T element){
        int count = 0;
        for (T el : this.data) {
            if (el.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
	//T getMax()
    public T getMax(){
        return Collections.max(this.data);
    }

    //T getMin()
    public T getMin(){
        return Collections.min(this.data);
    }

    public int size(){
        return this.data.size();
    }

    public void print(){
        this.data.forEach(e -> System.out.println(e));
    }
    public T get(int index){
        checkIndex(index);
        return this.data.get(index);
    }

    private void checkIndex(int index){
        if (index < 0 || index > this.data.size()){
            throw new IndexOutOfBoundsException();
        }
    }
}
