const headerHTML = `
<!-- Header Stack -->
<header class="header-stack">

    <!-- Announcement Bar -->
    <div class="announcement-bar">
        <div class="announcement-track">
            <span>Consumr Version 1.0 er klar! | Skriv en anmeldelse for et produkt - helt gratis</span>
        </div>
    </div>
    <!-- Announcement Bar -->

    <!-- Navbar Web -->
    <nav class="navbar-consumr">

        <div class="guac-container guac-d-flex guac-align-center guac-justify-between">

            <!-- Brand -->
            <a href="/" class="navbar-brand-consumr guac-d-flex guac-align-center">
                <img src="/images/logo/logo-256-white.png" class="navbar-logo-sizing">
                <span>Consumr.dk</span>
            </a>

            <!-- Links -->
            <ul class="guac-d-flex guac-align-center guac-gap-3 nav-links">

                <li class="dropdown">
                    <button class="dropdown-toggle">
                        Skriv en anmeldelse <i class="fa fa-chevron-down"></i>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Søg efter produkt</a></li>
                        <li><a href="#">Søg efter brand</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <button class="dropdown-toggle">
                        Top listen <i class="fa fa-chevron-down"></i>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Top 100 listen</a></li>
                        <li><a href="#">Bedst ratede</a></li>
                        <li><a href="#">Bruger leaderboard</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <button>Kategorier</button>
                </li>

                <li class="dropdown">
                    <button>Vores mission</button>
                </li>

            </ul>

            <!-- Actions -->
            <div class="guac-d-flex guac-gap-2">
                <button class="guac-btn consumr-logind-btn">Log ind</button>
                <button class="guac-btn consumr-opret-btn">Opret Bruger</button>
            </div>

        </div>
    </nav>
    <!-- Navbar Web -->

</header>
<!-- Header Stack -->
`;

export function loadHeader(containerId = "header-component") {

    const container = document.getElementById(containerId);

    if (!container) {
        console.error(`Header container #${containerId} not found`);
        return;
    }

    container.innerHTML = headerHTML;
}

// Auto-load announcement
loadHeader();
