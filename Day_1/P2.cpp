#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

using namespace std;

// Create a text string, which is used to output the text file
string puzzle_line;
string alphabet = "abcdefghijklmnopqrstuvwxyz";

int main()
{
    // Read from the text file
    ifstream MyReadFile("Day_1/input");
    int total = 0;

    // Use a while loop together with the getline() function to read the file line by line
    while (getline(MyReadFile, puzzle_line))
    {

        string value;
        int int_value;

        // Output the text from the file
        for (int x = 0; x <= puzzle_line.length(); x++)
        {
            if (alphabet.find(puzzle_line[x]) == std::string::npos)
            {
                int first_value = puzzle_line[x] - '0';
                value = puzzle_line[x];
                break;
            }
        }

        for (int x = puzzle_line.length() - 1; x >= 0; x--)
        {
            if (alphabet.find(puzzle_line[x]) == std::string::npos)
            {
                int last_value = puzzle_line[x] - '0';
                value += puzzle_line[x];
                break;
            }
        }
        std::istringstream(value) >> int_value;

        total += int_value;
    }
    cout << total;

    // Close the file
    MyReadFile.close();
}