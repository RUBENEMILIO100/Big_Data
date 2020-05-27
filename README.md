# Big_Data Unit_2                                
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
                                                      Unidad 2

                                         NOMBRE Y NÚMERO DE CONTROL DEL ALUMNO:
                                         Diaz Martinez Ruben Emilio #15210791
                                         Flores Acosta Alfredo #15210331
                                                NOMBRE DEL MAESTRO (A):
                                         Dr. Jose Christian Romero Hernandez
                                    
# HOMEWORK # 1 Main types of machine learning algorithms.   



# PRACTICES.

# Practice1

1-Import LinearRegression
```scala
1- import org.apache.spark.ml.regression.LinearRegression
```
2. Optional: Use the following code to configure errors
```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```
3. Start a simple Spark Session
```scala
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
```
4. Use Spark for the Clean-Ecommerce csv file
```scala
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("Clean-Ecommerce.csv")
```
5. Print the schema on the DataFrame
```scala
data.printSchema
```
6. Print an example row from the DataFrame
```scala
data.head(1)
val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(0, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}
```
7. Transform the data frame so that it takes the form of ("label", "features")
```scala
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
```
8. Rename the Yearly Amount Spent column as "label"
```scala
val df = data.select(data("Yearly Amount Spent").as("label"), $"Avg Session Length", $"Time on App", $"Time on Website", $"Length of Membership", $"Yearly Amount Spent")
```
9. The VectorAssembler Object
```scala
val new_assembler = new VectorAssembler().setInputCols(Array("Avg Session Length", "Time on App", "Time on Website", "Length of Membership", "Yearly Amount Spent")).setOutputCol("features")
```
10. Use the assembler to transform our DataFrame to two columns: label and features
```scala
val output = new_assembler.transform(df).select($"label",$"features")
```

11. Create an object for line regression model
```scala
val lr = new LinearRegression()
```
12. Fit the model for the data and call this model lrModel
```scala
val lrModel = lr.fit(output)
```
13. Print the coefficients and intercept for the linear regression
```scala
println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")
```
14. Summarize the model on the training set and print the output of some metrics
```scala
val trainingSummary = lrModel.summary
```
15. Show the residuals values, the RMSE, the MSE, and also the R^2
```scala
trainingSummary.residuals.show()
val RMSE = trainingSummary.rootMeanSquaredError
val MSE = scala.math.pow(RMSE, 2.0)
val R2 = trainingSummary.r2
```

# Practice2

1 Import a SparkSession with the Logistic Regression library
```scala
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
LogisticRegression:
```
Optional: Use the Error reporting code
```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
log4j._:
Logger.getLogger("org").setLevel(Level.ERROR):
```
Create a Spark session
```scala
val spark = SparkSession.builder().getOrCreate()
```
Use Spark to read the csv Advertising file
```scala
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv")
```
Print the Schema of the DataFrame
```scala
data.printSchema()
```

2. Display the data
Print an example line
```scala
data.head(1)

val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(0, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}
head():
```

3. Prepare the DataFrame for Machine Learning
Create a new column called "Hour" of the Timestamp containing "Hour of the click"
```scala
val timedata = data.withColumn("Hour",hour(data("Timestamp")))
withColumn():
```

Rename the column "Clicked on Ad" to "label"
Take the following columns as features "Daily Time Spent on Site", "Age", "Area Income", "Daily Internet Usage", "Hour", "Male"

```scala
val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily Internet Usage", $"Hour", $"Male")
.select():
```
Import VectorAssembler and Vectors
```scala
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
VectorAssembler:
Vectors:
```
Create a new VectorAssembler object called assembler for the features
```scala
val assembler = (new VectorAssembler()
                  .setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male"))
                  .setOutputCol("features"))
.setInputCols:
.setOutputCol:
```

Use randomSplit to create train and test data divided by 70/30
```scala
val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)
.randomSplit():
seed:
```

4. Set up a Pipeline
mport Pipeline
```scala
import org.apache.spark.ml.Pipeline
Pipeline:
```

Create a new LogisticRegression object called lr
```scala
val lr = new LogisticRegression()
```
Create a new pipeline with the elements: assembler, lr
```scala
val pipeline = new Pipeline().setStages(Array(assembler, lr))
.setStages():
```

