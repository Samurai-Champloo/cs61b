public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    private boolean isFull(){
        return size == items.length;
    }

    private boolean isSparse(){
        return size < (items.length / 4);
    }

    private int minusOne(int index){
        return (index - 1 + items.length) % items.length;
    }

    private int plusOne(int index){
        return (index + 1) % items.length;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void upSize(){
        resize(size * 2);
    }
    private void downSize(){
        resize(items.length / 2);
    }

    private void resize(int capacity){
        T[] newDeque = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);
        for(int newIndex = 0; newIndex < size; newIndex++){
            newDeque[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = newDeque;
        nextFirst = capacity - 1;
        nextLast = nextLast + 1 ;
    }

    public void addFirst(T item){
        if (isFull()) {
            upSize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item){
        if(size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public T removeFirst(){
        if(isSparse()){
            downSize();
        }
        nextFirst = plusOne(nextFirst);
        size--;
        return items[nextFirst];
    }

    public T removeLast(){
        if(isSparse()){
            downSize();
        }
        nextLast = minusOne(nextLast);
        size--;
        return items[nextLast];
    }

    public void printDeque() {
        int head = plusOne(nextFirst);
        int tail = minusOne(nextLast);
        for (int i = head; i != tail; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
    }

    public T get(int index){
        int resIndex = plusOne(nextFirst);
        for(int i = 0 ; i < index; i++){
            resIndex = plusOne(resIndex);
        }
        return items[resIndex];
    }

}
