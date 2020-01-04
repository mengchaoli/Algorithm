import java.util.LinkedList;
import java.util.Queue;

public class _297_SerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr != null) {
                sb.append(curr.val + " ");
                q.add(curr.left);
                q.add(curr.right);
            } else {
                sb.append("n ");
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();

            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