Adjust (fit) the pipeline for the training set
```scala
val model = pipeline.fit(training)
.fit():
```
Take the Results in the Test set with transform
```scala
val results = model.transform(test)
.transform():
```

5. Model evaluation
For Metrics and Evaluation import MulticlassMetrics
```scala
import org.apache.spark.mllib.evaluation.MulticlassMetrics
MulticlassMetrics:
```
Convert test results to RDD using .as and .rdd
```scala
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
.as():
.rdd:
```
Initialize a MulticlassMetrics object
```scala
val metrics = new MulticlassMetrics(predictionAndLabels)
```
Print the Confusion Matrix
```scala
println("Confusion matrix:")
println(metrics.confusionMatrix)
metrics:
confusionMatrix:
```

Print the model Accuracy value
```scala
metrics.accuracy
accuracy:
```

# Practice3

1. Import libraries.
```scala
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
```
2. Import a Spark Session.
```scala
import org.apache.spark.sql.SparkSession
```
3. Create a Spark session.
```scala
  def main(): Unit = {
    val spark = SparkSession.builder.appName("DecisionTreeClassificationExample").getOrCreate()
    ```
4. Load the data stored in LIBSVM format as a DataFrame.
```scala
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
```
5. Index labels, adding metadata to the label column.
```scala
Fit on whole dataset to include all labels in index.
    val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
    ```
6. Automatically identify categorical features, and index them.
```scala
Set maxCategories so features with > 4 distinct values are treated as continuous.
    val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
    ```
7. Split the data into training and test sets.
```scala
30% held out for testing.
    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
    ```
8. Train a DecisionTree model.
```scala
    val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")
    ```
9. Convert indexed labels back to original labels.
```scala
    val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
    ```
10. Chain indexers and tree in a Pipeline.
```scala
    val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
    ```
11. Train model.
```scala
This also runs the indexers.
    val model = pipeline.fit(trainingData)
    ```
12. Make predictions.
```scala
    val predictions = model.transform(testData)
    ```
13. Select example rows to display.
```scala
    predictions.select("predictedLabel", "label", "features").show(5)
    ```
14. Select (prediction, true label) and compute test error.
```scala
    val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
    val accuracy = evaluator.evaluate(predictions)
    println(s"Test Error = ${(1.0 - accuracy)}")
    ```
15. Print the tree obtained from the model.
```scala
    val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
    println(s"Learned classification tree model:\n ${treeModel.toDebugString}")

    spark.stop()
  }

main()
```
# Practice4

1. Import libraries.
```scala
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
```
2. Import a Spark Session.
```scala
import org.apache.spark.sql.SparkSession
```
3. Create a Spark session.
```scala
  def main(): Unit = {
    val spark = SparkSession.builder.appName("RandomForestClassifierExample").getOrCreate()
    ```
4. Load and parse the data file, converting it to a DataFrame.
```scala
    val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
    ```
5. Index labels, adding metadata to the label column.
```scala
Fit on whole dataset to include all labels in index.
    val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
    ```
6. Automatically identify categorical features, and index them.
```scala
Set maxCategories so features with > 4 distinct values are treated as continuous.
    val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
    ```
7. Split the data into training and test sets.
```scala
30% held out for testing.
    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
    ```
8. Train a RandomForest model.
```scala
    val rf = new RandomForestClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setNumTrees(10)
    ```
9. Convert indexed labels back to original labels.
```scala
    val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
    ```
10. Chain indexers and forest in a Pipeline.
```sscala
    val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))
     ```
11. Train model.
```scala
This also runs the indexers.
    val model = pipeline.fit(trainingData)
    ```
12. Make predictions.
```scala
    val predictions = model.transform(testData)
    ```
13. Select example rows to display.
```scala
    predictions.select("predictedLabel", "label", "features").show(5)
    ```
14. Select (prediction, true label) and compute test error.
```scala
    val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

    val accuracy = evaluator.evaluate(predictions)
    println(s"Test Error = ${(1.0 - accuracy)}")
    ```
15. Print the trees obtained from the model (10).
```scala
    val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]
    println(s"Learned classification forest model:\n ${rfModel.toDebugString}")

    spark.stop()
  }

main()
```









# 1. Linear Regression

