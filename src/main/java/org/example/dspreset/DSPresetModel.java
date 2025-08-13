package org.example.dspreset;

import org.example.dspreset.components.buses.Buses;
import org.example.dspreset.components.effects.Effects;
import org.example.dspreset.components.groups.Groups;
import org.example.dspreset.components.midi.Midi;
import org.example.dspreset.components.modulators.Modulators;
import org.example.dspreset.components.noteSequences.NoteSequences;
import org.example.dspreset.components.tags.Tags;
import org.example.dspreset.components.ui.UI;

public class DSPresetModel {
    public String minVersion;
    public UI ui;
    public Groups groups;
    public Effects effects;
    public Midi midi;
    public NoteSequences noteSequences;
    public Modulators modulators;
    public Tags tags;
    public Buses buses;

    private DSPresetModel(String minVersion, UI ui, Groups groups, Effects effects, Midi midi, NoteSequences noteSequences, Modulators modulators, Tags tags, Buses buses) {
        this.minVersion = minVersion;
        this.ui = ui;
        this.groups = groups;
        this.effects = effects;
        this.midi = midi;
        this.noteSequences = noteSequences;
        this.modulators = modulators;
        this.tags = tags;
        this.buses = buses;
    }

    public static class Builder {
        private String minVersion;
        private UI ui;
        private Groups groups;
        private Effects effects;
        private Midi midi;
        private NoteSequences noteSequences;
        private Modulators modulators;
        private Tags tags;
        private Buses buses;

        public Builder() {
        }

        public Builder minVersion(String minVersion) {
            this.minVersion = minVersion;
            return this;
        }
        public Builder ui(UI ui) {
            this.ui = ui;
            return this;
        }
        public Builder groups(Groups groups) {
            this.groups = groups;
            return this;
        }
        public Builder effects(Effects effects) {
            this.effects = effects;
            return this;
        }
        public Builder midi(Midi midi) {
            this.midi = midi;
            return this;
        }
        public Builder noteSequences(NoteSequences noteSequences) {
            this.noteSequences = noteSequences;
            return this;
        }
        public Builder modulators(Modulators modulators) {
            this.modulators = modulators;
            return this;
        }
        public Builder tags(Tags tags) {
            this.tags = tags;
            return this;
        }
        public Builder buses(Buses buses) {
            this.buses = buses;
            return this;
        }

        public DSPresetModel build() {
            if(minVersion == null) minVersion = "1.0.0";
            if(groups == null) throw new IllegalStateException("groups must not be null");
            return new DSPresetModel(minVersion, ui, groups, effects, midi, noteSequences, modulators, tags, buses);
        }
    }
}