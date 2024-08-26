#include <iostream>
#include <regex>
#include <sstream>
#include <string>
#include <vector>

int main() {
    // A way of splitting a string based on ','
    stringstream puzzle_line_stream(puzzle_line);
    string segment;
    vector<string> split_puzzle_line;

    while (getline(puzzle_line_stream, segment, ',')) {
        split_puzzle_line.push_back(segment);
    }
}