In machine learning, we have a set of input variables (x) that are used to determine an output variable (y). A relationship exists between the input variables and the output variable. The goal of ML is to quantify this relationship.

Linear-Regression

Figure 1: Linear Regression is represented as a line in the form of y = a + bx. Source

<img class=" ls-is-cached lazyloaded" src="https://www.dataquest.io/wp-content/uploads/2018/04/Linear-Regression.gif" data-src="https://www.dataquest.io/wp-content/uploads/2018/04/Linear-Regression.gif" alt="Linear-Regression">

In Linear Regression, the relationship between the input variables (x) and output variable (y) is expressed as an equation of the form y = a + bx. Thus, the goal of linear regression is to find out the values of coefficients a and b. Here, a is the intercept and b is the slope of the line.

Figure 1 shows the plotted x and y values for a data set. The goal is to fit a line that is nearest to most of the points. This would reduce the distance (‘error’) between the y value of a data point and the line.

# 2. Logistic Regression

Linear regression predictions are continuous values (i.e., rainfall in cm), logistic regression predictions are discrete values (i.e., whether a student passed/failed) after applying a transformation function.

Logistic regression is best suited for binary classification: data sets where y = 0 or 1, where 1 denotes the default class. For example, in predicting whether an event will occur or not, there are only two possibilities: that it occurs (which we denote as 1) or that it does not (0). So if we were predicting whether a patient was sick, we would label sick patients using the value of 1 in our data set.

Logistic regression is named after the transformation function it uses, which is called the logistic function h(x)= 1/ (1 + ex). This forms an S-shaped curve.

In logistic regression, the output takes the form of probabilities of the default class (unlike linear regression, where the output is directly produced). As it is a probability, the output lies in the range of 0-1. So, for example, if we’re trying to predict whether patients are sick, we already know that sick patients are denoted as 1, so if our algorithm assigns the score of 0.98 to a patient, it thinks that patient is quite likely to be sick.

This output (y-value) is generated by log transforming the x-value, using the logistic function h(x)= 1/ (1 + e^ -x) . A threshold is then applied to force this probability into a binary classification.


                                      Logistic-Function-machine-learning

Figure 2: Logistic Regression to determine if a tumor is malignant or benign. Classified as malignant if the probability h(x)>= 0.5. Source

In Figure 2, to determine whether a tumor is malignant or not, the default variable is y = 1 (tumor = malignant). The x variable could be a measurement of the tumor, such as the size of the tumor. As shown in the figure, the logistic function transforms the x-value of the various instances of the data set, into the range of 0 to 1. If the probability crosses the threshold of 0.5 (shown by the horizontal line), the tumor is classified as malignant.

The logistic regression equation P(x) = e ^ (b0 +b1x) / (1 + e(b0 + b1x)) can be transformed into ln(p(x) / 1-p(x)) = b0 + b1x.

The goal of logistic regression is to use the training data to find the values of coefficients b0 and b1 such that it will minimize the error between the predicted outcome and the actual outcome. These coefficients are estimated using the technique of Maximum Likelihood Estimation.

# 3. CART

Classification and Regression Trees (CART) are one implementation of Decision Trees.

The non-terminal nodes of Classification and Regression Trees are the root node and the internal node. The terminal nodes are the leaf nodes. Each non-terminal node represents a single input variable (x) and a splitting point on that variable; the leaf nodes represent the output variable (y). The model is used as follows to make predictions: walk the splits of the tree to arrive at a leaf node and output the value present at the leaf node.

The decision tree in Figure 3 below classifies whether a person will buy a sports car or a minivan depending on their age and marital status. If the person is over 30 years and is not married, we walk the tree as follows : ‘over 30 years?’ -> yes -> ’married?’ -> no. Hence, the model outputs a sports car.

<img class=" ls-is-cached lazyloaded" src="https://www.dataquest.io/wp-content/uploads/2018/04/Decision-Tree-Diagram.jpeg" data-src="https://www.dataquest.io/wp-content/uploads/2018/04/Decision-Tree-Diagram.jpeg" alt="Decision-Tree-Diagram-machine-learning">

Decision-Tree-Diagram-machine-learning

Figure 3: Parts of a decision tree. Source

# 4. Naïve Bayes

