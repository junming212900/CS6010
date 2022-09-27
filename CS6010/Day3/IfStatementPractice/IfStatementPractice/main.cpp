//
//  main.cpp
//  IfStatementPractice
//
//  Created by junming jin & Jo Song on 8/24/22.
//

#include <iostream>
using namespace std;
int main() {
    int age = -1;
    
    cout << "Part 1\nEnter your Age : \n";
    cin >> age  ;
    if( age> 18){
        cout<< "You can vote !\n";
    }
    if (age > 30){
        cout<< "You can run Senate!\n";
    }
        
    if (age> 80){
        cout<<" You are a greatest generation\n";
    }
    else  if ( age > 60){
        cout << "You are a baby boomers\n";
        
    }else  if ( age > 40){
        cout << "You are a generation X\n";
        
    }
    else  if ( age > 20){
        cout << "You are a millennial X\n";
    }
    else if ( age < 20){
        cout << "You are a iKid\n";
    }
   /* They're part of the "greatest generation" if they're older than 80,

    "baby boomers" if they're not in the greatest generation, but are older than 60,

    in "generation X" if they're older than 40,

    a "millennial" if they're older than 20, and an "iKid" if they're younger than that.*/
    
    
    
    char weekdayResponse  = 'y';
    char holidayResponse  = 'y';
    char ChildrenResponse = 'y'; // please '' for char 
    char dummy;
    cout << "Part2\nEnter whether or not it's a weekday (Y/N) : \nEnter whether or not it's a holiday.(Y/N) : \nEnter whether or not they have young children.(Y/N) :\n";
    cin >> weekdayResponse>>dummy>> holidayResponse>>dummy>>ChildrenResponse ;
    if ( weekdayResponse == 'y' && holidayResponse == 'y'&& ChildrenResponse == 'n'){
        cout << "You Can Sleep\n" ;}// if variable is char ,please use '=='
    else if  ( weekdayResponse == 'n' && holidayResponse == 'y'&& ChildrenResponse == 'n'){
        cout << "You Can Sleep\n" ; }
    else if  ( weekdayResponse == 'y' && holidayResponse == 'n'&& ChildrenResponse == 'n'){
        cout << "You Can't Sleep\n" ; }
    else if  ( weekdayResponse == 'y' && holidayResponse == 'n'&& ChildrenResponse == 'y'){
        cout << "You Can't Sleep\n" ; }
    else if  ( weekdayResponse == 'n' && holidayResponse == 'y'&& ChildrenResponse == 'y'){
        cout << "You Can't Sleep\n" ; }
    else if  ( weekdayResponse == 'y' && holidayResponse == 'n'&& ChildrenResponse == 'y'){
        cout << "You Can't Sleep\n" ; }
    else if  ( weekdayResponse == 'y' && holidayResponse == 'y'&& ChildrenResponse == 'y'){
        cout << "You Can't Sleep\n" ; }
    else if  ( weekdayResponse == 'n' && holidayResponse == 'n'&& ChildrenResponse == 'n'){
        cout << "You Can Sleep\n" ; }
    /* Prompt the user to enter whether or not it's a weekday (Y/N). Read in their response as a character.
     
     Prompt the user to enter whether or not it's a holiday.

     Prompt the user to enter whether or not they have young children.*/
    return 0 ;
}


