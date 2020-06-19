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

// We import libraries

import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature. {IndexToString, StringIndexer, VectorIndexer, VectorAssembler}

// We removed Warnig warnings / unnecessary errors
Logger.getLogger ("org"). SetLevel (Level.ERROR)

// We start our Spark session
val spark = SparkSession.builder (). getOrCreate ()

// Our DATASET is loaded into a DATAFRAME
val df = spark.read.option ("header", "true"). option ("inferSchema", "true"). option ("delimiter", ";"). format ("csv"). load (" bank-full.csv ")

// We will create the FEATURES
val assembler = new VectorAssembler (). setInputCols (Array ("balance", "day", "duration", "pdays", "previous")). setOutputCol ("features")
val features = assembler.transform (df)

 
val labelIndexer = new StringIndexer (). setInputCol ("and"). setOutputCol ("label")
val dataIndexed = labelIndexer.fit (features) .transform (features)


val lsvc = new LinearSVC (). setMaxIter (10) .setRegParam (0.1)

// We will make an accuracy or adjustment of the model
val lsvcModel = lsvc.fit (dataIndexed)

println ("\ nLinear Support Vector Machine Algorithm \ n")

// Print the Interception Coefficient
println (s "Coefficients: $ {lsvcModel.coefficients} Intercept: $ {lsvcModel.intercept}")


}

// Finally we will run the SVM algorithm
svm ()
# Results
# Conclusions 
# References


