package Sort;

import java.util.Arrays;
import java.util.Random;

public class SortHelper {
    public static void printArray(int[] array) {
        for(int i :array){
            System.out.print(i + " ");
        }
    }

    public static int[] generateArray(int n,int rangeL,int rangeR){
        int array[] = new int[n];
        if(rangeL > rangeR){
            throw new IllegalArgumentException("范围非法");
        }else{
            for(int i = 0;i < n;i++){
                array[i] = new Random().nextInt((rangeR - rangeL + 1)
                        + rangeL);
            }
            return array;
        }
    }
    public static int[] copyArray(int[] array){
        return Arrays.copyOf(array,array.length);
    }
    public static int[] generateNearlySortedArray(int n,int switchTimes,int range){
        int[] result = new int[n];
        for(int i = 1;i < switchTimes;i++){
            Random random = new Random();
            int a = random.nextInt(range);
            int b = random.nextInt(range);
            int temp = result[a];
            result[a] = result[b];
            result[b] = temp;
        }
        return result;
    }

}
