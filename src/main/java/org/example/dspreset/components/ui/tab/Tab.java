package org.example.dspreset.components.ui.tab;

import org.example.dspreset.XmlProvider;
import org.example.dspreset.components.ui.tab.button.Button;
import org.example.xml.XmlNode;
import org.example.xml.XmlTags;

import java.util.ArrayList;

public class Tab implements XmlProvider {
    private final String name;
    private final ArrayList<Button> buttons;

    private Tab(String name, ArrayList<Button> buttons) {
        this.name = name;
        this.buttons = buttons;
    }

    public static class Builder {
        private final String name;
        private ArrayList<Button> buttons;

        public Builder(String name) {
            if(name.isBlank()) throw new IllegalArgumentException("name must not be blank");
            this.name = name;
            this.buttons = null;
        }

        public Builder buttons(ArrayList<Button> buttons) {
            this.buttons = buttons;
            return this;
        }

        public Tab build() {
            return new Tab(name, buttons);
        }
    }

    @Override
    public XmlNode returnXml() {
        return new XmlNode.Builder("tab")
                .xmlTags(getXmlTags())
                .childs(getChilds())
                .build();
    }

    private XmlTags getXmlTags() {
        XmlTags xmlTags = new XmlTags();
        xmlTags.add("name", name);
        return xmlTags;
    }

    private ArrayList<XmlNode> getChilds() {
        ArrayList<XmlNode> childs = new ArrayList<>();
        for(Button button : buttons) {
            childs.add(button.returnXml());
        }
        return childs;
    }
}
