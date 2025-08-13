package org.example.dspreset.components.groups.group.sample;

import org.example.dspreset.XmlProvider;
import org.example.xml.XmlNode;
import org.example.xml.XmlTags;

public class Sample implements XmlProvider {
    private final String path;
    private final int root;
    private int loNote;
    private int hiNote;

    private Sample(String path, int root) {
        this.path = path;
        this.root = root;
    }

    public static class Builder {
        private String path;
        private int root;

        public Builder() {
            root = -1;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }
        public Builder root(int root) {
            if(root < 1 || root > 127) throw new IllegalArgumentException("root must be between 1 and 127 (inclusive). provided value was: " + root);
            this.root = root;
            return this;
        }

        public Sample build() {
            if(path == null) throw new IllegalStateException("sample path must be defined");
            if(root == -1) throw new IllegalStateException("sample root must be defined");
            return new Sample(path, root);
        }
    }

    public XmlNode returnXml() {
        return new XmlNode.Builder("sample")
                .xmlTags(getXmlTags())
                .build();
    }

    public XmlTags getXmlTags() {
        XmlTags xmlTags = new XmlTags();
        xmlTags.add("path", path);
        xmlTags.add("root", String.valueOf(root));
        return xmlTags;
    }
}
