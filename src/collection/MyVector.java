package collection;

import java.lang.*;

public class MyVector {

    int size = 0;
    int capacity = 0;
    Integer[] array;

    //size() - number of items
    public int size()
    {
        if( array == null )
            return -1;
        if(array.length == 0 )
            return -1;
        return array.length;
    }

    //capacity() - number of items it can hold
    public int capacity()
    {
        return capacity;
    }

    public boolean is_empty()
    {
        if( array == null )
            return true;
        if(array.length == 0 )
            return true;
        return false;
    }

    //at(index) - returns item at given index, blows up if index out of bounds
    public Integer at(int index)
    {
        if( index < 0 || index >= capacity )
        {
            return null;
        }
        return array[index];
    }

    //push(item)
    //insert(index, item) - inserts item at index, shifts that index's value and trailing elements to the right
    //prepend(item) - can use insert above at index 0
    //pop() - remove from end, return value
    //delete(index) - delete item at index, shifting all trailing elements left
    //remove(item) - looks for value and removes index holding it (even if in multiple places)
    //find(item) - looks for value and returns first index with that value, -1 if not found
    //resize(new_capacity) // private function
    void resize(int newCapacity)
    {
        Integer[] tmpArray = new Integer[ capacity * 2 ];
        tmpArray = array.clone();
        array = tmpArray;
        capacity *= 2;
    }
    //when you reach capacity, resize to double the size
    //when popping an item, if size is 1/4 of capacity, resize to half
}
