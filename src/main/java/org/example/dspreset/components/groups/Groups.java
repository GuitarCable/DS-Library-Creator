package org.example.dspreset.components.groups;

import org.example.dspreset.XmlProvider;
import org.example.dspreset.components.groups.group.Group;
import org.example.xml.XmlNode;

import java.util.ArrayList;

public class Groups implements XmlProvider {
    private final ArrayList<Group> groups;

    private Groups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public static class Builder {
        private ArrayList<Group> groups;

        public Builder() {}

        public Builder groups(ArrayList<Group> groups) {
            this.groups = groups;
            return this;
        }

        public Groups build() {
            if(groups == null) throw new IllegalStateException("groups must not be null");
            return new Groups(groups);
        }
    }

    public void add(Group group) {
        groups.add(group);
    }

    @Override
    public XmlNode returnXml() {
        return new XmlNode.Builder("groups")
                .xmlTags(null)
                .childs(getChilds())
                .build();
    }

    private ArrayList<XmlNode> getChilds() {
        ArrayList<XmlNode> childs = new ArrayList<>();
        for(Group group : groups) {
            childs.add(group.returnXml());
        }
        return childs;
    }
}
