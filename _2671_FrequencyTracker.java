public class _2671_FrequencyTracker {
    int[] arrNum = new int[100_001];
    int[] arrFreq = new int[100_001];
    public FrequencyTracker() {

    }

    public void add(int number) {
        if (arrNum[number] != 0) {
            arrFreq[arrNum[number]]--;
        }
        arrNum[number]++;
        arrFreq[arrNum[number]]++;
    }

    public void deleteOne(int number) {
        if (arrNum[number] != 0) {
            arrFreq[arrNum[number]]--;
            arrNum[number]--;
            arrFreq[arrNum[number]]++;
        }
    }

    public boolean hasFrequency(int frequency) {
        return arrFreq[frequency] != 0;
    }
}
