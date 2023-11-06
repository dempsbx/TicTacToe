# Tic Tac Toe Game

This project is a Java implementation of the classic game Tic Tac Toe. It allows users to play against a computer opponent that makes decisions using a minimax algorithm.

## Features

- A text-based user interface to play the game in the console.
- An AI opponent that can play optimally against the user.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Ensure you have Java installed on your machine. To check, run `java -version` in the terminal.

### Installation

Clone this repository:

```sh
git clone https://github.com/your-username/tic-tac-toe-java.git
```

Compile the Java classes:

```sh
javac TicTacToe.java Board.java Move.java
```

Run the game:

```sh
java TicTacToe
```

### Usage

After running the game, follow the on-screen prompts. Input your moves as row and column coordinates when prompted during your turn.

## How to Play

- The game board consists of a 3x3 grid.
- You can choose to play against a human opponent or against the computer as 'X' or 'O'.
- On your turn, input the row and column numbers to place your 'X' or 'O'.
- The goal is to get three of your symbols in a row horizontally, vertically, or diagonally.
- If all spots are filled without three in a row, the game ends in a draw.

## Code Structure

- TicTacToe.java: The main class that runs the game loop and handles user interaction.
- Board.java: Contains the board state and logic for checking wins, losses, and draws.
- Move.java: Represents a move made by a player, including its score for the AI's decision-making process.

## Contributing

Any contributions you make are greatly appreciated.

1. Fork the Project
2. Create your Feature Branch (git checkout -b feature/AmazingFeature)
3. Commit your Changes (git commit -m 'Add some AmazingFeature')
4. Push to the Branch (git push origin feature/AmazingFeature)
5. Open a Pull Request
