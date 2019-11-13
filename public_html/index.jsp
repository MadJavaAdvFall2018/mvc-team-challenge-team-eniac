<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

<html>
    <head>
        <title>ENIAC Quiz // Results</title>
        
        <meta name="generator" content="HTML Tidy, see www.w3.org">

        <link rel="stylesheet" href="css/styles.css">

        <script src="https://kit.fontawesome.com/0217c99d0d.js" crossorigin="anonymous"> </script>
    </head>

    <body>

        <div class="wrapper">

            <h1>ENIAC Quiz // Results</h1>

            <p>
                <a href="diagram.jsp">View challenge diagram</a>
            </p>

            <h2>Results for ${quizBean.name}</h2>

            <ul>
                <li>Total Correct: ${quizBean.questionsCorrect}</li>
                <li>Total Questions: ${quizBean.totalQuestions}</li>
                <li>Percent Correct: ${quizBean.percentCorrect}%</li>
            </ul>

            ${quizBean.gradingHtml}

            <a href="/java112/quiz">Retake the Quiz</a>

        </div>

    </body>
</html>