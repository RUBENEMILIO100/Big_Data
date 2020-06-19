# Big_Data

                                           TECNOLÓGICO NACIONAL DE MÉXICO
                                          INSTITUTO TECNOLÓGICO DE TIJUANA

                                              SUBDIRECCIÓN ACADÉMICA
                                      DEPARTAMENTO DE SISTEMAS Y COMPUTACIÓN

                                                    SEMESTRE: 
                                                Enero - Junio 2020
                                                     CARRERA: 
                                Ing. Tecnologías de la Información y Comunicaciones

                                                     MATERIA:
                                                   Datos Masivos
                                          
                                                  UNIDAD A EVALUAR:
                                                      Unidad 1

                                         NOMBRE Y NÚMERO DE CONTROL DEL ALUMNO:
                                         Diaz Martinez Ruben Emilio #15210791
                                         Flores Acosta Alfredo #15210331
                                                NOMBRE DEL MAESTRO (A):
                                         Dr. Jose Christian Romero Hernandez










# Introduction

This document will show the comparison of Machine Learning algorithms where the results are shown so that they can be distinguished from each other, for that they will be tabulated for a better expression of them, therefore we can choose the most favorable result for this, aspects such as its speed and precision will be taken, for this we will use a DATASET called "BANK MARKETING DATA SET"

There they can provide us with the DATASET downloads and the Data Set Description to be able to extract the values that need to be extracted later. Having said that, we will start with the established points shown in the index on page 2 of this documentation.


# Theoretical framework of the algorithms

1.	SVM

Support Vector Machine ”(SVM) is a supervised machine learning algorithm that can be used for ranking or regression challenges. However, it is mainly used in classification problems.

In the SVM algorithm, we plot each data item as a point in n-dimensional space (where n is the number of entities it has) with the value of each entity as the value of a particular coordinate. Then, we performed the classification by finding the hyperplane that differentiated the two classes very well.

2.	Decision Three 

A tree has many analogies in real life, and it turns out that it has influenced a wide area of machine learning, covering both classification and regression. In decision analysis, a decision tree can be used to visually and explicitly represent decisions and decision making. As its name suggests, it uses a tree-shaped decision model. Although it is a commonly used tool in data mining to derive a strategy to achieve a particular goal, it is also widely used in machine learning, which will be the main focus of this article.

A decision tree is drawn upside down with its root at the top. In the image on the left, the bold text in black represents an internal condition / node, based on which the tree is divided into branches / edges. The end of the branch that is no longer divided is the decision / sheet, in this case, whether the passenger died or survived, represented as red and green text respectively

3. Logistic Regression 

Logistic regression is a predictive modeling algorithm that is used when variable Y is binary categorical. That is, it can only take two values such as 1 or 0. The objective is to determine a mathematical equation that can be used to predict the probability of event 1. Once the equation is established, it can be used to predict the Y when only Las X are known.

4. Multilayer Perceptron

The following article provides a summary of the Perceptron Learning Algorithm. What does the word Perceptron mean in the machine learning industry? Perceptron is an artificial neural network unit that performs calculations to better understand data. What is a neural network unit? A group of artificial neurons interconnected to each other through synaptic connections is known as a neural network.

What is an artificial neuron?

Considering the state of the world today and to solve the problems around us, we are trying to determine the solutions by understanding how nature works, this is also known as biomimetics. Similarly, to function as human brains, people develop artificial neurons that function similarly to biological neurons in a human. An artificial neuron is a complex mathematical function, which takes data and weights separately, fuses them, and passes them through the mathematical function to produce results.



# Implementation

In this process of comparing performance in each of the algorithms, the following software tools will be required to perform it. The use of them in Machine Learning algorithms will be explained.

V. Why the use of these tools (Scala - Spark)?

Why spark?

Since almost all personal computers today have lots of Gigabytes of RAM (and it is growing fast) and powerful CPUs and GPUs, many real world machine learning problems can be solved with a single computer and frameworks like Scikit Learn, without the need for a distributed system, that is, a group of many computers. Sometimes, however, the data grows and continues to grow. Who never heard the term "Big Data"? When it happens, a non-distributed / scalable solution can be solved for a short time, but then it will be necessary to review that solution and perhaps change it significantly

