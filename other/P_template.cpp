#include <iostream>
#include <string>

using namespace std;

// Declare constants

// Declare variables
string puzzle_line;

int main() {
    cout << "---Start---\n";

    while (getline(cin, puzzle_line)) {
        cout << puzzle_line << endl;
    }
    cout << "\n----End----\n";
}