//
//  my_lib.cpp
//  Status Check 2
//
//  Created by junming jin on 9/7/22.
//

#include "my_lib.hpp"
#include <iostream>
#include <string>
using namespace std;
bool isavowel(char a){
    cout << "Enter a line of char : ";
    char c;
    
    cin >> c;
        for(int i = 0; line[i]!='\0'; ++i)
        {
            if(line[i]=='a' || line[i]=='e' || line[i]=='i' ||
               line[i]=='o' || line[i]=='u' || line[i]=='A' ||
               line[i]=='E' || line[i]=='I' || line[i]=='O' ||
               line[i]=='U')
            {
                ++vowels;
            }
            