To calculate the probability that an event will occur, given that another event has already occurred, we use Bayes’s Theorem. To calculate the probability of hypothesis(h) being true, given our prior knowledge(d), we use Bayes’s Theorem as follows:

P(h|d)= (P(d|h) P(h)) / P(d)

where:

    P(h|d) = Posterior probability. The probability of hypothesis h being true, given the data d, where P(h|d)= P(d1| h) P(d2| h)….P(dn| h) P(d)
    P(d|h) = Likelihood. The probability of data d given that the hypothesis h was true.
    P(h) = Class prior probability. The probability of hypothesis h being true (irrespective of the data)
    P(d) = Predictor prior probability. Probability of the data (irrespective of the hypothesis)

This algorithm is called ‘naive’ because it assumes that all the variables are independent of each other, which is a naive assumption to make in real-world examples.

Naive-Bayes

Figure 4: Using Naive Bayes to predict the status of ‘play’ using the variable ‘weather’.

Using Figure 4 as an example, what is the outcome if weather = ‘sunny’?

To determine the outcome play = ‘yes’ or ‘no’ given the value of variable weather = ‘sunny’, calculate P(yes|sunny) and P(no|sunny) and choose the outcome with higher probability.

->P(yes|sunny)= (P(sunny|yes) * P(yes)) / P(sunny) = (3/9 * 9/14 ) / (5/14) = 0.60

-> P(no|sunny)= (P(sunny|no) * P(no)) / P(sunny) = (2/5 * 5/14 ) / (5/14) = 0.40

Thus, if the weather = ‘sunny’, the outcome is play = ‘yes’.

# 5. KNN

The K-Nearest Neighbors algorithm uses the entire data set as the training set, rather than splitting the data set into a training set and test set.

When an outcome is required for a new data instance, the KNN algorithm goes through the entire data set to find the k-nearest instances to the new instance, or the k number of instances most similar to the new record, and then outputs the mean of the outcomes (for a regression problem) or the mode (most frequent class) for a classification problem. The value of k is user-specified.

The similarity between instances is calculated using measures such as Euclidean distance and Hamming distance.
Unsupervised learning algorithms

# 6. Apriori

The Apriori algorithm is used in a transactional database to mine frequent item sets and then generate association rules. It is popularly used in market basket analysis, where one checks for combinations of products that frequently co-occur in the database. In general, we write the association rule for ‘if a person purchases item X, then he purchases item Y’ as : X -> Y.

Example: if a person purchases milk and sugar, then she is likely to purchase coffee powder. This could be written in the form of an association rule as: {milk,sugar} -> coffee powder. Association rules are generated after crossing the threshold for support and confidence.

<img class=" ls-is-cached lazyloaded" src="https://www.dataquest.io/wp-content/uploads/2018/04/Formulae-for-support.png" data-src="https://www.dataquest.io/wp-content/uploads/2018/04/Formulae-for-support.png" alt="Formulae-for-support"> 

Formulae-for-support

Figure 5: Formulae for support, confidence and lift for the association rule X->Y.

The Support measure helps prune the number of candidate item sets to be considered during frequent item set generation. This support measure is guided by the Apriori principle. The Apriori principle states that if an itemset is frequent, then all of its subsets must also be frequent.

# 7. K-means

K-means is an iterative algorithm that groups similar data into clusters.It calculates the centroids of k clusters and assigns a data point to that cluster having least distance between its centroid and the data point.

<img class=" ls-is-cached lazyloaded" src="https://www.dataquest.io/wp-content/uploads/2018/04/k-means-algorithm.png" data-src="https://www.dataquest.io/wp-content/uploads/2018/04/k-means-algorithm.png" alt="k-means-algorithm">

k-means-algorithm

Figure 6: Steps of the K-means algorithm. Source

Here’s how it works:

We start by choosing a value of k. Here, let us say k = 3. Then, we randomly assign each data point to any of the 3 clusters. Compute cluster centroid for each of the clusters. The red, blue and green stars denote the centroids for each of the 3 clusters.

Next, reassign each point to the closest cluster centroid. In the figure above, the upper 5 points got assigned to the cluster with the blue centroid. Follow the same procedure to assign points to the clusters containing the red and green centroids.

Then, calculate centroids for the new clusters. The old centroids are gray stars; the new centroids are the red, green, and blue stars.

