package main.java.Elements;

import org.openqa.selenium.By;

public class BrowserElement extends Element{

    public BrowserElement(By[] storage) {
        this.storage = storage;
    }

    protected int index() {
            return 0;
    }

    public By getBy(){
        return storage[this.index()];
    }

}