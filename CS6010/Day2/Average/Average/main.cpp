//
//  main.cpp
//  Average
//
//  Created by Yue Sun on 8/23/22.
//
//  
//  - Group:
//      - Sonia-96(Sun yue ): Part2
//      - Junming Jin: Part1. His folder is named VolumeConvert-Jin
//
//  This project is wrriten by Sonia-96

#include <iostream>
using namespace std;

// Calculate the average of 5 scores that the user inputs
int main() {
    int score1, score2, score3, score4, score5;
    cout << "Enter 5 assignment scores: \n";
    
    cin >> score1 >> score2 >> score3 >> score4 >> score5;
    float avg = (score1 + score2 + score3 + score4 + score5) / 5.0;
    cout << "Average: " << avg << endl;
    
    return 0;
}
