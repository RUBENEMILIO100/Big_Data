// Diaz Martinez Ruben Emilio #15210791
// Flores Acosta Alfredo # 15210331

// > > > > SVM < < < 

// Unit in scala es idéntico a void en Java, además
// Java ve la Unidad de Scala como anulada, y viceversa
def svm():Unit={
// Importamos librerias

import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer, VectorAssembler}

// Eliminamos los aviso de Warnig/errores inecesarios
Logger.getLogger("org").setLevel(Level.ERROR)

// Inciamos nuestra sesion de Spark
val spark = SparkSession.builder().getOrCreate()

// Se realiza la carga de nuestro DATASET en un DATAFRAME 
val df = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")

// Crearemos los FEATURES
val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features")
val features = assembler.transform(df)

 
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("label")
val dataIndexed = labelIndexer.fit(features).transform(features)


val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)

// Haremos un accuracy o ajuste del modelo
val lsvcModel = lsvc.fit(dataIndexed)

println("\nAlgoritmo Linear Support Vector Machine\n")

// Imprimimos El Coeficiente De Intercepcion
println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")


}

// Por ultimo correremos el algoritmo SVM
svm()


// ADT (Algorithm Decision Three)

def dtre():Unit={
// Importamos librerias
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer, VectorAssembler}

// Quitamos los Warnings/posibles erroes
Logger.getLogger("org").setLevel(Level.ERROR)

// Iniciamos nuestra sesion spark 
val spark = SparkSession.builder().getOrCreate()

// Cargamos nuestro DATASET
val df = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")

val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features")
val features = assembler.transform(df)


val labelIndexer0 = new StringIndexer().setInputCol("y").setOutputCol("label")
val dataIndexed = labelIndexer0.fit(features).transform(features)

// ADT (Algoritmo Desision Three)

// Creamos nuestro indexedLabel
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(dataIndexed)

// Crearemos un indexedFeatures con sus respectivas categorias
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4)

// Dividimos los datos en una matriz en partes de 70% y 30% 
val Array(trainingData, testData) = dataIndexed.randomSplit(Array(0.7, 0.3))

// Entrenamos nnuestro modelo algoritmico 
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

// Convert indexed labels back to original labels.
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)


val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))

val model = pipeline.fit(trainingData)

// Se hace las predicciones
val predictions = model.transform(testData)

// Selecccionar las filsa para poder desplegar
println("\nAlgoritmo Decision Three\n")

predictions.select("predictedLabel", "label", "features").show(10)

// Se calcularan los errores de prueba
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}\n")

val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
println(s"Learned classification tree model:\n\n ${treeModel.toDebugString}")

}

// Se corre el algoritmo DT
dtre()

// Algorithm Linear Logistic regression 

def lore():Unit={
//importamos Librerias A Utilizar Del Algortimo De Regresion Logica
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer, VectorAssembler}
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.ml.Pipeline

//Elimina varios avisos de warnings/errores inecesarios
Logger.getLogger("org").setLevel(Level.ERROR)

// Iniciaremos sesion Spark
val spark = SparkSession.builder().getOrCreate()

// Caragamos nuestro DATASET
val df = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")

val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features")


val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("label")
val dataIndexed = labelIndexer.fit(df).transform(df)

// Algoritmo LR

// Se divide el DATAe en un array en partes de 70% & 30%
val Array(training, test) = dataIndexed.randomSplit(Array(0.7, 0.3), seed = 12345)

// Se creara un nuevo  Logistic Regression
val lr = new LogisticRegression()

// Crearemos un nuevo pipeline
val pipeline = new Pipeline().setStages(Array(assembler,lr))

// Nuestro modelo del DATA
val model = pipeline.fit(training)

// Resultados esperados
val results = model.transform(test)

// Nuestras predicciones
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd

// Nuestas metricas >>>>
val metrics = new MulticlassMetrics(predictionAndLabels)

// Confusion matrix and accuracy
// Cuando obtenemos los datos, después de la limpieza de los datos, 
// el procesamiento previo y las disputas, el primer paso que hacemos es alimentarlo a un modelo sobresaliente y
// por supuesto, obtener resultados en las probabilidades

println("\nAlgorithm Logistic Regresion\n")
println("\nConfusion matrix:")
println(metrics.confusionMatrix)
println("\nAccuracy:")
println(metrics.accuracy)
}

// Corremos nuestro ALgoritmo de Regresion Logistica 
lore()


// Algorithm Multilayer perceptron 

def mlp():Unit={
//importamos Librerias A Utilizar Del Algortimo De Multilayer Perceptron
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer, VectorAssembler}
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.linalg.Vectors

//Elimina varios avisos de warnings/errores inecesarios
Logger.getLogger("org").setLevel(Level.ERROR)

// Iniciamos nuestra sesion spark
val spark = SparkSession.builder().getOrCreate()

// Hacemos la carga del DATASET
val df = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")

val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features")
val features = assembler.transform(df)


val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("label")
val dataIndexed = labelIndexer.fit(features).transform(features)


//Dividimos Los Datos En Un Arreglo En Partes De 70% y 30%
val split = dataIndexed.randomSplit(Array(0.7, 0.3), seed = 1234L)
val train = split(0)
val test = split(1)

//  Indicamos Las Capas De La Red Neuronal Que Deseas Implementar en Este Dataset
//  5 Capas De Entrada Por El Tamaño Del Features, 2 capas Ocultas De 3 Neuronas y 4 De Salida
val layers = Array[Int](5, 3, 3, 4)

// We create the trainer with its parameters
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

// Se entrena el modelo 
val model = trainer.fit(train)

// //Imprimimos El Modelo De Exactitud Del Algoritmo Multilayer Perceptron
val result = model.transform(test)

// Las predicciones y el label (original)
val predictionAndLabels = result.select("prediction", "label")
println("\nAlgorithm  Multilayer perceptron\n")

// Ejecuciones de estimación de precisión del modelo
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
println(s"Accuracy test = ${evaluator.evaluate(predictionAndLabels)}")

}

//Se corre el Algoritmo 
mlp()