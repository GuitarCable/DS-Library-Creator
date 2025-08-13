package org.example.dspreset.components.ui;

import org.example.dspreset.XmlProvider;
import org.example.dspreset.components.ui.enums.DefaultSize;
import org.example.dspreset.components.ui.tab.Tab;
import org.example.xml.XmlTags;
import org.example.xml.XmlNode;

import java.util.ArrayList;

public class UI implements XmlProvider {
    private final String coverArt;
    private final String bgImage;
    private final String bgColor;
    private final int width;
    private final int height;

    private final Tab tab;

    public UI(String coverArt, String bgImage, String bgColor, int width, int height, Tab tab) {
        this.coverArt = coverArt;
        this.bgImage = bgImage;
        this.bgColor = bgColor;
        this.width = width;
        this.height = height;

        this.tab = tab;
    }

    public static class Builder {
        private String coverArt;
        private String bgImage;
        private String bgColor;
        private int width;
        private int height;
        private Tab tab;

        public Builder() {
            this.coverArt = null;
            this.bgImage = null;
            this.bgColor = null;
            this.width = DefaultSize.DEFAULT_WIDTH.value;
            this.height = DefaultSize.DEFAULT_HEIGHT.value;
            this.tab = null;
        }

        public Builder coverArt(String coverArt) {
            this.coverArt = coverArt;
            return this;
        }

        public Builder bgImage(String bgImage) {
            this.bgImage = bgImage;
            return this;
        }

        public Builder bgColor(String bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public Builder width(int width) {
            if(width < 0) throw new IllegalArgumentException("width must be a non-negative number");
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            if(height < 0) throw new IllegalArgumentException("height must be a non-negative number");
            this.height = height;
            return this;
        }
        public Builder tab(Tab tab) {
            this.tab = tab;
            return this;
        }

        public UI build() {
            return new UI(coverArt, bgImage, bgColor, width, height, tab);
        }
    }

    @Override
    public XmlNode returnXml() {
        return new XmlNode.Builder("ui")
                .xmlTags(getTags())
                .childs(getChilds())
                .build();
    }

    private XmlTags getTags() {
        XmlTags buttonXmlTags = new XmlTags();
        if(coverArt != null) buttonXmlTags.add("coverArt", coverArt);
        if(bgImage != null) buttonXmlTags.add("bgImage", bgImage);
        if(bgColor != null) buttonXmlTags.add("bgColor", bgColor);
        buttonXmlTags.add("width", String.valueOf(width));
        buttonXmlTags.add("height", String.valueOf(height));
        return buttonXmlTags;
    }

    private ArrayList<XmlNode> getChilds() {
        ArrayList<XmlNode> childs = new ArrayList<>();
        childs.add(tab.returnXml());
        return childs;
    }
}
