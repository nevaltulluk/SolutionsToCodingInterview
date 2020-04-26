
class BinaryNode {
    String data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(String data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public BinaryNode(String data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void setLeft(BinaryNode left){this.left = left;}
    public void setRight(BinaryNode right){this.right = right;}
}
