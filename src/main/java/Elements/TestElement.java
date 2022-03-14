package main.java.Elements;

public class TestElement  {

    private String id;
    private String elementName;
    private String text;
    private String xpath;

    public TestElement(String id,String text, String xpath, String elementName) {
        this.id = id;
        this.text = text;
        this.elementName= elementName;
        this.xpath = xpath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
}