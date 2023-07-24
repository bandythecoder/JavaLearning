package OOOPS.Inheritence;


public class Trie {

    private static Node root;
    public Trie() {
        root = new Node();
    }


    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(!node.contains(word.charAt(i)))
            {
                char c = word.charAt(i);
                node.add(c);
                node = node.get(c);
            }
        }
        node.setFlag();
    }

    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++)
        {
            System.out.println(root.isWord);
            if(!node.contains(word.charAt(i)))
            {
                return false;
            }
            else
            {
                node = node.get(word.charAt(i));
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        return false;
    }

    static class Node
    {
        Node[] linked;
        boolean isWord;

        Node()
        {
            linked = new Node[26];
        }

        public boolean contains(Character c)
        {
            return linked[c - 'a'] == null;
        }

        public void add(Character c)
        {
            linked[c - 'a'] = new Node();
        }

        public Node get(Character c)
        {
            return linked[c - 'a'];
        }

        public void setFlag()
        {
            isWord = true;
        }
    }
}

