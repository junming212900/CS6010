//
//  main.cpp
//  CommandLineArgs
//
//  Created by junming jin on 9/1/22.
//

#include <iostream>

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    for (int i = 0; i < argc; i++){
        std :: cout << argv[i] << std ::endl;
        
    }
    return 0;
}
