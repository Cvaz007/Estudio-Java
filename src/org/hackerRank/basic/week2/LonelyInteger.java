package org.hackerRank.basic.week2;

import java.util.List;

public class LonelyInteger {
    public static void main(String[] args) {

    }
    public static int lonelyinteger(List<Integer> a) {
        int cont,aux,uni=0;
        for (int i = 0; i < a.size(); i++) {
            aux=a.get(i);
            cont=0;
            for (int j = 0; j < a.size(); j++) {
                if(j==i) continue;
                if(aux == a.get(j)){
                    cont+=1;
                }
            }
            if(cont==0){
                uni=aux;
                break;
            }
        }
        return uni;
    }
}
