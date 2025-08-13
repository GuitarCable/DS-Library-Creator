package org.example.dspreset.components.groups.group;

import org.example.dspreset.XmlProvider;
import org.example.dspreset.components.groups.group.sample.Sample;
import org.example.xml.XmlNode;

import java.util.ArrayList;

public class Group implements XmlProvider {
    private final ArrayList<Sample> samples;

    private Group(ArrayList<Sample> samples) {
        this.samples = samples;
    }

    public static class Builder {
        private ArrayList<Sample> samples;

        public Builder() {
        }

        public Builder samples(ArrayList<Sample> samples) {
            this.samples = samples;
            return this;
        }

        public Group build() {
            if(samples == null) throw new IllegalStateException("samples must not be null");
            return new Group(samples);
        }
    }

    @Override
    public XmlNode returnXml() {
        return new XmlNode.Builder("group")
                .childs(getChilds())
                .build();
    }

    private ArrayList<XmlNode> getChilds() {
        ArrayList<XmlNode> childs = new ArrayList<>();
        for(Sample sample : samples) {
            childs.add(sample.returnXml());
        }
        return childs;
    }
}
