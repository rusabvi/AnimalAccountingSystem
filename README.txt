# AnimalAccountingSystem
Система учёта животных

Для корректной работы программы нужно
1) в папку src\main\inputData добавить файл animals.txt, где будут перечислены характеристики животных (пример 1)
2) в папку src\main\tasks добавить файлы task1.txt, task2.txt и task3.txt где будут перечислены правила для поиска животных (пример 2)

Пример 1 - оформление файла animals.txt:
"""
LIGHT, SMALL, GRASS
HEAVY, BIG, MEAT
HEAVY, MID, ALL
"""
Первое - это weight (вес), второе - это height(высота), третье - это foodType (тип питания)
На самом деле, значения любые могут быть)

Пример 2 - оформление файла taskX.txt
"""
weight: LIGHT or HEAVY, height: not SMALL, foodType: ALL
weight: LIGHT
height: not SMALL or MID, foodType: ALL
foodType: GRASS or MEAT, weight: LIGHT
"""
В отличие от прошлого файла, перед параметром нужно указать его тип (weight, height или foodType)
Есть ключевые слова or и not


Основное приложение содержится в папке src\main
Тесты к методам приложения содержатся в папке src\test


Недочёты:
1) Не заработала относительная ссылка, поэтому сделал на каждый файл абсолютную ссылку
2) При проверке на равенство строковых параметров foodType (через equals()) возвращает ложь, даже если последовательность символов абсолютно одинакова. Поэтому из тестов и основного запроса убрал этот параметр
3) Russian language doesn't work(