Finally, repeat steps 2-3 until there is no switching of points from one cluster to another. Once there is no switching for 2 consecutive steps, exit the K-means algorithm.

# 8. PCA

Principal Component Analysis (PCA) is used to make data easy to explore and visualize by reducing the number of variables. This is done by capturing the maximum variance in the data into a new coordinate system with axes called ‘principal components’.

Each component is a linear combination of the original variables and is orthogonal to one another. Orthogonality between components indicates that the correlation between these components is zero.

The first principal component captures the direction of the maximum variability in the data. The second principal component captures the remaining variance in the data but has variables uncorrelated with the first component. Similarly, all successive principal components (PC3, PC4 and so on) capture the remaining variance while being uncorrelated with the previous component.

PCA

Figure 7: The 3 original variables (genes) are reduced to 2 new variables termed principal components (PC’s). Source

Ensemble learning techniques:

Ensembling means combining the results of multiple learners (classifiers) for improved results, by voting or averaging. Voting is used during classification and averaging is used during regression. The idea is that ensembles of learners perform better than single learners.

There are 3 types of ensembling algorithms: Bagging, Boosting and Stacking. We are not going to cover ‘stacking’ here, but if you’d like a detailed explanation of it, here’s a solid introduction from Kaggle.

# 9. Bagging with Random Forests

The first step in bagging is to create multiple models with data sets created using the Bootstrap Sampling method. In Bootstrap Sampling, each generated training set is composed of random subsamples from the original data set.

Each of these training sets is of the same size as the original data set, but some records repeat multiple times and some records do not appear at all. Then, the entire original data set is used as the test set. Thus, if the size of the original data set is N, then the size of each generated training set is also N, with the number of unique records being about (2N/3); the size of the test set is also N.

The second step in bagging is to create multiple models by using the same algorithm on the different generated training sets.

This is where Random Forests enter into it. Unlike a decision tree, where each node is split on the best feature that minimizes error, in Random Forests, we choose a random selection of features for constructing the best split. The reason for randomness is: even with bagging, when decision trees choose the best feature to split on, they end up with similar structure and correlated predictions. But bagging after splitting on a random subset of features means less correlation among predictions from subtrees.

The number of features to be searched at each split point is specified as a parameter to the Random Forest algorithm.

Thus, in bagging with Random Forest, each tree is constructed using a random sample of records and each split is constructed using a random sample of predictors.

# 10. Boosting with AdaBoost

Adaboost stands for Adaptive Boosting. Bagging is a parallel ensemble because each model is built independently. On the other hand, boosting is a sequential ensemble where each model is built based on correcting the misclassifications of the previous model.

Bagging mostly involves ‘simple voting’, where each classifier votes to obtain a final outcome– one that is determined by the majority of the parallel models; boosting involves ‘weighted voting’, where each classifier votes to obtain a final outcome which is determined by the majority– but the sequential models were built by assigning greater weights to misclassified instances of the previous models.

# Homework # 2 Vectors & RMSE.   


# VectorAssembler Library

VectorAssembler is a transformer that combines a given list of columns into a single vector column. It is useful for combining raw features and features generated by different feature transformers into a single feature vector, in order to train ML models like logistic regression and decision trees. VectorAssembler accepts the following input column types: all numeric types, boolean type, and vector type. In each row, the values of the input columns will be concatenated into a vector in the specified order.
Examples

Assume that we have a DataFrame with the columns id, hour, mobile, userFeatures, and clicked:

 id | hour | mobile | userFeatures     | clicked
----|------|--------|------------------|---------
 0  | 18   | 1.0    | [0.0, 10.0, 0.5] | 1.0

userFeatures is a vector column that contains three user features. We want to combine hour, mobile, and userFeatures into a single feature vector called features and use it to predict clicked or not. If we set VectorAssembler’s input columns to hour, mobile, and userFeatures and output column to features, after transformation we should get the following DataFrame:

 id | hour | mobile | userFeatures     | clicked | features
----|------|--------|------------------|---------|-----------------------------
 0  | 18   | 1.0    | [0.0, 10.0, 0.5] | 1.0     | [18.0, 1.0, 0.0, 10.0, 0.5]


Vectors Library

