let add a b = a + b 

printfn "%i" (add 2 3)


// 以下のように書いてもok
// let cardFace (card: int): string =

let cardFace (card) = 
  let no = card % 13
  if no = 1 then "Ace"
  elif no = 0 then "King"
  elif no = 12 then "Queen"
  elif no = 11 then "Jack"
  else string no

printfn "%s" (cardFace 11)

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
