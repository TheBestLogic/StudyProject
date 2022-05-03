package collection;

public class MyLinkedList<T> {
    MyNode<T> Data;
    int size;

    public MyLinkedList(T data)
    {
        if( Data.equals(null) )
        {
            Data = new MyNode<>(data, true);

        }
    }

    /*private void recursiveAdd( T data, MyNode<T> nextNode )
    {
        if( Data.equals(null) )
        {
            Data = new MyNode<>(data, true);

        }
        else
        {
            Data.setNextNode();
        }


    }*/

    public int size()// - returns number of data elements in list
    {
        return size;
    }

    public boolean empty()// - bool returns true if empty
    {
        return ( size == 0) ? true : false;
    }

    public void push_back(T _Data)// - adds an item at the end
    {
        Data.setNextNode(new MyNode<T>(_Data), null);
    }

    public T pop_back() //- removes end item and returns its value
    {
        T _date;
        if (size == 0)
            return  null;
        if (size == 1)
        {
            --size;
            _date=  Data.getData();
            Data = null;
            return _date;
        }
        _date = Data.popLastNode(null);
        --size;
        return _date;

    }


    //value_at(index) - returns the value of the nth item (starting at 0 for first)
    //push_front(value) - adds an item to the front of the list
    //pop_front() - remove front item and return its value


    //front() - get value of front item
    //back() - get value of end item
    //insert(index, value) - insert value at index, so current item at that index is pointed to by new item at index
    //erase(index) - removes node at given index
    //value_n_from_end(n) - returns the value of the node at nth position from the end of the list
    //reverse() - reverses the list
    //remove_value(value) - removes the first item in the list with this value
}
