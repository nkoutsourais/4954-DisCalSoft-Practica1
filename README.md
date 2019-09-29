# Practica1

Practica de Diseño y Calidad del Software 
Fecha de entrega: 30/09/2019
Integrantes de la Pareja:
  -Neo Koutsourais
  -Fran Arboleya
  
 Diagrama UML de Mastermind
 
 TODO FRAN --> add svg image
 
 
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

