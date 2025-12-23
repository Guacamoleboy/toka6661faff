const announcementHTML = `
<!-- Announcement Bar -->
<div class="announcement-bar">
    <div class="announcement-track">
        <span>Consumr Version 1.0 er klar! | Skriv en anmeldelse for et produkt - helt gratis</span>
    </div>
</div>
<!-- Announcement Bar -->
`;

export function loadAnnouncement(containerId = "announcement-component") {

    const container = document.getElementById(containerId);

    if (!container) {
        console.error(`Announcement container #${containerId} not found`);
        return;
    }

    container.innerHTML = announcementHTML;
}

// Auto-load announcement
loadAnnouncement();
