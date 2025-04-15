package knn.core;

import java.util.List;

public class Instance {
    private List<Float> attributes;
    private String label;

    public Instance(List<Float> attributes, String label) {
        this.attributes = attributes;
        this.label = label;
    }

    public List<Float> getAttributes() {
        return attributes;
    }

    public String getLabel() {
        return label;
    }

    public void setAttributes(List<Float> attributes) {
        this.attributes = attributes;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Attributes: " + attributes + ", Label: " + label;
    }
}