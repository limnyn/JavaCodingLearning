package com.codingtest;

import java.util.Scanner;

public class d2_1959 {
    public static void main(String[] args) {
        // double doub;
        // int inte;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // testCase의 수
        
        for (int tC = 1; tC <= T; tC++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] nL = new int[n];
            int[] mL = new int[m];
            
            // 배열 초기화
            for (int i = 0; i < n; i++){
                nL[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++){
                mL[i] = sc.nextInt();
            }

            int[] shortL;
            int[] longL;

            if (n < m) {
                shortL = nL;
                longL = mL;
            } else {
                shortL = mL;
                longL = nL;
            }

            int maxNum = Integer.MIN_VALUE;

            for (int i = 0; i <= longL.length - shortL.length; i++){
                int loopSum = 0;
                for (int j = 0; j < shortL.length; j++){
                    loopSum += shortL[j] * longL[j + i];
                }

                maxNum = Math.max(maxNum, loopSum);
            }

            System.out.println("#"+tC+" "+maxNum);


        }
        sc.close();
        
    }

}



// 파이썬 코드
// for t_c in range(1, int(input())+1):
//     n, m = map(int, input().split())
//     n_l = list(map(int, input().split()))
//     m_l = list(map(int, input().split())) 
       
//     if n < m:
//         short_l = n_l
//         long_l = m_l
//     else:
//         short_l = m_l
//         long_l = n_l
    
//     max_num = -1e9
    
//     for i in range(len(long_l)-len(short_l)+1):
//         loop_sum = 0
//         for j in range(len(short_l)):
//             loop_sum += short_l[j]*long_l[j+i]    
        
//         max_num = max(max_num, loop_sum)
        
        
        
//     print(f'#{t_c} {max_num}')
        
    
        