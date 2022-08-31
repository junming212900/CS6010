//
//  main.cpp
//  Cards
//
//  Created by junming jin on 8/30/22.
//
#include <vector>
#include <string>
#include <iostream>
#include <map>
#include <algorithm>
#include <ctime>
using std::vector;
using std::string;
using namespace std;

enum Suit{spades,hearts,diamonds,clubs};
enum Rank{one,two,three,four,five,six,seven,eight,nine,ten,jake,queen,king};

struct Card
    {
    Rank rank;
    Suit suit;
    int num_suits = 4;
    int num_ranks = 13;
    };

struct Deck
    {
    vector<Card> cards;
    string card_back;
    int max_deck_size = 52;
    };

void initialize(Deck&);
void initialize(Deck& deck);
{
    Card card;
    for (int suit = 0; suit< card.num_suits; suit++)
    {
        for (int rank = 0 ;rank < card.num_ranks; rank ++)
        {
            card.suit = Suit(suit);
            card.rank = Rank(rank);
            deck.cards.push_back(card);
        }
    }

}
void print_deck(const Deck& deck)
{
    for (Card c : deck.cards)
    {
        cout << card(c);
    }
}
void print_card(const Card& card)
{
    std ::cout<< "Rank = "<< card.rank << " " <<"Suit"<< card.suit << "\n";
}

int main() {
    
{
    Deck my_deck;
    initialize(my_deck);
    print_deck(my_deck);

    
    void print_deck(const Deck&);
    void print_card(const Card&);
    return 0;
}

//vector<card> card(string input,string input2){
////    string suit[] ={"spades","hearts","diamonds","clubs"};
//    string rank[] = {"one","two","three","four","five","six","seven","eight","nine","ten","jake","queen","king"};
//
//    cout << card.push_back("","Joker1");
//    cout << card.push_back("","Joker2");
//    vector<card>cards;
//
//    for(int i= 0 ; i < 4; i ++ ){
//    for(int j = 0; j < 13; j++){
//        cards.push_back(suit[i],rank[j]);
//}
