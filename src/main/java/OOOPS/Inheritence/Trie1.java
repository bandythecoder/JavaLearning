package OOOPS.Inheritence;


public class Trie1 {
    private static Node root;

    public Trie1() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.add(word.charAt(i));
            }
            node = node.get(word.charAt(i));
            node.addPreCount();
        }
        node.setFlag();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.add(word.charAt(i));
            }
            node = node.get(word.charAt(i));

        }
        return node.getCount();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        int cnt = 0;
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.add(word.charAt(i));
            }
            node = node.get(word.charAt(i));

        }
        return node.getPreCount();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i)))
                return;
            node = node.get(word.charAt(i));
            node.reducePreCount();
        }
        node.eraseFlag();
    }

    class Node {
        private Node[] linked;
        private int preCount;
        private int count;

        Node() {
            linked = new Node[26];
        }

        public boolean contains(Character c) {
            return linked[c - 'a'] != null;
        }

        public void add(Character c) {
            linked[c - 'a'] = new Node();
        }

        public Node get(Character c) {
            return linked[c - 'a'];
        }

        public void setFlag() {
            preCount++;
            count++;
        }

        public void addPreCount() {
            preCount++;
        }

        public void reducePreCount() {
            preCount++;
        }

        public void eraseFlag() {
            count--;
            preCount--;
        }

        public int getCount() {
            return count;
        }

        public int getPreCount() {
            return preCount;
        }


    }
}



