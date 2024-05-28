case class ProgrammingLang(name: String, year: Int)

var java = ProgrammingLang("Java", 1995)
var scala = ProgrammingLang("Scala", 2004)

var langs = List(java, scala)

// langs.filter(l => l.year > 2000)

// あんすこ構文
// langs.filter(_.year > 2000)