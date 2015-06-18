To run in a command line:
java -jar LTLGen.jar

Requires input.txt for input, formulas will be written to output.txt.

Input file is not very robust so follow pattern.

Input files are case sensitive and must case match as follows:

Pattern types-
Absence
Existence
Precedence
Response
StrictPrecedence
Universality

Scope types:
AfterL
AfterLuntilR
BeforeR
BetweenLandR
Global

CP types:
AtLeastOneC
AtLeastOneE
ConsecutiveC
ConsecutiveE
EventualC
EventualE
ParallelC
ParallelE