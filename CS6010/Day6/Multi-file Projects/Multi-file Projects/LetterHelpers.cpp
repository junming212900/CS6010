//
//  LetterHelpers.cpp
//  Multi-file Projects
//
//  Created by junming jin on 8/29/22.
//

#include <string>
#include <cmath>
#include "LetterHelpers.hpp"
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

