import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Lcs {

    public void compute(String X, String Y) {
        int i,j;
        int n = X.length();
        int m = Y.length();
        int[][] C = new int[n + 1][m + 1];
        int[][] B = new int[n + 1][m + 1];

        /* C[i][0] = 0 for 0<=i<=n */
        for (i = 0; i <= n; i++) {
            C[i][0] = 0;
        }

        /* C[0][j] = 0 for  0<=j<=m */
        for (j = 0; j <= m; j++) {
            C[0][j] = 0;
        }
        
        /* dynamic programming */
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    B[i][j] = 1;  /* diagonal */
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                    B[i][j] = 2;  /* down */
                } else {
                    C[i][j] = C[i][j - 1];
                    B[i][j] = 3;   /* forword */
                }
            }
        }
        /* Backtracking */
        String lcs = new String();
        i = n;
        j = m;
        while (i != 0 && j != 0) {
            if (B[i][j] == 1) {   /* diagonal */
                lcs = X.charAt(i - 1) + lcs;
                i = i - 1;
                j = j - 1;
            }
            if (B[i][j] == 2) {  /* up */
                i = i - 1;
            }
            if (B[i][j] == 3) {  /* backword */
                j = j - 1;
            }
            
        }
        printMethod(lcs);
        
    }
    public static String printMethod(String lc){

        /* print out the result */
       // System.out.println("String X is " + X);
        //System.out.println("String Y is " + Y);
        //System.out.println("The length of LCS is " + C[n][m]);
         try {
            File newFile = new File("output.txt");
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("The LCS is " + lc);
            bw.close();
            fw.close();
         }
         catch (IOException ex) {
            Logger.getLogger(Readfile.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lc;
    }
    
    public static int printComputeForExtraCredit(String p, String q){

        /* print out the result */
       // System.out.println("String X is " + X);
        //System.out.println("String Y is " + Y);
        //System.out.println("The length of LCS is " + C[n][m]);
        int i,j;
        int n = p.length();
        int m = q.length();
        int[][] C = new int[n + 1][m + 1];
        int[][] B = new int[n + 1][m + 1];

        /* C[i][0] = 0 for 0<=i<=n */
         for (i = 0; i <= n; i++) {
            C[i][0] = 0;
        }

        /* C[0][j] = 0 for  0<=j<=m */
        for (j = 0; j <= m; j++) {
            C[0][j] = 0;
        }
        
        /* dynamic programming */
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (p.charAt(i - 1) == q.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    B[i][j] = 1;  /* diagonal */
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                    B[i][j] = 2;  /* down */
                } else {
                    C[i][j] = C[i][j - 1];
                    B[i][j] = 3;   /* forword */
                }
            }
        }
        /* Backtracking */
        String lcs = new String();
        i = n;
        j = m;
        while (i != 0 && j != 0) {
            if (B[i][j] == 1) {   /* diagonal */
                lcs = p.charAt(i - 1) + lcs;
                i = i - 1;
                j = j - 1;
            }
            if (B[i][j] == 2) {  /* up */
                i = i - 1;
            }
            if (B[i][j] == 3) {  /* backword */
                j = j - 1;
            }
            
        }
          try {
            File newFile = new File("output.txt");
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
           System.out.println("The length of LCS is " +  C[n][m]);
            bw.close();
            fw.close();
         }
         catch (IOException ex) {
            Logger.getLogger(Readfile.class.getName()).log(Level.SEVERE, null, ex);
        }
         return  C[n][m];
    }
}
