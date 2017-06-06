package com.company;

/**
 * Класс для слов
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



}
