package collection;

public class MyArray<T> {
    private int size = 0;
    private int capasity = 16;
    private Object[] array = new Object[capasity];

    private void resize() {
        Object[] newArray = new Object[capasity * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        capasity *= 2;
        array = newArray;
    }

    public int size()// - number of items
    {
        return size;
    }

    public int capacity()//number of items it can hold
    {
        return capasity;
    }

    public boolean is_empty() {
        return (size == 0) ? true : false;
    }

    public T at(int index)// returns item at given index, blows up if index out of bounds
    {
        if (index > size - 1 || index < 0) {
            return null;
        }
        return (T) array[index];
    }

    public void push(T item) {
        if (size == capasity || size > capasity) {
            resize();
        }
        array[size] = item;
        ++size;
    }

    public void insert(int index, T item)// - inserts item at index, shifts that index's value and trailing elements to the right
    {
        if (index > size || index < 0) {
            return;
        }
        if (size == capasity) {
            resize();
        }
        if (size == 0 && index == 0) {
            array = new Object[capasity];
            capasity = 16;
            array[0] = item;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = item;
        }
        ++size;
    }

    public void prepend(T item)// - can use insert above at index 0
    {
        if (size == 0) {
            capasity = 16;
            array = new Object[capasity];
            ++size;
        }
        array[0] = item;
    }

    public T pop()// - remove from end, return value
    {
        if (size != 0) {
            T returnValue = (T) array[size - 1];
            array[size - 1] = null;
            --size;
            return returnValue;
        }
        return null;
    }

    public int delete(int index)// - delete item at index, shifting all trailing elements left
    {
        if (index >= size || size == 0) {
            return -1;
        }
        if (size == 1) {
            array[0] = null;
            --size;
            return 0;
        }
        if (index == 0) {
            System.arraycopy(array, 1, array, 0, size - 1);
        } else {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        array[size - 1] = null;
        --size;
        return 0;
    }

    public int remove(T item)// - looks for value and removes index holding it (even if in multiple places)
    {
        if (size == 0) {
            return -1;
        }
        for (int i = size - 1; i >= 0; --i) {
            if (item.equals(array[i])) {
                if (i == size - 1) {
                    array[i] = null;
                } else {
                    System.arraycopy(array, i + 1, array, i, size - i -1);
                    array[size - 1] = null;
                }
                --size;
            }
        }
        return 0;
    }

    public int find(T item)// - looks for value and returns first index with that value, -1 if not found
    {
        int index;
        for (int i = 0; i < size; ++i) {
            if( item.equals(array[i]) )
                return i;
        }
        return -1;
    }

    public void print()
    {
        System.out.println();
        for (int i = 0; i < size; ++i)
           System.out.print(array[i].toString() + ' ');
        System.out.println();
    }
}
