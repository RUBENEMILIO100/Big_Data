// Assessment 1/Practice 1 // Diaz Martinez Ruben Emilio # 15210791
                           // Flores Acosta Alfreso # 152103
//1. Develop an algorithm in scala that calculates the radius of a circle

val c = 6

var radius = c/(2*3.1416)


2. Develop an algorithm in scala that tells me if a number is a cousin
def Esprimo(i :Int) : Boolean = {
    if (i <= 1)
    false
    else if (i==2)
    true
    else
    !(2 to (i-1)).exists(x=> i % x==0)
}



//3. Given the variable bird = "tweet", use string interpolation to
// print "I am writing a tweet"

var bird = "tweet"
println ("Im writen a  " + bird)



//4. Given the variable message = "Hi Luke, I'm your father!" use slilce to extract the
// sequence "Luke"

var variable = "Hello Luke i am your father!"
variable.slice(5,9)

//5. What is the difference in value and a variable in scala?
// Value (val) is assigned a value and can no longer be changed
// Variable (var) the assigned value can be changed

// 6. Given the tuple ((2,4,5), (1,2,3), (3,114,23))) return the number 3.1416
var my_tup = (2,4,5,1,2,3,3.1416,23)
my_tup._7
