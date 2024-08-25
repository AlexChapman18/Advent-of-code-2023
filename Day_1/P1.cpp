#include <fstream>
#include <iostream>
#include <regex>
#include <sstream>
#include <string>

using namespace std;

string puzzle_line;

// Regex for getting numbers
std::regex numbers_regex("\\d");

int main() {
    cout << "\n---Start---\n";
    // Read from the text file
    int total = 0;

    // Use a while loop together with the getline() function to read the file
    // line by line
    string puzzle_line;
    while (cin >> puzzle_line) {
        // Regex for the values in the puzzle line
        auto numbers_begin = std::sregex_iterator(
            puzzle_line.begin(), puzzle_line.end(), numbers_regex);

        // The values of the first and last char in the puzzle line
        bool is_first_value = true;
        char first_value;
        char last_value;

        // Iterate through each hit in the regex
        for (std::sregex_iterator i = numbers_begin;
             i != std::sregex_iterator(); ++i) {
            std::smatch match = *i;
            std::string match_str = match[0].str();

            // Converts value to its char form
            char current_value = match_str[0];
            if (is_first_value) {
                is_first_value = false;
                first_value = current_value;
            }
            last_value = current_value;
        }

        int puzzle_line_value;
        string value_string = std::string(1, first_value) + last_value;
        std::istringstream(value_string) >> puzzle_line_value;
        total += puzzle_line_value;
    }

    // Print total at the end
    cout << total;
    cout << "\n----End----\n";
}