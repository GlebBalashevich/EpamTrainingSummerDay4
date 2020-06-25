package by.balashevich.arrayapp.validator;

import by.balashevich.arrayapp.entity.ArithmeticArray;
import by.balashevich.arrayapp.exception.InvalidArrayDataException;

public class ArrayValidator {

    public boolean validateArrayBinarySearch(ArithmeticArray array) throws InvalidArrayDataException {
        boolean isValid = true;

        if (array.getLength() < 2) {
            isValid = false;
        } else {
            int arrayLength = array.getLength();

            for (int i = 0; i < arrayLength - 1; i++) {
                if (array.getElement(i).getAsInt() > array.getElement(i + 1).getAsInt()) {
                    isValid = false;
                }
            }
        }

        return isValid;
    }
}