Why Scala?

Scala is a beautiful and beautifully designed programming language, with a solid scientific background from Professor Martin Odersky's research team at the Ecole Polytechnique Fédérale de Lausanne.

# SVM 

 We import libraries
```scala
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature. {IndexToString, StringIndexer, VectorIndexer, VectorAssembler}
``` 

We removed Warnig warnings / unnecessary errors

```scala
Logger.getLogger ("org"). SetLevel (Level.ERROR)
```

 We start our Spark session
```scala
val spark = SparkSession.builder (). getOrCreate ()
```

 Our DATASET is loaded into a DATAFRAME
```scala
val df = spark.read.option ("header", "true"). option ("inferSchema", "true"). option ("delimiter", ";"). format ("csv"). load (" bank-full.csv ")
```

 We will create the FEATURES
```scala
val assembler = new VectorAssembler (). setInputCols (Array ("balance", "day", "duration", "pdays", "previous")). setOutputCol ("features")
```
```scala
val features = assembler.transform (df)
```

```scala 
val labelIndexer = new StringIndexer (). setInputCol ("and"). setOutputCol ("label")
val dataIndexed = labelIndexer.fit (features) .transform (features)
```

```scala
val lsvc = new LinearSVC (). setMaxIter (10) .setRegParam (0.1)
```

 We will make an accuracy or adjustment of the model
```scala
val lsvcModel = lsvc.fit (dataIndexed)
```

 Print the Interception Coefficient
```scala
println (s "Coefficients: $ {lsvcModel.coefficients} Intercept: $ {lsvcModel.intercept}")
}
```

Finally we will run the SVM algorithm
```scala
svm ()
```

# ADT (Algorithm Decision Three)

We import libraries
```scala
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature. {IndexToString, StringIndexer, VectorIndexer, VectorAssembler}
```


 We remove the Warnings / possible erroes
```scala
Logger.getLogger ("org"). SetLevel (Level.ERROR)
```

 We start our session spark
```scala
val spark = SparkSession.builder (). getOrCreate ()
```

 We load our DATASET
```scala
val df = spark.read.option ("header", "true"). option ("inferSchema", "true"). option ("delimiter", ";"). format ("csv"). load (" bank-full.csv ")
```
```scala
val assembler = new VectorAssembler (). setInputCols (Array ("balance", "day", "duration", "pdays", "previous")). setOutputCol ("features")
val features = assembler.transform (df)
```

```scala
val labelIndexer0 = new StringIndexer (). setInputCol ("and"). setOutputCol ("label")
val dataIndexed = labelIndexer0.fit (features) .transform (features)
```
We create our indexedLabel
```scala
val labelIndexer = new StringIndexer (). setInputCol ("label"). setOutputCol ("indexedLabel"). fit (dataIndexed)
```

We will create an indexedFeatures with their respective categories
```scala
val featureIndexer = new VectorIndexer (). setInputCol ("features"). setOutputCol ("indexedFeatures"). setMaxCategories (4)
```
 We divide the data in an array into parts of 70% and 30%
```scala
val Array (trainingData, testData) = dataIndexed.randomSplit (Array (0.7, 0.3))
```

We train our algorithmic model
```scala
val dt = new DecisionTreeClassifier (). setLabelCol ("indexedLabel"). setFeaturesCol ("indexedFeatures")
```

Convert indexed labels back to original labels
```scala
val labelConverter = new IndexToString (). setInputCol ("prediction"). setOutputCol ("predictedLabel"). setLabels (labelIndexer.labels)

val pipeline = new Pipeline (). setStages (Array (labelIndexer, featureIndexer, dt, labelConverter))

val model = pipeline.fit (trainingData)
```

Predictions are made
```scala
val predictions = model.transform (testData)
```

Select the filters to be able to display
```scala
predictions.select ("predictedLabel", "label", "features"). show (10)
```

