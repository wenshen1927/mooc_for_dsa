package com.dsa.mooc.class_1_1;

/**
 * 牛客上的二分查找题：
 * https://www.nowcoder.com/practice/28d5a9b7fc0b4a078c9a6d59830fb9b9?tpId=49&&tqId=29278&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
 * 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。
 * 若该元素出现多次，请返回第一次出现的位置。
 * <p>
 * 注意：要返回第一次出现的位置哦！而且没说数组是递增还是递减。
 */
public class BinarySearchPlusPlus {
    public static int search(int[] arr, int key) {
        //数组为空
        if (arr == null) {
            return -1;
        }
        //判断输入的数组是否合法（数组是否有序）（题目给出的都是有序的）

        //数组只有一个元素，不需要判断是递增数组还是递减数组
        if (arr.length == 1) {
            if (arr[0] != key) {
                return -1;
            } else {
                return 0;
            }
        }
        //数组大于一个元素，需要判断是递增数组还是递减数组
        boolean flag = true;//默认递增
        if (arr.length > 1) {
            if (arr[0] > arr[arr.length - 1]) {//若第一个元素大于最后一个元素，则认为数组递减（若数组的元素全部相同，默认递增）
                flag = false;
            }
        }

        int lo = 0;
        int hi = arr.length - 1;
        int mid = -1;

        if (flag) {//升序
            while (lo < hi) {//这里不能取等号 ==>(lo == hi)的时候，说明已经找到了第一次出现的值(或者没找到)，在继续的话，会进入死循环（不停地验证mid == lo == hi）
                mid = (lo + hi) / 2;
                if (key > arr[mid]) {
                    lo = mid + 1;
                } else if ((key < arr[mid])) {
                    hi = mid - 1;
                } else {
                    hi = mid;
                    //这里把查找的到值得坐标放在hi处，继续做二分查找，
                    //lo向右靠，慢慢靠近key,当arr[lo]==key时，hi向左靠（如果此时lo!=hi，也就是说lo和hi之间还有几个相同的元素），
                    //直到hi==lo为止，进而找到lo为第一次出现的key值            }
                }
                if (arr[lo] == key) {
                    return lo;
                }
            }
        }
        if (!flag) {//降序
            while (lo < hi) {//这里不能取等号 ==>(lo == hi)的时候，说明已经找到了第一次出现的值(或者没找到)，在继续的话，会进入死循环（不停地验证mid == lo == hi）
                mid = (lo + hi) / 2;
                if (key > arr[mid]) {
                    hi = mid - 1;
                } else if ((key < arr[mid])) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                    //这里把查找的到值得坐标放在hi处，继续做二分查找，
                    //lo向右靠，慢慢靠近key,当arr[lo]==key时，hi向左靠（如果此时lo!=hi，也就是说lo和hi之间还有几个相同的元素），
                    //直到hi==lo为止，进而找到lo为第一次出现的key值            }
                }
                if (arr[lo] == key) {
                    return lo;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 4, 11, 21};
        int[] b = {0, 1, 2, 3, 3, 3, 3, 4, 6, 7, 8, 9, 10, 11, 12, 12, 13, 14, 15};
        int[] c = {10, 9, 9, 9, 8, 7, 5, 4, 4, 4, 3, 1};
        System.out.println("input array is : ");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();

        int index = search(c, 9);
        System.out.println("index is :" + index);
    }
}
