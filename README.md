## Diseño y calidad del Software 
### Practica 1
* Fecha de entrega: 30/09/2019
* Integrantes de la Pareja:
  * Neo Koutsourais
  * Fran Arboleya
   
## Diagrama MasterMind

<p align="center">
  <img alt="" src="https://plantuml-server.kkeisuke.app/svg/ZLPTJzim57tFhx34IxfIUAyGeYlLX5HeHPcOD4t8JRnYBR4ZsuKnnd_VzKUIQpUWlRJDkSVtddjyxVH26whClgwohAYerkIQQiDKpKNvcf49QPHif6Rbkg8lJ94fMKU0fMXMA6OwmWOzkd11XV0H_oiZOz90E1y1zYHvQLbSVw4rMpqn5S7FYXjs9OoI21wJdrpGYlzXFVZMwiVbeOF_QQ7hOIxhBMGsN8gk4OG1Snpbp-DC8qTe56ke0cbJAumuZ0hzR3kR-WO0SOqTL6WPNJTn0T_FAsoPuSKRkPvzUvZTtIskrtSRqCk5SN5g3AiRem5QSctEsXoepdbGwW9vs1UaRiVC4kPWO2Ke743xbcQkk3veTM1HHEBwdbiHW6sbh1WL0LvAM9R2XHI6YpspjlJoCSCLlMLwNxczGiRIhJQA5ePuXv6W0Nldg-Ng5fixbvLKtt_0xoCO6kCUS_TvJA11RlDCWJnoZ5tBY4AGpg4kOV78Yb_h43xW1N-Em0WGsbJCe9ctk7M2Sg6H41llhUX5wBohd3IWyu16gPs5Q6Lh81FxsgUnXhdJyr9lPGKKS9QBNK2zf2GsSa4tOHiNSQdHkd6_0S09owTXCN8ksgekc_TXyHlcFaqSqrUDjPbMM2IgqeRFNFmylLwIeHcJWPDCJa-X40mcXKroU67l5GhxOgJYrEs-edKfQoy2TmSZJgjYNz5sYFE10uHsAmmydes9RVFZnJvwUDkyVoRMzhwvlNcu_BfUNirdTmliCRJZ4lQPhJ35QDcTKQou7Tt1unFDSCfDexfhr7z5PVgR9Larx9WV-CylOPxomZvtmzNvaawaEr7XDFiKU1YA59aMZrGTlhoy_CJpoyNiSlDmVtM3hg4IJDNucTPqnyeE6OTKEI8UnwpHi0dl60OIi_wl0VaqcPp7R_eqcBnaCqmcGuJucKZCmQ-QA97iTM1ETW2HavEFqgNCCByOTbtvyndXPtydfNmMam4PWxGX4Ta0w7iBGYwOAE5FsZy0.svg">
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
  - checkPosition(position:int) : void
  # isComplete() : void
  # containsColor(Color) : boolean
  # getColors() : Color[]
  # setColors(Color[]) : void
  # writeColors() : void
}

enum Color{
    - symbol : string
    - Color(symbol : string)
    + getSymbol() : string
    + {static} get(symbol:string) : Color
    - {static} getSymbolsColorExist() : string
    - {static} getOptionalColor(symbol:string) : Optional<Color>
}

class SecretCombination{
  + SecretCombination() // genera combinacion aleatoria
  - ramdomColor() : Color
  + calculateResult(ProposedCombination) : void
  + write() : void
  - getResult(ProposedCombination) : Result
}

class ProposedCombination{
  - {static} PATTERN_DUPLICATE : string
  - result : Result
  + read(Scanner) : void
  + contains(Color, position:int) : boolean
  + contains(Color) : boolean
  + setResult(Result) : void
  + isWinner() : boolean
  + write() : void
  - getColorsBySymbols(colorSymbolsCombination:string) : Color[]
  - checkColorsCombination(colorsCombination:char) : void
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
