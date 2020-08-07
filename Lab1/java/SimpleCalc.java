class SimpleCalc{
    public float calculate​(int firstOperand,
                       int secondOperand,
                       char operator)
    {
        if(operator == '+')
            return (float)(firstOperand + secondOperand);
        else if(operator  == '-')
            return firstOperand - secondOperand;
        else if(operator == '*')
            return firstOperand * secondOperand;
        else if(operator == '/' && secondOperand != 0)
            return (float)firstOperand / secondOperand;
        else
            return firstOperand;
    }

    public void typeCast​(float value,
                     char type)
    {
        if(type  == 'b')
        {
            byte b = (byte)value;
            System.out.printf("Byte: " + b);
        }
        else if(type == 'i')
        {
            int i = (int)value;
            System.out.printf("Int: " + i);
        }
        else if(type == 'c')
        {
            char c = (char)value;
            System.out.printf("Char: " + c);
        }
        else
            System.out.printf("Invalid type");
    }
}



