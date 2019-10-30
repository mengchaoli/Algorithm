/*
* n an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.



Example 1:

Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation:
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.


Note:

1 <= persons.length = times.length <= 5000
0 <= persons[i] <= persons.length
times is a strictly increasing array with all elements in [0, 10^9].
TopVotedCandidate.q is called at most 10000 times per test case.
TopVotedCandidate.q(int t) is always called with t >= times[0].
*
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//For this problem, we take advantage of two hashmaps, the first one's key-value pair is: time-leader, as long as we get the time, we can get the leader at that time
//And for the second hashmap, key-value pair is person-votes. For each time we got from times[i], we can get the person from persons[i],
//and we can add one vote for that person at that time, and we can compare the vote to the previous leader's vote to see if the leader changes after this vote at this time
//And we need to put the time and corresponding leader to the first hashmap every time in the for loop.
public class _911_OnlineElection {

    int[] times;
    Map<Integer, Integer> timeLeader = new HashMap<>();// key: time, value: leader at `time`, could also use a parallel int[] here with same size as persons

    public void TopVotedCandidate(int[] persons, int[] times) {
        int leader = -1;
        this.times = times;
        Map<Integer, Integer> personCount = new HashMap<>();// key: person, value: num of votes

        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            int time = times[i];
            // update votesCounter
            personCount.put(person, personCount.getOrDefault(person, 0) + 1);
            // update leader if we've seen any change in the order
            if (leader == -1 || personCount.get(person) >= personCount.get(leader)) {
                leader = person;
            }
            timeLeader.put(time, leader);
        }
    }

    public int q(int t) {
        return timeLeader.get(getTime(t));
    }

    private int getTime(int time) {
        //Arrays.binarySearch:
        //This method returns index of the search key, if it is contained in the array, else it returns (-(insertion point) - 1), according to this question,
        //we need to get the smaller index of the time which is (-i - 2)
        int i = Arrays.binarySearch(times, time);
        int index = i < 0 ? (-i - 2) : i;
        return times[index];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
