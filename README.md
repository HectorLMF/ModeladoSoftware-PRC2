# 🧠 Sistema de Clasificación KNN (K-Nearest Neighbours)

Este proyecto implementa un sistema de clasificación utilizando el algoritmo `k-NN` (k vecinos más cercanos). Está desarrollado en Java y permite cargar un dataset desde un archivo `.csv`, normalizar los datos, clasificar nuevas instancias y guardar resultados modificados.


---

## 📦 Clases y Funcionalidad

### 🔹 `Dataset` (paquete `knn.core`)
Representa el conjunto de datos cargado desde un fichero `.csv`.

- **Atributos:**
  - `List<Instance> instances` → Lista de instancias cargadas.
  - `List<String> attributeNames` → Nombres de los atributos (cabecera CSV).

- **Métodos:**
  - `void loadCSV(String filename)` → Carga un dataset desde un archivo CSV.
  - `void saveCSV(String filename)` → Guarda el dataset en un nuevo archivo.
  - `void addInstance(Instance instance)` → Agrega una nueva instancia.
  - `void normalize()` → Normaliza todos los atributos numéricos entre 0 y 1.
  - `void display()` → Muestra en consola el dataset cargado.

---

### 🔹 `Instance` (paquete `knn.core`)
Representa un caso o fila del dataset.

- **Atributos:**
  - `List<Float> attributes` → Lista de atributos numéricos.
  - `String label` → Clase o categoría a la que pertenece la instancia.

- **Métodos:**
  - `float distanceTo(Instance other, DistanceMetric metric)` → Calcula la distancia a otra instancia usando una métrica.

---

### 🔹 `KNNClassifier` (paquete `knn.core`)
Implementa el algoritmo k-NN.

- **Atributos:**
  - `Dataset trainingSet` → Conjunto de entrenamiento.
  - `int k` → Número de vecinos más cercanos a considerar.
  - `DistanceMetric distanceMetric` → Métrica usada para calcular distancias.

- **Métodos:**
  - `String classify(Instance newInstance)` → Devuelve la clase más frecuente entre los `k` vecinos más cercanos.

---

### 🔹 `DistanceMetric` (paquete `knn.distances`)
Interfaz funcional que permite definir diferentes métricas de distancia entre instancias.

- **Método:**
  - `float compute(Instance a, Instance b)` → Calcula la distancia entre dos instancias.

---

### 🔹 `EuclideanDistance` (paquete `knn.distances`)
Implementa la métrica de distancia euclídea.

- **Implementa:** `DistanceMetric`
- **Método:**
  - `float compute(Instance a, Instance b)`

---

### 🔹 `CSVHandler` (paquete `knn.io`)
Clase utilitaria para manejo de ficheros CSV. (Opcional si se separa de `Dataset`)

- **Métodos posibles:**
  - `static List<Instance> read(String path)`
  - `static void write(List<Instance> data, String path)`

---

### 🔹 `Main` (paquete `knn.ui`)
Clase principal que ejecuta el flujo básico del programa.

- **Métodos:**
  - `main(String[] args)` → Prueba de carga de dataset, visualización, modificación y guardado.

---

## 🧪 Dataset de Pruebas

Se utiliza el dataset clásico **Iris** (`iris.csv`), que contiene 150 instancias de tres especies de flores (`Iris-setosa`, `Iris-versicolor`, `Iris-virginica`) con los siguientes atributos:

- `sepal length`
- `sepal width`
- `petal length`
- `petal width`
- `class` (etiqueta)

---

## ▶️ Ejecución de Prueba

```java
Dataset ds = new Dataset();
ds.loadCSV("iris.csv");
ds.display();

List<Float> attrs = Arrays.asList(5.0f, 3.2f, 1.2f, 0.2f);
ds.addInstance(new Instance(attrs, "Iris-setosa"));
ds.saveCSV("iris_modified.csv");
