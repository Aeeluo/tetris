# Tetris
Java Tetris

Analyse détaillée :

- Game Loop :
  - Initialize (Game setup)
  - Update (Phase to prepare every objects to be drawn => physics code, pieces rotation/movement etc...)
  - Draw (Draw every objects)
State Machine :

[Game Setup (Menu, Settings)] -> [Game Start] -> {Loop : [Main State] -> [Piece Falling/Rotating (Update + Draw)]} ----(if piece at the top)----> **GameOver** 
