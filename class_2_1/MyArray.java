package com.dsa.mooc.class_2_1;

/**
 * 用数组构建一个线性表
 * 1、数组是一种提供连续存储空间的数据结构，java语言中，数组只能存储一种类型数据,且声明之后数组长度不可改变。
 * 2、MyArray类:封装一个Array类,具备初始化数组，遍历数组，添加数据，删除数据，修改数据，查找数据的功能
 * 3、数组的特点：（无序数组）：插入快，查找慢，删除慢，数组创建后大小固定。
 *              （有序数组）：插入慢，查找快。。。
 */

public class MyArray {
    //定义一个数组
    private int[] intArray;
    //定义数组实际包含的元素个数
    private int elems;
    //定义数组最大长度
    private int maxLen;

    /**
     * 初始化默认数组，默认长度为10
     */
    public MyArray() {
        elems = 0;
        maxLen = 10;
        intArray = new int[maxLen];
    }

    /**
     * 初始化自定义长度数组
     *
     * @param length
     */
    public MyArray(int length) {
        elems = 0;
        maxLen = length;
        intArray = new int[maxLen];
    }

    //1、遍历数组
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    //2、添加元素
    public boolean add(int value) {
        if (elems == maxLen) {
            return false;
        } else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    //3、根据下标获取元素
    public int get(int i) {
        if (i < 0 || i >= elems) {
            System.out.println("数组下标越界");
//            throw new IndexOutOfBoundsException();
        }
        return intArray[i];
    }

    //4、根据元素值获取元素（获取元素第一次出现的下标）
    public int find(int value) {
        for (int i = 0; i < elems; i++) {
            if (intArray[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //5、删除元素
    public boolean remove(int value) {
        for (int i = 0; i < elems; i++) {
            if (intArray[i] == value) {
                //删除操作：把找到的元素删掉，其他元素往左挪一个位置（离被删除的元素近的先挪）
                //如果要删掉的元素刚好在数组最后，那其他元素就不用挪位置了
                if (i == elems - 1) {
                    elems--;
                } else {
                    for (int j = i; j < elems; j++) {
                        intArray[j] = intArray[j + 1];
                        elems--;
                    }
                }
                return true;
            }
        }
        return false;
    }

    //6、修改元素
    public boolean modify(int oldValue, int newValue) {
        int i = find(oldValue);
        if (i == -1) {
            System.out.println("修改的数据不存在");
            return false;
        } else {
            intArray[i] = newValue;
            return true;
        }
    }

    //7、插入元素
    public boolean insert(int index, int value) {
        //判断index是否越界
        if (index < 0 || index > elems) {
            System.out.println("数组下标越界");
            return false;
        }
        //若插入位置在数组末尾，相当于add方法
        if (index == elems) {
            add(value);
        } else {
            //在末尾从右往左，所有元素向右移动一格
            elems++;//先给数组扩容
            for (int i = elems - 1; i > index; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[index] = value;
        }
        return true;
    }

    //8、返回数组长度
    public int getSize() {
        return elems;
    }
}

class TestArray {
    public static void main(String[] args) {
        //初始化数组对象，默认长度为4
        MyArray arr = new MyArray();
        //添加元素
        System.out.println("添加元素" + arr.add(2));
        arr.add(6);
        arr.add(0);
        arr.add(5);
        System.out.println("添加元素" + arr.add(1));
        //遍历数组
        arr.display();
//        System.out.println(arr.get(4));
        //根据下标获取元素
        System.out.println("获取元素" + arr.get(3));
        //根据元素值获取元素下边
        System.out.println("查找元素" + arr.find(0));
        //删除元素
        System.out.println("删除元素 " + arr.remove(7));
        arr.display();
        //修改元素
        arr.modify(6, 8);
        arr.display();
        //插入元素
        arr.insert(0, 29);
        arr.display();
        arr.insert(arr.getSize(), 10);
        arr.display();

    }
}


