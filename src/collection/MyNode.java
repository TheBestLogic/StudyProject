package collection;

public class MyNode<T> {
    T data;
    MyNode<T>  NextNode;
    boolean first;

    public MyNode(T _data)
    {
        data = _data;
        first = false;
    }

    public MyNode(T _data,boolean _first)
    {
        data = _data;
        first = _first;
    }

    public MyNode(T _data, MyNode<T> _nextNode,boolean _first)
    {
        data = _data;
        NextNode = _nextNode;
        first = _first;
    }

    public void setNode(T _data)
    {
        data = _data;
    }

    public void setNextNode(MyNode<T>  _NextNode, MyNode<T>  _PrevNode)
    {
        if(NextNode.equals(null))
            NextNode = _NextNode;
        else
            setNextNode(_NextNode, NextNode);
    }

    public void getLastNode(MyNode<T>  _NextNode)
    {
        if(NextNode.equals(null))
            NextNode = _NextNode;
        else
            setNextNode(_NextNode, NextNode);
    }

    public boolean findNullNodeForPop()
    {
        if(NextNode.NextNode == null )
            return true;
        return false;
    }

    public T getData()
    {
        return data;
    }

    public T popLastNode(MyNode<T>  _NextNode)
    {
        T _data;
        if (findNullNodeForPop() && _NextNode.equals(null))
        {
            _data = NextNode.getData();
            NextNode = null;
            return _data;
        }
        if (findNullNodeForPop())
        {
            _data = _NextNode.NextNode.getData();
            _NextNode.NextNode = null;
            return _data;
        }
        if (_NextNode.equals(null))
            _data = popLastNode(NextNode) ;
        else
            _data = popLastNode(_NextNode) ;
        return _data;
    }



    public void ChangeFirstFlag()
    {
        first = ( first == true) ? false : true;
    }
}
