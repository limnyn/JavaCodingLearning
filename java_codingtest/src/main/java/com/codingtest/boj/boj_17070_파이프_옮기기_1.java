package com.codingtest.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17070
public class boj_17070_파이프_옮기기_1 {
    static int count; // 경우의 수 결과 값
    
    
    static int n;
    static int[][]grid;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for(int r = 0; r < n; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < n; c++){
                if (st.nextToken().equals("1"))
                    grid[r][c] = 1;
                
            }
        }

        pipe(0,1,0);
        System.out.println(count);
        //입력 완료
    }

    public static void pipe(int r, int c, int d){
        if (r == n-1 && c == n-1){
            count += 1;
            return;
        }

        if (d == 0){
            if (c == n-1)
                return;
            if (0 <= r && r < n && 0 <= c + 1 && c + 1 < n && grid[r][c+1] == 0){
                pipe(r, c+1, 0);
            }
            if (0 <= r + 1 && r + 1 < n && 0 <= c + 1 && c + 1 < n 
            && grid[r][c+1] == 0 && grid[r+1][c] == 0 &&  grid[r+1][c+1] == 0){
                pipe(r+1, c+1, 2);
            }
        }

        else if (d == 1){
            if (r == n-1)
                return;
            if (0 <= r + 1 && r + 1 < n && 0 <= c && c < n && grid[r+1][c] == 0){
                pipe(r + 1, c, 1);
            }
            if (0 <= r + 1 && r + 1 < n && 0 <= c + 1 && c + 1< n 
            && grid[r][c+1] == 0 && grid[r+1][c] == 0 &&  grid[r+1][c+1] == 0){
                pipe(r+1, c+1, 2);
            }
        }

        
        else if (d == 2){
            if (0 <= r  && r < n && 0 <= c + 1 && c + 1 < n
                && grid[r][c+1] == 0){
                    pipe(r, c+1, 0);
                }
            if (0 <= r + 1 && r + 1 < n && 0 <= c && c < n && grid[r+1][c] == 0){
                pipe(r + 1, c, 1);
            }
            if (0 <= r + 1 && r + 1 < n && 0 <= c + 1 && c + 1< n 
            && grid[r][c+1] == 0 && grid[r+1][c] == 0 &&  grid[r+1][c+1] == 0){
                pipe(r+1, c+1, 2);
            }
        }
    }
}
