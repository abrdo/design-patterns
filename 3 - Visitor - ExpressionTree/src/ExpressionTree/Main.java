package ExpressionTree;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Operation("+", new Number(3), new Operation("*", new Number(5), new Number(6)));

        Visitor printer = new PrintingVisitor();
        tree.iterate(printer);
        printer.printResult();

        Visitor calculator = new CalculatingVisitor();
        tree.iterate(calculator);
        calculator.printResult();
    }
}
