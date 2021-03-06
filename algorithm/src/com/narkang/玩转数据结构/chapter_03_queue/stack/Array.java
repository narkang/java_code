package com.narkang.玩转数据结构.chapter_03_queue.stack;

/**
 * 基于数组操作的工具类，方便外部使用调用
 */
class Array<T> {

    private T[] data;  //维护的数据
    private int size;  //维护的数据容量大小

    public Array(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造方法，默认容量大小为10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取容器的长度
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组已经存放元素的个数
     */
    public int getSize(){
        return size;
    }

    /**
     *  返回数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *  在index索引处添加元素
     */
    public void add(int index, T e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if(size == data.length){
            resize(2 * data.length);
        }

        for (int i = size - 1; i>=index; i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     *  在所有元素前添加一个新元素
     */
    public void addFirst(T e){
        add(0, e);
    }

    /**
     *  在所有元素后面添加一个新元素
     */
    public void addLast(T e){
        add(size, e);
    }

    /**
     *  获取index索引位置的元素
     */
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        return data[index];
    }

    /**
     *  修改index索引位置的元素
     */
    public void set(int index, T e){

        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }

        data[index] = e;
    }

    /**
     *  查找数组中是否有元素
     */
    public boolean contains(T e){

        for (int i = 0; i < size; i++){
            if(data[i] == e){
                return true;
            }
        }

        return false;
    }

    /**
     *  查找数组中指定元素的索引
     */
    public int find(T e){

        for (int i = 0; i < size; i++){
            if(data[i] == e){
                return i;
            }
        }

        return -1;
    }

    /**
     *  从数组中删除index位置的元素，返回删除的元素
     */
    public T remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        T ret = data[index];
        for(int i = index + 1; i<size; i++){
            data[i - 1] = data[i];
        }

        size --;
        data[size] = null;

        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     *   从数组中删除第一个元素，并返回删除的元素
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     *   从数组中删除最后一个元素，并返回删除的元素
     */
    public T removeLast(){
        return remove(size - 1);
    }

    /**
     *  将数组扩容为newCapacity大小
     */
    private void resize(int newCapacity){

        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取数组第一个元素
     * @return
     */
    public T getFirst(){
       return get(0);
    }

    /**
     * 获取数组最后一个元素
     * @return
     */
    public T getLast(){
        return get(size - 1);
    }

    /**
     *  toString重写
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i<size; i++){
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}