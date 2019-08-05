package Sort;


import java.util.SplittableRandom;

public class Test {
    public static void main(String[] args) {
        int[] data = SortHelper.generateArray(10000,0,2000000);
//        BinarySort(SortHelper.copyArray(data));
//        BubbleSort(SortHelper.copyArray(data));
//        insertSort(SortHelper.copyArray(data));
//        ShellSort(SortHelper.copyArray(data));
//        selectionSort(SortHelper.copyArray(data));
//        mergeSort(SortHelper.copyArray(data));
        quickSort(SortHelper.copyArray(data));
//        int[] data = new int[]{1,5,7,9,8,2,4,3};
//        insertSort(data);
//        BubbleSort(data);
//        BinarySort(data);
//        ShellSort(data);
//        selectionSort(data);
//        mergeSort(data);
//        quickSort(data);
//        SortHelper.printArray(data);
    }
    public static void BinarySort(int array[]){
        long start = System.currentTimeMillis();
        int n = array.length;

        if(n <= 1){
            return;
        }else{
            for(int i = 1;i < n;i++){
                int value = array[i];
                int low = 0;
                int high = i - 1;
                int j = i - 1;
                while (low <= high){
                    int mid = low + (high - low)/ 2;
                    if (array[mid] < value) {
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
                //找到插入位置high+1；
                for(;j >= high + 1;j--){
                    array[j+1] = array[j];
                }
                array[j+1] = value;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("折半插入排序的时间为："+(end - start)+"毫秒");
    }
    public static void BubbleSort(int[] array){
        long start = System.currentTimeMillis();
        int n = array.length;
        if(n <= 1){
            return;
        }else{
            //控制冒泡排序的次数
            //一次排序只能确保一个元素到达最终位置
            for(int i = 0;i < n;i++){
                boolean flag = false;
                for (int j = 0;j < n-i-1;j++){
                    if(array[j] > array[j+1]){
                        flag = true;
                        int temp = array[j];
                        array[j] = array[j +1];
                        array[j+1] = temp;
                    }
                }
                if(!flag) {
//                    System.out.println("数据集已经有序");
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序耗时："+(end - start) + "毫秒");
    }
    public static void insertSort(int[] array){
        long start = System.currentTimeMillis();
        int n = array.length;
        if(n <= 1){
            return;
        }else{
            for(int i = 1;i < n;i++){
                int value = array[i];
                int j = i - 1;
                for(;j >= 0;j--){
                    if(array[j] > value){
                        //搬移元素
                        array[j+1] = array[j];
                    }else{
                        break;
                    }
                    //已找到插入位置
                }
                array[j+1] = value;
            }
        }
        long end =System.currentTimeMillis();
        System.out.println("直接插入排序耗时："+ (end - start)+"毫秒");
   }
    public static void ShellSort(int[] array){
        long start = System.currentTimeMillis();
        int n = array.length;
        if(n <= 1){
            return;
        }else{
            int step = n / 2;
            while(step >= 1){
                for(int i = step; i < n;i++){
                    int value = array[i];
                    int j = i - step;
                    for(;j >= 0;j-= step){
                        if(array[j] > value){
                            array[j + step] = array[j];
                        }else{
                            break;
                        }
                    }
                    array[j + step] = value;
                }
                step = step / 2;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("希尔排序耗时："+(end - start)+"毫秒");
    }
    public static void selectionSort(int[] array){
        long start = System.currentTimeMillis();
        int n = array.length;
        if(n <= 1){
            return;
        }else{
            for(int i = 0;i < n - 1;i++){
                int minIndex = i;
                for(int j = i+1;j < n;j++){
                    if(array[j] < array[minIndex]){
                        minIndex = j;
                    }
                }
                //此时minIndex对于的元素一定是当前未排序区间的最小值
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("选择排序耗时："+(end - start)+"毫秒");
    }
    public static void mergeSort(int[] array){
        long start = System.currentTimeMillis();
        int n  =array.length;
        if(n <= 1){
            return;
        }
        int mid = n / 2;
        mergeInternal(array,0,  n - 1);
        long end = System.currentTimeMillis();
        System.out.println("归并排序耗时："+(end - start)+"毫秒");
    }
    private static void mergeInternal(int[] array,int low,int high)
    {
        if(low >= high){
            return;
        }
        int mid = (low+(high-low)/2);
        //左边小数组
        mergeInternal(array,low,mid );
        //右边小数组
        mergeInternal(array,mid + 1,high);
        //合并
        merge(array,low,mid,high);
   }
   public static void merge(int[]array ,int p,int q ,int r){
        int i = p;
        int j = q+1;
        int[] temp = new int[r-p+1];
        int k = 0;
        //此时俩个数组均有元素
        while(i <=q && j<= r){
            if(array[i] <= array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        //判断当前还有哪个数组没有走完
        int start = i;
        int end = q;
        //假如第二个小数组没有走完
        if(j <= r){
            start =j;
            end = r;
        }
        //把剩余元素直接放置在temp数组即可
       while(start <= end){
            temp[k++] = array[start++];
       }
       //将临时空间中已经合并好的数组拷贝回原数组
       for(i = 0;i < r-p+1;i++){
            array[p+i] = temp[i];
       }
   }
    public static void quickSort(int[] array){
        long start = System.currentTimeMillis();
        int n = array.length;
        if(n <= 1){
            return;
        }else {
            quickSortInternal3(array,0,n-1);
        }
        long end = System.currentTimeMillis();
        System.out.println("快速排序耗时："+(end - start)+"毫秒");
    }
    private static void quickSortInternal(int[] array,int l,int r){
        if(l >= r){
            return;
        }
        int q = partition2(array,l,r);
        quickSortInternal(array,l,q - 1);
        quickSortInternal(array,q + 1 ,r);
    }
    private static void quickSortInternal3(int[] array,int l ,int r){
        if(l >= r){
            return;
        }
        int randomIndex = (int) (Math.random() * (r-l-1) +l);
        swap(array,l,randomIndex);
        int v = array[l];
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while(i < gt){
            if(array[i] < v){
                swap(array,i,lt +1);
                lt++;
                i++;
            }else if(array[i] > v){
                swap(array,i,gt - 1);
                gt--;
            }else{
                i++;
            }
        }
        swap(array,l,lt);
        quickSortInternal3(array,l,lt-1);
        quickSortInternal3(array,gt,r);
    }

    /**
     *分区点选取方法
     * @param array 待排序的数组
     * @param l 数组最左元素
     * @param r 数组最右元素
     * @return 返回已经到达位置的分区点下标
     */
    private static int partition(int[] array,int l ,int r){
        //默认基准值为第一个元素
        int randomIndex = (int)(Math.random()*(r-l+1)+l);
        swap(array,l,randomIndex);
        int v = array[l];
        //array[l+1...j]<v
        int j = l;
        //array[j+1...i-1]>v
        int i = l+1;
        for(;i <= r;i++){
            //碰到小于比较值元素的值就与j+1交换位置爱，小与区间长度加1
            if(array[i] < v){
                //交换i与j+1的元素
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,l,j);
        return j ;
    }
    private static int partition2(int[] array,int l ,int r){
        int randomIndex = (int) (Math.random()*(r - l + 1) + l);
        swap(array,l,randomIndex);
        int v = array[l];
        int i = l + 1;
        int j = r;
        while (true){
            while (i <= r && array[i] < v){
                i++;
            }
            while (j >= l+1 && array[j] > v){
                j--;
            }
            if(i > j){
                break;
            }
            swap(array,l,j);
            i++;
            j--;
        }
        swap(array,l,j);
        return j;
    }

    private static void swap(int[] array,int indexA,int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}