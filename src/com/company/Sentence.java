package com.company;

/**
 * Created by Anna-PC on 14.05.2017.
 */
public class Sentence {
    private Word[] sentenceMembers = null;
    private Delim delim = null;
    private StringBuffer[] golos = null;
    private StringBuffer[] wods = new StringBuffer[1000];

    Sentence(StringBuffer str) {
        if (str.length() != 0) {
            deleteSpaces(str);
            sentenceMembers = new Word[sizeOfSent(str)];
            int lexemeCount = 0;
            int lastLexemeStart = 0;
            StringBuffer word;
            int golosLex = 0;
            for (int i = 0; i < str.length(); i++) {
                if (charIsDelim(str.charAt(i))) {
                    if (i - lastLexemeStart > 0) {
                        word = new StringBuffer(str.substring(lastLexemeStart, i));
                        sentenceMembers[lexemeCount] = new Word(word);
                        wods[lexemeCount] = new StringBuffer(word);
                        lexemeCount++;
                    }
                    lastLexemeStart = i + 1;
                } else if (i == str.length() - 1) {
                    word = new StringBuffer(str.substring(lastLexemeStart, i + 1));
                    wods[lexemeCount] = new StringBuffer(word);
                    sentenceMembers[lexemeCount] = new Word(word);
                }
            }
        }

    }

    public StringBuffer wordPosit(int pos) {
        return wods[pos];
    }

    public int length() {
        return sentenceMembers.length;
    }

    /* */
    void print() {
        for (int i = 0; i < golos.length; i++) {
            System.out.println(golos[i]);
            System.out.println(" ");
        }
        //System.out.println(delim.getDeli());
    }

    void deleteSpaces(StringBuffer str) {
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '\t') {
                str.setCharAt(i, ' ');
            } else if ((str.charAt(i) == ' ' || str.charAt(i) == '\t') && (i + 1 < str.length()) && (str.charAt(i + 1) == ' ' || str.charAt(i + 1) == '\t')) {
                str.deleteCharAt(i);
                i--;
            }
        }
        if (str.charAt(str.length() - 1) == ' ') str.deleteCharAt(str.length() - 1);
    }

    int sizeOfSent(StringBuffer str) {
        int lexemeCount = 0;
        int lastLexemeStart = 0;
        for (int i = 0; i < str.length(); i++) {
            if (charIsDelim(str.charAt(i))) {
                if (i - lastLexemeStart > 0) {
                    lexemeCount++;
                }
                lastLexemeStart = i + 1;
            } else if (i == str.length() - 1) {
                lexemeCount++;
            }
        }
        return lexemeCount;
    }

    private boolean charIsDelim(char c) {
        char[] delimiters = new char[]{'.', ',', ' ', '?', '!', '-', '\t', '\n', '\r'};
        for (int i = 0; i < delimiters.length; i++) {
            if (c == delimiters[i]) {
                return true;
            }
        }
        return false;
    }

}
