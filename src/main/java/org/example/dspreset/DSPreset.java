package org.example.dspreset;

import org.example.xml.XmlNode;
import org.example.xml.XmlTags;

import java.util.ArrayList;

public class DSPreset {
    String name = "DecentSampler";
    DSPresetModel model;

    public DSPreset(DSPresetModel model) {
        this.model = model;
    }

    public String exportPresetToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

        XmlNode xmlNode = new XmlNode.Builder(name)
                .xmlTags(getXmlTags())
                .childs(getChilds())
                .build();



        sb.append(xmlNode.exportToString());
        return sb.toString();
    }

    public XmlTags getXmlTags() {
        XmlTags xmlTags = new XmlTags();
        xmlTags.add("minVersion", model.minVersion);
        return xmlTags;
    }

    public ArrayList<XmlNode> getChilds() {
        ArrayList<XmlNode> childs = new ArrayList<>();

        if(model.ui != null) childs.add(model.ui.returnXml());
        if(model.groups == null) throw new IllegalArgumentException("Missing groups module");
        childs.add(model.groups.returnXml());
//        if(model.effects != null) childs.add(model.effects.returnXml());
//        if(model.midi != null) childs.add(model.midi.returnXml());
//        if(model.noteSequences != null) childs.add(model.noteSequences.returnXml());
//        if(model.modulators != null) childs.add(model.modulators.returnXml());
//        if(model.tags != null) childs.add(model.tags.returnXml());
//        if(model.buses != null) childs.add(model.buses.returnXml());
        return childs;
    }
}
