#include <iostream>
#include <set>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

// Declare variables
string puzzle_line;
vector<vector<char>> grid;
int width;
int height;

// Declare constants
set<char> VALID_CHARS{'.', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

// Check if symbol is surrounding coords
bool is_part(int x, int y) {
    int min_x = (x - 1 >= 0) ? (x - 1) : 0;
    int min_y = (y - 1 >= 0) ? (y - 1) : 0;
    int max_x = (x + 1 <= width - 1) ? (x + 1) : width - 1;
    int max_y = (y + 1 <= height - 1) ? (y + 1) : height - 1;

    // Iterate through surrounding coords checking
    for (int cur_y = min_y; cur_y <= max_y; cur_y++) {
        for (int cur_x = min_x; cur_x <= max_x; cur_x++) {
            char current_char = grid[cur_y][cur_x];
            if (VALID_CHARS.find(current_char) == VALID_CHARS.end()) {
                return true;
            }
        }
    }
    return false;
}

int main() {
    cout << "---Start---\n";

    // Create a 2d vector grid
    while (getline(cin, puzzle_line)) {
        grid.push_back(vector<char>(puzzle_line.begin(), puzzle_line.end()));
    }
    width = grid[0].size();
    height = grid.size();
    string num_string = "";
    bool is_valid = false;
    int current_value;
    int total = 0;

    // Iterate through the grid
    for (int cur_y = 0; cur_y < height; cur_y++) {
        for (int cur_x = 0; cur_x < width; cur_x++) {
            char current_char = grid[cur_y][cur_x];

            // If the current char is a digit, check if there is a symbol
            // surrounding it
            if (isdigit(current_char)) {
                num_string += current_char;
                // If there is a symbol, set valid to true
                if (is_part(cur_x, cur_y)) {
                    is_valid = true;
                }
            } else {
                // If there is a valid number and we're at the end, add it to
                // the total
                if (is_valid && num_string != "") {
                    std::istringstream(num_string) >> current_value;
                    total += current_value;
                }
                // Reset the num_string
                num_string = "";
                is_valid = false;
            }
        }
    }

    // Output the total
    cout << total;
    cout << "\n----End----\n";
}
