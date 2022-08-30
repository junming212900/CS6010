//
//  main.cpp
//  LabStructs
//
//  Created by junming jin on 8/30/22.
//
#include <vector>
#include <iostream>
#include <string>
using namespace std;

struct politician{ //in the struct
    string name ;
    string party;
    string statefederal;
};
vector<politician> Javacans(vector<politician> input) {
    vector<politician>Javacansparty;
    for ( int i=0; i < input.size(); i++){
        if (input[i].party == "Javacans"){
            Javacansparty.push_back(input[i]);
        }
    }
    return Javacansparty;
}
vector<politician> federalCplusers(vector<politician> input) {
    vector<politician>Javacansparty;
    for ( int i=0; i < input.size(); i++){
        if (input[i].party == "Cplusers"&& input[i].statefederal == "federal"){
            Javacansparty.push_back(input[i]);
        }
    }
    return Javacansparty;
}

using namespace std;
int main() {
    politician p1 = {"jay","Javacans","state"};
    politician p2 = {"Jon","Javacans","state"};
    politician p3 = {"Trump","Cplusers","state"};
    politician p4 = {"Coliton","Cplusers","federal"};
    politician p5 = {"Biden","Javacans","federal"};
    politician p6 = {"Reven","Cplusers","federal"};
    politician p7 = {"Howard","Cplusers","federal"};
    politician p8 = {"Wooden","Javacans","federal"};
    politician p9 = {"Xi","Cplusers","federal"};
    politician p10 = {"Li","Javacans","state"};
    politician p11 = {"Mao","Cplusers","state"};
    politician p12 = {"Lee","Cplusers","state"};
    vector<politician> x ={p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12};
    vector<politician> Javacans1 = Javacans(x);
    vector<politician> federalCplusers1 = federalCplusers(x);
    cout << "People who are in Javacan Party: \n";
    for ( int i=0 ;i<Javacans1.size();i++){
        
        cout<<Javacans1[i].name<<"\n";
        }
    cout << "People who is  federal Cplusers: \n";
    for ( int i = 0; i < federalCplusers1.size(); i++){
        cout << federalCplusers1[i].name<<"\n";
    }
    return 0;
}
