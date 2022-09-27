//
//  main.cpp
//  Lab: Binary and Hex Numbers
//
//  Created by junming jin on 9/6/22.
//
#include "Lab: Binary and Hex Numbers.hpp"
#include <iostream>
#include <string>
#include<string.h>
#include<math.h>

using namespace std;

int main()
{
//    cout << " Enter a decimal numbers to binary and hexadecimal:\n";
//    int n;
//    cin >> n;
//
//    cout << "Binary number :";
//    decToBinary(n);
//    cout << "\n" ;
//
//    cout<<" The hexadecimal value: ";
//    decToHexadecimal(n);
//    cout << "\n" ;
//    cout << " Get the Hexadecimal number:\n";
//    string h;
//    cin >> h;
////
//    cout << "\nEquivalent Binary value is : ";
//    HexToBin(h);
//    cout << "\n" ;
//    char g;
//    hexadecimalToDecimalnum (g);
//    cout << "\n" ;
//    cout << "enter a dinary number : \n";
//    string n;
//    cin >> n;
//   cout << "covert dinary to decimal :\n"<<binaryToDecimal(n);
//    cout << "\n" ;
   
      int hex[1000];
      int i = 1, j = 0, rem, dec = 0, binaryNumber;
        cin>> binaryNumber;
      while (binaryNumber > 0)
      {
        rem = binaryNumber % 2;
        dec = dec + rem * i;
        i = i * 2;
        binaryNumber = binaryNumber / 10;
      }
        i = 0;
      while (dec != 0)
      {
        hex[i] = dec % 16;
        dec = dec / 16;
        i++;
      }

      cout<<" The hexadecimal value: ";
      for (j = i - 1; j >= 0; j--)
      {
        if (hex[j] > 9)
          cout<<(char)(hex[j] + 55)<<"\n";
        else
          cout<<hex[j];
      }
    cout << "\n" ;
      return 0;
    }

