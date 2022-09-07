//
//  Lab: Binary and Hex Numbers.cpp
//  Lab: Binary and Hex Numbers
//
//  Created by junming jin on 9/6/22.
//

#include "Lab: Binary and Hex Numbers.hpp"
#include <iostream>
#include <string>

using namespace std;
 
// function to convert decimal to binary
void decToBinary(int n)
{
    // array to store binary number
    int binaryNum[32];
 
    // counter for binary array
    int i = 0;
    while (n > 0) {
 
        // storing remainder in binary array
        binaryNum[i] = n % 2;
        n = n / 2;
        i++;
    }
 
    // printing binary array in reverse order
    for (int j = i - 1; j >= 0; j--)
        cout << binaryNum[j];
}
 
// Driver program to test above function


void decToHexadecimal(int n)
{
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

 
  for (j = i - 1; j >= 0; j--)
  {
    if (hex[j] > 9)
      cout<<(char)(hex[j] + 55)<<"\n";
    else
      cout<<hex[j];
  }
}
void HexToBin(string hexdec)
{
    long int i = 0;
 
    while (hexdec[i]) {
 
        switch (hexdec[i]) {
        case '0':
            cout << "0000";
            break;
        case '1':
            cout << "0001";
            break;
        case '2':
            cout << "0010";
            break;
        case '3':
            cout << "0011";
            break;
        case '4':
            cout << "0100";
            break;
        case '5':
            cout << "0101";
            break;
        case '6':
            cout << "0110";
            break;
        case '7':
            cout << "0111";
            break;
        case '8':
            cout << "1000";
            break;
        case '9':
            cout << "1001";
            break;
        case 'A':
        case 'a':
            cout << "1010";
            break;
        case 'B':
        case 'b':
            cout << "1011";
            break;
        case 'C':
        case 'c':
            cout << "1100";
            break;
        case 'D':
        case 'd':
            cout << "1101";
            break;
        case 'E':
        case 'e':
            cout << "1110";
            break;
        case 'F':
        case 'f':
            cout << "1111";
            break;
        default:
            cout << "\nInvalid hexadecimal digit "
                 << hexdec[i];
        }
        i++;
    }
}

int hexadecimalToDecimalnum (char hexdeci)
{
    char hexDeci[20];
    int deci = 0, rem, i = 0, len = 0;
     
    cout << "Enter the Hexadecimal Number: ";
    cin >> hexDeci;
     
       //calculating the length of hexa entered
       while (hexDeci[i] != '\0')
       {
          len++;
          i++;
       }
     
       len--;
       i = 0;
     
       while (len >= 0)
       {
          rem = hexDeci[len];
     
          if (rem >= 48 && rem <= 57)
             rem = rem - 48;
          else if (rem >= 65 && rem <= 70)
             rem = rem - 55;
          else if (rem >= 97 && rem <= 102)
             rem = rem - 87;
        else
        {
             cout << "The entered hexa digit is invalid";
             return 0; //exit the program
        }
     
          deci += (rem* pow(16, i));
          len--;
          i++;
       }
     
       //Display
       cout << "Decimal Value: " << deci;
    return 0;
}

int binaryToDecimal(string n)
{
    string num = n;
    int dec_value = 0;
 
    // Initializing base value to 1, i.e 2^0
    int base = 1;
 
    int len = num.length();
    for (int i = len - 1; i >= 0; i--) {
        if (num[i] == '1')
            dec_value += base;
        base = base * 2;
    }
 
    return dec_value;
}

