<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

<html>
    <head>
        <title>ENIAC Quiz</title>

        <meta name="generator" content="HTML Tidy, see www.w3.org">

        <link rel="stylesheet" href="css/styles.css">

        <script src="https://kit.fontawesome.com/0217c99d0d.js" crossorigin="anonymous"> </script>
    </head>

    <body>

        <div class="wrapper">

            <h1>ENIAC Quiz</h1>

            <form action="/java112/quiz" method="GET">
                <input type="hidden" name="quiz-submitted" value="true" />

                ${quizBean.questionHtml}
                
                <input type="submit" />
            </form>

        </div>

    </body>
</html>