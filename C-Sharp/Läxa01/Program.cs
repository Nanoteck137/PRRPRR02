using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
  -  1. Skapa en metod som tar in ett okänt antal heltal och returnerar deras summa.
  -  2. Skapa en rekursiv metod som tar in en sträng och returnerar den baklänges.
  -  3. Skapa en generisk metod som tar in ett okänt antal objekt och returnerar en array av dem.
  -  4. Skapa en klass Box som tar in ett okänt antal objekt och lagrar dem.
  -  5. Skapa en metod i klassen Box som kan jämföra ifall två stycken Boxar innehåller samma datatyp.*
  6. Skapa en rekursiv metod som tar in ett ord och skriver ut alla anagram av ordet.*
  7. Skapa Application som rekursivt ritar ut ett fibonacci-träd.*
 */

class Program
{
    static void Main(string[] args)
    {
        {
            Console.WriteLine("1: ");
            int[] numbers = { 4, 6, 10, 8, 2 };
            int result = SumArray(numbers);
            Console.WriteLine("Sum Result: " + result);
        }

        Console.WriteLine();

        {
            Console.WriteLine("2: ");
            string str = "Hello World";
            string reversedStr = ReverseStr(str);
            Console.WriteLine("Reverse: {0} -> {1}", str, reversedStr);
        }

        Console.WriteLine();

        {
            Console.WriteLine("3: ");
            int[] numbers = ConvertToArray<int>(123, 321, 456, 654);

            Console.Write("[");
            foreach (object obj in numbers)
            {
                Console.Write("{0}, ", obj.ToString());
            }
            Console.WriteLine("]");
        }

        {
            Console.WriteLine("4:");
            Box box = new Box(123, 321);
            Console.WriteLine("Box: {0}", box.ToString());
            box.AddItem("Wooh");
            Console.WriteLine("Box: {0}", box.ToString());
        }

        {
            Console.WriteLine("5:");
            Box box = new Box(123, 321);
            Box box2 = new Box(123, 321, 456);
            Console.WriteLine("Box 1: {0}", box.ToString());
            Console.WriteLine("Box 2: {0}", box2.ToString());
            Console.WriteLine("(box == box2) = {0}", box.Equals(box2));
        }

        {
            Console.WriteLine("6:");
            string str = "abc";
            PrintAnagram(str.ToCharArray(), 0);
        }


        Console.Read();
    }

    static int SumArray(int[] arr)
    {
        int result = 0;
        foreach (int el in arr)
        {
            result += el;
        }

        return result;
    }

    static string ReverseStr(string str)
    {
        if (str.Length <= 0)
            return str;

        return str[str.Length - 1] + ReverseStr(str.Substring(0, str.Length - 1));
    }

    static T[] ConvertToArray<T>(params T[] list)
    {
        return list;
    }

    static void PrintAnagram(char[] str, int i)
    {
        if (i == str.Length - 1)
        {
            Console.WriteLine(str);
        }
        else
        {
            for (int j = i; j < str.Length; j++)
            {
                char c = str[i];
                str[i] = str[j];
                str[j] = c;

                PrintAnagram(str, i + 1);

                c = str[i];
                str[i] = str[j];
                str[j] = c;
            }
        }
    }
}
