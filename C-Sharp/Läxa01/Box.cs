using System;
using System.Collections.Generic;

class Box
{
    public List<object> items;

    public Box(params object[] list)
    {
        items = new List<object>();

        foreach (object item in list)
        {
            items.Add(item);
        }
    }

    public void AddItem(object item)
    {
        items.Add(item);
    }

    public override string ToString()
    {
        string result = "Box: ";

        result += "[";
        foreach (object obj in items)
        {
            result += string.Format("{0}, ", obj.ToString());
        }
        result = result.Remove(result.Length - 2, 2);
        result += "]";

        return result;
    }
}
