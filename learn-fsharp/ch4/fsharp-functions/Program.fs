let add a b = a + b 

printfn "%i" (add 2 3)


// let cardFace (card: int): string =
// と書いてもok
let cardFace (card) = 
  let no = card % 13
  if no = 1 then "Ace"
  elif no = 0 then "King"
  elif no = 12 then "Queen"
  elif no = 11 then "Jack"
  else string no

printfn "%s" (cardFace 11)
