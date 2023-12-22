package de.java.array;

public class arr2 {
    public static void main(String[] args) {
        // 1. 행이 2개, 열이 4개인 2차원 배열
        int[][] twodArray = new int[2][4];

        twodArray[0][0] = 30; // 0행 0열 (첫번째 행, 첫번째 열)
        twodArray[1][3] = 60; // 1행 3열 (두번째 행, 네번째 열)
        twodArray[1][2] = 22; // 1행 2열 (두번째 행, 세번째 열)

        for(int i = 0; i < twodArray.length; i++){
            for(int j = 0; j < twodArray[i].length; j++){
                System.out.print("twodArray["+i+"]["+j+"] = "+ twodArray[i][j]+" ");
            }
            System.out.println();
        }

        // 2. 초기화
        int[][] arr = {
                {0,20,30},
                {1,2,3}
        };
    }
}
