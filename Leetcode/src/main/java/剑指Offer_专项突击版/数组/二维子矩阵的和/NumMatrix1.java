package 剑指Offer_专项突击版.数组.二维子矩阵的和;

class NumMatrix1 {
    int[][] sum;

    public NumMatrix1(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sum = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0) sum[i][j] = sum[i][j - 1] + matrix[i][j];
                    if (j == 0) {
                        sum[i][j] = matrix[i][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int count = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 - 1 >= 0) count += sum[i][col2] - sum[i][col1 - 1];
            else count += sum[i][col2];
        }
        return count;
    }
}
