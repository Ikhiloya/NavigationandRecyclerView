package com.loya.android.navigationandrecyclerview.models;

/**
 * Created by Ikhiloya on 12/29/2017.
 * * A Model class for alphabets and words
 */

public class Word {
    private String alphabet;
    private String word;

    public Word(String alphabet, String word) {
        this.alphabet = alphabet;
        this.word = word;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public String getWord() {
        return word;
    }
}
