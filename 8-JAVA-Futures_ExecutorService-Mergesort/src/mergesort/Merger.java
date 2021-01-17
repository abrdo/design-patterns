package mergesort;

import java.util.LinkedList;

public class Merger implements Runnable{
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;
    public Merger(LinkedList<Integer> list1_, LinkedList<Integer> list2_) {
        list1 = list1_;
        list2 = list2_;
    }
    @Override
    public void run(){
        LinkedList<Integer> result = new LinkedList<>();
        while(!list1.isEmpty() || !list2.isEmpty()){
            if(list1.isEmpty()){
                result.addAll(list2); //check!
                break;
            }
            if(list2.isEmpty()){
                result.addAll(list1); //check!
                break;
            }

            if(list1.getFirst() < list2.getFirst()){
                result.add(list1.getFirst());
                list1.removeFirst();
            } else{
                result.add(list2.getFirst());
                list2.removeFirst();
            }
        }

        Mergesort.partialResults.add(result);
    }
}
