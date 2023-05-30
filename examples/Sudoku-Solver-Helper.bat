@echo off
title Sudoku Solver

set arg1=%1
if not defined arg1 set /p arg1="Please provide a path to the Sudoku file: "
java -jar "./Sudoku-Solver_v0.0.1.jar" %arg1%

pause
