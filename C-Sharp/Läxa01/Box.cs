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

    public override bool Equals(object obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        Box other = (Box)obj;

        if (items.Count != other.items.Count)
            return false;

        for (int i = 0; i < items.Count; i++)
        {
            if (items[i].GetType() != other.items[i].GetType())
                return false;

            if (!items[i].Equals(other.items[i]))
                return false;
        }

        return true;
    }

    public override string ToString()
    {
        string result = "";

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
