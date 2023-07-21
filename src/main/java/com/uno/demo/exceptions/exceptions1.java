package com.uno.demo.exceptions;

public class exceptions1 extends RuntimeException {
    public exceptions1() {
        super();
        
    }

    public exceptions1(String message) {
        super(message);
    }

    public exceptions1(long id) {
        super("Product not found: " + id);
    }
}
