package com.ifmo.lesson14.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Добавьте поддержку переменных.
 * Синтаксис следующий.
 * Объявление переменной через символ '=':
 * x = 8
 *
 * Имя переменной не может быть числом.
 *
 * Использование в выражении вместо одного или двух аргументов:
 * x + 2
 * Результат: 10.
 *
 * Калькулятор должен выбрасывать соответствующие исключения с
 * подробными описаниями ошибок и как их исправить. Например,
 * если имя переменной не найдено или использовался неверный синтаксис.
 */
public class SimpleCalc {

    static Map<String, Integer> mVars = new HashMap<String, Integer>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        mVars.clear();

        while (true) {
            System.out.println("Enter expression: ");

            String line = scanner.nextLine();

            if ("exit".equals(line))
                break;

            try {
                System.out.println("Answer is: " + calculate(line));
            }
            catch (CalcException e) {
                System.err.println("Error occurred: ");

                e.printStackTrace();
            }
        }
    }

    static String calculate(String line) throws CalcException {

        if (!line.contains("+") && !line.contains("-") && !line.contains("="))
            throw new CalcException("Expression must contain '+', '-' or '=' : " + line);

        String[] operands = line.split(" ");

        if (operands.length != 3)
            throw new CalcException("Expression must have only 3 operands separated with space (e.g. 2 + 4, v1 + v2, v9 + 5 or v8 = 3): " + line);

        OPERATOR operator = OPERATOR.parse(operands[1]);

        if ( !(operandIsVar(operands[0]) || operandIsNumber(operands[0])) && !(operandIsVar(operands[2]) || operandIsNumber(operands[2])) )
            throw new CalcException("Wrong operand, must be integer numbers or variables : " + operands[0] + "," + operands[2]);

        return operator.applyA(operands[0], operands[2]);
    }

    private static boolean operandIsVar(String string) throws CalcException {
        return string.matches("^[a-zA-Z]+\\w*$") ;
    }

    private static boolean operandIsNumber(String string) throws CalcException {
        int i;
        try {
            i =  Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e) {
        }
        return false;
    }

    private static int parseOperand(String string) throws CalcException {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            throw new CalcException("Wrong operand, must be only integer number: " + string, e);
        }
    }

    private enum OPERATOR {

        PLUS, MINUS, ISEQ;

        String applyA( String argA, String argB ) throws CalcException {

            Integer arg1, arg2;

            switch (this) {

                case PLUS:
                case MINUS:
                    if (operandIsVar(argA)){
                        arg1 = mVars.get(argA);
                        if ( arg1 == null )
                            throw new CalcException("variable " + argA + " is not found");
                    }
                    else
                        arg1 = parseOperand(argA);
                    if (operandIsVar(argB)){
                        arg2 = mVars.get(argB);
                        if ( arg2 == null )
                            throw new CalcException("variable " + argB + " is not found");
                    }
                    else
                        arg2 = parseOperand(argB);
                    if (this == PLUS)
                        arg1 += arg2;
                    else
                        arg1 -= arg2;
                    return String.valueOf(arg1);
                case ISEQ:
                    if ( !operandIsVar(argA) )
                        throw new CalcException("variable must contain letters and digits only and first symbol is letter");
                    arg2 = parseOperand(argB);
                    mVars.put(argA, arg2);
                    return argA + " saved";
            }

            throw new CalcException("Unsupported operator: " + this);
        }

        static OPERATOR parse(String str) throws CalcException {
            switch (str) {
                case "+":
                    return PLUS;

                case "-":
                    return MINUS;

                 case "=":
                     return ISEQ;

            }

            throw new CalcException("Incorrect operator: " + str);
        }
    }
}
