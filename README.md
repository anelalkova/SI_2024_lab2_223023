# Анастасија Лалкова 223023
# Слика од Control Flow Graph
![Dijagrami_SI-Лаб 2](https://github.com/anelalkova/SI_2024_lab2_223023/assets/115743219/48c8a2ff-25af-4fae-b5dd-5270bbf5c9eb)

# Цикломатска комплексност 
Цикломатска комплексност за овој код е 10, и истата ја добив со броење на бројот на региони во Control Flow Graph. 

# Тест случаи според критериумот Every branch
**Тест 1:** allItems = [] <br>
Со поставување на allItems како null, ќе се фрли исклучок.<br>

**Тест 2:** name = null, barcode = null<br>
Со креирање на Item, со name = null, на името ќе се додели вредност "unknown", а доколку barcode е null, тогаш ќе се фрли исклучок. <br>

**Тест 3:** name = "Item", barcode = "123b23"<br>
Со креирање на Item, со name = "Item", и barcode = "123b23", за barcode ќе фрли исклучок бидејќи има недозволени знаци во самиот баркод.<br>

**Тест 4:** name = "Item", barcode = "012123", discount = 0.25F, price = 350, payment = 100<br>
Со креирање на Item со name = "Item", barcode = "012123", discount = 0.25F, и price = 350, за сумата ќе се пресмета 350*0.25 = 87.5, па потоа од сумата ќе се одземе 30 и ќе добиеме 57.5 < 100, за кое ќе се врати true. <br>

**Тест 5:** name = "Item", barcode = "012123", discount = 0, price = 100, payment = 50<br>
Со креирање на Item со name = "Item", barcode = "012123", discount = 0, и price = 100, за сумата ќе се доделе вредноста 100, бидејќи сумата не е помала од наплатата ќе се врати false.<br>

# Тест случаи според критериумот Multiple Condition
if condition = (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0)
== '0')<br>

**TTT:** item.getPrice() = 350; item.getDiscount() = 0.1F; item.getBarcode() = "012123"<br>
350 > 300 ќе врати точно, 0.1 > 0 ќе врати точно, '0' == '0' ќе врати точно<br>

**TTF:** item.getPrice() = 350; item.getDiscount() = 0.1F; item.getBarcode() = "123123"<br>
350 > 300 ќе врати точно, 0.1F > 0 ќе врати точно, '1' == '0' ќе врати неточно<br>

**TFX:** item.getPrice() = 350; item.getDiscount() = 0; item.getBarcode() = "abcxyz"<br>
350 > 300 ќе врати точно, 0 > 0 ќе врати неточно, бидејќи во if условот имаме "&&" или логичко "И", доколку еден од условите не е исполнет, останатите не не интересираат и поради тоа нема да се проверат.<br>

**FXX:** item.getPrice() = 200; item.getDiscount() = x; item.getBarcode() = "abcxyx"<br>
200 > 300 ќе врати неточно, бидејќи во if условот имаме "&&" или логичко "И", доколку еден од условите не е исполнет, останатите не не интересираат и поради тоа нема да се проверат.<br>
