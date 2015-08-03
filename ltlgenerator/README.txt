LTL Generator Team 2.

How to Use:
The LTL Generator requires a file named input.txt

The LTL Generator will output the generated LTL Formulas in a file named output.txt. If the file already exists, it will append the results, if it's not, it will create the file.

The LTL generator will read 7 lines of text at a time to get an input set from the input.txt file. 
The input set is composed of the Scope, Pattern, and the P, Q, R, L Composite Proposition parameters. 
The seventh line is disregarded.
The order in which the parameters are placed is not important.
The parameters are not case sensitive.

The Syntax for each parameter is very specific, and must be as follows:

For the scope parameter: 
Scope:[Scope Name]

[Scope Name]: The valid options for the Scope Name parameter are:
AfterL 
AfterLUntilR
BeforeR
BetweenLAndR
Global

For the pattern parameter:
Pattern:[Pattern Name]

[Pattern Name]: The valid options for the Pattern Name parameter are:
Absence
Existence
Precedence
Response
StricPrecedence

For the Different Composite Proposition Types and Parameters:
[CP LETTER]_[CP NAME]_[NUMBER OF CPS]

[CP LETTER]: The valid options for the CP Letters are:
L
P
Q
R

[CP_NAME]: The valid options for the CP Names are:
Empty			- Use when a CP is not needed, if it is used, the [Number Of CPS] parameter is not needed, but you must specify the [CP LETTER]
AtLeastOneC
AtLeastOneH
AtLeastOneE
ParallelC
ParallelH
ParallelE
ConsecutiveC
ConsecutiveH
ConsecutiveE
EventualC
EventualH
EventualE



[NUMBER OF CPS]: Is the number of CP's, it must be entered with numbers from 2 to n.

Example of a complete Input Set:

Scope:Global
Pattern:Absence
P_AtLeastOneC_3
Q_ParallelC_4
R_ConsecutiveE_5
L_Empty
----------------------

You can have as many input sets as needed.
