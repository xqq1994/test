package datastructure.array;

public class Array {
    //声明数组
    public int[] array;
    //数组初始化大小
    private int n;
    //数组实际大小
    private int count;

    public Array(int capacity) {
        n = capacity;
        array = new int[n];
        count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= count) return -1;
        return array[index];
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > count) return false;
        if (index == n) {
            return false;
        }
        for (int i = count; i > index; --i) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;
        for (int i = index+1; i < count; i++) {
            array[i-1] = array[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 1);
        array.insert(0, 2);
        array.printAll();
        array.delete(1);
        array.printAll();
        int i = array.find(0);
        System.out.println(i);
    }
}
