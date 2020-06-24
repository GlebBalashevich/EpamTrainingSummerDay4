package by.balashevich.arrayapp.parser;

import by.balashevich.arrayapp.entity.ArithmeticArray;

public class ArrayDataParser {
    private static final String REGEX_FILLED_ARRAY = "Arithmetic Array:\\W(-?\\d*,\\s)*-?\\d*\\W";
    private static final String REGEX_SPLIT = "\\W\\s";

    public ArithmeticArray parseArrayData(String arrayData) {
        ArithmeticArray array;

        if (arrayData.matches(REGEX_FILLED_ARRAY)) {
            int startIndex = arrayData.indexOf('[') + 1;
            int endIndex = arrayData.indexOf(']');
            String[] arrayElements = arrayData.substring(startIndex, endIndex).split(REGEX_SPLIT);
            int[] parsedArray = new int[arrayElements.length];

            for (int i = 0; i < parsedArray.length; i++) {
                parsedArray[i] = Integer.parseInt(arrayElements[i]);
            }

            array = new ArithmeticArray(parsedArray);
        } else {
            array = new ArithmeticArray();
        }

        return array;
    }
}
