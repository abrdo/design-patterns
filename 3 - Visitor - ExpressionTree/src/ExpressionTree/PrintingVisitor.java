package ExpressionTree;

public class PrintingVisitor extends Visitor {
    public PrintingVisitor() {
        result = "";
    }

    @Override
    public Tree.TreeIterator getIterator() {
        return new Tree.InorderTreeIterator();
    }

    @Override
    public void visit(String s) {
        result = result + s;
    }
}