Test errors will be calculated
```scala
val evaluator = new MulticlassClassificationEvaluator (). setLabelCol ("indexedLabel"). setPredictionCol ("prediction"). setMetricName ("accuracy")
```
```scala
val accuracy = evaluator.evaluate (predictions)
println (s "Test Error = $ {(1.0 - accuracy)} \n")
```
```scala
val treeModel = model.stages (2) .asInstanceOf [DecisionTreeClassificationModel]
println (s "Learned classification tree model: \n\n $ {treeModel.toDebugString}")

}
```

DT algorithm is run
```scala
dtre ()
```

# Algorithm Linear Logistic regression


we import libraries to use from the logical regression algorithm
```scala
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature. {IndexToString, StringIndexer, VectorIndexer, VectorAssembler}
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.ml.Pipeline
```

Eliminate various warnings / unnecessary errors
```scala
Logger.getLogger ("org"). SetLevel (Level.ERROR)
```

We will start Spark session
```scala
val spark = SparkSession.builder (). getOrCreate ()
```

We stick our DATASET
```scala
val df = spark.read.option ("header", "true"). option ("inferSchema", "true"). option ("delimiter", ";"). format ("csv"). load (" bank-full.csv ")

val assembler = new VectorAssembler (). setInputCols (Array ("balance", "day", "duration", "pdays", "previous")). setOutputCol ("features")
```

```scala
val labelIndexer = new StringIndexer (). setInputCol ("and"). setOutputCol ("label")
val dataIndexed = labelIndexer.fit (df) .transform (df)
```

Divide the DATAe in an array into parts of 70% & 30%
```scala
val Array (training, test) = dataIndexed.randomSplit (Array (0.7, 0.3), seed = 12345)
```

 A new Logistic Regression will be created
```scala
val lr = new LogisticRegression ()
```

We will create a new pipeline
```scala
val pipeline = new Pipeline (). setStages (Array (assembler, lr))
```

Our Data model
```scala
val model = pipeline.fit (training)
```


Expected results
```scala
val results = model.transform (test)
```

Our predictions
```scala
val predictionAndLabels = results.select ($ "prediction", $ "label"). as [(Double, Double)]. rdd
```

Our metrics
```scala
val metrics = new MulticlassMetrics (predictionAndLabels)
```
 Confusion matrix and accuracy
 When we get the data, after cleaning the data,
 pre-processing and disputes, the first step we do is to feed it to an outstanding model and
 of course get results on the odds

```scala
println (metrics.confusionMatrix)
println (metrics.accuracy)
```


We run our Logistic Regression Algorithm
```scala
lore ()
```

# Algorithm Multilayer perceptron

we import libraries to use from the Multilayer Perceptron algorithm
```scala
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature. {IndexToString, StringIndexer, VectorIndexer, VectorAssembler}
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.linalg.Vectors
```

Eliminate various warnings / unnecessary errors
```scala
Logger.getLogger ("org"). SetLevel (Level.ERROR)
```

We start our session spark
```scala
val spark = SparkSession.builder (). getOrCreate ()
```

We load the DATASET
```scala
val df = spark.read.option ("header", "true"). option ("inferSchema", "true"). option ("delimiter", ";"). format ("csv"). load (" bank-full.csv ")

val assembler = new VectorAssembler (). setInputCols (Array ("balance", "day", "duration", "pdays", "previous")). setOutputCol ("features")
val features = assembler.transform (df)
```

```scala
val labelIndexer = new StringIndexer (). setInputCol ("and"). setOutputCol ("label")
val dataIndexed = labelIndexer.fit (features) .transform (features)
```


We divide the data into an array into parts of 70% and 30%
```scala
val split = dataIndexed.randomSplit (Array (0.7, 0.3), seed = 1234L)
val train = split (0)
val test = split (1)
```

We indicate the layers of the neural network that you want to implement in this dataset
5 Input Layers By Size Of Features, 2 Hidden Layers Of 3 Neurons and 4 Output
```scala
val layers = Array [Int] (5, 3, 3, 2)
```

