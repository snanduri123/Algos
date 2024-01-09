package qtree;
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};


public class QuadTree558 {

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null && quadTree2 == null) return quadTree1;
        if (quadTree1 == null) return quadTree2;
        if (quadTree2 == null) return quadTree1;
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            quadTree1.val = quadTree1.val || quadTree2.val;
            return quadTree1;
        }
        Node tl = intersect(quadTree1.isLeaf? quadTree1 : quadTree1.topLeft, quadTree2.isLeaf? quadTree2 : quadTree2.topLeft);
        Node tr = intersect(quadTree1.isLeaf? quadTree1 : quadTree1.topRight, quadTree2.isLeaf? quadTree2 : quadTree2.topRight);
        Node bl = intersect(quadTree1.isLeaf? quadTree1 : quadTree1.bottomLeft, quadTree2.isLeaf? quadTree2 : quadTree2.bottomLeft);
        Node br = intersect(quadTree1.isLeaf? quadTree1 : quadTree1.bottomRight, quadTree2.isLeaf? quadTree2 : quadTree2.bottomRight);

        boolean isLeaf = tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf;
        boolean val = tl.val == tr.val == bl.val == br.val;
        if (isLeaf && val) {
            return tl;
        }
        quadTree1.topLeft = tl;
        quadTree1.topRight = tr;
        quadTree1.bottomLeft = bl;
        quadTree1.bottomRight = br;
        return quadTree1;

    }

    public static void main(String[] args) {
       // Node qt1 = new Node(true, true, true, true, false, false);
    }
}
