package datastructure.stack;

import java.util.Arrays;

public class StackArray {

    public String[] stack;
    private int count;
    private int n;
    public int getCount(){
        return count;
    }
    public StackArray(int n) {
        stack = new String[n];
        this.n = n;
        count = 0;
    }
    public boolean push(String value){
        if(count == n){
            return false;
        }
        stack[count] = value;
        ++count;
        return true;
    }
    public String pop(){
        if(count == 0) return null;
        String data = stack[count-1];
        stack[count-1]=null;
        --count;
        return data;
    }

    @Override
    public String toString() {
        return "StackArray{" +
                "stack=" + Arrays.toString(stack) +
                ", count=" + count +
                ", n=" + n +
                '}';
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(5);
        stackArray.push("1");
        stackArray.push("2");
        stackArray.push("3");
        System.out.println(stackArray.toString());
        String pop = stackArray.pop();
        System.out.println(pop);
        String pop1 = stackArray.pop();
        System.out.println(pop1);
        System.out.println(stackArray.toString());
    }
}
