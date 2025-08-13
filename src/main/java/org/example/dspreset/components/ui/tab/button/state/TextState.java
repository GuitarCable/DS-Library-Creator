package org.example.dspreset.components.ui.tab.button.state;

import org.example.xml.XmlTags;
import org.example.xml.XmlNode;

public class TextState implements State {
    private final String name;

    public TextState(String name) {
        super();
        this.name = name;
    }

    @Override
    public XmlNode returnXml() {
        return new XmlNode.Builder("state")
                .xmlTags(getXmlTags())
                .build();
    }

    private XmlTags getXmlTags() {
        XmlTags xmlTags = new XmlTags();
        xmlTags.add("name", name);
        return xmlTags;
    }
}
