package ExpressionTree;
import java.util.Iterator;

public abstract class Tree {
    private String value; // in case of Number you may have to convert it to a number type
    private Tree left, right; // in case of Number they are nullptr
    private Tree parent;

    // Iterators

    public static abstract class TreeIterator implements Iterator {
        Tree current;

        public void initialize(Tree tree) {
            Tree mostLeft = tree;
            while (mostLeft.left != null)
                mostLeft = mostLeft.left;
            current = mostLeft;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public abstract Tree next();
    }

    public static class InorderTreeIterator extends TreeIterator{
        @Override
        public Tree next() {
            if(!hasNext()){
                System.out.println("The iterator is done.");
            }
            Tree return_curr = current;
            if(current.right != null){
                initialize(current.right);
            } else if(current.parent != null) {
                if(current.parent.left == current) {
                    current = current.parent;
                } else if (current.parent.right == current) {
                    while (current.parent.parent != null && current.parent.parent.left != current.parent) {
                        current = current.parent;
                    }
                    if (current.parent.parent != null)
                        current = current.parent.parent;
                    else
                        current = null;
                }
            }else{ current = null; }


            return return_curr;
        }
    }

    public static class PostorderTreeIterator extends TreeIterator{
        @Override
        public Tree next() {
            if(!hasNext()){
                System.out.println("The iterator is done.");
            }
            Tree return_curr = current;
            if(current.parent != null){
                if(current.parent.left == current){
                    try {
                        initialize(current.parent.right);
                    } catch (Exception e) {
                        System.out.println("Error: valamelyik operationnak nincs 2 parametere...");
                    }
                } else if(current.parent.right == current) {
                    current = current.parent;
                } else {
                    System.out.println("Error: a parentek nem jol lettek definialva");
                }
            } else {
                current = null;
            }

            return return_curr;
        }
    }



    protected Tree(String nameP, Tree leftP, Tree rightP) {
        value = nameP;
        left = leftP;
        right = rightP;
        parent = null;
        if(left != null && right != null) {
            left.parent = this;
            right.parent = this;
        }
    }

    public void iterate(Visitor visitor) {
        // I assumed that to give "this" as parameter to the visitor is forbidden. (If it would have been allowed,
        // than the iterator and also the iterate(Visitor) would not have been necessery at all,
        // because than the visitor would have been able to simply iterate through on the whole structure recursively.)

        // BUT this way we cant do it recursively, because this way the visitor don1t know where we are in the tree, it just know
        // what is the next value.

        TreeIterator it = visitor.getIterator();
        it.initialize(this);
        while(it.hasNext())
            visitor.visit(it.next().value);
    }
}
