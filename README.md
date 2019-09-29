## Diseño y calidad del Software 
### Practica 1
* Fecha de entrega: 30/09/2019
* Integrantes de la Pareja:
  * Neo Koutsourais
  * Fran Arboleya
   
## Diagrama MasterMind

<p align="center">
  <img alt="" src="https://plantuml-server.kkeisuke.app/svg/VLJ1QiCm3BtxAtnCnzBUonWTktPGriCEOmSr5iMGsC5sLaQtVvzi9yHkJ4-9dvwUdYGdE-l0kA5h6MjQi9Q_WNLeEgd4bV6-XPzgjVtMKh2_YN74ng0xK0WDSR9pTJ2wrnP5FAuet1limU0emma1PIz47NKvlnZfS2uJg-H2lWuuXrtlRD0CmUhOW59KPb8wezkJ_odtLNSdgS19hKY-W4x5NuAqlR5KI4Weqdv8NvoGazOjWWhWNbDA3ZPQEQa6zAtCbkTuAFQETcZ35ESID78uMMUWSJnE9R5oPQ-wrURpYqQ6QkXuE6OxojXy2LOhljbm81jE6wczLMYReON9JbKOGNbjtco-k9lY9WY65n2BnVaHWQJnXYOUEIb8dxcLojsESkQb4Ojkz1mVz_Uqy3wQZxdUho2R_ge9wE2CXNwBkYJ4vY-8FzJrS_PzB8BvDMSi9VCI8JzpdNBIcvq9wTb7oc4BYA_Nz-HkcN5SB8L3L_4gPlZJRotqHTK56qLQoGGhWB6tqSWEbQ1_sJy0.svg">
</p>

### PlantUML
 
 ```PlantUML
 @startuml

class Mastermind{
 play():void
}

class SecretPlayer{
  SecretPlayer(ProposedPlayer)
  prepare():void 
  answer():void
  write():void
}
class ProposedPlayer{
  attempts
  propose(Scanner):void
  getLastProposedCombination():ProposedCombination
  writeAttemps():void
  writeProposedCombinations():void
  isWinner():boolean
  isLooser():boolean
  continuePlay(Scanner):boolean
  writeResultPlay():void
  }

abstract class Combination{
Color[]
}
enum Color
class SecretCombination{
  SecretCombination() // aleatorio
  calculateResult(ProposedCombination):void
  write():void
  }
class ProposedCombination{
  result
  read(Scanner):void
  contains(Color, position:int):boolean
  contains(Color):boolean
  setResult(Result):void
  isWinner():boolean
  write():void
  }

class Result{
  deads
  damaged
  write():void
  isWinner():boolean
  }


Mastermind *--> SecretPlayer
Mastermind *--> ProposedPlayer

SecretPlayer --> ProposedPlayer

ProposedPlayer o--> ProposedCombination
SecretPlayer o--> SecretCombination

SecretCombination ..> ProposedCombination
SecretCombination ..> Result
Combination *--> Color

Combination <|-down- SecretCombination
Combination <|-down- ProposedCombination

ProposedCombination o--> Result
@enduml



```

## Diagrama Tres en raya

<p align="center">
  <img alt="" src="https://plantuml-server.kkeisuke.app/svg/JL3B2iCW4Bpx5HxJaln03YNqKEWfXHmQ23aO8rHgDAXf6qh_lRjg7mVNcP6PNRTodbc_J8eGhfXpjAtfar0wAxOAwsZNbwS0GMFSovk8j9JQWpGOPiToZnLOMsURv0Nm-aI6PmoLMlgkxtg0_2BuzUWEYrB1a_XPwa2bTiBwx85jyXKhgdShlVXFZhDWTBDEWr40efH5deVMOIPhPkEIMUXbIWxqjd1gr0byVbiKkpZnbwK5a7X7BVLBqiz3Ag57MESR.svg">
</p>

### PlantUML
 
```PLantUML XO
@startuml

class XO {
  players []:Player
  activePlayer:int
  board:Board
  XO()
  play()
}

class Board{
  init[][]
  checkIsFull()
  checkIsWin()
  insert(x:int,y:int)
  write()
}

class Player{
  Symbol
  Player(Symbol,Board)
  propose()
}

enum Symbol{
  X
  O
}


XO *--> Board
XO *--> Player

Player *--> Symbol
Player --> Board

@enduml


```
