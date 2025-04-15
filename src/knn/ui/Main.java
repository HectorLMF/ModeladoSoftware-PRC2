package knn.ui;

import knn.core.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dataset ds = new Dataset();

        // Leer dataset
        ds.loadCSV("iris.csv");

        // Mostrar contenido
        ds.display();

        // Agregar instancia dummy
        List<Float> attrs = Arrays.asList(5.0f, 3.2f, 1.2f, 0.2f);
        ds.addInstance(new Instance(attrs, "Iris-setosa"));

        // Guardar nuevo archivo
        ds.saveCSV("iris_modified.csv");
    }
}
