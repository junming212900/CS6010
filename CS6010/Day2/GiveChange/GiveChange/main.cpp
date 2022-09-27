//
//  main.cpp
//  GiveChange
//
//  Created by junming jin on 8/23/22.
//

#include <iostream>
using namespace std;
int main() {
    // insert code here...
    std::cout << "Enter item price in cents:\n";
    float Price = -1;
    cin >> Price;
    std::cout << "Enter amount paid in cents:\n";
    float Amount =-1;
    cin >> Amount;
    float Changes = Amount - Price;
    
    cout<<"Changes :"<< Changes << "\n";
    
    int Quarters = Changes/25;
    cout<<"Quarters: "<< Quarters << "\n";
    int Dimes = (Changes - Quarters*25)/10;
    cout<<"Dimes: "<< Dimes << "\n";
    int Nickels = (Changes - (Quarters*25 + Dimes*10))/5 ;
    cout<<"Nickels: "<< Nickels << "\n";
    int Pennies =(Changes - (Quarters*25 + Dimes*10 + Nickels*5))/1;
    cout<<"Pennies: "<< Pennies << "\n";
    /*Enter item price in cents:
    12
    Enter amount paid in cents:
    95
    Change = 83 cents
     Quarters: 3
     Dimes: 0
     Nickels: 1
     Pennies: 3*/
    return 0;
}
