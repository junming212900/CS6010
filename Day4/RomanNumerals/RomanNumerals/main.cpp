//
//  main.cpp
//  RomanNumerals
//
//  Created by junming jin on 8/25/22.

#include <iostream>
using namespace std;
int main() {
    int x ;
    int piece ;
    string roman ;
    
    cout << " Enter decimal number:\n";
    cin >> x;
    
    if ((x>= 4000)||(x <= 0)){
        cout << "Decimal number out of Range\n";
    }
    else {
        if ( x >= 1000){
            piece = (x / 1000);
    // How Many number in 1000s.
            for (int i = 0; i < piece; i++){
    // print each numbers
                roman += "M";}
    // add "M"s in result with perious result

    x %= 1000;
    // number get off all 1000s
            }
    if (x >=100){
        piece= (x/100);
    // how many number in 100
        if (piece == 9){
    //specific number situation
    
            roman += "CM";
    // add "M"s in result with perious result
                        }
        else if(piece >= 5){
    // when number is greater or equil to 5
            roman += "D";
            for (int i = 0; i < piece - 5; i++ ){
    // how many number are the greatr then 5
                    roman += "C";
    // keep adding C in the result.
                
                                                }
                            }
        else if (piece == 4){
                roman += "CD";
                }
        else if (piece >= 1){
                for (int i = 0; i < piece ; i++ )
                roman += "C";
            }
        x %= 100;
                }
    if (x >=10){
                piece= (x/10);
        if (piece == 9){
                    roman += "XC";
                        
                    }
        else if(piece >= 5){
                    roman += "L";
                    for (int i = 0; i < piece - 5; i++ ){
                        roman += "X";
                                    }
                    }
        else if (piece == 4){
                    roman += "XL";
                    }
        else if (piece >= 1){
                    for (int i = 0; i < piece ; i++ )
                    roman += "X";
                }
            x %= 10;
                    }
    if (x >= 1){
            
                piece = x ;
            
        if (piece == 9){
                    roman += "IX";
                        
                    }
            }
        else if( piece >= 5 ){
                    roman += "V" ;
                    
                    for (int i = 0; i < piece - 5; i++ ){
                        roman += "I";
                                    }
                    }
        else if (piece == 4){
                    roman += "IV";
                    }
        else if (piece >= 1){
                    for (int i = 0; i < piece ; i++ ){
                    roman += "I";
                }
                }
                    
            }
        
    cout << " Roman numeral version:"<< roman <<"\n";
    
    return 0;
}
