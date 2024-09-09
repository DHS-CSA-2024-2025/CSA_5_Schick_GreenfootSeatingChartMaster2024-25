
PROJECT TITLE: AP CSA Assignment 1 (An interactive seating chart using Greenfoot)

PURPOSE OF PROJECT: The purpose of this assignment is to visually work with classes and subclasses, abstract classes, and interfaces, and to familiarize yourself with the basics of the GIT command line.  As a side effect, it will help your instructor learn your names!

VERSION or DATE: 07/21/2020
Version 5 (2024-25): 08/15/24

HOW TO START THIS PROJECT:  To start this project, assuming that you have Greenfoot installed, click on the greenfoot project file within the top level of the assignment directory.  If greenfoot is correctly installed, you will see a green foot icon just to the left of "project".

AUTHORS:                    Mr. Kaehms, Dr. Schick, Mr. Song,  and CSA students

CONTRIBUTERS:               Kilgore Trout
                            (Add you name here once your code 
                             is added and correct)

USER INSTRUCTIONS:


1) Start git bash (assuming that you are using git bash). 
NOTE: We will ask  for one or more class buildmasters.  Each class build-master should fork the main repo to a new repo before starting. Names below should be updated accordingly

2) Move to a directory where you want to keep your work. For instance, cd c:/ then cd Users/YourName/Documents/Assignments

3) Clone (first time, each class build-master should fork, so that each class has their own copy) the repository into the directory where git bash is pointing:

    git clone https://github.com/DHS-CP/GreenfootSeatingChartMaster2024-25.git  (this will change based on fork created by build-master(s).

NOTE: This should set up all initial conditions for GIT and avoid a lot of confusion.

4) Open the greenfoot project file from within greenfoot and start editing.

5) Once tested and saved in Greenfoot, from the bash shell add any files that you want to put into the repository to the next git commit: (Note: File names are case sensitive!)

PLEASE DO NOT COMMIT YOUR FILES IF THEY DO NOT COMPILE LOCALLY!!!!! DO NOT COMMIT TO THIS MASTER REPOSITORY! Work with your build master to create a fork with appropriate permissions! Teachers will provide the current version of the seating chart in Canvas, so that you know where you should be seated.
=====================================================================

git add FirstLast.java
git add images/firstlast.jpg
git add sounds/firstlast.wav

(Files are case sensitive!!!)

6) Check to see what has been staged (from the git command line):

git status

7) Commit your changes from the git command line:

git commit -m “adding my files to the repository”

8) Push your changes to the remote repository (each period should have their own cloned or branched version to work with.
Do not commit back to the master repo:

git push


ASSIGNMENT INSTRUCTIONS IN BRIEF

1) Each student needs to create their own student file, and write a method that plays the firstlast.wav file while performing some kind of animation.  Please pronounce your full name clearly
when making your .wav file, as this assignment will be used to learn correct pronunciation of names.

2) Each student must implement one of the abstract classes. See KilgoreTrout.java for an example. Note the "implements" directive in the class declaration.

3) The wav file should state your name, and say one thing true and unique about you (not that you hunt lions in Africa).

4) Once you have created your student class file with all requirements met, you should work with your class to make overall improvements in the seating chart program.  Brainstorm with your class on ideas for improvement.  Ideas could include such things as fixing bugs, refactoring common code and pushing the logic up the hierarchy into the parent class (for instance), adding features to allow a teacher to reassign seats, work to improve the visual design of the seating chart, allow the teacher to add notes to the seating chart, etc.  Once you have a reasonable list of improvements, break into smaller (table) groups to implement the changes.  Each class will be asked to present their changes at the end of the project, as a set of presentations made by each sub/table group. We may ask each class to create a screencast that explains the
changes so that we can share across classes.

5) Before you start, each period should agree on a build-master or build-masters, and a workflow that they will use to manage and update the master repository.  Access rights can be assigned to groups. Individual classes can work with their teacher to set up appropriate groups that can be managed within the class repository for this project.

See the Canvas instructions for a complete set of requirements for this year's project. 




