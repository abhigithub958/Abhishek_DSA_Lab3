package com.balancedbrackets;

import java.util.Stack;

public class BalancedBrackets {

    public static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        char[] brackets = expr.toCharArray();

        for (char bracket : brackets) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), bracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isMatchingPair(char char1, char char2) {
        return (char1 == '(' && char2 == ')') ||
               (char1 == '[' && char2 == ']') ||
               (char1 == '{' && char2 == '}');
    }

    public static void printResult(String input) {
        if (areBracketsBalanced(input)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered String does not contain Balanced Brackets");
        }
    }

    public static void main(String[] args) {
        // Sample input
        String input1 = "( [ [ { } ] ] )";
        String input2 = "( [ [ { } ] ] ) )";

        // Check and print the result
        printResult(input1);
        printResult(input2);
    }
}
