const questions = [
  {
    question: "Which is largest animal in the world?",
    answers: [
      { text: "Shark", correct: "false" },
      { text: "Blue Whale", correct: "true" },
      { text: "Elephant", correct: "false" },
      { text: "Giraffe", correct: "false" },
    ]
  },

  {
    question: "Which is smallest continent in the world?",
    answers: [
      { text: "Australia", correct: "true" },
      { text: "Asia", correct: "false" },
      { text: "Europe", correct: "false" },
      { text: "Arctic", correct: "false" },
    ]
  },

  {
    question: "What is the meaning of D in DSA ?",
    answers: [
      { text: "Document", correct: "false" },
      { text: "Different", correct: "false" },
      { text: "data", correct: "true" },
      { text: "Data Mining", correct: "false" },
    ]
  },

  {
    question: "Which is longest river in the india?",
    answers: [
      { text: "Sharda", correct: "false" },
      { text: "Looni", correct: "false" },
      { text: "Yumna", correct: "false" },
      { text: "Ganga", correct: "ture" },
    ]
  },

  {
    question: "Which is longest river in the world?",
    answers: [
      { text: "Amazon", correct: "false" },
      { text: "Nile", correct: "true" },
      { text: "Yellow ", correct: "false" },
      { text: "Yangtze", correct: "false" },
    ]
  }
];

 const questionElement = document.getElementById("question");
 const answerButton = document.getElementById("answer-buttons");
const nextButton = document.getElementById("next-btn");

let currentQuestionIndex = 0;
let score = 0;

function startQuiz(){
    currentQuestionIndex = 0;
    score = 0;
    nextButton.innerHTML = "Next";
    showQuestion();
}



function showQuestion(){
    resetState();
    let currentQuestion = questions[currentQuestionIndex];
    let questionNo = currentQuestionIndex + 1;
    questionElement.innerHTML = questionNo + "." + currentQuestion.question;

    currentQuestion.answers.forEach(answer =>{
        const button = document.createElement("button");
        button.innerHTML = answer.text;
        button.classList.add("btn");
        answerButton.appendChild(button);

        if(answer.correct){
            button.dataset.correct = answer.correct;
        }

        button.addEventListener("click", selectAnswer);
    });

    

}

 function resetState(){
nextButton.style.display = "none";
while(answerButton.firstChild){
    answerButton.removeChild(answerButton.firstChild);
}
}

function selectAnswer(e){
   const selectedBtn = e.target;
   const isCorrect = selectedBtn.dataset.correct === "true";

   if(isCorrect){
    selectedBtn.classList.add("correct");
    score++;
   }else{
    selectedBtn.classList.add("incorrect");
   }

   Array.from(answerButton.children).forEach(button =>{
    if(button.dataset.correct === "true"){
        button.classList.add("correct");
    }
    button.disabled = "true";
   }) ;
   nextButton.style.display = "block";
}


nextButton.addEventListener("click",()=>{
    if(currentQuestionIndex < questions.length){
        handleNextButton();
    } else{
        startQuiz();
    }

});

function handleNextButton(){
    currentQuestionIndex++;
    if(currentQuestionIndex < questions.length){
        showQuestion();
    }else{
        showScore();
    }
}

 function showScore(){
    resetState();
    questionElement.innerHTML = `You scored ${score} out of ${questions.length}! `;
    nextButton.innerHTML = "Play Again!";
    nextButton.style.display = "block";
}

startQuiz(); 






