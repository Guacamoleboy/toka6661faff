document.addEventListener("DOMContentLoaded", () => {

    if (!window.location.pathname.startsWith("/login") && !window.location.pathname.startsWith("/register")) {
        sessionStorage.setItem("lastPage", window.location.pathname + window.location.search);
    }

    const lastPage = sessionStorage.getItem("lastPage") || "/";
    const loginRedirect = document.getElementById("login-redirect");
    const registerRedirect = document.getElementById("register-redirect");

    if (loginRedirect) loginRedirect.value = lastPage;
    if (registerRedirect) registerRedirect.value = lastPage;

});