package org.example.dspreset.components.ui.tab.button.state;

import org.example.xml.XmlNode;
import org.example.xml.XmlTags;

public class ImageState implements State {
    private final String name;
    private final String mainImage;
    private final String hoverImage;
    private final String clickImage;

    private ImageState(String name, String mainImage, String hoverImage, String clickImage) {
        this.name = name;
        this.mainImage = mainImage;
        this.hoverImage = hoverImage;
        this.clickImage = clickImage;
    }

    public static class Builder {
        private String name = null;
        private final String mainImage;
        private String hoverImage = null;
        private String clickImage = null;

        public Builder(String mainImage) {
            this.mainImage = mainImage;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder hoverImage(String hoverImage) {
            this.hoverImage = hoverImage;
            return this;
        }

        public Builder clickImage(String clickImage) {
            this.clickImage = clickImage;
            return this;
        }

        public ImageState build() {
            return new ImageState(name, mainImage, hoverImage, clickImage);
        }
    }

    @Override
    public XmlNode returnXml() {
        return new XmlNode.Builder("state")
                .xmlTags(getXmlTags())
                .build();
    }

    private XmlTags getXmlTags() {
        XmlTags xmlTags = new XmlTags();
        if(name != null) xmlTags.add("name", name);
        xmlTags.add("mainImage", mainImage);
        if(hoverImage != null) xmlTags.add("hoverImage", hoverImage);
        if(clickImage != null) xmlTags.add("clickImage", clickImage);

        return xmlTags;
    }
}
