package Tree;

public class _331_VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        int degree = 1; // there needs to be a root node, so we give one degree first to allow root

        for (String node : nodes) {
            if (--degree < 0) {
                // this means we dont have available spot to put this node
                return false;
            }

            if (!node.equals("#")) { // if it's not #, we just need to consume one degree, which above --degree did. if it's a valid node, it will generate 2 available spot.
                degree += 2;
            }
        }

        return degree == 0;
    }
}
