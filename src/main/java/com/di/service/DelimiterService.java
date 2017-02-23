package com.di.service;

import com.di.entity.Delimiter;

/**
 * Created by beerman on 23.02.2017.
 */
public class DelimiterService {
    private Delimiter delimiter;

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public String delimit(String arg){

        return delimiter.delimit(arg);
    }
}