We create the trainer with its parameters
```scala
val trainer = new MultilayerPerceptronClassifier (). setLayers (layers) .setBlockSize (128) .setSeed (1234L) .setMaxIter (100)
```

Model is trained
```scala
val model = trainer.fit (train)
```

Print the Accuracy Model of the Multilayer Perceptron Algorithm
```scala
val result = model.transform (test)
```

The predictions and the label (original)
```scala
val predictionAndLabels = result.select ("prediction", "label")
```

Model precision estimation runs
```scala
val evaluator = new MulticlassClassificationEvaluator (). setMetricName ("accuracy")
println (s "Accuracy test = $ {evaluator.evaluate (predictionAndLabels)}")

}
```

The algorithm is run
```scala
mlp ()
```


# Results

We will remember that for each algorithm a number of 10 iterations had to be performed to see the change in results in each of them, We will start with the first algorithm

1. Support Vector Machine (SVM)
For this algorithm, the results were as follows:
```scala
Coefficients: [- 2.125897501491213E, -0.13517227458849872,7.51402188801716E-4.2.70233375064008964E, 0.0111177544540215354] Intercep: -1.084924165339881
With an Accuracy of: 0.8881574025585397
```

2. Decision Tre

For this second algorithm, it is a little more complex due to the interactions that must be carried out with each of the nodes until reaching a result, this because your process is interpreted as a tree and each node refers to the tree leaves, making your process a little more exhausted

The results of this algorithm give us an error test of: 0.11107837360047146
As expected, he threw us the diagram of the tree, accommodating it depending on its Major> or <Minor value

3. Logistic Regression

This is the algorithm that we consider the correct one due to the response time and the accuracy of its prediction and with a small percentage of errors in its structural model for the final result.

When we get the data, after the data cleansing, pre-processing, and disputes, the first step we take is to feed an outstanding model and of course get results on the odds.

4. Multilayer Perceptron

Well this algorithm is a little more complex because it is a neural model, its response time is a little longer but it also performs well like the rest of the algorithms, its only disadvantage would be the wait for response.
```scala
Iteración SVM     TREE	   LR	     MLP
1	        0.881	 0.8942	 0.8901	 0.8827
2             0.881	 0.8990	 0.8706	 0.8827
3	        0.881	 0.8928	 0.8901	 0.8827
4	        0.881	 0.8920	 0.8991	 0.8827
5	        0.881	 0.8946	 0.8886	 0.8827
6	        0.881	 0.8956	 0.8954	 0.8827
7	        0.881	 0.8998	 0.8953	 0.8827
8	        0.881	 0.8953	 0.8954	 0.8827
9	        0.881	 0.8928	 0.8853	 0.8827
10	      0.881	 0.8944	 0.8994	 0.8827

Average	  0.881  0.8944	 0.8994	 0.8827
```



# Conclusions 

The performance of each of the algorithms are very good, but each algorithm is for a special case, if you are looking for a more accurate answer it is Logistic or the opposite case if you have a more complex model with a supervised structure it would be Multilayer, these algorithms Machine Learning is adapted depending on the need, since the perfect algorithm is the one that one considers. This is a wide range that Machine Learning has when projecting this type of performance on the various algorithms that were presented. In this case we opted for Logistic Regression, thanks to its performance, with a very fast response speed and the accuracy of its predictions.

# References

Portilla, J. (2019, 13 septiembre). Scala and Spark for Big Data and Machine Learning. Recuperado 17 de junio de 2020, de
 https://www.udemy.com/course/scala-and-spark-for-big-data-and-machine-learning/

Ray, S. (2020, 15 abril). Understanding Support Vector Machine(SVM) algorithm from examples (along with code). Recuperado 17 de junio de 2020, de https://www.analyticsvidhya.com/blog/2017/09/understaing-support-vector-machine-example-code/

https://towardsdatascience.com/decision-trees-in-machine-learning-641b9c4e8052+ 

Prabhakaran, S. (2018, 23 abril). Logistic Regression – A Complete Tutorial With Examples in R. Recuperado 17 de junio de 2020, de https://www.machinelearningplus.com/machine-learning/logistic-regression-tutorial-examples-r/+