Factory methods for org.apache.spark.ml.linalg.Vector. We don't use the name Vector because Scala imports scala.collection.immutable.Vector by default.


# What does RMSE really mean?

These errors, thought of as random variables, might have Gaussian distribution with mean μ and standard deviation σ, but any other distribution with a square-integrable PDF (probability density function) would also work. We want to think of ŷᵢ as an underlying physical quantity, such as the exact distance from Mars to the Sun at a particular point in time. Our observed quantity yᵢ would then be the distance from Mars to the Sun as we measure it, with some errors coming from mis-calibration of our telescopes and measurement noise from atmospheric interference.

# RMSE in Data Science: Subtleties of Using RMSE

In data science, RMSE has a double purpose:

    To serve as a heuristic for training models
    To evaluate trained models for usefulness / accuracy

This raises an important question: What does it mean for RMSE to be “small”?

We should note first and foremost that “small” will depend on our choice of units, and on the specific application we are hoping for. 100 inches is a big error in a building design, but 100 nanometers is not. On the other hand, 100 nanometers is a small error in fabricating an ice cube tray, but perhaps a big error in fabricating an integrated circuit.

For training models, it doesn’t really matter what units we are using, since all we care about during training is having a heuristic to help us decrease the error with each iteration. We care only about relative size of the error from one step to the next, not the absolute size of the error.

But in evaluating trained models in data science for usefulness / accuracy , we do care about units, because we aren’t just trying to see if we’re doing better than last time: we want to know if our model can actually help us solve a practical problem. The subtlety here is that evaluating whether RMSE is sufficiently small or not will depend on how accurate we need our model to be for our given application. There is never going to be a mathematical formula for this, because it depends on things like human intentions (“What are you intending to do with this model?”), risk aversion (“How much harm would be caused be if this model made a bad prediction?”), etc.

Besides units, there is another consideration too: “small” also needs to be measured relative to the type of model being used, the number of data points, and the history of training the model went through before you evaluated it for accuracy. At first this may sound counter-intuitive, but not when you remember the problem of over-fitting.

There is a risk of over-fitting whenever the number of parameters in your model is large relative to the number of data points you have. For example, if we are trying to predict one real quantity y as a function of another real quantity x, and our observations are (xᵢ, yᵢ) with x₁ < x₂ < x₃ … , a general interpolation theorem tells us there is some polynomial f(x) of degree at most n+1 with f(xᵢ) = yᵢ for i = 1, … , n. This means if we chose our model to be a degree n+1 polynomial, by tweaking the parameters of our model (the coefficients of the polynomial), we would be able to bring RMSE all the way down to 0. This is true regardless of what our y values are. In this case RMSE isn’t really telling us anything about the accuracy of our underlying model: we were guaranteed to be able to tweak parameters to get RMSE = 0 as measured measured on our existing data points regardless of whether there is any relationship between the two real quantities at all.

# References 

Extracting, transforming and selecting features - Spark 2.4.5 Documentation. (s. f.). Recuperado 3 de mayo de 2020, de https://spark.apache.org/docs/latest/ml-features.html#vectorassembler 


Moody, J. (2019, septiembre 5). What does RMSE really mean? Recuperado 3 de mayo de 2020, de https://towardsdatascience.com/what-does-rmse-really-mean-806b65f2e48e 



# Homework #3 Pipeline & Confusion 🍥 Matrix 😎

MLlib standardizes APIs for machine learning algorithms to make it easier to combine multiple algorithms into a single pipeline, or workflow. This section covers the key concepts introduced by the Pipelines API, where the pipeline concept is mostly inspired by the scikit-learn project.

    DataFrame: This ML API uses DataFrame from Spark SQL as an ML dataset, which can hold a variety of data types. E.g., a DataFrame could have different columns storing text, feature vectors, true labels, and predictions.

    Transformer: A Transformer is an algorithm which can transform one DataFrame into another DataFrame. E.g., an ML model is a Transformer which transforms a DataFrame with features into a DataFrame with predictions.

    Estimator: An Estimator is an algorithm which can be fit on a DataFrame to produce a Transformer. E.g., a learning algorithm is an Estimator which trains on a DataFrame and produces a model.

    Pipeline: A Pipeline chains multiple Transformers and Estimators together to specify an ML workflow.

    Parameter: All Transformers and Estimators now share a common API for specifying parameters.

