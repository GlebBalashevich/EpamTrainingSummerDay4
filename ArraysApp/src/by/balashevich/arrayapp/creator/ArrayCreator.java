package by.balashevich.arrayapp.creator;

import by.balashevich.arrayapp.entity.ArithmeticArray;
import by.balashevich.arrayapp.exception.InvalidArrayDataException;
import by.balashevich.arrayapp.parser.ArrayDataParser;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class ArrayCreator {
    private static final int MAX_CAPACITY = 100;

    public ArithmeticArray createRandomArray() {
        int randomCapacity = (int) (random() * MAX_CAPACITY);
        ArithmeticArray randomArray = new ArithmeticArray(randomCapacity);
        long valuesRange = MAX_VALUE * 2L;

        for (int i = 0; i < randomCapacity; i++) {
            int randomElement = (int) (random() * valuesRange - MAX_VALUE);
            randomArray.setElement(randomElement, i);
        }

        return randomArray;
    }

    public List<ArithmeticArray> createArraysFromString(List<String> arrayData) {
        ArrayDataParser arrayDataParser = new ArrayDataParser();
        List<ArithmeticArray> arithmeticArrays = new ArrayList<>();

        for (String arrayElement : arrayData) {
            arithmeticArrays.add(arrayDataParser.parseArrayData(arrayElement));
        }

        return arithmeticArrays;
    }

}
