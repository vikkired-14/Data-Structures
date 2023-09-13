package google;

import java.util.*;

/*
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.


Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.


Constraints:

0 <= start < end <= 109
At most 1000 calls will be made to book.
 */

/*
Approach #2: Sorted List + Binary Search
Intuition

If we maintained our events in sorted order, we could check whether an event could be booked in O(log⁡N)O(\log N)O(logN) time (where NNN is the number of events already booked) by binary searching for where the event should be placed. We would also have to insert the event in our sorted structure.

Algorithm

Initialize with an empty sorted list data structure calendar.
For every new interval[start, end) in book() invokation, we check if there is a conflict on each side with neighboring intervals.
Lookup the first index idx, which maps to an element [s1,e1) in calendar and s > start, and this step can be conducted by binary search (see this explore card) as we keep calendar in sorted order by starting points of intervals. (Notice that there may not be such an idx beacuse start >= all kept intervals. In this case, we don't need to check the follwing step)
Check if end > s1. If yes, [start, end) and [s1,e1) must be overlapped, [start, end) is illegal, and we should return false for the invokation now.
Roll back to the index idx-1, which maps to an element [s2,e2) in calendar and s1 is the largest staring points that satisfy s1 <= start. (Similarly, notice that there may be no element at idx-1 because idx is the 0-th index. In this case, we don't need to check the follwing step either)
Check if e2 > start. If yes, [s2,e2) and [start, end) must be overlapped, [start, end) is illegal, and we should return false for the invokation now.
If [start, end) passes all checkings above, we insert this valid interval at idx in calendar.
Implementation

We need a data structure that keeps elements sorted and supports fast insertion.

In Java, a TreeMap is the perfect candidate.
In C++, we can use set container and lower_bound method.
In Python, we can keep a SortedList.
 */
public class MyCalendarI {
    TreeMap<Integer,Integer> calender;
    MyCalendarI(){
        calender = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        Integer prev = calender.floorKey(start);
        Integer next = calender.ceilingKey(start);
        if((prev==null || start>=calender.get(prev))&&
                (next==null || end <=next)){
            calender.put(start,end);
            return true;
        }

        return false;
    }
}
