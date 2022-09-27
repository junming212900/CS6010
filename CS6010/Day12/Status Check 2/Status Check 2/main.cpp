//
//  main.cpp
//  Status Check 2
//
//  Created by junming jin on 9/7/22.
//

#include <iostream>
#include <string>
using namespace std;


int main(int argc, const char * argv[]) {
////    part 2
////    %clang++ -c my_lib.cpp mani.cpp
////    %clang++ -o myProg my_lib.o main.o
////    part 3
////    What is the difference between: An array and a structures:
////
////    A structure creates a data type that can be used to group items of possibly different types into a single type. Array refers to a collection consisting of elements of homogeneous data type. Structure refers to a collection consisting of elements of heterogeneous data type.
////
////    What is the difference between: An array and a vector:
////    Vector is a sequential container to store elements and not index based. Array stores a fixed-size sequential collection of elements of the same type, and it is index based. Vector is dynamic in nature so, size increases with insertion of elements. As array is fixed size, once initialized can't be resized
//
//    struct dog {
//    string  name;
//    int age;
//    bool vaccinated;
//    };
//
//    dog mydog;
//    mydog.name = "beef";
//    mydog.age = 2;
//    mydog.vaccinated = true;
//
//    vector<dog> dogs;
//
//
    
    int sum(const std::vector<int>& v){
         int s = 0
         for[int i=1; i<=v.size(); i++]{
             s+=v[i];
         }
    }
    return 0;
    

    
}
