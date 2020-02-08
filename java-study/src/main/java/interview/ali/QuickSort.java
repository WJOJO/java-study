package interview.ali;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {

    private void quickSort(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int base = array[low];
        int i = low;
        int j = high;
        int temp ;
        while(i < j){
            while(array[j] >= base && i < j){
                j --;
            }
            while(base >= array[i] && i < j){
                i ++;
            }
            if(i < j){
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        array[low] = array[i];
        array[i] = base;
        quickSort(array, low, i - 1);
        quickSort(array,i + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {9,8,7,7,5,4,33,3,2,1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0 , array.length - 1);
        String collect = Arrays.stream(array).boxed().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(collect);
    }

}
