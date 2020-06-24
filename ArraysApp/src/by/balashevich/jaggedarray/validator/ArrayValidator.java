package by.balashevich.jaggedarray.validator;

public class ArrayValidator {

    public boolean validateJaggedArray(int[][] array) {
        boolean isValid = true;

        if (array == null || array.length < 2) {
            isValid = false;
        }
        for (int[] subArray : array) {
            if (subArray == null || subArray.length <= 0) {
                isValid = false;
            }
        }

        return isValid;
    }
}
