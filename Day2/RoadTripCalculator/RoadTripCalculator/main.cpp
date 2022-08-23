//
//  main.cpp
//  RoadTripCalculator
//
//  Created by junming jin on 8/23/22.
//
// CS 6010- fall 2022
// create by Junming

#include <iostream>

using namespace std;

int main(){
    
    int distance = -1;
//The driving distance, in (whole) miles
    int MPG  = -1;
//The vehicle's miles per gallon efficiency
//The cost of gas in dollars per gallon
    float PG  = -1;

    std::cout << " Enter distance ,MPG ,and Cost (On separate line) :" << endl;
                                                                                
    cin >> distance;
    cin >> MPG;
    cin >> PG;
                                                                                
    float Galloncost = distance/MPG;
    
    cout<<"You used"<< Galloncost << "gallons.\n";
                                                                                
    //The number of gallons used is the distance / miles per gallon
    float cost = Galloncost*PG;
                                                                                
    cout << "The cost was $"<< cost<<"\n";
    //The cost is the number of gallons * dollars per gallon
    return -1;
}
