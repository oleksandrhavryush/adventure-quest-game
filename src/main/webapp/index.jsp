<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Start of the quest</title>
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
                max-width: 1140px; /* Recommended maximum size for .container-lg */
            }
        }

        @media (min-width: 1200px) {
            .container {
                max-width: 1320px; /* Recommended maximum size for .container-xl */
            }
        }

        .row {

            margin-left: -1px;
            margin-right: -1px;
        }

        .col-md-4 {

            padding-left: 60px;
            padding-right: 60px;
            margin-bottom: 60px; /* Added margin between columns */
            display: grid;
        }

        p {

            color: #343a40;
            font-size: 18px;
            line-height: 1.5;
            overflow-wrap: break-word;
            hyphens: auto; /* allows automatic word wrap */
        }


    </style>
</head>
<body>
<div class="container">
    <h1><%= "Welcome to the exciting world of adventure!" %>
        <br>
        <%= "You find yourself in an unpredictable place where every choice determines your fate." %>
    </h1>
    <div class="row text-justify">
        <div class="col-md-4">
            <br>
            <br>
            <h4>
                UFO Mystery
            </h4>
            <br>
            <p>
                Losing memory, you find yourself in the epicenter of an incredible adventure.
                You are faced with a choice - to accept the UFO challenge or to refuse. Your answer will determine the
                fate of the hero.

            </p>
            <p>
                Climbing onto the bridge, you are faced with a question about your identity. Will you reveal the truth?
                Each choice leads to victory or defeat, affecting the final result of this exciting
                quest.
            </p>
            <br/>
            <a href="quest-servlet?type=ufo">Start the quest</a>
        </div>

        <div class="col-md-4">
            <br>
            <br>
            <h4>
                Shipwreck
            </h4>
            <br>
            <p>
                You - the only one who survived after a shipwreck, wake up on an unknown island where danger lurks.
                If you decide to accept the challenge, then find out the secret of the island, meet a pirate captain who
                can be an ally or an enemy, find a treasure map that leads to wealth and glory.

            </p>
            <p>
                Your fate depends on your choice. Ready to play?
            </p>

            <br/>
            <a href="quest-servlet?type=pirate">Start the quest</a>

        </div>
        <div class="col-md-4">
            <br>
            <br>
            <h4>
                Saving the world
            </h4>
            <br>
            <p>
                You - chosen to solve a great mystery that threatens the existence of this world.
            </p>
            <p>
                You have to overcome enemies, solve puzzles and interact with magical creatures.
            </p>
            <p>
                Get ready for an exciting adventure quest where choice matters,
                and every step leads to a new challenge. So, your great test begins...
            </p>
            <br/>
            <a href="quest-servlet?type=adventure">Start the quest</a>
        </div>
    </div>
</div>
</body>
</html>
