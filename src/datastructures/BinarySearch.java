package datastructures;

/*
binary search of a sorted array
pay attention to midIndex-1 and +1 in recursive
because no need to compare mid again.

time efficiency of a binary search of an array
   Best Case: O(1)
  Worst Case: O(log n)
Average Case: O(log n)


  ...::: note :::...
(float) 5/2 is 2.5
5/2 is 2
*/
public class BinarySearch{

    /**
     * @param array array to be searched
     * @param value to be searched
     * @return index of the searching value (-1 if not found)
     */
    public static int search(int[] array, int first, int last, int value){
        if (first > last) return -1;

        int midIndex = (first+last)/2;
        int midValue = array[midIndex];
        if (midValue == value) {
            System.out.println("Found at index: "+midIndex);
            return midIndex;
        }
        else if (value < midValue) search(array, first, midIndex-1, value);
        else if (value > midValue) search(array, midIndex+1, last, value);
        return -1;
    }


    public static void main(String[] args) {
        int[] grades = {0,2,3,5,8,12,19}; // a sorted array (odd length)
        search(grades, 0, grades.length-1, 19);
    }
}
