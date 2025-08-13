package org.example.xml;

public class XmlTag {
    private final String key;
    private final String value;

    public XmlTag(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=\"" + value + "\"";
    }

    @Override
    public boolean equals(Object object) {
        try {
            XmlTag compareTo = (XmlTag) object;
            return this.key.contentEquals(compareTo.key);
        } catch (Exception e) {
            return false;
        }
    }
}
