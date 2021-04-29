# Project Description
Implement SortingHat : A school hostel assignment Program
New students join a school and need to be assigned to one of 4 boarding houses. As students come in,
they register their roll number, class & food preference. There are 2 classes - 
A and B, and two food preferences - V & NV. There are 4 boarding houses with equal but limited capacity.
The hat follows a first in first out policy with the following rules -
● Queue will be processed based on the time a student registered, first in first out
● Boarding houses for students who prefer V cannot board NV students
● Boarding houses for class A would be separate from boarding houses for class B
● Once all boarding houses are filled up to capacity, no more students can be allocated.
● Other rules
○ Roll number is a 4 digit integer unique to each student
○ Student can only be registered once, duplicate commands for same student may be
ignored

# How to use

There are 2 ways to registered students to boarding house 

**For file input:**

- Add file name in Configuration --> Use Edit Configuration and add file name -->
  "./bin/sorting_hat_input_file.txt"

- Run your project you can see the output for operation command specified in file.

ScreenShot Of File output for reference  :- 

![example output for file](/Users/vrushali/Backend/javaprojects/sorting_hat/src/main/resources/SampleOutput/file_output.png)

**For input from terminal:**
Note :- 
If you earlier have registered students using file, please remove path from config file and then try from terminal.

- Use command to create boarding house with equal capacity, 
  give total number of student capacity which can be equal for each boarding house 
  :- init 12
  (12 is total number so 12/4 = 3 student capacity for each boarding house)

- Use command to registered students  :- reg 1 B V

- use command to exit and see output :- fin

ScreenShot Of Terminal output for reference :- 

![example output for terminal](/Users/vrushali/Backend/javaprojects/sorting_hat/src/main/resources/SampleOutput/terminal_output.png)

### Author
  Vrushali