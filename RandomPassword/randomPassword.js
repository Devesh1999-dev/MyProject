const passwordBox = document.getElementById("password");
const length = 12;

const upperCase ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const lowerCase = "abcdefghijklmnopqrstuvwxyz";
const number = "0123456789";
const specialSymbol = "@!$%^&*()?><.,}{][|\/=";
const allChars = upperCase + lowerCase + number + specialSymbol;

function createPassword(){
    let password = "";

     password += upperCase[Math.floor(Math.random () * upperCase.length)];
     password += lowerCase[Math.floor(Math.random() * lowerCase.length)];
     password += number[Math.floor(Math.random() * number.length)];
     password += specialSymbol[Math.floor(Math.random() * specialSymbol.length)];

     while(length > password.length){
        password += allChars[Math.floor(Math.random() * allChars.length)];
     }

     passwordBox.value = password;
}

 function copyPassword(){
    passwordBox.select();
    document.execCommand("copy");

}

const button = document.querySelector("button");
const image = document.getElementById("image");

button.addEventListener("click" ,createPassword);
image.addEventListener("click", copyPassword);
