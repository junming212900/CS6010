//
//  main.cpp
//  LabStructs
//
//  Created by junming jin on 8/30/22.
//
#include <vector>
#include <iostream>
#include <string>
using namespace std;
// 定义了一个新的变量，在struct 里可以自定义变量的内容。
struct politician{ //   起始 struct name { 内容 int ， string , double 都可以};
    string name ;
    string party;
    string statefederal;
};

vector<politician> Javacans(vector<politician> input) {    // vector<polictician>输出内容vector 的变量类型，javancans 是 名字 。（vector<politica>） 是 输入内容的变量类型。
    vector<politician>Javacansparty; // 定义了新的变量 Javacansparty.
    for ( int i=0; i < input.size(); i++){
        if (input[i].party == "Javacans"){// 在每一个 politician 里 找 Javacans.
            Javacansparty.push_back(input[i]);// 将符合的向量安插进 Javacansparty里
        }
    }
    return Javacansparty;// 得出新的向量 Javacansparty
}
vector<politician> federalCplusers(vector<politician> input) {
    vector<politician>Javacansparty;
    for ( int i=0; i < input.size(); i++){
        if (input[i].party == "Cplusers"&& input[i].statefederal == "federal"){
            Javacansparty.push_back(input[i]);
        }
    }
    return Javacansparty;
}

using namespace std;
int main() {
    politician p1 = {"jay","Javacans","state"};// 创造新的vectors p1 是名字
    politician p2 = {"Jon","Javacans","state"};
    politician p3 = {"Trump","Cplusers","state"};
    politician p4 = {"Coliton","Cplusers","federal"};
    politician p5 = {"Biden","Javacans","federal"};
    politician p6 = {"Reven","Cplusers","federal"};
    politician p7 = {"Howard","Cplusers","federal"};
    politician p8 = {"Wooden","Javacans","federal"};
    politician p9 = {"Xi","Cplusers","federal"};
    politician p10 = {"Li","Javacans","state"};
    politician p11 = {"Mao","Cplusers","state"};
    politician p12 = {"Lee","Cplusers","state"};
    vector<politician> x ={p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12};// 定义新的vector x 包含之前所有的向量 p1-p12
    vector<politician> Javacans1 = Javacans(x);// 定义新的向量 Javacans1 使用 公式 Javacans 到 x上。
    vector<politician> federalCplusers1 = federalCplusers(x);
    cout << "People who are in Javacan Party: \n";
    for ( int i=0 ;i<Javacans1.size();i++){
        
        cout<<Javacans1[i].name<<"\n"; // 逐个提取成安插向量中name的string。
        }
    cout << "People who is  federal Cplusers: \n";
    for ( int i = 0; i < federalCplusers1.size(); i++){
        cout << federalCplusers1[i].name<<"\n";
    }
    return 0;
}
