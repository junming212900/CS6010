CFLAGS=-std=c++11
built : msdscript
msdscript : main.o cmdline.o Expr.o TestCase.o
	c++	$(CFLAGS) main.o cmdline.o Expr.o TestCase.o -o msdscript
main.o: main.cpp
	c++	$(CFLAGS) main.cpp -c
cmdline.o: cmdline.cpp cmdline.hpp
	c++	$(CFLAGS) cmdline.cpp cmdline.hpp -c
Expr.o: Expr.cpp Expr.h
	c++	$(CFLAGS) Expr.cpp Expr.h -c
TestCase.o: TestCase.cpp catch.h
	c++	$(CFLAGS) TestCase.cpp -c
# clean is remove all the .o file
.PHONY:clean test
clean:
	rm -f *.o msdscript
test:
	./msdscript --test
