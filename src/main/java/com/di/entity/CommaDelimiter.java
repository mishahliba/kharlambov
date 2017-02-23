package com.di.entity;

/**
 * Created by beerman on 23.02.2017.
 */
public class CommaDelimiter implements Delimiter  {
    private final String delimiter = ",";
    @Override
    public String delimit(String arg) {
        String result = "";
        for (int i = 0; i <arg.length(); i++) {
            result+=arg.charAt(i)+delimiter;
        }
        return result;
    }
}
