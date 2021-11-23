# 1. Сравнительный анализ производительности MyLinkedList и java.util.LinkedList
Проведем тесты для 10 000, 100 000 и 1 000 000 элементов в коллекции. Каждый тест повторяем по 10 раз для усреднения результатов.
В качестве тестов возьмем: 
1. Добавление элемента в середину списка.
2. Возврат элемента по индексу.
3. Поиск элемента.
4. Удаление элемента по индексу.
## Сравнение MyLinkedList и LinkedList
![Figure_11](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_11.png)
![Figure_12](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_12.png)
![Figure_13](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_13.png)
![Figure_14](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_14.png)
## Вывод
По результатам тестов видно, что в целом результаты для MyLinkedList и LinkedList схожи. В данном случае MyLinkedList работает немного быстрее, за исключением случая с поиском элемента. Однако разброс результатов тестов больше этой разницы и запустив тесты повторно можно получить другой результат. Таким образом можно сделать вывод что существенной разницы нет.
____
# 2. Сравнительный анализ производительности основных Java коллекций
Проведем тесты для 10 000, 100 000 и 1 000 000 элементов в коллекции. Каждый тест повторяем по 10 раз для усреднения результатов.
## a. Сравнение ArrayList и LinkedList
В качестве тестов возьмем: 
1. Заполнение списка числами от 0 в порядке возрастания. 
2. Добавление элемента в начало, середину и конец списка. 
3. Возврат элемента по индексу из середины списка.
4. Удаление элемента по индексу из середины списка.

![Figure_21](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_21.png)
![Figure_22](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_22.png)
![Figure_23](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_23.png)
![Figure_24](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_24.png)
![Figure_25](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_25.png)
![Figure_26](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_26.png)
## Вывод
1. Видим, что заполнение элементами быстрее сработало в ArrayList. Полагаю это вызвано тем, что добавить элемент в ArrayList в проще чем в LinkedList, так как не нужно создавать ссылки на следующий и предыдущий элемент. В ArrayList нужно просто занести элемент в массив и иногда увеличивать емкость. Увеличение емкости приводит к копированию элементов в новый массив, что займет линейное время, O(N), но чем больше ArrayList, тем реже требуется менять емкость и следовательно, копировать элементы. В Java 8 и более поздних версиях новая емкость на 50% больше, чем предыдущая.
2. Добавление элемента в начало заметно быстрее в LinkedList, так как там на это уходит константное время, а в ArrayList потребуется передвинуть все элементы вперед, что займет линейное время. Добавление элемента в середину быстрее в ArrayList, что означает, что итерирование по LinkedList займет больше времени чем сдвиг элементов в ArrayList. Добавление элемента в конец занимает константное время и у ArrayList и у LinkedList, при условии, что в ArrayList не требуется увеличение емкости, иначе линейное.
3. Получение элемента по индексу быстрее в ArrayList и занимает константное время, так как нам не придется проходить по списку до нужного элемента как в LinkedList. Исключение составляют только первый и последний элемент LinkedList.
4. Удаление элемента по индексу из середины списка быстрее в ArrayList, что сравнимо с результатами и выводами для пунка 2, что видно и по графикам.
В итоге можно сказать, что LinkedList удобно использовать, когда требуется работать с первым и последним элементом списка. В большинстве же случаев удобнее использовать ArrayList.
## b. Сравнение HashSet, LinkedHashSet, TreeSet
В качестве тестов возьмем: 
1. Заполнение множества числами от 0 в порядке возрастания.
2. Добавление элемента.
3. Поиск элемента.
4. Удаление элемента.

![Figure_31](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_31.png)
![Figure_32](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_32.png)
![Figure_33](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_33.png)
![Figure_34](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_34.png)
## Вывод
1. Видим, что TreeSet медленнее чем HashSet и LinkedHashSet, что вероятно связано с затратами на балансировку дерева, для сортировки элементов. Добавление, поиск и удаление для TreeSet работает за логарифмическое время, а для HashSet и LinkedHashSet за константное.
2. HashSet и LinkedHashSet примерно равны по производительности, но LinkedHashSet более медленный по заполнению элементами из-за сохранения порядка их добавления.
HashSet используется, когда порядок элементов не имеет значения.
LinkedHashSet используется, когда важно сохранить порядок добавления элементов.
TreeSet используется, когда нужно отсортированное множество.
## c. Сравнение HashMap, LinkedHashMap, TreeMap
В качестве тестов возьмем: 
1. Заполнение словаря парами ключ-значение, где ключи - числа от 0 в порядке возрастания, а значения - строки. 
2. Добавление пары ключ-значение.
3. Поиск по ключу.
4. Удаление по ключу.

![Figure_41](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_41.png)
![Figure_42](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_42.png)
![Figure_43](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_43.png)
![Figure_44](https://github.com/andrbezr2016/Java-Homework-3/raw/main/figures/Figure_44.png)
## Вывод
Видим, что результаты в целом сравнимы с результатами для Set, что логично так как Set сделан на основе Map. Выводы аналогичны выводам предыдущего раздела.
HashMap используется, когда порядок добавления не имеет значения.
LinkedHashMap используется, когда важно сохранить порядок добавления.
TreeMap используется, когда нужен отсортированный по ключам словарь.