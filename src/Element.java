public class Element {
    int val;
    Element prev;
    Element next;

    public Element(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object e) {
        if (e == null)
            return false;

        final Element other = (Element) e;
        if (this.val == other.val)
            return true;
        else
            return false;
    }
}

