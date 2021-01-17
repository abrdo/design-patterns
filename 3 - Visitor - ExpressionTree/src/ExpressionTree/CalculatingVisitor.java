package ExpressionTree;

import java.util.ArrayList;

public class CalculatingVisitor extends Visitor {
    ArrayList<Integer> numStack;

    public CalculatingVisitor() { result = ""; numStack = new ArrayList<Integer>();}
    @Override
    public Tree.TreeIterator getIterator(){ return new Tree.PostorderTreeIterator(); }
    @Override
    public void visit(String s){
        if(s.equals("+")){
            if(numStack.size()>=2){
                int a = numStack.get(numStack.size()-1);
                int b = numStack.get(numStack.size()-2);
                int c = a+b;
                numStack.remove(numStack.size()-1);
                numStack.remove(numStack.size()-1);
                numStack.add(c);
            }
        } else if(s.equals("*")){
            int a = numStack.get(numStack.size()-1);
            int b = numStack.get(numStack.size()-2);
            int c = a * b;
            numStack.remove(numStack.size()-1);
            numStack.remove(numStack.size()-1);
            numStack.add(c);
        } else {
            int intnum = 0;
            try{
                intnum= Integer.parseInt(s);
                numStack.add(intnum);
            } catch (Exception e){
                System.out.println( intnum + " is not a valid integer or operation" );
            }
        }
    }
    @Override
    public void printResult(){
        if(numStack.size() == 1){
            result = String.valueOf(numStack.get(0));
            System.out.println(result);
        } else {
            System.out.println("Error: Stacksize is not 1 in CalculatingVisitor.");
        }
    }
}
