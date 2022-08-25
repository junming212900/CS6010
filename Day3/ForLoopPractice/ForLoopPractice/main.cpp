//
//  main.cpp
//  ForLoopPractice
//
//  Created by junming jin on 8/24/22.
//

#include <iostream>
using namespace std;
int main() {
    //Part 1
    //For loop
    cout << " Result from Forloop:";
    for (int x=1 ;x<=10;x=x+1){
        cout << x<< "," ;
    }
    cout << "\n";
    cout << " Result from Whileloop:";
    // while Loop
    int x = 1;
    while(x<=10){
        cout << x <<",";
        x=x+1;
    }
    cout << "\n";
    
    //Part 2
    cout <<" Enter first Number :";
    int number = -1;
    cin >> number ;
    cout <<" Enter first Number2 :";
    int number2 = -1;
    cin >> number2;
    cout << " Result from Part 2 :";
    if (number2 > number){
        for (x = number;x<= number2; x=x+1 ){
            cout << " "<< x ;
        }
    }
    // Part 3
    cout << "\n";
    cout << " Result from Part 3:";
    int x3 = -1;
    for (x3=1; x3 <=20 ; x3+=2){
        cout << x3<<",";
    }
     
   // Part 4
    cout << "\n";
    int PN = 0;
    int AN = 0;
    cout << " enter positive numbers to add up :\n";
    cin >> PN;
    while (PN > 0){
        AN = AN + PN;
        cin >> PN;
        
        
    } ;
    cout << "Result from Part 4:";
    cout << AN <<"\n";
    cout << "\n";
    
    // Part 5
    cout << "Result from Part 5:\n";
    for(int x2=1 ;x2<=5; x2++){
        cout << x2 << "x*: " ;
        for(int x3=1;x3<=5;x3++){
            cout << x2*x3<<" ";
        
        }
        cout <<endl;
    }
       
 

    return 0;
      
}
