import java.util.HashMap;

public class LRU {

    Element head;
    Element tail;
    HashMap<Integer, Element> map = new HashMap<>();

    public Element getLRU() {

        if (head != null) {
            return head;
        } else {
            return null;
        }
    }

    public Element getElement(int i) {
        Element e = new Element(i);
        if (map.containsKey(i)) {
            Element elem = map.get(i);
            if (elem.prev != null) {
                elem.prev.next = elem.next;
                elem.prev = null;
                elem.next = head;
                head.prev = elem;
                head = elem;
                map.put(i, elem);
            }
        }
        return e;
    }

    public void addElement(int i) {
        Element e = new Element(i);
        if (map.size() < 3 && !map.containsKey(e)) { //new element but was not already added and size limit is not reached
            map.put(i, e);
            if (head == null && tail == null) {
                head = tail = e;
            } else {
                head.prev = e;
                e.next = head;
                head = e;
            }
        } else if (map.containsKey(i)) { //existing element
            getElement(i);
        } else {  // new element and size limit is already reached
            head.prev = e;
            e.next = head;
            head = e;
            map.remove(tail);
            map.put(i, e);
        }
    }


    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.addElement(1);
        System.out.println("1.least recently used element is " + lru.getLRU().val); //1
        lru.addElement(2);
        System.out.println("2. least recently used element is " + lru.getLRU().val);//2
        lru.addElement(3);
        System.out.println("3. least recently used element is " + lru.getLRU().val);//3
        lru.addElement(1);
        System.out.println("4. least recently used element is " + lru.getLRU().val);//1
        lru.getElement(3);
        System.out.println("5. least recently used element is " + lru.getLRU().val);//3
        lru.getElement(2);
        System.out.println("5. least recently used element is " + lru.getLRU().val);//2
        lru.getElement(1);
        System.out.println("5. least recently used element is " + lru.getLRU().val);//1
        lru.addElement(4);
        System.out.println("5. least recently used element is " + lru.getLRU().val);//4

    }

}

