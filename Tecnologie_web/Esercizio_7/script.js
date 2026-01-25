//controllo sui vincoli
const form=document.getElementById("registrationForm");
form.addEventListener("submit",function(e){
document.querySelectorAll('.error').forEach(err => err.textContent = '');//pulizia errori
let valid=true;
const email=document.getElementById("email").value;
const emailError = document.querySelector("#email + .error");//prende il tag error successivo
if(!email.includes("@")){//controllo presenza di almeno 1 @
    emailError.textContent="L'email deve contenere '@' !";
    valid=false;
}else{
    const parts=email.split("@");
    if(parts.length!==2){//controllo assenza di più di 1 @
        emailError.textContent="L'email contiene più di una '@' !";
        valid=false;
    }else{
        const part=parts[1];
        if(part!=="gmail.com"&&part!=="yahoo.it"){//controllo dei 2 tipi di mail
            emailError.textContent="L'email non è una gmail o una yahoo .com !";
            valid=false;
        }
    }
}
const tel=document.getElementById("telefono").value;
const telError=document.querySelector("#telefono + .error");//prende il tag error successivo, in questo caso telefono e lo ribattezza col .error
const patternTelefono = /^\+?[0-9]{10}$/;//pattern della stringa di telefono d'interesse
const telefonoclean=tel.replace(/[\s\-]/g,'');// \s metacarattere per gli spazi bianchi, \- escape per il trattino, la g trova tutte le occorrenze
if(!patternTelefono.test(telefonoclean)){
    telError.textContent="Numero di telefoon non valido!";
    valid=false;
}
const password=document.getElementById("password").value;
const password1=document.getElementById("password1").value;
const passError=document.querySelector("#password1 + .error");//prende il tag successivo a password1 che è l'errore relativo alle password
if(password!==password1){//controllo password
    passError.textContent="La conferma della password non corrisponde all'originale!";
    valid=false;
}
if(valid){//controllo validità
    e.target.submit();
}else{
    e.preventDefault();
}
});