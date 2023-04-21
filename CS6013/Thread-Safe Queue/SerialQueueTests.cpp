#include "SerialQueue.hpp"
#include <iostream>
#include <cassert>

void test_static_allocation() {
    SerialQueue<int> queue;
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    assert(queue.size() == 3);

    int value;
    bool result = queue.dequeue(&value);
    assert(result);
    assert(value == 1);
    assert(queue.size() == 2);

    result = queue.dequeue(&value);
    assert(result);
    assert(value == 2);
    assert(queue.size() == 1);

    result = queue.dequeue(&value);
    assert(result);
    assert(value == 3);
    assert(queue.size() == 0);

    result = queue.dequeue(&value);
    assert(!result);
}

void test_dynamic_allocation() {
    SerialQueue<int>* queue = new SerialQueue<int>();
    queue->enqueue(1);
    queue->enqueue(2);
    queue->enqueue(3);

    assert(queue->size() == 3);

    int value;
    bool result = queue->dequeue(&value);
    assert(result);
    assert(value == 1);
    assert(queue->size() == 2);

    result = queue->dequeue(&value);
    assert(result);
    assert(value == 2);
    assert(queue->size() == 1);

    result = queue->dequeue(&value);
    assert(result);
    assert(value == 3);
    assert(queue->size() == 0);

    result = queue->dequeue(&value);
    assert(!result);

    delete queue;
}

int main() {
    test_static_allocation();
    test_dynamic_allocation();
    std::cout << "All tests passed!" << std::endl;
    return 0;
}
