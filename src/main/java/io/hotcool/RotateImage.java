package io.hotcool;

public class RotateImage {

    public void rotate(int[][] matrix) {
        if(null == matrix || 1 >= matrix.length){
            return;
        }
        final int lastIndex = matrix.length - 1;
        final int layers = lastIndex / 2;
        int temp = -1;
        for (int i = 0; i <= layers; i++) {
            for (int j = i; j <= lastIndex - i - 1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[lastIndex - j][i];
                matrix[lastIndex - j][i] = matrix[lastIndex - i][lastIndex - j];
                matrix[lastIndex - i][lastIndex - j] = matrix[j][lastIndex - i];
                matrix[j][lastIndex - i] = temp;

            }
        }
    }

}
