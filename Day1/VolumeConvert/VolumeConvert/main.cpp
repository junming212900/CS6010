//
//  main.cpp
//  VolumeConvert
//
//  Created by junming jin on 8/23/22.
//

#include <iostream>
using namespace std;

int main() {
    // insert code here...
    std::cout << "Enter volume in ounces:\n";
    int Ounces = -1;
    cin >> Ounces;
    
    cout<<"Unit"<< Ounces << "\n";
    
    //Unit    '1 Ounce = x of these'
    //Ounces    1
    float Cups = Ounces/8.0;
    
    cout<<"Cups :"<< Cups << "\n";
    //Cups    1/8
    float Pints = Ounces/16.0;
    cout<<"Pints :"<< Pints << "\n";
    //Pints    1/16
    float Gallons = Ounces/128.0;
    cout<<"Gallons :"<< Gallons << "\n";
   
    //Gallons    1/128
    float Liters = Ounces*0.0296;
    cout<<"Liters :"<< Liters << "\n";
    
    //Liters    0.0296
    float CI = Ounces*1.9;
    cout<<"Cubic Inches :"<< CI << "\n";
    //Cubic Inches    1.8
    return 0;
}

