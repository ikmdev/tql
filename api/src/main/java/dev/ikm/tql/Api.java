package dev.ikm.tql;

public class Api {
    public String getMessage() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new Api().getMessage());
    }
}