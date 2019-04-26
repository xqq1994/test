package datastructure.array;

import java.util.ArrayList;

public class GenericArray<T> {
    public T[] array;
    private int size;
    public ArrayList list = new ArrayList<Long>();
    public GenericArray(int capacity) {
        array = (T[])new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }
    public int getCapacity(){
        return array.length;
    }
    public int count(){
        return size;
    }
    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }
    public boolean add(int index,T value){
        if(index < 0 || index > size){
            throw new RuntimeException("index must >= 0 Or index <=size");
        }
        if(size == getCapacity()){
            //扩容
            rsize(2*getCapacity());
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = value;
        ++size;
        return true;
    }
    public boolean addFirst(T value){
        return add(0,value);
    }
    //扩容方法，时间复杂度 O(n)
    public void rsize(int capacity){
        T[] newArray = (T[])new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    public boolean remove(int index){
        if(index<0 || index >= size){
            throw new RuntimeException("index must >= 0 Or index < size");
        }
        for (int i = index+1; i < size; i++) {
            array[i-1] = array[i];
        }
        size--;
        array[size] = null;
        if(size == getCapacity()/4 && getCapacity() / 2 !=0){
            rsize(getCapacity() / 2);
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, array.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(array[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
    public static void main(String[] args) {
        GenericArray<Long> array = new GenericArray<Long>();
        for (int i = 1; i <= 100; i++) {
            array.addFirst((long) i);
        }
        System.out.println(array.toString());
        array.remove(0);
        System.out.println(array.toString());


    }


}
