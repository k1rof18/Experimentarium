// # literal

// 定数
// 小文字で始まる識別子は、常にバインドされる変数として扱われる。リテラルを定義する場合は先頭大文字を使用する
[<Literal>]
let Pi = 3.14

printfn "%A" Pi

// # 文字列

// Using a verbatim string
let xmlFragment1 = @"<book author=""Milton, John"" title=""Paradise Lost"">"
printfn "%A" xmlFragment1

// Using a triple-quoted string
let xmlFragment2 = """<book author="Milton, John" title="Paradise Lost">"""
printfn "%A" xmlFragment2

let str1 =
    "abc
def"

printfn "%A" str1

let str2 =
    "野球\
baseball"

printfn "%A" str2

printfn "%c" str2[1]
printfn "%s" str2[0..1]

// # 挿入文字列
