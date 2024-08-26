#include <iostream>
#include <regex>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

// Declare constants
regex ID_r("\\d+(?=(:))");
regex RED_r("\\d+(?=( red))");
regex GREEN_r("\\d+(?=( green))");
regex BLUE_r("\\d+(?=( blue))");
int RED_MAX = 12;
int GREEN_MAX = 13;
int BLUE_MAX = 14;

// Declare variables
string puzzle_line;

// Return vector of ints based on regex of input
vector<int> regex_for_values(string input, regex r) {
    vector<int> result;
    int result_value;

    // Regex for the values in the puzzle line
    auto result_iterator = sregex_iterator(input.begin(), input.end(), r);

    // Iterate through each hit in the regex
    for (sregex_iterator i = result_iterator; i != sregex_iterator(); ++i) {
        smatch match = *i;
        string match_str = match[0].str();
        std::istringstream(match_str) >> result_value;

        // Add the result to the results vector
        result.push_back(result_value);
    }
    return result;
}

int main() {
    cout << "---Start---\n";
    int total = 0;

    while (getline(cin, puzzle_line)) {
        bool is_valid = true;

        // regex for the red values and check if they are valid
        vector<int> red_values = regex_for_values(puzzle_line, RED_r);
        for (int value : red_values) {
            if (value > RED_MAX) {
                is_valid = false;
            }
        }

        // regex for the green values and check if they are valid
        vector<int> green_values = regex_for_values(puzzle_line, GREEN_r);
        for (int value : green_values) {
            if (value > GREEN_MAX) {
                is_valid = false;
            }
        }

        // regex for the blue values and check if they are valid
        vector<int> blue_values = regex_for_values(puzzle_line, BLUE_r);
        for (int value : blue_values) {
            if (value > BLUE_MAX) {
                is_valid = false;
            }
        }

        // If all the values are valid, find the game ID and add it total
        if (is_valid) {
            int game_id = regex_for_values(puzzle_line, ID_r)[0];
            total += game_id;
        }
    }
    cout << total;
    cout << "\n----End----\n";
}