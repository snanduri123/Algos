import java.util.Arrays;

public class ImplementArrayList {

    Object[] aList;
    int numOfElements = 0;

    public ImplementArrayList(int size) {
        aList = new Object[size];
    }

    public void add(Object obj) {
        if (numOfElements == aList.length) {
            aList = Arrays.copyOf(aList, aList.length * 2);
        }
        aList[numOfElements] = obj;
        numOfElements ++;
    }

    public void remove(int index) {
        if (index < numOfElements) {
            aList[index] = null;
            int i = index;
            for (; i < numOfElements; i++) {
                aList[i] = aList[i + 1];
            }
            aList[i] = null;
            numOfElements --;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Object get(int index) {
        if (index < numOfElements) {
            return aList[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void printAllElements(){
        System.out.println("-------------");
        for(int i = 0 ; i <= numOfElements; i++){
            System.out.println(aList[i]);
        }
    }

    public static void main( String[] args){
        ImplementArrayList arrayList = new ImplementArrayList(10);

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.printAllElements();
        arrayList.remove(0); // removing 1
        arrayList.printAllElements();
        arrayList.remove(3); // removing 5
        arrayList.printAllElements();
        arrayList.remove(1); //removing 3
        arrayList.printAllElements();

    }
}
