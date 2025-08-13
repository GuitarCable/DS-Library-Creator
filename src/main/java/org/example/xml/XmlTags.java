package org.example.xml;

import java.util.ArrayList;

public class XmlTags {
    private final ArrayList<XmlTag> xmlTags;

    public XmlTags() {
        xmlTags = new ArrayList<>();
    }

    public XmlTags(ArrayList<XmlTag> xmlTags) {
        this.xmlTags = xmlTags;
    }

    public void add(String key, String value) {
        XmlTag newXmlTag = new XmlTag(key, value);
        if(!xmlTags.contains(newXmlTag)) {
            xmlTags.add(newXmlTag);
        } else {
            throw new IllegalArgumentException("Tag already exists");
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(XmlTag xmlTag : xmlTags) {
            sb.append(" ");
            sb.append(xmlTag);
        }
        return sb.toString();
    }
}
