package name.alenkov.habr.app;

import name.alenkov.habr.library.LibraryClass;

public class Application {
    public static void main(String[] args) {
        System.out.printf("library: " + new LibraryClass().get());
    }
}
