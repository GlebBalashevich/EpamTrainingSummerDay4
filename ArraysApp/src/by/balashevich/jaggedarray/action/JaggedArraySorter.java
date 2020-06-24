package by.balashevich.jaggedarray.action;

import by.balashevich.jaggedarray.enumeration.SortDirection;
import by.balashevich.jaggedarray.enumeration.SortKey;
import by.balashevich.jaggedarray.exception.InvalidArrayDataException;
import by.balashevich.jaggedarray.validator.ArrayValidator;

public class JaggedArraySorter {

    public void bubbleSort(int[][] array, SortDirection sortDirection, SortKey sortKey) throws InvalidArrayDataException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!arrayValidator.validateJaggedArray(array)){
            throw new InvalidArrayDataException("Incorrect jagged array data for bubble sorting");
        }
        for (int[] ignored : array) {
            for (int j = 0; j < array.length - 1; j++) {
                int firstSortKey = searchSortKey(array[j], sortKey);
                int secondSortKey = searchSortKey(array[j + 1], sortKey);

                if ((firstSortKey - secondSortKey) * sortDirection.getFlag() > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private int searchSortKey(int[] array, SortKey sortKey) {
        int key = sortKey == SortKey.SUM ? 0 : array[0];

        for (int element : array) {
            if (sortKey == SortKey.SUM) {
                key += element;
            } else {
                if ((key < element && sortKey == SortKey.MAXIMUM) ||
                        (key > element && sortKey == SortKey.MINIMUM)) {
                    key = element;
                }
            }
        }

        return key;
    }

    private void swap(int[][] array, int firstIndex, int secondIndex) {
        int[] buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;
    }
}
