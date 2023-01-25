//
//  cmdline.cpp
//  HW1
//
//  Created by junming jin on 1/18/23.
//
#define CATCH_CONFIG_RUNNER
#include <iostream>
#include "cmdline.hpp"
#include "catch.h"

int use_arguments(int argc, const char * argv[]) {
    bool tested = false;
    for (int i = 1;i< argc;i++){
        if (strcmp(argv[i], "--help") == 0){
            std:: cout <<"this is your help" <<std::endl;
            exit(0);
        } else if (strcmp(argv[i], "--test") == 0){
            if (!tested){
                if (Catch::Session().run(1, argv)!=0){
                    exit(1);
                }

//                if else {}
                tested = true;
//                std::cout <<"Tests passed" << std::endl;

            }

            else {
                std:: cerr << "there is something wrong"<< std::endl;
                exit(1);
            }
            
        } else{
            std::cerr << "nothing";
            exit(1);
        }
    }
    return 0;
}
