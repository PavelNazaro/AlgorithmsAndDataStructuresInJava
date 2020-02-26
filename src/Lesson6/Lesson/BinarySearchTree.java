package Lesson6.Lesson;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    private Node addRecursive(Node current, T value){
        if (current == null){
            return new Node(value);
        }

        if (less(value, current.value)){
            current.left = addRecursive(current.left, value);
        } else if (more(value, current.value)){
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(T value){
        addRecursive(root, value);
    }

    private boolean containsValueRecursive(Node current, T value){
        if (current == null){
            return false;
        }

        if (current.value.compareTo(value) == 0){
            return true;
        }

        return less(value, current.value) ?
                containsValueRecursive(current.left, value) :
                containsValueRecursive(current.right, value);
    }

    public boolean containsValue(T value){
        return containsValueRecursive(root, value);
    }

    private Node deleteRecursive(Node current, T value){
        if (current == null){
            return null;
        }

        if (current.value.compareTo(value) == 0){
            if (current.left == null && current.right == null){
                return null;
            }

            if (current.right == null){
                return current.left;
            }

            if (current.left == null){
                return current.right;
            }

            T smallest = findSmallest(current.right);
            current.value = smallest;
            current.right = deleteRecursive(current.right, smallest);
        }

        if (less(value, current.value)){
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private T findSmallest(Node root){
        return root.left == null ? root.value : findSmallest(root.left);
    }

    private static boolean less(Comparable a, Comparable b){
        if (a == b){
            return false;
        }
        return a.compareTo(b) < 0;
    }

    private static boolean more(Comparable a, Comparable b){
        if (a == b){
            return false;
        }
        return a.compareTo(b) > 0;
    }

    private class Node{
        private T value;

        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
    }
}
