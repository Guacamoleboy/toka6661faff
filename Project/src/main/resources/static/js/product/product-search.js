document.addEventListener('DOMContentLoaded', () => {

    const searchInput = document.getElementById('consumr-search-index');
    const searchButton = document.querySelector('.btn-send');

    searchButton.addEventListener('click', (e) => {
        e.preventDefault();

        const barcode = searchInput.value.trim();
        if (!barcode) return;

        window.location.href = `/product/search?barcode=${encodeURIComponent(barcode)}`;
    });

});