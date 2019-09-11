using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
  -  1. Skapa en metod som tar in ett okänt antal heltal och returnerar deras summa.
  -  2. Skapa en rekursiv metod som tar in en sträng och returnerar den baklänges.
  3. Skapa en generisk metod som tar in ett okänt antal objekt och returnerar en array av dem.
  4. Skapa en klass Box som tar in ett okänt antal objekt och lagrar dem.
  5. Skapa en metod i klassen Box som kan jämföra ifall två stycken Boxar innehåller samma datatyp.*
  6. Skapa en rekursiv metod som tar in ett ord och skriver ut alla anagram av ordet.*
  7. Skapa Application som rekursivt ritar ut ett fibonacci-träd.*
 */

class Program
{
    static void Main(string[] args)
    {
        int[] numbers = { 4, 6, 10, 8, 2 };
        int result = SumArray(numbers);
        Console.WriteLine("Sum Result: " + result);

        string str = "Hello World";
        string reversedStr = ReverseStr(str);
        Console.WriteLine("Reverse: {0} -> {1}", str, reversedStr);

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
}
