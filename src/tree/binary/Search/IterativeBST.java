package tree.binary.Search;

/******************************************************************************
 *  Compilation:  javac IterativeBST.java
 *  Execution:    java IterativeBST.java
 *
 *  A symbol table implemented with a binary search tree using
 *  iteration instead of recursion for put and get.
 * 
 *  % java IterativeBST
 *  128.112.136.11
 *  208.216.181.15
 *  null
 *  [ www.amazon.com, 208.216.181.15 ]
 *  [ www.cs.princeton.edu, 128.112.136.11 ]
 *  [ www.princeton.edu, 128.112.128.15 ]
 *  [ www.simpsons.com, 209.052.165.60 ]
 *  [ www.yale.edu, 130.132.143.21 ]
 *
 ******************************************************************************/

public class IterativeBST<Key extends Comparable, Val> {

    private Node root;          // root of BST

    private class Node {
        private Key key;              // sorted by key
        private Val val;              // associated data
        private Node left, right;     // left and right subtrees

        public Node(Key key, Val val) {
            this.key = key;
            this.val = val;
        }
    }


   /***************************************************************************
    *  Insert item into BST, nonrecursive version
    ***************************************************************************/
    public void put(Key key, Val val) {
        Node z = new Node(key, val);
        if (root == null) {
            root = z;
            return;
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int res = key.compareTo(x.key);
            if      (res < 0) x = x.left;
            else if (res > 0) x = x.right;
            else {
                x.val = val;
                return;
            }   // overwrite duplicate
        }
        int res = key.compareTo(parent.key);
        if (res < 0) parent.left  = z;
        else         parent.right = z;
    }
   

   /***************************************************************************
    *  Search BST for given key, nonrecursive version
    ***************************************************************************/
    public Val get(Key key) {
        Node x = root;
        while (x != null) {
            int res = key.compareTo(x.key);
            if      (res < 0) x = x.left;
            else if (res > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    // is the given key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    }


    // return size of tree (linear time operation)
    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }


    // sample client
    public static void main(String[] args) {
        IterativeBST<String, String> st = new IterativeBST<String, String>();

        // insert some (key, value pairs)
        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.amazon.com",       "208.216.181.15");
        st.put("www.simpsons.com",     "209.052.165.60");

        // search for IP addresses given URL
        System.out.println(st.get("www.cs.princeton.edu"));
        System.out.println(st.get("www.amazon.com"));
        System.out.println(st.get("www.amazon.edu"));

        System.out.println(st);
    }



}

