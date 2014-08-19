File f = new File(args[0])

String captionBase =  "Leiden manuscript VGF 64"
String folioUrnBase = "urn:cite:hmt:vgf64."
println "Parse " + f
f.eachLine {  ln ->
  def cols = ln.split(/,/)

  String urn = cols[0]
  String pg = "unidentified page"
  switch(cols.size()) {
  case 1:
  break

  case 2:
  case 3:
  if (cols[1] ==~ "${folioUrnBase}.+") {
    pg = "folio " + cols[1].replaceFirst(folioUrnBase,"")
  }
  break

  }
  println urn + ',"' + captionBase + ", ${pg}" + '","Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License"'
}
