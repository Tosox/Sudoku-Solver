# Sudoku Solver

## Features

* Solves Sudoku recursively
* Reads and parses the Sudoku from a file
* Supports multiple formats (check out the [examples](/examples))
* Outputs the solved Sudoku as text in the command line

## Usage

```shell
java -jar "path/to/the/sudoku-solver.jar" "path/to/your/sudoku-puzzle.txt"
```

_Alternatively, drag and drop the Sudoku file onto the [`Sudoku-Solver-Helper.bat`](/examples/Sudoku-Solver-Helper.bat) file_

## Example Output

```shell
Input Sudoku:
0 0 0 | 0 0 7 | 0 3 0
0 0 0 | 0 0 0 | 5 0 0
0 5 9 | 0 0 2 | 7 0 0
- - - - - - - - - - -
1 0 0 | 4 0 0 | 0 0 8
0 2 0 | 0 0 5 | 0 0 0
0 4 3 | 8 0 0 | 0 6 0
- - - - - - - - - - -
9 3 0 | 0 0 0 | 0 0 0
0 0 0 | 0 7 0 | 8 2 0
0 8 0 | 9 4 0 | 0 0 5

Possible solution:
2 1 4 | 5 8 7 | 9 3 6
3 7 6 | 1 9 4 | 5 8 2
8 5 9 | 6 3 2 | 7 4 1
- - - - - - - - - - -
1 9 7 | 4 6 3 | 2 5 8
6 2 8 | 7 1 5 | 4 9 3
5 4 3 | 8 2 9 | 1 6 7
- - - - - - - - - - -
9 3 1 | 2 5 8 | 6 7 4
4 6 5 | 3 7 1 | 8 2 9
7 8 2 | 9 4 6 | 3 1 5
```
