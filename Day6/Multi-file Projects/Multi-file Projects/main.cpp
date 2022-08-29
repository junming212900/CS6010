//
//  main.cpp
//  String Analyzer
//
//  Created by junming jin on 8/27/22.
//

#include <iostream>
#include <string>
#include <cmath>
//#include "LetterHelpers.hpp"
#include "computinghelper.hpp"
using namespace std;
int main() {
    string s;
    cout<<"Enter a string containing one or more sentences:\n";
    getline(cin,s);

    while (s!="done"&&s!="Done"){
    
        int NOW = NumWords(s);
        int NOS = NumSentences(s);
        int NOV = NumVowels(s);
        int NOC = NumConsonants(s);
        double AOW = AverageWordLength(s);
        double AOV = AverageVowelsPerWord(s);
        cout<< "Analysis:\n";
        cout<< "Number of words:"<<NOW<<"\n";
        cout<< "Number of sentences:"<<NOS<<"\n";
        cout<< "Number of vowels:"<<NOV<<"\n";
        cout<< "Number of consonants:"<<NOC<<"\n";
        cout<< "Reading level (average word length):"<< AOW<<"\n";
        cout<< "Average vowels per word:"<<AOV<<"\n";
        cout<<"Enter a string containing one or more sentences:\n";
        getline(cin,s);
    }
    
    cout <<"good bye\n";
    
    
    return 0;
}
