USAGE : 

"a=[[1 1]]
a+%1 
a+a

" "tototest" "[[1 1]]"

1- program (WITH THIS FORMAT ( return line for each expr and at the end 2 returnline) 
	note that if you put nothing it will start a console (REPL like)
2- name of the class
3- as much as arguments you want, it describe as example the size of each matrix you want and use the data inside to show you an example result. 
you can call these args in your 1-program by calling them %1 %2,...


The main usage of this language is to compute operation on matrix (if you want to compute on array just declare matrixwith one line)
here what you can do : 
[[1 1][1 1]] 	it declare the following matrix under a random name (a random number in fact)
a				it declare a variable (only lowercase (a to z)) with an empty matrix (all variables are diplayed each time to manage easly your operation
a=[[1 2][3 4]]	it affect the variable previously declared to the following matrix
a*%1			it compute the operation a*%1(args1, but can be another variable or an annonymous matrix) and update the result in a matrix

all operation on matrix are recursive, that mean you can do a+b+c+.... 
BE CAREFUL if you use a variable twice in the same operation, as it store the result in the variable, take account of that
you can do : 
a=b+c but a minor bug can makes you loose b and c datas (a becomes a "read only" variable, you can read the result but you have to redefine it if you want to reuse it ("there will be 2 'a'(one with the result) in Env) 
by redifining, you'll clean env)

