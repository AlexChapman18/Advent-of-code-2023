#include <fstream>
#include <iostream>
#include <sstream>
#include <string>

using namespace std;

// Create a text string, which is used to output the text file
string puzzle_line;
string alphabet = "abcdefghijklmnopqrstuvwxyz";

int main() {
    cout << "---Start---\n";
    // Read from the text file
    int total = 0;

    // Use a while loop together with the getline() function to read the file
    // line by line
    string puzzle_line;
    while (cin >> puzzle_line) {
        string value;
        int int_value;

        // Output the text from the file
        for (int x = 0; x <= puzzle_line.length(); x++) {
            if (alphabet.find(puzzle_line[x]) == std::string::npos) {
                int first_value = puzzle_line[x] - '0';
                value = puzzle_line[x];
                break;
            }
        }

        for (int x = puzzle_line.length() - 1; x >= 0; x--) {
            if (alphabet.find(puzzle_line[x]) == std::string::npos) {
                int last_value = puzzle_line[x] - '0';
                value += puzzle_line[x];
                break;
            }
        }
        std::istringstream(value) >> int_value;

        total += int_value;
    }
    cout << total;

    cout << "\n----End----\n";
}