package org.riwi.simulacros.simulacro2_2.utils;

import javax.swing.*;
import java.util.List;

public class Utils {
    public <T> T[] listToArray(List<T> list) {
        T[] array = (T[]) new Object[list.size()];
        int i = 0;
        for (T iterator : list) {
            array[i++] = iterator;
        }
        return array;
    }

    public Object getOption(List<?> list, String message) {
        Object[] options = listToArray(list);
        return JOptionPane.showInputDialog(
                null,
                message,
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }
}
