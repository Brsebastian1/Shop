package com.shop.demo.exceptions;

import org.apache.logging.log4j.message.Message;

import java.text.MessageFormat;

public class SearchException extends ExceptionsShop{
    public SearchException(String name) {
        super(MessageFormat.format("Product {0} not found", name));
    }
}
