# 🔢 Between Two Sets – Хоёр багцын хооронд

 [HackerRank бодлого үзэх](https://www.hackerrank.com/challenges/between-two-sets/problem)

##  Бодлогын тайлбар (Монгол хэлээр)

Танд хоёр массив (багц) өгөгдөнө:  
- `A` багц: бүх элементүүд нь шалгах тоонуудын **хуваагдагч** байх ёстой.
- `B` багц: бүх элементүүд нь шалгах тооны **хуваагдагчид** байх ёстой.

 Зорилго:  
Тийм бүхэл тоонуудын тоог олно уу, тэдгээр нь дараах 2 нөхцлийг хангах ёстой:
1. `A` багц дахь бүх тоонд **хуваагддаг** (`x % a[i] == 0`)
2. `x` тоо нь `B` багц дахь бүх тоог **хуваадаг** (`b[j] % x == 0`)

---

##  Оролт

- Эхний мөр: `n m` — массив `A`, `B`-ийн хэмжээ
- 2-р мөр: `n` ширхэг бүхэл тоо (массив A)
- 3-р мөр: `m` ширхэг бүхэл тоо (массив B)

 Хязгаарлалт:
- 1 ≤ n, m ≤ 10
- 1 ≤ A[i] ≤ 100
- 1 ≤ B[j] ≤ 100

---

##  Гаралт

- Дээрх 2 нөхцлийг хангах бүхэл тоонуудын **тоо**

---
## Жишээ оролт
2 3
2 4
16 32 96

## Жишээ гаралт

3

##  Жишээ тайлбар

Шалгах боломжит бүхэл тоонууд: `4, 8, 16`

- `4 % 2 == 0`, `4 % 4 == 0` → OK  
  `16 % 4 == 0`, `32 % 4 == 0`, `96 % 4 == 0` → OK  
→ 4 боломжит утга

- `8`, `16` дээр мөн адил шалгана.
➤ Нийт 3 тоо нөхцлийг хангаж байна.

---

##  Шийдэл ба алгоритмын үндэс

Алгоритмын үндсэн санаа:

1. `A` багцын **ХХО (LCM)**-г олно — энэ нь шалгах тоо `x`-ын доод босго
2. `B` багцын **ХБХ (GCD)**-г олно — энэ нь `x`-ын дээд хязгаар
3. `LCM ≤ x ≤ GCD` хооронд `x`-ийг шалгана:
   - `x` нь `LCM`-ийн үржвэр байх ёстой
   - `GCD % x == 0` байвал тоолж авна