package knn.core;

import java.io.*;
import java.util.*;

public class Dataset {
    private String filename;
    private List<Instance> dataList;
    private boolean normalized;

    private List<String> attributeNames;

    public Dataset() {
        this.dataList = new ArrayList<>();
        this.normalized = false;
    }

    public void loadCSV(String filename) {
        attributeNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (isFirstLine) {
                    attributeNames.addAll(Arrays.asList(parts));
                    isFirstLine = false;
                    continue;
                }

                List<Float> attributes = new ArrayList<>();
                for (int i = 0; i < parts.length - 1; i++) {
                    attributes.add(Float.parseFloat(parts[i]));
                }
                String label = parts[parts.length - 1];
                Instance instance = new Instance(attributes, label);
                dataList.add(instance);
            }

            System.out.println("Dataset cargado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public List<Instance> getInstances() {
        return dataList;
    }

    public void addInstance(Instance inst) {
        dataList.add(inst);
    }

    public void saveCSV(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Instance inst : dataList) {
                List<Float> attrs = inst.getAttributes();
                for (Float f : attrs) {
                    bw.write(f + ",");
                }
                bw.write(inst.getLabel());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving CSV: " + e.getMessage());
        }
    }

    public void display() {
        if (attributeNames != null && !attributeNames.isEmpty()) {
            System.out.println(String.join(", ", attributeNames));
        }

        for (Instance instance : dataList) {
            System.out.println(instance);
        }
    }

    public boolean isNormalized() {
        return normalized;
    }

    public void setNormalized(boolean normalized) {
        this.normalized = normalized;
    }
}
