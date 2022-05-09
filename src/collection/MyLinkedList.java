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


    public T value_at(int index)// - returns the value of the nth item (starting at 0 for first)
    {
        if ( index < 0 || index <= size )
        {
            return null;
        }
        if ( index == 0 )
            return Data.getData();
        MyNode<T> CurrentNode = Data;
        for( int i = 1; i < index +1 ; ++i)
        {
            CurrentNode = CurrentNode.NextNode;
        }
        return CurrentNode.getData();
    }

    public void push_front(T value)// - adds an item to the front of the list
    {
        if ( size == 0 )
        {
            Data = new MyNode<>(value, true);
            return;
        }
        MyNode<T> BufData = new MyNode<>(value, Data,true);
        Data = BufData;
    }

    public T pop_front() //- remove front item and return its value
    {
        if ( size == 0 )
        {
            return null;
        }
        if ( size == 1 )
        {
            T data = Data.getData();
            --size;
            Data = null;
            return data;
        }
        T data = Data.getData();
        Data = Data.NextNode;
        --size;
        return data;
    }


    public T front() //- get value of front item
    {
        if ( size == 0 )
            return null;
        return Data.getData();
    }

    public T back()// - get value of end item
    {
        return value_at(size-1);
    }

    public void insert(int index, T value)// - insert value at index, so current item at that index is pointed to by new item at index
    {
        if ( index < 0 || index +1 > size )
            return;
        if( index == 0 )
        {
            MyNode<T> BufData = new MyNode<>(value, Data,true);
            Data = BufData;
            ++size;
        }
        MyNode<T> CurrentNode = Data;
        MyNode<T> CreateNode;
        for( int i = 1; i < index  ; ++i)
        {
            CurrentNode = CurrentNode.NextNode;
            if ( i == size )
            {
                CurrentNode.NextNode = new MyNode<T>(value,false);
                ++size;
                break;
            }
            if( i == index - 1)
            {
                CreateNode = new MyNode<T>(value,CurrentNode.NextNode,false);
                CurrentNode.NextNode = CreateNode;
                ++size;
            }
        }
    }
    
    public void erase(int index)// - removes node at given index
    {
        if ( index < 0 || index >= size )
            return;
        else if( index == 0 && size > 1)
        {
            Data = new MyNode<T>(Data.NextNode, true);
        }
        else if( index == 0 && size == 1)
        {
            Data = null;
        }
        else
        {
            MyNode<T> CurrentNode = Data;
            for( int i = 1; i < index  ; ++i)
            {
                CurrentNode = CurrentNode.NextNode;
                if ( i == index -1 && index < size - 1 )
                {
                    CurrentNode.NextNode = new MyNode<T>(CurrentNode.NextNode.NextNode,false);
                    break;
                }
                if( i == index -1 && index == size - 1 )
                {
                    CurrentNode.NextNode = null;
                    break;
                }
            }
        }
        --size;
    }

    public T value_n_from_end(int index)// - returns the value of the node at nth position from the end of the list
    {
        if ( index < 0 || index >= size )
            return null;
        return value_at(size-1-index);
    }

    public void reverse()// - reverses the list
    {
        MyLinkedList<T> NewList = new MyLinkedList<>(this.pop_back());
        for (int i = 0; i < size; ++i)
            NewList.push_back(this.pop_back());
        this.copy(NewList);
    }

    public void copy(MyLinkedList<T> NewList)
    {
        Data = NewList.Data;
        size = NewList.size;
    }

    public void remove_value(T value)// - removes the first item in the list with this value
    {
        if ( size == 0 )
            return;
        if ( size == 1 )
            if (Data.getData().equals(value))
                this.pop_back();
        MyNode<T> CurrentNode = Data;
        for (int i = 0; i<size;++i)
        {
            if (CurrentNode.NextNode.getData().equals(value))
            {
                this.erase(i+1);
                break;
            }
        }
    }
}
