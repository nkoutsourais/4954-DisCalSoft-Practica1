## Diseño y calidad del Software 
### Practica 1
* Fecha de entrega: 30/09/2019
* Integrantes de la Pareja:
  * Neo Koutsourais
  * Fran Arboleya
   
## Diagrama MasterMind

<p align="center">
  <img alt="" src="https://plantuml-server.kkeisuke.app/svg/ZLPTJzim57tlhx34IxfIUAyGefGA8HLQjPsOD4sLctYTXMD7jWjYZF--wuyajfF1Ng0vzzphSwvlRtEbD9RwMBB186TOANIFbIQofBnu6w0nggIeX2B5Yk5N8j44hIB0K1J99T4DOHCysd2EENSHzsc0HgY2S3O4x5dGmh2ekiKbMJuJ6S4lacfonxKK0Jn2Fod7ZFucBVXUwm-F1mV_Ow7nC1Fb7YfhAdXZ9C20EOhgPt6beILKabHOWhI94OOiXhbwCSucpW0WrbZdX9hHk8aFS7xUuCeqpT_H_VJRRhhTpkzNsmtefLpREDQQb9LM02seqXTrZU2SIw_K1Z9_Bu6w0z4Bc8EUJ53OWxQMflPmrR7QanIHg7gaHWHWUo4OmTp32m5fAPmBhYa_4jEMLdx8i8UkYJeoUrT1O_5UQObpZLo70q4zxPqj5yjrsDoPO49-_m6VJs1ej7tCxDzJ10QfgJC1yj0o3ZKZ2a4vYxhfz96PC5FEEapVeHDe1KYj6D71r1lSz09JhW8f9jusevMXikRin8BAF1gLjaqCCkiM4duiNHdJihXfyyrcUZlVpTVhvHfIeDUK7rBMoepj-c5tytMrk9jDj_EKgLxBlM0fwYmciQ4DsfdTs8YL6kIDsdE1uzCdFZcuYuXPTxLBRniR9KXS5g9q2kEgWU_y5ycVlCfEOT_sA044Boip3fY5veEiEdnXuvTf0QeUZemjvJN3_2c3nOJBpxqqytBzwiIgB3VF_Y7uogHjj6FLjUogXMlaytfzQptvievGpmP5v-TW01O2XakqU6xsEGQZMaYAtGB1B3yoNA-8h6Sz1LVYrqdulHkR9dsSxABTNTxPED8Ismnpe2IuQ3PRgAGPpBwb4rrfoasZgZ7W_aN7jFiuoKewqRXpDP8LUZEVtcnsZtSFmGOjm9aAdt693wHea94lbGN4qvWrxB-JVwW6YOFshGPz6OyluvUKD9Yy7mn2CkeZnCz8X9pmLp8g95eT8MVGWT3PsKVbKgOVeX2shjn2Yl2BF-D2lF1nZunUMf-8GG_el7aXLuGNy7xv5m00.svg">
</p>

### PlantUML
 
 ```PlantUML
@startuml

class Mastermind{
 - proposedPlayer : ProposedPlayer
 - secretPlayer : SecretPlayer
 - scanner : Scanner
 + play() : void
 - isGameOver() : void
 - writeIntro() : void
 + finalize() : void
}

class SecretPlayer{
  - proposedPlayer : ProposedPlayer
  - secretCombination : SecretCombination
  + SecretPlayer(ProposedPlayer)
  + prepare():void 
  + answer():void
  + writeSecretCombination():void
}

class ProposedPlayer{
  - {static} MAX_ATTEMPTS : int
  - attempts : List<ProposedCombination>
  + propose(Scanner):void
  + getLastProposedCombination():ProposedCombination
  + writeAttemps():void
  + writeProposedCombinations():void
  + isWinner():boolean
  + isLooser():boolean
  + continuePlay(Scanner):boolean
  + writeResultPlay():void
}

abstract class Combination{
  - {static} MAX_COLORS : int
  - Color[]
  # setColor(Color, position:int)
  # getColor(position:int) : Color
  - positionControl(position:int) : void
  # isComplete() : void
  # containsColor(Color) : boolean
  # getColors() : Color[]
  # setColors(Color[]) : void
  # writeColors() : void
}

enum Color{
    - {static} MESSAGE_ERROR : string
    - {static} PATTERN_DUPLICATE : string
    - symbol : string
    - Color(symbol : string)
    + getSymbol() : string
    + {static} get(symbol:string) : Color
    + {static} contains(symbol:string) : boolean
    + {static} ramdomColor() : Color
    - {static} checkSymbol(symbol:string) : void
    - {static} getOptionalColor(symbol:string) : Optional<Color>
    - {static} isNullOrBlank(param:string) : boolean
    + {static} getColorsBySymbols(colorSymbolsCombination:string) : Color[]
    - {static} checkColorsCombination(colorSymbolsCombination:string) : void
}

class SecretCombination{
  + SecretCombination() // genera combinacion aleatoria
  + calculateResult(ProposedCombination) : void
  + write() : void
  - getResult(ProposedCombination) : Result
}

class ProposedCombination{
  - result : Result
  + read(Scanner) : void
  + contains(Color, position:int) : boolean
  + contains(Color) : boolean
  + setResult(Result) : void
  + isWinner() : boolean
  + write() : void
}

class Result{
  - {static} DEADS_WIN : int
  - deads : int
  - damaged : int
  + Result(deads : int, damaged : int)
  + write() : void
  + isWinner() : boolean
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
