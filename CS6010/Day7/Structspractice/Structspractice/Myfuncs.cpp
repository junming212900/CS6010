//
//  Myfuncs.cpp
//  Structspractice
//
//  Created by junming jin on 8/30/22.
//
#include <iostream>
#include "Myfuncs.hpp"
int main( int argc, char *agrv[]){
    car honda;
    honda.carType.make = "Honda";
    honda.carType.model = "Civic";
    honda.carType.Year = "2022";
    honda.color = "red"
    honda.trim.hastrim = false
    honda.mileage = CalculateFuelEfficiency( honda,120);
    
    cout<<"Car details: \n";
    cout<<"Car make: "<<honda.carType.model<<"\n";
    cout<<"Car Model: "<<honda.carType.make <<"\n";
    cout<<"Year :"<<honda.carType.Year <<"\n";
    
    honda.doorNum.push_back(5);
    Car camry{{"Toyata","Camry",2022}}
    return 0;
}
