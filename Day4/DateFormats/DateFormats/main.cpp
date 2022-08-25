//
//  main.cpp
//  DateFormats
//
//  Created by junming jin on 8/25/22.
//

#include <iostream>
using namespace std;
int main() {
    cout <<"Enter a date:\n";
    string day;
    string mouth;
    string year;
    cin >> mouth >>day >>year;
    string date = mouth+day+year;
    
    
    cout << date;
    return 0;
}

/*
 Enter a date:
 1/1/1999
 January 1, 1999
 Enter a date:
 12/20/2017
 December 20, 2017
 Enter a date:
 15/20/2017
 Invalid date
 */
