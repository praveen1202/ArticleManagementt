
document.querySelector(".signUp").style.display = "none";
document.querySelector(".sign").addEventListener("click",enable);

function enable(){
    document.querySelector(".signUp").style.display = "block";
    document.querySelector(".sign").style.display = "none";
}