# DataFrame

Machine learning can be applied to a wide variety of data types, such as vectors, text, images, and structured data. This API adopts the DataFrame from Spark SQL in order to support a variety of data types.

DataFrame supports many basic and structured types; see the Spark SQL datatype reference for a list of supported types. In addition to the types listed in the Spark SQL guide, DataFrame can use ML Vector types.

A DataFrame can be created either implicitly or explicitly from a regular RDD. See the code examples below and the Spark SQL programming guide for examples.

Columns in a DataFrame are named. The code examples below use names such as “text,” “features,” and “label.”
Pipeline components
Transformers

A Transformer is an abstraction that includes feature transformers and learned models. Technically, a Transformer implements a method transform(), which converts one DataFrame into another, generally by appending one or more columns. For example:

    A feature transformer might take a DataFrame, read a column (e.g., text), map it into a new column (e.g., feature vectors), and output a new DataFrame with the mapped column appended.
    A learning model might take a DataFrame, read the column containing feature vectors, predict the label for each feature vector, and output a new DataFrame with predicted labels appended as a column.

# Estimators

An Estimator abstracts the concept of a learning algorithm or any algorithm that fits or trains on data. Technically, an Estimator implements a method fit(), which accepts a DataFrame and produces a Model, which is a Transformer. For example, a learning algorithm such as LogisticRegression is an Estimator, and calling fit() trains a LogisticRegressionModel, which is a Model and hence a Transformer.
Properties of pipeline components

Transformer.transform()s and Estimator.fit()s are both stateless. In the future, stateful algorithms may be supported via alternative concepts.

Each instance of a Transformer or Estimator has a unique ID, which is useful in specifying parameters (discussed below).
Pipeline

In machine learning, it is common to run a sequence of algorithms to process and learn from data. E.g., a simple text document processing workflow might include several stages:

    Split each document’s text into words.
    Convert each document’s words into a numerical feature vector.
    Learn a prediction model using the feature vectors and labels.

MLlib represents such a workflow as a Pipeline, which consists of a sequence of PipelineStages (Transformers and Estimators) to be run in a specific order. We will use this simple workflow as a running example in this section.
How it works

A Pipeline is specified as a sequence of stages, and each stage is either a Transformer or an Estimator. These stages are run in order, and the input DataFrame is transformed as it passes through each stage. For Transformer stages, the transform() method is called on the DataFrame. For Estimator stages, the fit() method is called to produce a Transformer (which becomes part of the PipelineModel, or fitted Pipeline), and that Transformer’s transform() method is called on the DataFrame.

We illustrate this for the simple text document workflow. The figure below is for the training time usage of a Pipeline.

<img src="https://spark.apache.org/docs/latest/img/ml-Pipeline.png" title="ML Pipeline Example" alt="ML Pipeline Example" width="80%">

# ML Pipeline Example

Above, the top row represents a Pipeline with three stages. The first two (Tokenizer and HashingTF) are Transformers (blue), and the third (LogisticRegression) is an Estimator (red). The bottom row represents data flowing through the pipeline, where cylinders indicate DataFrames. The Pipeline.fit() method is called on the original DataFrame, which has raw text documents and labels. The Tokenizer.transform() method splits the raw text documents into words, adding a new column with words to the DataFrame. The HashingTF.transform() method converts the words column into feature vectors, adding a new column with those vectors to the DataFrame. Now, since LogisticRegression is an Estimator, the Pipeline first calls LogisticRegression.fit() to produce a LogisticRegressionModel. If the Pipeline had more Estimators, it would call the LogisticRegressionModel’s transform() method on the DataFrame before passing the DataFrame to the next stage.

A Pipeline is an Estimator. Thus, after a Pipeline’s fit() method runs, it produces a PipelineModel, which is a Transformer. This PipelineModel is used at test time; the figure below illustrates this usage.

<img src="https://camo.githubusercontent.com/92f8e764dfc76b266d3bf657407c6944d0f52727/68747470733a2f2f737061726b2e6170616368652e6f72672f646f63732f6c61746573742f696d672f6d6c2d506970656c696e654d6f64656c2e706e67" title="ML Pipeline Example" alt="ML Pipeline Example" width="80%">

