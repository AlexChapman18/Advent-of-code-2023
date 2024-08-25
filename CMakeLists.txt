cmake_minimum_required(VERSION 3.28.3)

project(Advent-of-code-2023 LANGUAGES CXX)

add_executable(Day_1_P1 Day_1/P1.cpp)
add_executable(Day_1_P2 Day_1/P2.cpp)

add_library(MyProject INTERFACE) # Create and empty library
target_compile_features(MyProject INTERFACE cxx_std_17) # Specify the C++ version
target_compile_options(MyProject INTERFACE -Wall -Wpedantic) # Specify the compiler flags
link_libraries(MyProject) # Link the library to all targes



# Create make file
# cmake -S . -B build -GNinja

# Create make file using ninja
# cmake -S . -B build -GNinja

# Build program using the make file
# cmake --build .\build\

# cmake -S . -B build -GNinja --toolchain .\toolchain_LINUX.cmake
