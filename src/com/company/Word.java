package com.company;

/**
 * Created by Anna-PC on 14.05.2017.
 */
public class Word {
    private Letter[] letts = null;

    Word(StringBuffer word) {
        int leng = word.length();
        letts = new Letter[leng];
        for (int i = 0; i < leng; ++i) {
            letts[i] = new Letter(word.charAt(i));
        }
    }


    void printWord() {
        if (letts != null) {
            for (Letter letter : letts) {
                System.out.print(letter.getLet());
            }
        }
    }

    int sizeOfWord() {
        return this.letts.length;
    }

    char getTwoPositionValue() {
        return this.letts[0].getLet();
    }


}
