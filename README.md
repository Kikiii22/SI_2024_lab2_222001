Втора лабораториска вежба по Софтверско инженерство

Христина Здравеска 222001

CONTROL FLOW GRAPH

![image](https://github.com/Kikiii22/SI_2024_lab2_222001/assets/116901976/76c48860-827e-4f05-baca-9bd500744ee7)



ЦИКЛОМАТСКА КОМПЛЕКСНОСТ

Цикломатската комплексност на овој код е 2, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.Направив и втора проверка каде број на ребра е 36,јазли 28,па комплексноста е 36-28+2=10

Тест случаи според критериумот EVERY BRANCH
![image](https://github.com/Kikiii22/SI_2024_lab2_222001/assets/116901976/2dc127e1-5b48-41f0-bf17-bcbc0ebce6e8)

Тест случаи според критериумот MULTIPLE CONDITION
![image](https://github.com/Kikiii22/SI_2024_lab2_222001/assets/116901976/b4d27b39-528f-49f4-bb89-cf34b72d2ed0)

Објаснување на напишаните unit tests

1.unit tests за EVERY BRANCH критериумите -функција TestForEveryBranch()

Прв тест случај:

Exception exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
assertEquals("allItems list can't be null!",exception.getMessage());

Влезни параметри: allItems = null, payment = 100
Очекуван излез: Исклучок со порака "allItems list can't be null!"
Овој тест случај проверува дали методот checkCart правилно фрла исклучок кога листата allItems е null.

Втор тест случај:

Item item11 = new Item("", null, 35, 0.5F);
List<Item> lista = new ArrayList<>();
lista.add(item11);
Exception exceptionn = assertThrows(RuntimeException.class, () -> SILab2.checkCart(lista, 100));
assertEquals("No barcode!",exceptionn.getMessage());

Влезни параметри: allItems = {item11}, каде item11 = {null, null, 35, 0.5}, payment = 100
Очекуван излез: Исклучок со порака "No barcode!"
Овој тест случај проверува дали методот checkCart правилно фрла исклучок кога barcode на некој предмет е null.

Трет тест случај:

Item item1 = new Item("", "-1511", 22, 0.5F);
List<Item> lista1 = new ArrayList<>();
lista1.add(item1);
Exception exception1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(lista1, 100));
assertEquals("Invalid character in item barcode!",exception1.getMessage());

Влезни параметри: allItems = {item1}, каде item1 = {"", "-1511", 22, 0.5}, payment = 100
Очекуван излез: Исклучок со порака "Invalid character in item barcode!"
Овој тест случај проверува дали методот checkCart правилно фрла исклучок кога barcode на некој предмет содржи невалиден карактер (во овој случај -).

Четврт тест случај:

Item item = new Item("tina", "1111", 34, 0.2F);
Item item2 = new Item("mina", "0211", 301, 0.1F);
Item item3 = new Item("kika", "22211", 22, 0);
List<Item> lista11 = new ArrayList<>();
lista11.add(item);
lista11.add(item2);
lista11.add(item3);
assertTrue(SILab2.checkCart(lista11, 550));

Влезни параметри: allItems = {item, item2, item3}, каде item = {"tina", "1111", 34, 0.2}, item2 = {"mina", "0211", 301, 0.1}, item3 = {"kika", "22211", 22, 0}, payment = 550
Очекуван излез: true
Овој тест случај проверува дали методот checkCart враќа true кога вкупната цена на предметите е помала или еднаква на payment.

Петти тест случај:

Item item111 = new Item("tina", "1111", 34, 0.2F);
Item item222 = new Item("mina", "0211", 301, 0.1F);
Item item333 = new Item("kika", "22211", 22, 0);
List<Item> lista22 = new ArrayList<>();
lista22.add(item111);
lista22.add(item222);
lista22.add(item333);
assertFalse(SILab2.checkCart(lista22, 0));

Влезни параметри: allItems = {item111, item222, item333}, каде item111 = {"tina", "1111", 34, 0.2}, item222 = {"mina", "0211", 301, 0.1}, item333 = {"kika", "22211", 22, 0}, payment = 0
Очекуван излез: false
Овој тест случај проверува дали методот checkCart враќа false кога вкупната цена е поголема од payment.

2.unit tests за MULTIPLE CONDITION критериумите -функција TestForMultipleCondition()

Прв тест случај:

// FXX
Item m = new Item("kika", "222", 100, 0);
List<Item> list = new ArrayList<>();
list.add(m);
assertTrue(SILab2.checkCart(list, 500));

Влезни параметри: item = { "kika", "222", 100, 0 }, payment = 500
Услови: item.getPrice() > 300 (False), item.getDiscount() > 0 (Не е важно), item.getBarcode().charAt(0) == '0' (Не е важно)
Овој тест случај проверува кога првиот услов е False и не се исполнува и останатите проверки не се значајни.Во овој случај, целата функција  треба да врати true бидејќи сумата е помала од payment.

Втор тест случај:

// TTT
Item s = new Item("kika1", "022201", 600, 0.1F);
List<Item> lista = new ArrayList<>();
lista.add(s);
assertTrue(SILab2.checkCart(lista, 500));

Влезни параметри: item = { "kika1", "022201", 600, 0.1 }, payment = 500
Услови: item.getPrice() > 300 (Tочно), item.getDiscount() > 0 (Точно), item.getBarcode().charAt(0) == '0' (Точно)
Овој тест случај проверува кога сите услови се True. Во овој случај, методот треба да врати true бидејќи сумата е помала од payment.

Трет тест случај:

// TFX
Item ss = new Item("kika2", "222201", 800, 0);
List<Item> lista1 = new ArrayList<>();
lista1.add(ss);
assertFalse(SILab2.checkCart(lista1, 700));

Влезни параметри: item = { "kika2", "222201", 800, 0 }, payment = 700
Услови: item.getPrice() > 300 (Точно), item.getDiscount() > 0 (Неточно), item.getBarcode().charAt(0) == '0' (Не е важно)
Овој тест случај проверува кога првиот услов е True, вториот услов е False, без разлика на третиот услов. Во овој случај, методот треба да врати false бидејќи сумата е помала од payment.

Четврт тест случај:

// TTF
Item ss2 = new Item("kika3", "322201", 500, 0.4F);
List<Item> lista2 = new ArrayList<>();
lista2.add(ss2);
assertFalse(SILab2.checkCart(lista2, 30));

Влезни параметри: item = { "kika3", "322201", 500, 0.4 }, payment = 30
Услови: item.getPrice() > 300 (Точно), item.getDiscount() > 0 (Точно), item.getBarcode().charAt(0) == '0' (Неточно)
Овој тест случај проверува кога првите два услови се True, а третиот услов е False. Во овој случај, методот треба да врати false бидејќи сумата е помала од payment.
