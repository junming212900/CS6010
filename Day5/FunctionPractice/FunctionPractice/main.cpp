//
//  main.cpp
//  FunctionPractice
//
//  Created by junming jin on 8/26/22.
//

#include <iostream>
#include <cmath>

using namespace std;
// Part 2 -1 My own funcation-calculating the t
float Thirdsidelengthcalculater ( float side1 , float side2){
    
    return sqrt( pow(side1,2) + pow(side2,2) ); // return
}

double velocitycalculatercos(double speed, double angle){// if there is nothing return, change to void.
   return  speed*cos(angle);
       //return x;
    
}
double velocitycalculatersin(double speed, double angle){// if there is nothing return, change to void.
   return  speed*sin(angle);
       //return x;
    
}

// the reason why difficult to turn the speed/velocity task above into a function, becasue the function cannot return two result (according our current knowledage)

bool Capitaliedtester (string word ){
    char a = word[0];
    if(a=='A'||a=='B'||a=='C'||a=='D'||a=='E'||a=='F'||a=='G'||a=='H'||a=='I'||a=='J'||a=='K'||a=='L'||a=='M'||a=='N'||a=='O'||a=='P'||a=='Q'||a=='R'||a=='S'||a=='T'||a=='U'||a=='V'||a=='W'||a=='X'||a=='Y'||a=='Z'){
         return true;
    }
    else { return false;
        }
}

/////////////////////////////

string boolToString(bool Answer ){
    string boolAnswer = "False"; // default to False
    
    if (Answer == true){
    
        boolAnswer = "True";
    }
//    else {
//        boolAnswer = "fales";
//    }
    
    return boolAnswer;
    
    
}

bool isPrime(int Number){
    
    for (int i=2;i < Number; i++ ){
        
        if(Number%i==0){
            return false;
        }
    }
    
    return true;
}

int main() {
    
    float side1;
    float side2;
    cout << "Enter the two side length:\n";
    cin >> side1 >> side2;
    float side3p1= sqrt(side1*side1 + side2*side2);
    
    float side3p2 = Thirdsidelengthcalculater(side1, side2);
    cout << "the third side length  from Part 1: "<< side3p1 <<"\n"<<"the third side length  from Part 2: "<< side3p2<<"\n";

    double speed;
    double angle;
    cout << "Enter the two side length:\n";
    cin >> speed >> angle;
    
    double velocitysinp1 = speed*sin(angle);
    
    double velocitycosp1 = speed*cos(angle);
    
    double velocitysinp2 = velocitycalculatercos(speed, angle);
    
    double velocitycosp2 = velocitycalculatersin(speed, angle);
    
    cout << "the third velocity by sin is from Part 1: "<< velocitysinp1 <<"\n"<<"the third velocity by sin is from Part 2: "<< velocitysinp2<<"\n";
    cout << "the third velocity by cos is from Part 1: "<< velocitycosp1 <<"\n"<<"the third velocity by cos is from Part 2: "<< velocitycosp2<<"\n";
    
    
    
    std::time_t result = std::time(nullptr);// the codes works
    std::cout << std::asctime(std::localtime(&result))
              << result << " seconds since the Epoch\n";
    
    // Above code have content functions: time(), asctime(),localtime().
    
    string word;
    cout << "Enter a word:\n";
    cin >> word;

    bool Answer1 = Capitaliedtester(word);

    string Finalanswer = boolToString(Answer1);

    cout << "Is word has Capitalized ? :"<< Finalanswer<<"\n";
    
    int Number3;
    cout << "Enter a Number :";
    cin >> Number3;
    bool Prime = isPrime(Number3);
    string Finalanswerprime = boolToString(Prime);
    cout << "Is number is a Prime ? :"<< Finalanswerprime<<"\n";
    
    return 0;
    
}


