document.write(" Hello World") ;

myArray = ['hello', true, 2, 3.14, {'name': 'Jamin', 'GPA': 4.0}]; // array containing a string, a boolean, an int, a floating-point number, and an object.
document.write = (myArray);
function f(a, b) {
    return a + b;
}

let myFunction = function(a, b){
    return a + b;
}
console.log(f(1, 2)); // int & int, result is 3
console.log(f(2.2, 3.3)); // float & float, result is 5.5
console.log(f('hello', 'world')); // string & string, result is helloworld
console.log(f(1, 'hello')); // int & string, result is 1hello
console.log(f(1, 2.2)); // int & float, result is 3.2
console.log(f(2.2, 'world')); // float & string, result is 2.2world