# ML PipelineModel Example

In the figure above, the PipelineModel has the same number of stages as the original Pipeline, but all Estimators in the original Pipeline have become Transformers. When the PipelineModel’s transform() method is called on a test dataset, the data are passed through the fitted pipeline in order. Each stage’s transform() method updates the dataset and passes it to the next stage.

Pipelines and PipelineModels help to ensure that training and test data go through identical feature processing steps.

# Understanding Confusion Matrix 

 When we get the data, after data cleaning, pre-processing and wrangling, the first step we do is to feed it to an outstanding model and of course, get output in probabilities. But hold on! How in the hell can we measure the effectiveness of our model. Better the effectiveness, better the performance and that’s exactly what we want. And it is where the Confusion matrix comes into the limelight. Confusion Matrix is a performance measurement for machine learning classification.
 
 <img class="nv sp s t u gy ai hi" srcset="https://miro.medium.com/max/552/1*va6qO1E_MK9Yg8PaCghy3A.jpeg 276w, https://miro.medium.com/max/1104/1*va6qO1E_MK9Yg8PaCghy3A.jpeg 552w, https://miro.medium.com/max/1280/1*va6qO1E_MK9Yg8PaCghy3A.jpeg 640w, https://miro.medium.com/max/1400/1*va6qO1E_MK9Yg8PaCghy3A.jpeg 700w" sizes="700px" role="presentation" src="https://miro.medium.com/max/1280/1*va6qO1E_MK9Yg8PaCghy3A.jpeg" width="1280" height="720">
 
  <img src="https://3.bp.blogspot.com/-bVP5wzu5br4/TftMS5ty1BI/AAAAAAAAAJA/PIxhR7_wwNM/s1600/Matrix.gif" title="ML Pipeline Example" alt="ML Pipeline Example" width="23%"> 

This blog aims to answer following questions:

  1-  What the confusion matrix is and why you need it?
  2- How to calculate Confusion Matrix for a 2-class classification problem?

Today, let’s understand the confusion matrix once and for all.

What is Confusion Matrix and why you need it?

Well, it is a performance measurement for machine learning classification problem where output can be two or more classes. It is a table with 4 different combinations of predicted and actual values.


<img class="nv sp s t u gy ai hi" srcset="https://miro.medium.com/max/552/1*Z54JgbS4DUwWSknhDCvNTQ.png 276w, https://miro.medium.com/max/712/1*Z54JgbS4DUwWSknhDCvNTQ.png 356w" sizes="356px" role="presentation" src="https://miro.medium.com/max/356/1*Z54JgbS4DUwWSknhDCvNTQ.png" width="356" height="267">

It is extremely useful for measuring Recall, Precision, Specificity, Accuracy and most importantly AUC-ROC Curve.

Let’s understand TP, FP, FN, TN in terms of pregnancy analogy.

<img class="nv sp s t u gy ai hi" srcset="https://miro.medium.com/max/552/1*7EYylA6XlXSGBCF77j_rOA.png 276w, https://miro.medium.com/max/924/1*7EYylA6XlXSGBCF77j_rOA.png 462w" sizes="462px" role="presentation" src="https://miro.medium.com/max/462/1*7EYylA6XlXSGBCF77j_rOA.png" width="462" height="340">

True Positive:

Interpretation: You predicted positive and it’s true.

You predicted that a woman is pregnant and she actually is.

True Negative:

Interpretation: You predicted negative and it’s true.

You predicted that a man is not pregnant and he actually is not.

False Positive: (Type 1 Error)

Interpretation: You predicted positive and it’s false.

You predicted that a man is pregnant but he actually is not.

False Negative: (Type 2 Error)

Interpretation: You predicted negative and it’s false.

You predicted that a woman is not pregnant but she actually is.

Just Remember, We describe predicted values as Positive and Negative and actual values as True and False.

# References 

ML Pipelines - Spark 2.4.5 Documentation. (s. f.). Recuperado 4 de mayo de 2020, de https://spark.apache.org/docs/latest/ml-pipeline.html


Narkhede, S. (2019, mayo 9). Understanding Confusion Matrix. Recuperado 4 de mayo de 2020, de https://towardsdatascience.com/understanding-confusion-matrix-a9ad42dcfd62 

