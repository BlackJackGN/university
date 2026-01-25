var button = document.getElementById('button');

button.onclick = function () {
    fetch('https://jsonplaceholder.typicode.com/posts')//               1) Si chiama Fetch con l'url associato
    .then(response => {//                   2) Si effettua un controllo, response.ok è una proprietà booleana che è true se lo status HTTP è nella fascia 200-299 (cioè successo)
        if(!response.ok){//                 Se response.ok è false (es. 404, 500, ecc.), allora si lancia un errore
            throw new Error("Errore nella richiesta:"+response.status);
        }
        return response.json();//           3) Si trasforma la risposta in un JSON
    })//                                    4) Si usano i dati JSON (l’array di post) per creare i div o fare altre cose
    .then(data=>{
        const container=document.getElementById("postsContainer");
        data.forEach(post => {
            var divElement=document.createElement("div");
            divElement.className="post";
            const title=document.createElement("h3");
            const body=document.createElement("p");
            title.textContent=post.title;
            body.textContent=post.body;
            divElement.appendChild(title);
            divElement.appendChild(body);
            container.appendChild(divElement);
        });
    })//                                    5) Tramite un catch di errori (con eventuali finally successivi) si gestiscono gli errori che si possono incontrare nel codice
    .catch(error => {
        console.error('Errore nella fetch:', error);
    });
};