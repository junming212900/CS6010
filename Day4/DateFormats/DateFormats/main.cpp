//
//  main.cpp
//  DateFormats
//
//  Created by group of Jinyi Zhou & Jo song & junming jin on 8/25/22.
//

#include <iostream>
#include <string>

int main(int argc, const char * argv[]) {
    
    // insert code here...
    // create variables
    std::string date;
    std::string day_year;
    std::string month; // position: 0-1
    std::string day; // position: 3-4
    std::string year; // position: 6-907004
    std::string s_month;
    
    // ask the user to enter a date
    std::cout << "Please enter a date (mm/dd/yyyy):\n";
    std::cin >> date;
    
    // find month
    for (int i = 0; i < date.find('/'); i++){ //
      month += date.substr(i,1); //因为是loop 这里是一个一个数字得出的 最后组成两数字（其实这里可以不用loop和find）
    }
    // find day
    day_year = date.substr((date.find('/')+1),7);// (date.rfind(‘/’)+1)
    
    for (int x = 0; x < day_year.find('/'); x++){
      day += day_year.substr(x,1);
    }
    
    // find year
    year = day_year.substr((day_year.find('/')+1),4);
    
    // convert date string to integers
    int i_month = std::stoi(month);
    int i_day = std::stoi(day);
    int i_year = std::stoi(year);
    
    // determine invalid conditions
    if (i_month < 1 or i_month >12 or i_day < 1 or i_day > 31 or i_year < 1000 or i_year >9999){
      std::cout << "Invalid date.\n";
    }
    // print out valid results
    else if (i_month == 1){
      s_month = "January";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 2){
      s_month = "February";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 3){
      s_month = "March";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 4){
      s_month = "April";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 5){
      s_month = "May";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 6){
      s_month = "June";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 7){
      s_month = "July";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 8){
      s_month = "August";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 9){
      s_month = "September";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 10){
      s_month = "October";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 11){
      s_month = "November";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    else if (i_month == 12){
      s_month = "December";
      std::cout << s_month << " " << day << ", " << year << std::endl;
    }
    return 0;
}
