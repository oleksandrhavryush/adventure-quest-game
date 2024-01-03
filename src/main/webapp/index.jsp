<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Початок квесту</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Bootstrap background color */
        }

        .container {
            text-align: center;
            margin-top: 100px;
        }

        h1 {
            color: #007bff; /* Bootstrap primary color */
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: #fff;
            background-color: #007bff; /* Bootstrap primary color */
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
        }

        a:hover {
            background-color: #0056b3; /* Bootstrap primary darker color on hover */
        }

        p {
            color: #343a40; /* Bootstrap dark color for text */
            font-size: 18px;
            line-height: 1.5;
        }

        @media (min-width: 992px) {
            .container {
                max-width: 1140px; /* Рекомендований максимальний розмір для .container-lg */
            }
        }

        @media (min-width: 1200px) {
            .container {
                max-width: 1320px; /* Рекомендований максимальний розмір для .container-xl */
            }
        }

        .row {

            margin-left: -1px;
            margin-right: -1px;
        }

        .col-md-4 {

            padding-left: 60px;
            padding-right: 60px;
            margin-bottom: 60px; /* Доданий відступ між колонками */
            display: grid;
        }

        p {

            color: #343a40;
            font-size: 18px;
            line-height: 1.5;
            overflow-wrap: break-word;
            hyphens: auto; /* дозволяє автоматичний перенос слів */
        }


    </style>
</head>
<body>
<div class="container">
    <h1><%= "Ласкаво просимо в захоплюючий світ пригод!" %>
        <br>
        <%= "Ти опинився в непередбачуваному місці, де кожен вибір визначає твою долю." %>
    </h1>
    <div class="row text-justify">
        <div class="col-md-4">
            <br>
            <br>
            <h4>
                Загадка НЛО
            </h4>
            <br>
            <p>
                Втрачаючи пам'ять, ви знаходитесь в епіцентрі неймовірної пригоди.
                Перед вами стоїть вибір — прийняти виклик НЛО чи відмовитися. Ваша відповідь визначачить долю героя.

            </p>
            <p>
                Піднявшись на місток, вас чекає питання про вашу ідентичність. Чи розкриєте ви правду?
                Кожнен вибір веде до виграшу чи програшу, впливаючи на кінцевий результат цього захоплюючого
                квесту.
            </p>
            <br/>
            <a href="quest-servlet?type=ufo">Почати квест</a>
        </div>

        <div class="col-md-4">
            <br>
            <br>
            <h4>
                Корабельна аварія
            </h4>
            <br>
            <p>
                Ви — єдиний, хто вижив після корабельної аварії, прокидаєтесь на невідомому острові, де чигає небезпека.
                Якщо Ви вирішете прийняти виклик, то дізнатися таємницю острова, зустрінете піратського капітана, який
                може бути союзником або ворогом, знайдете карту скарбів, що веде до багатства і слави.

            </p>
            <p>
                Ваша доля залежить від вашого вибору. Готові до гри?
            </p>

            <br/>
            <a href="quest-servlet?type=pirate">Почати квест</a>

        </div>
        <div class="col-md-4">
            <br>
            <br>
            <h4>
                Спасіння світу
            </h4>
            <br>
            <p>
                Ти — обраний для розв'язання великої загадки, що загрожує існуванню цього світу.
            </p>
            <p>
                Тобі належить долати ворогів, вирішувати головоломки та взаємодіяти з чарівними створіннями.
            </p>
            <p>
                Приготуйся до захоплюючого пригодницького квесту, де вибір має значення,
                а кожен крок призводить до нового виклику. Отже, твоє велике випробування починається...
            </p>
            <br/>
            <a href="quest-servlet?type=adventure">Почати квест</a>
        </div>
    </div>
</div>
</body>
</html>
