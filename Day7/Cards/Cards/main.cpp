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

struct Card // struct a new type of card
    {
    Rank rank; // what is inside the card
    Suit suit;
    int num_suits = 4;
    int num_ranks = 13;
    };
struct Deck // struct a new type of deck
    {
    vector<Card> cards; // since i need vector have two element
//    string card_back;
    int max_deck_size = 52;
    };


void initialize(Deck& deck)
{

    Card card;
    for (int suit = 0; suit<= card.num_suits; suit++)
    {
        for (int rank = 0 ;rank <= card.num_ranks; rank ++) // double loop with rank and suit
        {
            card.suit = Suit(suit);
            card.rank = Rank(rank);
            deck.cards.push_back(card);//push 到 deck 里的vector “cards”里。 push 的是card 这个element。
        }
    }

}

void print_card(const Card& card) // print out single cards
{
    std ::cout<< "Rank  "<< card.rank << " " <<"Suit"<< card.suit << "\n";
}

void print_deck(const Deck& deck) // print out the deck
{
    for (Card c : deck.cards)
    {
        print_card(c);
    }
}


int main() {
    Deck my_deck; // create a new varibale name my_deck 
    initialize(my_deck);
    print_deck(my_deck);
    
 
    
    return 0;
}


