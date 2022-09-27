//
//  main.cpp
//  BookAnalyzer
//
//  Created by Junming Jin on 9/1/22.
//

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

string findTitle(vector<string> words) { // set up the string in check in the vector
    string title; // create string variable  "title"
    int start, end;// create the two variable "start" and "end "
    for (int i = 0; i < words.size(); i++) {
        if (words[i] == "Title:") { // scan the file to one by one to find the word"title";
            start = i; // find the location of the first index  the "title" = start
            break;
        }
    }
    for (int i = 0; i < words.size(); i++) {
        if (words[i] == "Author:") { //scan the file to one by one to find the word"Author ";
            end = i; // find the location last index   = end
            break;
        }
    }
    for (int i = start + 1; i < end; i++) {
        title += words[i];
        title += " "; // print out the title name from start to end
    }
    return title;
}

string findAuthor(vector<string> words) { // same above
    string title;
    int start, end;
    for (int i = 0; i < words.size(); i++) {
        if (words[i] == "Author:") {
            start = i;
            break;
        }
    }
    for (int i = 0; i < words.size(); i++) {
        if (words[i] == "Illustrator:") {
            end = i;
            break;
        }
    }
    for (int i = start + 1; i < end; i++) {
        title += words[i];
        title += " ";
    }
    return title;
}

string findReleaseDate(vector<string> words) { // same above
    string title;
    int start, end;
    for (int i = 0; i < words.size(); i++) {
        if (words[i] == "Date:") {
            start = i;
            break;
        }
    }
    for (int i = 0; i < words.size(); i++) {
        if (words[i] == "[eBook") {
            end = i;
            break;
        }
    }
    for (int i = start + 1; i < end; i++) {
        title += words[i];
        title += " ";
    }
    return title;
}

int totalChar(vector<string> words) { // calculat the total word
    int sum = 0;
    for (auto word : words) {
        sum += word.size();
    }
    return sum;
}

string shortestWord(vector<string> words) { // set up "a" shortest word and find out
    string shortest = "a";
    for (auto word : words) {// auto is automatily identify the type of the variable in the for loop
        if (word.size() <= shortest.size()) { //compare the shortest word to next word. if the next word is shorter than the current word then the current word will replacce the periously word.
            return word;
        }
    }
    return shortest;
}

string longestWord(vector<string> words) {
    string result;
    for (auto word : words) {
        if (word.size() >= result.size()) {// compare the longest word to next word. if the next word is longer than the current word then the current word will replacce the periously word.
            result = word;
        }
    }
    return result;
}

void keyWord(string keyword, vector<string> words) {// setting up to looking for the key ward int the vector which already create with words
    int appearedTimes = 0;// show how many times it has been appear in the file
    int totalChars = totalChar(words);// the total char in the file
    vector<int> appearedCharLocations;
    vector<int> appearedWordLocations;
    int appearedCharLocation = 0;
    for (int i = 0; i < words.size(); i++) {// for loop find out the number of keyward
        if (words[i] == keyword) {
            appearedTimes ++;
            appearedCharLocations.push_back(appearedCharLocation);// everytime keyward appear each time's number i will add to appearedcharlocation
            appearedWordLocations.push_back(i);//  everytime keyward appear number i will add to appearedwordlocation
        }
        appearedCharLocation += words[i].size();// each time keyword apprear in the entire char
    }
    if (appearedTimes == 0) {
        cout << "The word " << keyword << " does not appear in the book." << endl;
        return;
    } else if (appearedTimes == 1) {
        cout << "The word " << keyword << " appears 1 time " << endl;
    } else {
        cout << "The word " << keyword << " appears " << appearedTimes << " times" << endl;
    }
    for (int i = 0; i < appearedWordLocations.size(); i++) {
        if (appearedWordLocations[i] != 0 &&
            appearedWordLocations[i] != words.size() - 1) {
            cout << "at " << static_cast<float> (appearedWordLocations[i]) / static_cast<float> (totalChars) * static_cast<float>(100) << "%: " <<// use static_cast covert int to float.()
            words[appearedWordLocations[i] - 1] << " " << // show the one word before the key word
            words[appearedWordLocations[i]] << " " <<
            words[appearedWordLocations[i] + 1] << endl; // show the one word behind the key word
        } else if (appearedWordLocations[i] == 0) {
            cout << "at " << static_cast<float> (appearedWordLocations[i]) / static_cast<float> (totalChars) * static_cast<float>(100) << "%: " <<
            words[appearedWordLocations[i]] << " " <<
            words[appearedWordLocations[i] + 1] << " " << endl;
        } else if (appearedWordLocations[i] == words.size() - 1) {
            cout << "at " << static_cast<float> (appearedWordLocations[i]) / static_cast<float> (totalChars) * static_cast<float>(100) << "%: " <<
            words[appearedWordLocations[i] - 1] << " " <<
            words[appearedWordLocations[i]] << " " << endl;
        }
    }
    return;
}

int main(int argc, const char * argv[]) {
    string input = argv[1]; // inputting the file from command line
    ifstream fin(input);
    if (fin.fail()) {
        cout << "Failed to find the book!" << endl;
        return 0;
    }

    string word; // create the string "word "
    vector<string> allWords; // creat the vector "all words"
    while (fin >> word) {
        allWords.push_back(word);// push all word to vector allWords
    }

    string title = findTitle(allWords);
    string author = findAuthor(allWords);
    string releaseDate = findReleaseDate(allWords);

    int totalWords = allWords.size();
    int totalChars = totalChar(allWords);

    string shortest = shortestWord(allWords);

    cout << "title: " << title << endl;
    cout << "author: " << author << endl;
    cout << "release date: " << releaseDate << endl;
    cout << "total words: " << totalWords << endl;
    cout << "total characters: " << totalChars << endl;
    cout << "shortest word: " << shortest << endl;
    cout << "longest word: " << longestWord(allWords) << endl;
    
    keyWord(argv[2], allWords);
    
    return 0;
}
