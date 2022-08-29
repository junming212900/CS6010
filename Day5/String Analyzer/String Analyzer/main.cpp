//
//  main.cpp
//  String Analyzer
//
//  Created by junming jin on 8/27/22.
//

#include <iostream>
#include <string>
#include <cmath>
using namespace std;
bool IsTerminator(char c){
    
    if(c=='.'||c=='!'||c=='?'){
         return true;
    }
    else { return false;
        }
}
/////////////
bool IsPunctuation(char c){

    if(c=='.'||c=='!'||c=='?'||c==','){
     return true;
}
    else { return false;
    }
}
/////////////////
bool IsVowel(char c){
    if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'||c=='Y'){
     return true;
}
    else { return false;
    }
}

bool IsConsonant(char c){
    if(c!='a'&& c!='e'&&c!='i'&&c!='o'&&c!='u'&&c!='y'&&c!='A'&&c!='E'&&c!='I'&&c!='O'&&c!='U'&&c!='Y'&&c!='.'&& c!='!'&&c!='?'&&c!=','&&c!=' '){
        return true;
}
    else { return false;
    }
}
///////////

int NumWords(string sentence){
    int words = 0;
    for (int i = 0; i < sentence.length();i++ ){
        if (sentence[i] == ' '){
            words++;
        }
        
    }
    return words = words + 1 ;
}

int NumSentences(string s){
    int count = 0;
    for (int i = 0; i < s.length();i++ ){
        if (s[i] =='.'||s[i]=='!'||s[i]=='?'){
            count++;
        }
        
    }
    return count ;
}

int NumVowels(string s){
int count = 0;
for (int i = 0; i < s.length();i++ ){
    
    if ( IsVowel(s[i])){
        count++;
        }
    }
        return count;
}


int NumConsonants(string s){
int count = 0;
for (int i = 0; i < s.length();i++ ){
    
    if ( IsConsonant(s[i])){
        count++;
        }
    }
        return count;
}

//}

double AverageWordLength(string s){
    double NOW = NumWords(s);
    double  AverageW;
    double Numofchars = s.length();
    for (unsigned int i = 0;i< s.length();i++){
        
        if (s.at(i) == ' '||IsPunctuation(s[i])){
            Numofchars--;
        }
        
    }
    return AverageW = Numofchars/ NOW ;
}

double AverageVowelsPerWord(string s){
    double  NOV = NumVowels(s);
    double NOW = NumWords(s);
    return NOV/NOW;
}

int main() {
   
    cout<<"Enter a string containing one or more sentences:\n";
    string s;
    getline(cin,s);
//    while (s!="done"||s!="Done"){
//        if (s =="done"||s=="Done"){
//            cout <<"good bye\n";
//        }
//        else {
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
    
    
    
    return 0;
}
