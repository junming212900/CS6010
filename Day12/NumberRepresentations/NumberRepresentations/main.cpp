//
//  main.cpp
//  NumberRepresentations
//
//  Created by junming jin on 9/7/22.
//

#include <iostream>
#include <cstdint>
#include <cmath>
#include <fstream>
using namespace std;
void loadCharacters(std::string s) {
  std::ifstream fin(s);
  char c;
  while (fin >> c) {
    std::cout << c << std::endl;
  }
}

bool approxEquals( double a, double b, double tolerance ){
    return (a - b < tolerance );
}
int main(int argc, const char * argv[]) {
    int a[] = { 7, 2, -56, 32, 1, 7, -2, 7 };
       cout << "size: " << sizeof( a ) << "\n";//
    cout << sizeof(char) << "\n";
    cout << sizeof(int8_t) << "\n";
    cout << sizeof(int16_t) << "\n";
    cout << sizeof(int64_t) << "\n";
    cout << sizeof(uint8_t) << "\n";
    cout << sizeof(uint16_t) << "\n";
    cout << sizeof(uint64_t) << "\n";
    
    cout << INT8_MAX <<"\n";
    cout << INT8_MIN <<"\n";
    cout << INT16_MAX <<"\n";
    cout << INT16_MIN <<"\n";
    cout << INT64_MAX <<"\n";
    cout << INT64_MIN <<"\n";
    cout << UINT8_MAX <<"\n";
    cout << 0xFF << "\n";
    cout << UINT16_MAX <<"\n";
    cout <<0xFFFF<<"\n";
    cout << UINT64_MAX <<"\n";
    cout <<0XFFFFFFFF<<"\n";
    cout << "Try adding 1 to the max-value variables: \n";
    cout << INT64_MAX <<"\n";
    cout << INT64_MAX+1 <<"\n";
    cout << "Try subtracting 1 from the min values: \n";
    cout << INT64_MIN <<"\n";
    cout << INT64_MIN-1 <<"\n";
 
    
    double fl = 0.1+0.2;
    assert( fl =0.3);

    if ( approxEquals(0.01, 0.001, 0.0001)){
    cout<< " they must be to be considered equal\n";

    }
    else{
    cout << " they are not  considered equal\n";
    }
    

  
    loadCharacters("UTF-8-demo.txt");
    
    return 0;
}
