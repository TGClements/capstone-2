<h1>The Problem Solving Framework : 'UPER'</h1>

- U = "Understand"
- P = "Plan"
- E = "Execute"
- R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>

- I need to create an ASCII based terminal game.
- It needs to follow all the core requirements in the README.
- I also want to try to attempt to fulfill the bonus requirements of the project.

<h2>
    2. Planning the Solution
</h2>

- I already understand the game of sudoku, so I don't need to figure out the rules and research how the game works. Because of this, I will start with trying to make my user interface first. I want to have an intuitive UI to make the game easy to play. This will also work to satisfy one of the bonuses (use a 3rd party libary [ java swing ])
- After creating the UI, I will start to implement the base functionality of the game.
- Once the base functionality is created, I will look into the other bonus requirements, such as creating a front-end with react.
- If I can satisfy the bonus requirements, I will pursue those. Otherwise I will try to add more functionality to the game, like hints, highscore, etc.

<h2>
    3. Executing the Plan
</h2>

- Started to build the UI.
  - Built the window.
  - Built the main menu.
  - Built the button grid.
  - Added functionality to click the button and change its value.
  - Added the different game difficulties so I could wire them up later.
  - Built the "quit" option.
  - Built the "instructions" option.
- Built first revision of algorithm to generate a valid and completed sudoku puzzle.
- Created "Current Game" menu and menu items.
  - Completed the "Lock in Correct Cells" functionality to check for correct cells before checking for win.
  - Completed the "Check Win" option to allow players to actually win the game.
- Wired up the different game difficulties. (The game is harder the less numbers are shown.)
- Refactored some of the game algorithm to include lambdas and interfaces (including here instead of section 4, because this is for core req's.).
- Created a timer by utilizing abstract classes.
- Created a "Best Times" tracker that utilizes streams.
- Created the ability to change the UI to be either "light mode" or "dark mode".

<h2>
    4. Reflection / Refactor
</h2>

- Did some refactoring while I was developing to fulfill the core requirements
  - Refactored the puzzle generation algorithm to utilize lambdas and interfaces.
  - Refactored my Thread-based timer a few times to be able to access some of the fields and data from the UI class.
- By refactoring while I was developing, and by "getting it working normally first", I felt like I actually saved some time and avoided potential bugs than if I were to try to refactor it later.
