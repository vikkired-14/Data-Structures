package HeapPrioirtyQueue;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public FindMedianfromDataStream(){
      minHeap = new PriorityQueue<>((a,b)->b-a);
      maxHeap = new PriorityQueue<>((a,b)->a-b);
    }

    public void addNum(int num) {
      minHeap.add(num);
      if(minHeap.size()>maxHeap.size())
          maxHeap.add(minHeap.poll());
       if(maxHeap.size()>minHeap.size())
          minHeap.add(maxHeap.poll());
    }

    public double findMedian() {
       if(maxHeap.size() == minHeap.size())
         return (double) (maxHeap.peek() + minHeap.peek())/2;
       else if(maxHeap.size() > minHeap.size())
           return (double) maxHeap.peek();
       else
           return (double) minHeap.peek();


    }

    public static  void main(String[] args){


//Input
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//  Output
// [null, null, null, 1.5, null, 2.0]

        FindMedianfromDataStream medianFinder = new FindMedianfromDataStream();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}
