package org.codeForces.nvl1400;

import java.util.Scanner;

public class ColorfulField {
    public static void main(String[] args) {
        Scanner objScanner = new Scanner(System.in);
        int n,m,k,t,size,posNW,posMW,pos,bandera=1,posNF,posMF;
        n= objScanner.nextInt();
        m= objScanner.nextInt();
        k= objScanner.nextInt();
        t= objScanner.nextInt();
        size=n*m;
        String array[]=new String[size];

        for (int i = 0; i < k; i++) {
            posNW= objScanner.nextInt();
            posMW= objScanner.nextInt();
            pos=((posNW-1)*5)+(posMW-1);
            array[pos]="Waste";
        }

        for (int i = 0; i < size; i++) {
            if (array[i] == null){
                if (bandera==1) {
                    array[i] = "Carrots";
                    bandera+=1;
                }else
                    if(bandera==2){
                    array[i] = "Kiwis";
                    bandera+=1;
                    }else{
                        array[i] = "Grapes";
                        bandera+=1;
                    }
            }else continue;

            if(bandera == 4) bandera=1;
        }
        for (int i = 0; i < t; i++) {
            posNF= objScanner.nextInt();
            posMF= objScanner.nextInt();
            pos=((posNF-1)*5)+(posMF-1);
            System.out.println(array[pos]);
        }

    }
}
