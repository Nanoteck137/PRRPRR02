using System;

class Node
{

}

class NodeNumber : Node
{
    public double Number { get; private set; }

    public NodeNumber(double number)
    {
        Number = number;
    }
};

enum Operation
{
    PLUS,
    MINUS,
    DIVIDE,
    MULTIPLY,
}

class NodeOp : Node
{
    public Node Left { get; private set; }
    public Node Right { get; private set; }
    public Operation Op { get; private set; }

    public NodeOp(Node left, Node right, Operation op)
    {
        Left = left;
        Right = right;
        Op = op;
    }
}

class Parser
{
    private Lexer lexer;

    public Parser(Lexer lexer)
    {
        this.lexer = lexer;
    }

    public Node Parse()
    {
        Node node = new Node();

        return node;
    }
}
