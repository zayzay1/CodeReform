
package com.dependable.codereform.util;

import com.dependable.codereform.model.CRDocument;

import java.util.Arrays;

public class CRUtil {
    private static final String OPERATOR_FOUND = "X";

    private static final String[] operators = {
            "=", "+", "-", "*", "/", "%"
    };

    private static final String[] dataTypes = {
            "int", "double", "float", "String", "char", "byte", "boolean"
    };

    private static final Brackets[] brackets = {
            new Brackets("(", ")"),
            new Brackets("{", "}"),
            new Brackets("[", "]")
    };

    public static int countLines(CRDocument document) {
        return document.getContent().split("\n").length;
    }

    // TODO: 08/02/18 Add brackets
    public static int countDistinctOperators(CRDocument document) {
        String[] _operators = Arrays.copyOf(operators, operators.length);

        char[] characters = document.getContent().toCharArray();
        for (char character : characters) {
            for (int j = 0; j < _operators.length; j++) {
                if (String.valueOf(character).equals(_operators[j])) {
                    _operators[j] = OPERATOR_FOUND;
                    break;
                }
            }
        }

        int result = 0;
        for (String _operator : _operators) {
            if (_operator.equals(OPERATOR_FOUND)) {
                result++;
            }
        }

        return result;
    }

    // TODO: 08/02/18 Add brackets
    public static int countTotalOperators(CRDocument document) {
        int result = 0;
        char[] characters = document.getContent().toCharArray();
        for (char character : characters) {
            for (String operator : operators) {
                if (String.valueOf(character).equals(operator)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }

    public static int countDistinctOperands(CRDocument document) {
        return 0;
    }

    // TODO: 08/02/18 A function (operator in this case) can start with a datatype
    // TODO: 08/02/18 So try to find a way to distinguish!!!!
    public static int countTotalOperands(CRDocument document) {
        int result = 0;
        String[] lines = document.getContent().split("\n");
        for (String currentLine : lines) {
            if (currentLine.contains("("))
                result += (getQuotes(currentLine) / 2);

            // Check whether the current line contains with a data type.
            for (String dataType : dataTypes) {
                if (currentLine.startsWith(dataType)) {
                    String textAfterDataType = currentLine.substring(dataType.length(), currentLine.length());
                    if (!textAfterDataType.contains(",") && textAfterDataType.contains("=")) {
                        String[] variables = textAfterDataType.split(",");
                        result += variables.length;
                        break;
                    }
                    // Check whether there are functions which are also operands
                    // TODO: 20/02/18 Find a better way if you can
                    else if (getQuotes(textAfterDataType) != 0) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private static int getNumbers(String currentLine) {
        // TODO: 08/02/18 Continue workiing here:

        return 0;
    }

    private static int getQuotes(String currentLine) {
        int start = currentLine.indexOf("(") + 1;
        int end = currentLine.indexOf(")");
        String valueBetween = currentLine.substring(start, end);
        char[] chars = valueBetween.toCharArray();
        int quotes = 0;
        for (Character character: chars) {
            if (character == '"') {
                quotes++;
            }
        }

        return quotes;
    }

    private static class Brackets {
        private String open;
        private String close;

        public Brackets(String open, String close) {
            this.open = open;
            this.close = close;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public void setClose(String close) {
            this.close = close;
        }
    }
}
