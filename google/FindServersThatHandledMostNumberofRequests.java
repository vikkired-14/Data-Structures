package google;
import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/description/
You have k servers numbered from 0 to k-1 that are being used to handle multiple requests simultaneously. Each server has infinite computational capacity but cannot handle more than one request at a time. The requests are assigned to servers according to a specific algorithm:

The ith (0-indexed) request arrives.
If all servers are busy, the request is dropped (not handled at all).
If the (i % k)th server is available, assign the request to that server.
Otherwise, assign the request to the next available server (wrapping around the list of servers and starting from 0 if necessary). For example, if the ith server is busy, try to assign the request to the (i+1)th server, then the (i+2)th server, and so on.
You are given a strictly increasing array arrival of positive integers, where arrival[i] represents the arrival time of the ith request, and another array load, where load[i] represents the load of the ith request (the time it takes to complete). Your goal is to find the busiest server(s). A server is considered busiest if it handled the most number of requests successfully among all the servers.

Return a list containing the IDs (0-indexed) of the busiest server(s). You may return the IDs in any order.



Example 1:


Input: k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
Output: [1]
Explanation:
All of the servers start out available.
The first 3 requests are handled by the first 3 servers in order.
Request 3 comes in. Server 0 is busy, so it's assigned to the next available server, which is 1.
Request 4 comes in. It cannot be handled since all servers are busy, so it is dropped.
Servers 0 and 2 handled one request each, while server 1 handled two requests. Hence server 1 is the busiest server.
Example 2:

Input: k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
Output: [0]
Explanation:
The first 3 requests are handled by first 3 servers.
Request 3 comes in. It is handled by server 0 since the server is available.
Server 0 handled two requests, while servers 1 and 2 handled one request each. Hence server 0 is the busiest server.
Example 3:

Input: k = 3, arrival = [1,2,3], load = [10,12,11]
Output: [0,1,2]
Explanation: Each server handles a single request, so they are all considered the busiest.


Constraints:

1 <= k <= 105
1 <= arrival.length, load.length <= 105
arrival.length == load.length
1 <= arrival[i], load[i] <= 109
arrival is strictly increasing.
 */
public class FindServersThatHandledMostNumberofRequests {
    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = new TreeSet<>();
        PriorityQueue<Pair<Integer,Integer>> busy = new PriorityQueue<>((a,b)->a.getKey()-b.getKey());
        int[] count = new int[k];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++){
            free.add(i);
        }

        for(int i=0;i<arrival.length;i++){
            int start = arrival[i];
            while(!busy.isEmpty() && busy.peek().getKey()<=start){
                Pair<Integer,Integer> busyToFree = busy.poll();
                free.add(busyToFree.getValue());
            }

            if (!free.isEmpty()){
                Integer serverId =free.ceiling(i%k);
                if(serverId==null)
                    serverId = free.first();
                busy.offer(new Pair<>(start+load[i],serverId));
                free.remove(serverId);
                count[serverId]++;
            }
        }
        int maxJob = Collections.max(Arrays.stream(count).boxed().collect(Collectors.toList()));
        for(int i=0;i<k;i++){
            if(count[i]==maxJob)
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args){

//        Input: k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
//        Output: [0]
        System.out.println(busiestServers(3,new int[]{1,2,3,4},new int[]{1,2,1,2}));
//        Input: k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
//        Output: [1]
   //     System.out.println(busiestServers(3,new int[]{1,2,3,4,5},new int[]{5,2,3,3,3}));

//        Input: k = 3, arrival = [1,2,3], load = [10,12,11]
//        Output: [0,1,2]
    //    System.out.println(busiestServers(3,new int[]{1,2,3},new int[]{10,12,11}));

    }
    }
/*
Two Priority Queues

In the previous approach, we relied on some built-in functions to help maintain free servers in sorted order. Here we also introduce a method that does not require binary search nor a complex sorting container, but simply two priority queues. Let's get into it now!

Let's temporarily change the conditions of the topic a little: whenever we have a request, we want to assign it to the smallest free server.
Now the problem becomes much easy;
We just need another priority queue named free to maintain a min-heap of all free servers. Each time we encounter a new request, pop the first server from the free queue that is guaranteed to be the smallest one.

Back to this problem, what will happen if we still use a priority queue to store free servers? Will we still get the correct result?

Let's look at the example below. We want to assign request 4 to a server. Since all free servers are stored in free by their IDs, assign it to the server on the top of free, that is, server 0.

img

Oops, this is the wrong choice! This request should be assigned to server 1 but is assigned to server 0! We use a priority queue as the container, so the first available server always has the smallest ID, regardless of what ID we want first.

This implies that we can't simply add the free server back to the free queue with its original ID, we can try modifying its ID before adding it to free.

img

But this is certainly not a random modification, and we must change the ID according to these rules:

The modified ID represents its priority to be assigned to a request i. In other words, the smallest ID represents the correct server for request i.
Suppose we have two free servers, 0 and 2, and the current i % k is 1. In this case, we should choose server 2, so the modified ID of server 2 should be smaller than that of server 0 (meaning server 2 has a higher priority than server 0).

The modified ID is still mapped to its original ID so that we can track a server by its modified ID.

Hence, we can increment each ID by multiple k to make it equal to or greater than i. Therefore, the value of the modified ID represents its priority to be assigned to task i, and we can always get its original ID by taking the remainder of this ID to k. Back to the problem, we add 3 to both servers 0 and 2 to make them 3 and 5. Now both modified IDs are no less than 3, and we assign task 3 to the server with the smaller modified ID (server 2).

img

Now, we can always get the correct server for each request. Refer to the slides below!

Current


Algorithm
Initialize an empty priority queue named free and a sorted container busy to store free and busy servers separately.

Use an array count of size k to record the workload of each server.

Put all k servers to free.

Iterate over requests, for each request [start[i], load[i]], do the following steps by order:

Remove free servers from busy, increment their IDs by multiple ks to make them no less than i, and add them to free.

If there are free servers in free, remove the first one and get its original ID busy_id by taking the residual of k for the modified ID, add this server to busy, and increment count[busy_id] by 1.

Otherwise, this request is abandoned, as we currently have no free server.
Repeat step 4.

After the iteration stops, collect all servers having the maximum workload.

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        PriorityQueue<Integer> free = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Pair<Integer, Integer>> busy = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

        // All servers are free at the beginning.

        for (int i = 0; i < k; ++i) {
            free.add(i);
        }

        for (int i = 0; i < arrival.length; ++i) {
            int start = arrival[i];

            // Remove free servers from 'busy', modify their IDs and
            // add them to 'free'
            while (!busy.isEmpty() && busy.peek().getKey() <= start) {
                Pair<Integer, Integer> curr = busy.remove();
                int serverId = curr.getValue();
                int modifiedId = ((serverId - i) % k + k) % k + i;
                free.add(modifiedId);
            }

            // Get the original server ID by taking the remainder of
            // the modified ID to k.
            if (!free.isEmpty()) {
                int busyId = free.peek() % k;
                free.remove();
                busy.add(new Pair<>(start + load[i], busyId));
                count[busyId]++;
            }
        }

        // Find the servers that have the maximum workload.
        int maxJob = Collections.max(Arrays.stream(count).boxed().collect(Collectors.toList()));
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            if (count[i] == maxJob) {
                answer.add(i);
            }
        }

        return answer;
    }
}
 */