package org.example.xml;

import java.util.ArrayList;

public class XmlNode {
    private final String name;
    private final XmlTags xmlTags;
    private String content;
    private final ArrayList<XmlNode> childs;

    private XmlNode(String name, XmlTags xmlTags, String content, ArrayList<XmlNode> xmlNode) {
        if(name.isBlank()) throw new IllegalArgumentException("name not defined");
        this.name = name;
        this.xmlTags = xmlTags;
        this.content = content;
        this.childs = xmlNode;
    }

    public static class Builder {
        private String name;
        private XmlTags xmlTags;
        private String content;
        private ArrayList<XmlNode> childs;

        public Builder(String name) {
            this.name = name;
        }

        public Builder xmlTags(XmlTags xmlTags) {
            this.xmlTags = xmlTags;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder childs(ArrayList<XmlNode> childs) {
            this.childs = childs;
            return this;
        }

        public XmlNode build() {
            if(xmlTags ==null) xmlTags = new XmlTags();
            if(content==null) content = "";
            if(childs==null) childs = new ArrayList<>();
            return new XmlNode(name, xmlTags, content, childs);
        }
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addTag(String key, String value) {
        xmlTags.add(key, value);
    }

    public void addChild(XmlNode child) {
        this.childs.add(child);
    }

    public String exportToString() {
        return exportToStringIndented(0);
    }

    protected String exportToStringIndented(int whiteSpaceCount) {
        StringBuilder sb = new StringBuilder();

        if(childs.isEmpty() && content.isEmpty()) {
            sb.append(orphanNodeString(whiteSpaceCount));
        } else {
            sb.append(openNodeString(whiteSpaceCount));
            if(!content.isBlank()) sb.append(getWhiteSpaces(whiteSpaceCount)).append(content).append("\n");
            for (XmlNode child : childs) {
                sb.append(child.exportToStringIndented(whiteSpaceCount + 2));
            }
            sb.append(closeNodeString(whiteSpaceCount));
        }
        return sb.toString();
    }

    private String openNodeString(int whiteSpaceCount) {
        return getWhiteSpaces(whiteSpaceCount) + "<" + name + xmlTags.toString() + ">\n";
    }

    private String closeNodeString(int whiteSpaceCount) {
        return getWhiteSpaces(whiteSpaceCount) + "</" + name + ">\n";
    }

    private String orphanNodeString(int whiteSpaceCount) {
        return getWhiteSpaces(whiteSpaceCount) + "<" + name + xmlTags.toString() + "/>\n";
    }

    private String getWhiteSpaces(int whiteSpaceCount) {
        return " ".repeat(Math.max(0, whiteSpaceCount));
    }
}
