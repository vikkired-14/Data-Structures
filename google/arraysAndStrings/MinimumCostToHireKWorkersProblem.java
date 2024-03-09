package google.arraysAndStrings;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem URL : https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 * */
public class MinimumCostToHireKWorkersProblem {

    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;

        System.out.println(new MinimumCostToHireKWorkersProblem().mincostToHireWorkers(quality, wage, k));
    }

    /*
     * Time Complexity : O(N logN)
     * Space Complexity : O(N)
     * N is number of workers
     * */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Worker[] workers = new Worker[len];
        for (int i = 0; i < len; i++) workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);

        double ans = Integer.MAX_VALUE;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>();

        for (Worker worker : workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;

            if (pool.size() > k) sumq += pool.poll();
            if (pool.size() == k) ans = Math.min(ans, sumq * worker.ratio());
        }

        return ans;
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage;

    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker worker) {
        return Double.compare(ratio(), worker.ratio());
    }
}

/*
public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        List<double[]> workers = new ArrayList<>();
        Double minCost= Double.MAX_VALUE;
        for(int i=0;i<n;i++){
         workers.add(new double[]{(double)wage[i]/quality[i],(double)quality[i]});
        }
  workers.sort(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[0], b[0]);
            }
        });

          PriorityQueue<Double> pq = new PriorityQueue<>(new Comparator<Double>() {
            public int compare(Double a, Double b) {
                return Double.compare(b, a); // Compare in descending order
            }
        });
        double total=0.0;
        for(double[] work : workers){
            total += work[1];
            pq.offer(work[1]);
            if(pq.size()>k){
                total -= pq.poll();
            }
            if(pq.size()==k){
             minCost=   Math.min(minCost,total*work[0]);
            }
        }
        return minCost;
    }
 */