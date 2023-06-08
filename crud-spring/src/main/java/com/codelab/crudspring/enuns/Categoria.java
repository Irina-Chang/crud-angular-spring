package com.codelab.crudspring.enuns;

public enum Categoria {
    BACK_END("Back-end"), FRONT_END("Front-end");

    private String value;

    private Categoria(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}