package com.codingtest.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] beforeLine = new int[0];
        
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            int[] newLine = new int[i+1];
            
            for(int j = 0; j <= i; j++){
                newLine[j]= Integer.parseInt(st.nextToken());
                if (n == 1){
                    result = newLine[j];
                    break;
                }
            }

            if (i > 0){
                for(int j = 0; j < i; j++){
                    if (j == 0)
                        newLine[0] = beforeLine[0] + newLine[0];
                    else if (j == i)
                        newLine[j] = beforeLine[j-1] + newLine[j];
                    else
                        newLine[j] = Math.max(beforeLine[j-1], beforeLine[j])+newLine[j];
                    
                    result = result < newLine[j] ? newLine[j] : result;
                }
            }
            beforeLine = newLine;    
        }

        System.out.println(result);
        
        

    }
}
