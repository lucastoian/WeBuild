package main.java.Elements;
import org.openqa.selenium.By;

public abstract class Element {
    protected By[] storage;

    protected abstract int index();

    public By getBy(){
        return storage[index()];
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (By el:storage) {
            sb.append(el.toString());
        }
        return sb.toString();
    }

    public String getXpath(){
        String xpath = this.getBy().toString().substring(10);
        return xpath;
    }
}