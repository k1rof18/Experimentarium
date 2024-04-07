let add a b = a + b 

printfn "%i" (add 2 3)


// 以下のように書いてもok
// let cardFace_ (card: int): string =

let cardFace_ (card) = 
  let no = card % 13
  if no = 1 then "Ace"
  elif no = 0 then "King"
  elif no = 12 then "Queen"
  elif no = 11 then "Jack"
  else string no

printfn "%s" (cardFace_ 11)

printfn "###########"
printfn "コンポジション"
printfn "###########"

let multiply a b = a*b
let multiply3 a = a * 3
printfn "%i" (multiply3 2)

let add9 a = a + 9
let addAndMultiply = add9 >> multiply3
printfn "%i" (addAndMultiply 1)

printfn "###########"
printfn "パイプライン"
printfn "###########"

let list  = [20;6;5]
let sort (l: int list) = List.sort l
let print (l: int list) = List.iter(fun x-> printfn "%i" x) l

list |> sort |> print

printfn "###########"
printfn "演習"
printfn "###########"

let cards = [21; 3; 1; 7; 9; 23]
let cardFace card = 
    let no = card % 13
    if no = 1 then "Ace"
    elif no = 0 then "King"
    elif no = 12 then "Queen"
    elif no = 11 then "Jack"
    else string no

let suit card =
    let no = card / 13
    if no = 0 then "Hearts"
    elif no = 1 then "Spades"
    elif no = 2 then "Diamonds"
    else "Clubs"

let shuffle ls =
  let random = System.Random()
  ls |> List.sortBy(fun x -> random.Next())

let printCard x = printfn "%s of %s" (suit x) (cardFace x)

let printAll ls = List.iter(fun x -> printCard x) ls

let take (no:int) (ls) = List.take  no ls

cards |> shuffle |> take 3 |> printAll
