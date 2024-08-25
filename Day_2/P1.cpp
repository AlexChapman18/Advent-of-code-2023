#include <iostream>
#include <string>

using namespace std;

string puzzle_line;

int main() {
    cout << "---Start---\n";

    while (cin >> puzzle_line) {
        cout << puzzle_line;
    }
    cout << "\n----End----\n";
}