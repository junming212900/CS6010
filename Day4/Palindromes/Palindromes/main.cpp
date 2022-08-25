//
//  main.cpp
//  Palindromes
//
//  Created by Group of junming jin & Jo Song & Jinyi Zhou on 8/25/22.
//

#include <iostream>
using namespace std;
int main() {
    
     string Palindromes;
    cout << " Enter a word ";
    cin >> Palindromes;
    string revPalindromes;
    
    int i;
       
    for(i = Palindromes.length() - 1; i >= 0; i--)
        {
            revPalindromes +=Palindromes[i];//+= (逐个递增并向加) add i char one by one to make a word
        }
    
    
    if (Palindromes == revPalindromes){
        cout<<"\n"<< Palindromes<<"IS a Palindromes "<<"\n";}
    
else{
    cout <<"\n"<<Palindromes<<" Is not Palindromes "<<"\n";}
    
    
    return 0;
}
