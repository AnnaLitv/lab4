package com.company;

/**
 * Класс для текста
 */
public class Text {
    private Sentence[] textMembers = null;
    private StringBuffer[] golos = new StringBuffer[500];
    int sentNumb = 0;
    int golosLex = 0;

    //конструктор
    Text(StringBuffer text) {
        int start = 0;
        if (!charIsDel(text.charAt(text.length() - 1))) {
            text.append('.');
        }
        textMembers = new Sentence[numbOfSentences(text)];
        int num = 0;
        deleteSpaces(text);
        if (text.length() != 0) {
            for (int i = 0; i < text.length(); i++) {
                if (charIsDel(text.charAt(i))) {
                    textMembers[num] = new Sentence(new StringBuffer(text.substring(start, i)));
                    if (i < text.length() - 2 && text.charAt(i + 1) == ' ') {
                        start = i + 2;
                    } else
                        start = i + 1;
                    num++;
                }
            }
        } else System.out.println("Text is empty");

    }

    //удаление пробелов
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

    //выделение слов, которые начинаются на гласную букву
    void textToGolos() {
        for (int i = 0; i < sentNumb; i++) {
            for (int j = 0; j < textMembers[i].length(); j++) {
                if (isGolos(textMembers[i].wordPosit(j))) {
                    String st = new String(textMembers[i].wordPosit(j));
                    golos[golosLex] = new StringBuffer(st);
                    golosLex++;
                }
            }

        }
    }

    //подсчет количества предложений
    int numbOfSentences(StringBuffer text) {
        int start = 0;

        if (text.length() != 0) {
            for (int i = 0; i < text.length(); ++i) {
                if (charIsDel(text.charAt(i))) {
                    sentNumb++;
                }
            }
        }
        return sentNumb;
    }

    //печать отсортированого масива
    void print() {
        for (int i = 0; i < golosLex; ++i) {
            System.out.println(golos[i]);
        }
    }

    //сортировка по второй букве
    void Sort() {
        for (int p = 0; p < golosLex; ++p) {
            for (int k = p + 1; k < golosLex; ++k) {
                if (golos[k].charAt(1) < golos[p].charAt(1)) {
                    StringBuffer t = golos[p];
                    golos[p] = golos[k];
                    golos[k] = t;
                }
            }
        }
    }

    //проверка первой буквы на гласность
    boolean isGolos(StringBuffer str) {
        if ((str.length() != 1) && (str.charAt(0) == 97 || str.charAt(0) == 101 || str.charAt(0) == 105 || str.charAt(0) == 111 || str.charAt(0) == 117 || str.charAt(0) == 121)) {
            return true;
        }
        return false;
    }

    //проверка символа на разделительный знак
    boolean charIsDel(char c) {
        char[] delimiters = new char[]{'.', '?', '!'};
        for (int i = 0; i < delimiters.length; i++) {
            if (c == delimiters[i]) {
                return true;
            }
        }
        return false;
    }
}
