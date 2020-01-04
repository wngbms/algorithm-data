package _01_SparseArray;

public class Demo1 {

    public static void main(String[] args) {

        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[7][6];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //统计非0元素的个数
        int num = 0;
        for (int[] arr : chessArr1) {
            for (int val : arr) {
                if (val != 0) {
                    num++;
                }
            }
        }
        System.out.println("非0个数:"+num);

        //创建稀疏数组
        int[][] sparseArray = new int[num + 1][3];
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = num;

        //为稀疏数组赋值
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] =chessArr1[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组");
        for (int[] arr : sparseArray) {
            for (int val : arr) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

        //还原稀疏数组
        int rows = sparseArray[0][0];
        int lines = sparseArray[0][1];
        int[][] destArray = new int[rows][lines];

        for (int i = 1; i < sparseArray.length; i++) {
            destArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //打印还原的数组
        System.out.println("还原后的数组");
        for (int[] arr : destArray) {
            for (int val : arr) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

    }
}
