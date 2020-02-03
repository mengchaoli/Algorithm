import java.util.LinkedList;
import java.util.List;

public class _425_Word_Squares {

    class TreeNode {
        char ch;
        TreeNode[] children = new TreeNode[26];
        List<String> prefix = new LinkedList<>();

        public TreeNode(char ch) {
            this.ch = ch;
        }
    }

    class Trie {
        TreeNode root;

        public Trie() {
            root = new TreeNode(' ');
        }

        public void insert(String[] words) {
            for (String word : words) {
                TreeNode curr = root;
                char[] ch = word.toCharArray();

                for (char c : ch) {
                    if (curr.children[c - 'a'] == null) {
                        curr.children[c - 'a'] = new TreeNode(c);
                    }

                    curr = curr.children[c - 'a'];
                }
            }
        }

        public List<String> search(String s) {
            List<String> list = new LinkedList<>();
            if (s == null || s.length() == 0) return list;

            char[] ch = s.toCharArray();
            TreeNode curr = root;

            for (char c : ch) {

                if (curr.children[c - 'a'] == null) {
                    return list;
                }

                curr = curr.children[c - 'a'];
            }

            list.addAll(curr.prefix);
            return list;
        }
    }


    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new LinkedList<>();
        if (words == null || words.length == 0) return ans;

        Trie tr = new Trie();
        tr.insert(words);

        for (String word : words) {
            int len = word.length();
            List<String> ansBuilder = new LinkedList<>();
            ansBuilder.add(word);
            search(len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }

        return ans;
    }

    public void search(int len, Trie tr, List<List<String>> ans, List<String> ansBuilder) {
        if (ansBuilder.size() == len) {
            ans.add(new LinkedList(ansBuilder));
            return;
        }

        int i = ansBuilder.size();
        StringBuilder sb = new StringBuilder();

        for (String s : ansBuilder) {
            sb.append(s.charAt(i));
        }

        List<String> prefix = tr.search(sb.toString());

        for (String pre : prefix) {
            ansBuilder.add(pre);
            search(len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }

    }
}