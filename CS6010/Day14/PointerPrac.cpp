/
// main.cpp
// Practice
//
// Created by Junming Jin on 9/1/22.
//
#include <iostream>
#include <vector>
struct MyVector {
  double * data;// date has been set up as a pointer.
  int size;
  int capacity;
};

double arrayModSum(MyVector& vec) {
  int sum = 0;
  for (int i = 0; i < vec.size; i++) {
    temp[i] = vec.data[i] + 1;
    sum += temp[i];
  }
   return sum;
}

void growMyVector(MyVector& vec) {
  double * temp = new double[2 * vec.capacity];
  for (int i = 0; i < vec.size; i++) {
    temp[i] = vec.data[i];
  }
  delete [] vec.data;
  vec.data = temp;
  vec.capacity = 2 * vec.capacity;
  temp = nullptr;
}

int main(int argc, const char * argv[]) {
  MyVector vec1;
  std::cout << "Input the array size: " << std::endl;
  std::cin >> vec1.size;// input the value of "size" inside the MyVector
  vec1.data = new double[vec1.size];// vec1.data is now pointing to the first element of the array.
  vec1.capacity = vec1.size;// vec1.capacity to be equal to the size.
  for (int i = 0; i < vec1.size; i++) {
    vec1.data[i] = 1.0;//fill each element with 1.0.
    std::cout << vec1.data[i] << std::endl;// cout the each element.
  }
  double newSum = arrayModSum(vec1);
  std::cout << "The modified sum is: " << newSum << std::endl;
  growMyVector(vec1);
  std::cout << "After growing, the capacity becomes: " << vec1.capacity << std::endl;
  for (int i = vec1.size; i < vec1.capacity; i++) {
    vec1.data[i] = -1.0;
  }
  std::cout << "The elements in the vector are: " << std::endl;
  for (int i = 0; i < vec1.capacity; i++) {
    std::cout << vec1.data[i] << std::endl;
  }
  return 0;
}
