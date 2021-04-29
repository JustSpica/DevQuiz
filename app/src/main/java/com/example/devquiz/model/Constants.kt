package com.example.devquiz.model

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val questionOne = Question(
            1,
            "Para qual linguagem Kotlin compila na Virtual Machine ?",
            "C#",
            "KotlinJS",
            "Java",
            "Assembly",
            3
        )
        questionList.add(questionOne)

        val questionTwo = Question(
            2,
            "Qual empresa desenvolveu a linguagem Java ?",
            "Oracle",
            "Moon Microsystems",
            "Sun Microsystems",
            "JetBrains",
            1
        )
        questionList.add(questionTwo)

        val questionThree = Question(
            3,
            "O que é o React Native ?",
            "Uma biblioteca PHP",
            "Um framework para android",
            "Uma biblioteca de interface em JS para android",
            "Um fragment template para android",
            3
        )
        questionList.add(questionThree)

        val questionFour = Question(
            4,
            "O que significa MVC ?",
            "Model-Var-Controller",
            "Main-Var-Char",
            "Main-View-Controller",
            "Model-View-Controller",
            4
        )
        questionList.add(questionFour)

        val questionFive = Question(
            5,
            "O Elixir foi criado por(pela):",
            "Andrew Tridgell",
            "José Valim",
            "Guido van Rossum",
            "JetBrains",
            2
        )
        questionList.add(questionFive)

        val questionSix = Question(
            6,
            "A Apple desenvolveu uma linguagem de programação própria para desenvolvimento de aplicações sob IOS. Ela se chama:",
            "C++",
            "Swift",
            "Flutter",
            "Pineapple",
            2
        )
        questionList.add(questionSix)

        val questionSeven = Question(
            7,
            "O que significa a HTML ?",
            "Heading Tags Main Label",
            "Hippo T-Rex Mascot Lemur",
            "Hyper Title Market Language",
            "Hypertext Markup Language",
            4
        )
        questionList.add(questionSeven)

        val questionEight = Question(
            8,
            "Qual o nome de lançamento do android 6.0 ?",
            "Oreo",
            "Marshmallow",
            "Pie",
            "Lollipop",
            2
        )
        questionList.add(questionEight)

        val questionNine = Question(
            9,
            "O que faz o método React useState() ?",
            "Utiliza um estado em uma propriedade",
            "Define um estado",
            "Esse método não existe no React",
            "Controla o estado do fluxo de uma API",
            2
        )
        questionList.add(questionNine)

        val questionTen = Question(
            10,
            "<p> é uma tag HTML que significa:",
            "Picture",
            "Point",
            "Paragraph of text",
            "Pineapples",
            3
        )
        questionList.add(questionTen)

        return questionList
    }
}