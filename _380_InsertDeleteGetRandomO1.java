import java.util.*;

public class _380_InsertDeleteGetRandomO1 {

    Map<Integer, Integer> locations;
    List<Integer> nums;
    Random rand = new Random();
    /** Initialize your data structure here. */

    //public RandomizedSet() {
   public _380_InsertDeleteGetRandomO1() {
        locations = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = locations.containsKey(val);
        if (contains) {
            return false;
        }
        locations.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contains = locations.containsKey(val);
        if (!contains) {
            return false;
        }
        int loc = locations.get(val);
        if (loc != nums.size()) { // not the last one then overwrite the this val with the lastOne and then we can remove the lastOne, which means we also removed this val
            int lastOne = nums.get(nums.size() - 1);
            nums.set(loc, lastOne);
            locations.put(lastOne, loc);
        }
        nums.remove(nums.size() - 1);
        locations.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
