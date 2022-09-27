//
//  main.cpp
//  Card new version
//
//  Created by junming jin on 8/31/22.
//

#include <iostream>
#include <vector>
#include <string>
using namespace std;
struct Card
{
    string suit;
    string rank;
};
vector<Card> create()
{

string suit[] ={"spades","hearts","diamonds","clubs"};
string rank[] = {"Ace","two","three","four","five","six","seven","eight","nine","ten","jake","queen","king"};


vector<Card>deck;
vector<Card>card;
    for(int i= 0 ; i < 4; i ++ )
    {
    for(int j = 0; j < 13; j++)
        {
        Card cards {suit[i],rank[j]};
        deck.push_back(card);
    }
        Card joker1 = {"Jacker1"," " };
        Card joker2 = {"Jacker2"," "};
        deck.push_back(joker1);
        deck.push_back(joker2);
}
    void printcard(Card card){
        
        cout <<;
        
    }

int main() {
    
    return 0;
}
