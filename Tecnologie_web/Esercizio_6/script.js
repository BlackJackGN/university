const arr = [
    {
        url: "https://www.armandoalpantheon.it/wp-content/uploads/2023/03/Primavera-a-Roma-%E2%80%93-Il-Colosseo-e-gli-scavi-di-Ostia-Antica-armando-al-pantheon-768x480.jpg",
        title: "Colosseo",
        description: "Originariamente conosciuto come Anfiteatro Flavio è il più grande anfiteatro romano del mondo.",
    },
    {
        url: "https://www.donne.it/wp-content/uploads/2023/10/intelligenza-artificiale-768x512.jpg",
        title: "Intelligenza Artificiale",
        description: "Nel suo significato più ampio, è la capacità di un sistema artificiale di simulare l'intelligenza umana attraverso l'ottimizzazione di funzioni matematiche.",
    },
    {
        url: "https://png.pngtree.com/background/20230525/original/pngtree-floral-wallpaper-with-brown-and-brown-paint-picture-image_2735082.jpg",
        title: "Linguaggio dei fiori",
        description: "Modo di comunicazione ottocentesco per cui i fiori e gli allestimenti floreali venivano utilizzati per esprimere sensazioni che non sempre potevano essere pronunciate.",
    }
];


function createCard(data) {
    // div representing a card
    var card = document.createElement("div");
    card.className = "bg-white rounded-lg overflow-hidden shadow-lg hover:shadow-xl transition-shadow";

    var img=document.createElement("img");
    img.src=data.url;
    img.className = "w-full h-48 object-cover";
    card.appendChild(img);

    var textcontainer = document.createElement("div");
    textcontainer.className="p-6 text-center";
    
    var titolo=document.createElement("h3");
    titolo.className = "font-semibold text-dark text-xl";
    titolo.appendChild(document.createTextNode(data.title));
    textcontainer.appendChild(titolo);

    var descrizione=document.createElement("p");
    descrizione.className = "text-base text-body-color leading-relaxed mb-7";
    descrizione.appendChild(document.createTextNode(data.description));
    textcontainer.appendChild(descrizione);

    card.appendChild(textcontainer);
   
    // Append the created card to the container
    document.getElementById("container").appendChild(card);
    
}
