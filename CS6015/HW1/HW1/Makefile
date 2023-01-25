built : msdscript
msdscript : main.o cmdline.o Expr.o TestCase.o
	g++	main.o cmdline.o Expr.o-o msdscript
main.o: main.cpp
	g++ main.cpp -c
cmdline.o: cmdline.cpp cmdline.hpp
	g++ cmdline.cpp cmdline.hpp -c
Expr.o: Expr.cpp Expr.h
	g++ Expr.cpp Expr.hpp -c
TestCase.o: TestCase.cpp catch.h
	g++ TestCase.cpp -c
# clean is remove all the .o file
.PHONY:clean
clean:
	rm -f *.o msdscript
