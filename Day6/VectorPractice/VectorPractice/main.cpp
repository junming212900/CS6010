//
//  main.cpp
//  VectorPractice
//
//  Created by junming jin on 8/29/22.
//

#include <iostream>
#include <vector>


using namespace std;
                    

int sum(vector<int> myvector){
    int x=0 ;
    for ( int i = 0 ; i<myvector.size();i++){
        x += myvector[i];
}
    return x;
    
}
/////////////

vector<char> stringToVec(string x){
    vector<char> myvector;
    for ( int i = 0; i < x.length();i++ ){
        myvector.push_back(x[i]);
    }
    return myvector;
}
////////////
vector<int> reverse(vector<int> x){
    vector<int> myvector;
    for (int i = x.size()-1; i>=0; i--){
        myvector.push_back(x[i]);
    }
    return myvector;
}

int main() {
vector<int> myvector;
    for(int i =0;i<4;i++)
    {
        int x;
        cout<<"enter a value";
        cin >> x;
        myvector.push_back(x);
    }
//
//    int result = sum(myvector);
//    ----------------------------
//    cout<< result ;
//    string x;
//    cin >> x;
//
//    vector<char> myvector = stringToVec(x);
//    for ( char i : myvector)// line 46-49 to the way to cout the result.
//    {
//        cout<<i<<"\n";
//    }
//    -------------------------------
    vector<int>myvector2 = reverse(myvector);
    for ( int i : myvector2)
     {
         cout<<i<<"\n";
        }
   
    return 0;
    
    // vector[number] = number2
    // vector[num.size()-1] = 200 (change the last element)
    // vector<int> inserttovector(int pos, int value,vector<int> input)
    // {if ( input.size()-1 < pos ){
    //input[pos]= value;}
    
//    for ( int = input.size(); i < input.size(); i++){
//        input[i+1]= input[i];} // left to right create
//    for ( int i = input.size(); i > pos; i--){
//        input[i]= input[i-1]; // right to left
    
//    }
}

// make a vector chars
vector<char>mychars(5,a);
vector<string>mychars(5,aha);// five aha in the vector.
// can we add to s tring
sring dummy = "blash";
for(char c: mychars){// ex1
    dummy+= c;
}
dummy = dummy + mychars[0];//ex2



