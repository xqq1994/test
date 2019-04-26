package datastructure.stack;

public class BrowserStack {
    StackArray x = new StackArray(5);

    StackArray y = new StackArray(5);

    public String open(String valeu){
        x.push(valeu);
        clear(y);
        return valeu;
    }
    public String before(){
        String pop = x.pop();
        String pop1 = null;
        if(x.getCount() > 1) {
            pop1 = x.stack[x.getCount()-1];
        }
        y.push(pop);
        return pop1;
    }
    public String after(){
        String pop = y.pop();
        String pop1 = null;
        if(y.getCount() > 1){
            pop1 = y.stack[y.getCount()-1];
        }
        x.push(pop);
        return pop1;
    }
    public void clear(StackArray n){
        int count = n.getCount();
        for (int i = 0; i < count; i++) {
            n.pop();
        }
    }


    public static void main(String[] args) {
        BrowserStack browserStack = new BrowserStack();
        browserStack.x.push("a");
        browserStack.x.push("b");
        browserStack.x.push("c");
        String before = browserStack.before();
        System.out.println(before);
        System.out.println(browserStack.x.toString());
        System.out.println(browserStack.y.toString());
        browserStack.after();
        System.out.println(before);
        System.out.println(browserStack.x.toString());
        System.out.println(browserStack.y.toString());
        browserStack.open("d");
        System.out.println(before);
        System.out.println(browserStack.x.toString());
        System.out.println(browserStack.y.toString());
        String before1 = browserStack.before();
        System.out.println(before1);
        System.out.println(browserStack.x.toString());
        System.out.println(browserStack.y.toString());


    }

}
