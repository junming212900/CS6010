/**
* \file cmdline.hpp
* \brief cmdline class
*
* declare cmdline function, arguments can be used in this program.
*/

#ifndef cmdline_hpp
#define cmdline_hpp

#include <stdio.h>
typedef enum {

    do_nothing,
    do_interp,
    do_print,

} run_mode_t;
run_mode_t use_arguments(int argc, const char **argv);


#endif /* cmdline_hpp */