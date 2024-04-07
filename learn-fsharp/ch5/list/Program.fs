// リスト: F# のリストは、順序付けられた、"変更不可" の同じ型の一連の要素
// 配列: 配列は固定サイズで、0 から始まるインデックスで連続して順序付けされた、同じ型の "変更可能" なデータ要素のコレクション
// シーケンス: シーケンスは、すべて同じ型である一連の論理的要素です。

printfn "##########"
printfn "リスト"
printfn "##########"

let num = [ -2 .. 1 ]

printfn "%A" num

// 先頭に追加
let numX = 3 :: num
printfn "%A" numX

// リスト全体を追加
let numZ = numX @ numX
let numZZ = List.append numX numX
printfn "%A" numZ
printfn "%A" numZZ

printfn "##########"
printfn "演習"
printfn "##########"

let cards = [ 0..5 ]

let drawCard (tuple: int list * int list) =
    let deck = fst tuple
    let draw = snd tuple
    let firstCard = deck.Head
    printfn "%i" firstCard

    let hand = draw |> List.append [ firstCard ]

    (deck.Tail, hand)

let hand = []

let d, h = (cards, hand) |> drawCard |> drawCard

printfn "Deck: %A Hand: %A" d h

printfn "##########"
printfn "map"
printfn "##########"

type Person = { FirstName: string; LastName: string }

let people =
    [ { FirstName = "Albert"
        LastName = "Einstein" }
      { FirstName = "Marie"
        LastName = "Curie" } ]

let nobelPrizeWinners =
    List.map (fun person -> person.FirstName + person.LastName) people

printfn "%A" nobelPrizeWinners

printfn "##########"
printfn "フィルター" // true に評価されると、要素は保持されます
printfn "##########"

let alberts = List.filter (fun person -> person.FirstName = "Albert") people
printfn "%A" alberts
