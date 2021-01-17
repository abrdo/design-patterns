package ExpressionTree;

public abstract class Visitor {
    protected String result;

    //protected Visitor() { result = ""; } // -- not necessary;  (why can't I use super with zero parameter constructor?)
    public abstract Tree.TreeIterator getIterator();
    public abstract void visit(String s);
    public void printResult() { System.out.println(result); }

}
