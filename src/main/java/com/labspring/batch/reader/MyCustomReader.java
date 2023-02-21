package com.labspring.batch.reader;

import org.springframework.batch.item.ItemReader;

public class MyCustomReader implements ItemReader<String>{

    private final String[] stringArray = { "Zero", "One", "Two", "Three", "Four", "Five" };

    private int index = 0;

    @Override
    public String read() throws Exception {
        if (index >= stringArray.length) {
            return null;
        }

        String data = index + " " + stringArray[index];
        index++;
        System.out.println("MyCustomReader    : Reading data    : "+ data);
        return data;
    }


}
