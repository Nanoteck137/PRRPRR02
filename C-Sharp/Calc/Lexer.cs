using System;

enum TokenType
{
    UNKNOWN,

    NUMBER,
    IDENTIFIER,

    PLUS,
    MINUS,
    DIVIDE,
    MULTIPLY,

    END_OF_STREAM,
};

class Token
{
    public TokenType Type { get; set; }

    public Token(TokenType type)
    {
        Type = type;
    }
}

class TokenNumber : Token
{
    public double Number { get; private set; }

    public TokenNumber(double number) : base(TokenType.NUMBER)
    {
        Number = number;
    }
}

class TokenIdentifier : Token
{
    public string Identifier { get; private set; }

    public TokenIdentifier(string identifier) : base(TokenType.IDENTIFIER)
    {
        Identifier = identifier;
    }
}

class Lexer
{
    private int ptr;

    public string Text { get; private set; }

    public Lexer(string text)
    {
        Text = text;
    }

    public Token NextToken()
    {
        Token token = null;

        if (ptr >= Text.Length)
        {
            token = new Token(TokenType.END_OF_STREAM);
            goto done;
        }

        char currentChar = Text[ptr++];
        switch (currentChar)
        {
            case '+':
                token = new Token(TokenType.PLUS);
                break;

            default:
                if (char.IsDigit(currentChar))
                {
                    string numStr = "";
                    numStr += currentChar;

                    while (ptr < Text.Length && char.IsDigit(Text[ptr]))
                    {
                        numStr += Text[ptr];
                        ptr++;
                    }

                    double value = double.Parse(numStr);

                    token = new TokenNumber(value);
                }
                else if (char.IsLetter(currentChar) || currentChar == '_')
                {
                    string ident = "";
                    ident += currentChar;

                    while (ptr < Text.Length && char.IsDigit(Text[ptr]) || currentChar == '_')
                    {
                        ident += Text[ptr];
                        ptr++;
                    }

                    token = new TokenIdentifier(ident);
                }
                break;
        }

        if (token == null)
        {
            token = new Token(TokenType.UNKNOWN);
        }

    done:
        return token;
    }
}
