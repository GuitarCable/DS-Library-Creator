package org.example.dspreset.components.ui.tab.button;

import org.example.dspreset.XmlProvider;
import org.example.dspreset.components.ui.tab.button.enums.Enabled;
import org.example.dspreset.components.ui.tab.button.enums.Style;
import org.example.dspreset.components.ui.tab.button.state.State;
import org.example.xml.XmlTags;
import org.example.xml.XmlNode;

import java.util.ArrayList;

public class Button implements XmlProvider {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private int value;
    private Style style;
    private String mainImage;
    private String hoverImage;
    private String clickImage;
    private double disabledOpacity;
    private Enabled enabled;
    private String tags;
    private String tooltip;

    private ArrayList<State> states;

    private Button(int x, int y, int width, int height, int value, Style style, String mainImage, String hoverImage, String clickImage, double disabledOpacity, Enabled enabled, String tags, String tooltip) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        if(value > 0) this.value = value;
        if(style != null) this.style = style;
        if(mainImage != null) this.mainImage = mainImage;
        if(hoverImage != null) this.hoverImage = hoverImage;
        if(clickImage != null) this.clickImage = clickImage;
        if(disabledOpacity != 0.5) this.disabledOpacity = disabledOpacity;
        if(enabled != null) this.enabled = enabled;
        if(tags != null) this.tags = tags;
        if(tooltip != null) this.tooltip = tooltip;
    }

    public static class Builder {
        private int x = -1;
        private int y = -1;
        private int width = -1;
        private int height = -1;
        private int value;
        private Style style;
        private String mainImage;
        private String hoverImage;
        private String clickImage;
        private double disabledOpacity = 0.5;
        private Enabled enabled;
        private String tags;
        private String tooltip;

        public Builder() {
        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder value(int value) {
            this.value = value;
            return this;
        }

        public Builder style(Style style) {
            this.style = style;
            return this;
        }

        public Builder mainImage(String mainImage) {
            this.mainImage = mainImage;
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

        public Builder disabledOpacity(double disabledOpacity) {
            if(disabledOpacity <= 1 && disabledOpacity >= 0) this.disabledOpacity = disabledOpacity;
            else throw new IllegalArgumentException("disabledOpacity must be between 0.0 and 1.0 (inclusive)");
            return this;
        }

        public Builder enabled(Enabled enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder tooltip(String tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public Button build() {
            if(x < 0) throw new IllegalArgumentException("x should be a non-negative number");
            if(y < 0) throw new IllegalArgumentException("y should be a non-negative number");
            if(width < 0) throw new IllegalArgumentException("width should be a non-negative number");
            if(height < 0) throw new IllegalArgumentException("x should be a non-negative number");

            return new Button(x, y, width, height, value, style, mainImage, hoverImage, clickImage, disabledOpacity, enabled, tags, tooltip);
        }
    }

    @Override
    public XmlNode returnXml() {
        return new XmlNode.Builder("button")
                .xmlTags(getXmlTags())
                .build();
    }

    private XmlTags getXmlTags() {
        XmlTags xmlTags = new XmlTags();
        xmlTags.add("x", String.valueOf(x));
        xmlTags.add("y", String.valueOf(y));
        xmlTags.add("width", String.valueOf(width));
        xmlTags.add("height", String.valueOf(height));
        if(value > 0) xmlTags.add("value", String.valueOf(value));
        if(style != null) xmlTags.add("style", style.value);
        if(mainImage != null) xmlTags.add("mainImage", mainImage);
        if(hoverImage != null) xmlTags.add("hoverImage", hoverImage);
        if(clickImage != null) xmlTags.add("clickImage", clickImage);
        if(disabledOpacity != 0.5) xmlTags.add("disabledOpacity", String.valueOf(disabledOpacity));
        if(enabled != null) xmlTags.add("enabled", enabled.value);
        if(tags != null) xmlTags.add("tags", tags);
        if(tooltip != null) xmlTags.add("tooltip", tooltip);
        return xmlTags;
    }
}
