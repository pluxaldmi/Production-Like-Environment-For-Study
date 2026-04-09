# Практическая работа №3  
## Интеллектуальные мобильные приложения  
**ФИО** - Дмитриева А.А.  
Группа: БСБО-52-24  
Дата: 08.04.2026

## Цель работы

Изучить работу с **Intent**, обмен данными между активностями, вызов системных приложений, а также освоить использование **Fragments** и **Navigation Drawer** в Android-приложениях

---

## Выполненные задания

### 1. Намерения (Intents)

**Модуль:** `IntentApp`  
- Реализована передача системного времени из `MainActivity` в `SecondActivity`
- Во второй активности отображается текст:  
  **"КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ 81, а текущее время (текущее время)"**

<image-card alt="Реализация модуля 1" src="screenshots/1.1.png" ></image-card>
<image-card alt="Реализация модуля 1" src="screenshots/1.2.png" ></image-card>

### 2. Обмен данными

**Модуль:** `Sharer`  
- Реализовано два экрана с использованием `ActivityResultLauncher`
- Передача названия любимой книги и цитаты от разработчика
- Возврат введённых пользователем данных на главный экран

<image-card alt="Реализация модуля 2" src="screenshots/2.1.png" ></image-card>
<image-card alt="Реализация модуля 2" src="screenshots/2.2.png" ></image-card>

### 3. Вызов системных приложений

**Модуль:** `SystemIntentsApp`  
- Кнопка "Позвонить" -> `ACTION_DIAL`
- Кнопка "Открыть браузер" -> `ACTION_VIEW` (http)
- Кнопка "Открыть карту" -> `ACTION_VIEW` (geo)

<image-card alt="Реализация модуля 3" src="screenshots/3.1.png" ></image-card>
<image-card alt="Реализация модуля 3" src="screenshots/3.2.png" ></image-card>
<image-card alt="Реализация модуля 3" src="screenshots/3.3.png" ></image-card>
<image-card alt="Реализация модуля 3" src="screenshots/3.4.png" ></image-card>

### 4. Фрагменты

**Модуль:** `SimpleFragmentApp`  
- Создано два фрагмента с разными цветами фона
- Реализовано переключение фрагментов через кнопки
- Поддержка горизонтальной ориентации экрана (при этом оба фрагмента всё так же отображаются рядом)

<image-card alt="Реализация модуля 4" src="screenshots/4.1.png" ></image-card>
<image-card alt="Реализация модуля 4" src="screenshots/4.2.png" ></image-card>

### 5. Контрольное задание

**Основной проект:** `MireaProject` (Empty Views Activity + Navigation Drawer реализация)

#### Реализованные компоненты:
- `DataFragment` - информационный экран об отрасли
- `WebViewFragment` - простой встроенный браузер с загрузкой https://developer.android.com по умолчанию
- Навигационное боковое меню Drawer с тремя пунктами
- Корректная обработка открытия/закрытия шторки
- Современная обработка кнопки «Назад» через `OnBackPressedDispatcher`, как этого требует AndroidStudio, выдавая ранее ошибку

<image-card alt="Реализация контрольного задания" src="screenshots/5.1.png" ></image-card>