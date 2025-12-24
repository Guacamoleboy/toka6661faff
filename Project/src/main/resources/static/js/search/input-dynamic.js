const input = document.getElementById("consumr-search-index");
const resultsContainer = document.createElement("div");
resultsContainer.className = "search-dropdown";
input.parentElement.appendChild(resultsContainer);

input.addEventListener("input", async () => {

    const query = input.value.trim();

    if (query.length === 0) {
        resultsContainer.style.display = "none";
        resultsContainer.innerHTML = "";
        return;
    }

    try {
        const response = await fetch(`/input?q=${encodeURIComponent(query)}`);
        const results = await response.json();

        resultsContainer.innerHTML = "";

        if (results.length === 0) {
            resultsContainer.style.display = "none";
            return;
        }

        results.forEach(product => {
            const item = document.createElement("div");
            item.className = "search-item";
            item.innerHTML = `
                <img src="${product.imagePath}" alt="${product.title}">
                <span>${product.title}</span>
            `;

            item.addEventListener("click", () => {
                input.value = product.title;
                resultsContainer.style.display = "none";
                resultsContainer.innerHTML = "";
            });

            resultsContainer.appendChild(item);
        });

        resultsContainer.style.display = "flex";
        resultsContainer.style.flexDirection = "column";

    } catch (err) {
        console.error("Fejl ved hentning af produkter:", err);
        resultsContainer.style.display = "none";
    }

});