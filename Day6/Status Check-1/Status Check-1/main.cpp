//
//  main.cpp
//  Status Check-1
//
//  Created by junming jin on 8/29/22.
//

#include <iostream>
using namespace std;
int main() {
    int x;
   
    int sum = 0;
    
    for (int i = 0; i<=3 ; i++){
        
        cout << "Enter a number:\n";// to keep same info over and over in the loop
        cout << "Enter -99 to exit, keep number range between 1 to 10\n";
        cin >>x;
        if (x== -99 ){
            cout << "END\n";
            return 0;
        }
        else if (x>0&& x<10){ // keep x range and igorne the invalied numbers
            sum += x; // sum is adding x1 by x2.
          
        }
        
    }
    cout<< sum; // to cout the final sum
    return 0;
}
