package com.sam.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:NQuene
 * @Email: samqi1122@126.com
 * @Description: N皇后，LeeCode51
 * @Date: 2022/7/6 19:48
 *
 * 给你一个 N×N 的棋盘，让你放置 N 个皇后，使得它们不能互相攻击。
 * 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
 */
public class NQueens {

    static int N =5;

    // 棋盘
    static List<Integer> board = new ArrayList<>(N*N);

    public static void main(String[] args) {
        // 初始化棋盘，0 表示空，1表示占用
        for (int i = 0; i < N * N; i++) {
            board.add(0);
        }

        backtrack(board,0);

    }

    /**
     * 路径：棋盘中
     * 选择列表：每一行N中不同的可能
     * 结束条件：所有行都被访问过了
     *
     * @param board
     * @param row
     */
    public static void  backtrack(List<Integer> board,int row){
        // 结束条件
        if(row == N){
            // 打印
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d,",board.get(i*N + j));
                }
                System.out.println();
            }
            System.out.println("\n=================\n");
            return;
        }

        // 遍历状态：每行有N中不同的可能
        for (int i = 0; i < N; i++) {
            // 检查当前状态，排除不合法
            if(!isValid(board,row,i)){
                continue;
            }

            // 设置当前状态
            board.set(row * N + i,1);

            // 下一层
            backtrack(board,row + 1);

            // 撤销状态
            board.set(row * N + i,0);
        }
    }

    public static boolean isValid(List<Integer> board,int row,int col){
        // 检查列 col
        int cnt = 0;
        for (int irow = 0; irow < row; irow++) {
            cnt += board.get(irow * N + col);
        }

        if(cnt >0) return false;

        // 检查行
        for (int icol = 0; icol < col; icol++) {
            cnt += board.get(row * N + icol);
        }
        if(cnt >0) return false;

        // 检查左上
        int startRow = row -1;
        int startCol = col -1 ;

        for (; startRow >=0 && startCol >= 0 ; startRow--,startCol--) {
            cnt += board.get(startRow *N + startCol);
        }
        if(cnt >0) return false;

        // 检查右上

        startCol = col + 1;
        startRow = row - 1;
        for (;  startRow >=0 && startCol < N; startCol ++,startRow --) {
            cnt += board.get(startRow *N + startCol);
        }
        if(cnt >0) return false;

        return true;
    }
}
