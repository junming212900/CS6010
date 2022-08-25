//
//  main.cpp
//  RomanNumerals
//
//  Created by junming jin on 8/25/22.
//

#include <iostream>
using namespace std;
int main() {
    int x = -1;
    string str;
    cout << " Enter decimal number:\n";
    cin >> x;
    string roman;
    if (x>= 1000){
        roman=x%1000;
        x 
        
        
        /*
         "M" if the remaining number is >= 1000

         "CM" if the remaining number is >= 900

         "D" if the remaining number is >= 500

         "CD" if the remaining number is >= 400

         "C" if the remaining number is >= 100

         "XC" if the remaining number is >= 90

         "L" if the remaining number is >= 50

         "XL" if the remaining number is >= 40

         "X" if the remaining number is >= 10

         "IX" if the remaining number is >= 9

         "V" if the remaining number is >= 5

         "IV" if the remaining number is >=4

         "I" if the remaining number is >= 1
         */
    }
    cout << " Roman numeral version:\n"<< str;
    return 0;
}
