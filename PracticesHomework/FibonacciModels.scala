First Algorithm
In this first algorithm a function was added that after having performed,
the corresponding operations the function will give us a result (return)
this must be an integer value (Int)
def funcion (n: Int): Int = 
{   
// If the number entered in the function is less than 2, the number entered will be returned
 if (n<2)
    {
        return n
    }
// In any case, the function will do a series of sums, and the result returns
  else
    {
        return funcion(n-1) + funcion(n-2)
    }
}

funcion(9)
Second Algorithm
In this second algorithm a function was added that after having performed
the corresponding operations the function will give us a result (return)
this must be an integer value with decimal points (Double)
def funcion1(n: Double): Double =
{
// If the number entered in the function is less than 2, the number entered will be returned
  if (n<2)
   {
       return n
   }
// In any case, the following will be done
else
   {
// The mathematical formula is more extensive, but I decided to do it in small parts
// and then join it in the variable (j)
var p = ((1+(Math.sqrt(5)))/2)
       var a = Math.pow(p,n)
       var b = Math.pow((1-p),n)
       var c = Math.sqrt(5)
       var j = ((a-(b)))/(c)
// The result of (j) will be the result upon return (return)
   return(j)
   }

}
funcion1(9)
Third Algorithm
In this third algorithm a function was added that after having performed
the corresponding operations the function will give us a result (return)
this must be an integer value (Int)
def funcion2(n: Int): Int =
{
var a = 0
var b = 1
var c = 0

// A cycle (for) starts where k = 1, will start cycling until it becomes (n)
// (n) represents the value that will be entered into the function
 for (k <- 1 to n)
    {
// Depending on the cycle (for) the variables (c, a, b) will begin to change their result
// until the end of the cycle (for)
    c = b + a
        a = b
        b = c
    }
// The result will be returned with (return)
    return(a)
}
funcion2(9)
Fourth Algorithm
In this fourth quarter, a function is agreed upon after having performed
// the corresponding operations the function will give us a result (back)
// this must be an integer value (Int)
def funcion3(n: Int): Int =
{
    var a = 0
    var b = 1
 // A cycle (for) starts where k = 1, will start cycling until it becomes (n)
// (n) represents the value that will be entered into the function
for(k <- 1 to n)
        {

            b = b + a
            a = b - a
 // Depending on the cycle (for) the variables (b, a) will begin to change their result
// until the end of the cycle (for)
        }
// The result will be returned with (return)
       return(a)
}
funcion3(9)
// Fifth Algorithm
// In this fifth algorithm a function is performed that asks for an integer value (Int)
// then return an integer value with decimals (Double)
def funcion4(n: Int): Double =
{
// An array is created that starts from 0 to (n + 1)
    val vector = Array.range (0, n + 1)
// If the variable (n) is less than 2, that same variable is returned as a result
    if (n <2)
    {
        return (n)
    }
// Otherwise the vector with space (0) will have a value of zero (0)
// and the vector with space (1) will have a value of one (1)
    else
    {
        vector (0) = 0
        vector (1) = 1
// Start cycling with a for the vector
        for (k <- 2 to n)
        {
            vector (k) = vector (k-1) + vector (k-2)
        }
// The result will be the variable (n) according to the established vector
        return vector (n)
    }
}
function4 (9)