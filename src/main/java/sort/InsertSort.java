package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序（直接插入排序）
 * 概念：类似于打扑克牌，将取到的新牌插入手中已经排好序的牌中。即将一个元素插入到已经排好序的有序表中，从而一个新的、记录数增 1 的有序表。
 * 思路：将待插元素，依次与已排序好元素从后到前进行比较，如果当前元素值比待插元素值大，则将移位到与其相邻的后一个位置，否则直接将待插元素插入当前元素相邻的后一位置，因为说明已经找到插入点的最终位置
 * 对于少量元素的排序，它是一个有效的算法。稳定排序
 *
 * @Author LeonardYe
 * @Date 2023/1/27 13:05
 */
public class InsertSort {

    /**
     * 插入排序（默认升序）
     *
     * @param array 待排序的数组
     */
    public static void sort(int[] array) {
        //排出简单情形，没有元素或者只有一个元素无需进行排序操作
        if (array != null && array.length > 1) {
            //外层循环，从数组的第二个元素开始，寻找该元素应该插入的位置
            for (int i = 1; i < array.length; i++) {
                //内层循环，往前遍历比大小，找到自己所在的位置
                for (int j = i; j > 0; j--) {
                    if (array[j] < array[j - 1]) {
                        //交换这两个元素的位置
                        int temp = array[j-1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }

    }

    /**
     * 用Arrays自带的排序方法和我们实现的插入排序方法 对相同的数组进行排序，然后对比结果
     *
     * @return 返回测试结果
     */
    public static boolean test() {
        //生成随机数组
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt(1000);
        }
        int[] testArray = array.clone();

        //对比结果
        InsertSort.sort(array);
        Arrays.sort(testArray);
        for (int i = 0; i < 1000; i++) {
            if (array[i] != testArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (!test()) {
                System.out.println("插入排序算法实现错误！");
            }
        }
        System.out.println("插入排序算法实现正确！");
    }

}
