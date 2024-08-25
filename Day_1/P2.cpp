#include <iostream>
#include <map>
#include <regex>
#include <string>

using namespace std;

string puzzle_line;
map<string, char> number_words = {
    {"zero", '0'}, {"one", '1'}, {"two", '2'},   {"three", '3'}, {"four", '4'},
    {"five", '5'}, {"six", '6'}, {"seven", '7'}, {"eight", '8'}, {"nine", '9'}};

// Regex for getting numbers
std::regex numbers_regex(
    "(?=(\\d|one|two|three|four|five|six|seven|eight|nine))");

// Converts value to its char form
// e.g. 7 or "seven" -> '7'
char get_char(string value) {
    if (isdigit(value[0])) {
        return value[0];
    } else {
        return number_words[value];
    }
}

int main() {
    cout << "---Start---\n";
    // Read from the text file
    int total = 0;
    int puzzle_line_value;

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
            std::string match_str = match[1].str();

            // Converts value to its char form
            char current_value = get_char(match_str);
            if (is_first_value) {
                is_first_value = false;
                first_value = current_value;
            }
            last_value = current_value;
        }
        string value_string = std::string(1, first_value) + last_value;
        std::istringstream(value_string) >> puzzle_line_value;
        total += puzzle_line_value;
    }
    // Print total at the end
    cout << total;
    cout << "\n----End----\n";
}